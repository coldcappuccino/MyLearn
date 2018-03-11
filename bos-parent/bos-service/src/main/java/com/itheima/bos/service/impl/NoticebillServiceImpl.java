package com.itheima.bos.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.bos.dao.IDecidedzoneDao;
import com.itheima.bos.dao.INoticebillDao;
import com.itheima.bos.dao.IWorkbillDao;
import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.domain.User;
import com.itheima.bos.domain.Workbill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.crm.ICustomerService;

@Service
@Transactional
public class NoticebillServiceImpl implements INoticebillService {

  
  @Autowired
  private INoticebillDao dao;
  
  @Autowired
  private IWorkbillDao workbilldao;
  
  @Autowired
  private ICustomerService proxy;
  
  @Autowired
  private IDecidedzoneDao decidedzonedao;
  
  //保存业务通知单，尝试自动分单
  public void add(Noticebill noticebill) {
      // TODO Auto-generated method stub
      User user = BOSUtils.getLoginUser();
      noticebill.setUser(user);
      dao.save(noticebill);
      
      //获取客户的取件地址
      String address = noticebill.getPickaddress();
      //调用CRM服务获取定区
      String decidedzone_id = proxy.findDecidedzoneIdByAddress(address);
      
      if(decidedzone_id!=null){
         //自动分单
         Decidedzone decidedzone= decidedzonedao.findById(decidedzone_id);
         Staff staff = decidedzone.getStaff();
         noticebill.setStaff(staff);
         //设置分单类型
         noticebill.setOrdertype(Noticebill.ORDERTYPE_AUTO);
         
         //为取派员产生一个工单
         Workbill workbill = new Workbill();
         workbill.setAttachbilltimes(0);//追单次数
         workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//创建时间
         workbill.setStaff(staff);
         workbill.setNoticebill(noticebill);
         workbill.setPickstate(Workbill.PICKSTATE_NO); //取件状态
         workbill.setRemark(noticebill.getRemark());
         workbill.setType(Workbill.TYPE_1);
         workbilldao.save(workbill);
         //调用短信平台发送短信
      }else{
        //不能自动分单
        noticebill.setOrdertype(Noticebill.ORDERTYPE_MAN);
      }
      
      
  }
    
  
}








