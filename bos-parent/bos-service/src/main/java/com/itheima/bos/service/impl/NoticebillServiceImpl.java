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
  
  //����ҵ��֪ͨ���������Զ��ֵ�
  public void add(Noticebill noticebill) {
      // TODO Auto-generated method stub
      User user = BOSUtils.getLoginUser();
      noticebill.setUser(user);
      dao.save(noticebill);
      
      //��ȡ�ͻ���ȡ����ַ
      String address = noticebill.getPickaddress();
      //����CRM�����ȡ����
      String decidedzone_id = proxy.findDecidedzoneIdByAddress(address);
      
      if(decidedzone_id!=null){
         //�Զ��ֵ�
         Decidedzone decidedzone= decidedzonedao.findById(decidedzone_id);
         Staff staff = decidedzone.getStaff();
         noticebill.setStaff(staff);
         //���÷ֵ�����
         noticebill.setOrdertype(Noticebill.ORDERTYPE_AUTO);
         
         //Ϊȡ��Ա����һ������
         Workbill workbill = new Workbill();
         workbill.setAttachbilltimes(0);//׷������
         workbill.setBuildtime(new Timestamp(System.currentTimeMillis()));//����ʱ��
         workbill.setStaff(staff);
         workbill.setNoticebill(noticebill);
         workbill.setPickstate(Workbill.PICKSTATE_NO); //ȡ��״̬
         workbill.setRemark(noticebill.getRemark());
         workbill.setType(Workbill.TYPE_1);
         workbilldao.save(workbill);
         //���ö���ƽ̨���Ͷ���
      }else{
        //�����Զ��ֵ�
        noticebill.setOrdertype(Noticebill.ORDERTYPE_MAN);
      }
      
      
  }
    
  
}








