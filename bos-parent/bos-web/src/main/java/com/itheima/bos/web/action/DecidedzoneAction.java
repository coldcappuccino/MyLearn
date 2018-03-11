package com.itheima.bos.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Decidedzone;
import com.itheima.bos.domain.Staff;
import com.itheima.bos.service.IDecidedzoneService;
import com.itheima.bos.web.action.base.BaseAction;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;

@Controller
public class DecidedzoneAction extends BaseAction<Decidedzone>{
    @Autowired
    private IDecidedzoneService decidedzoneService;
  
    @Autowired
    private ICustomerService proxy;
    
    private String[] subareaid;
    public void setSubareaid(String[] subareaid) {
      this.subareaid = subareaid;
    }
     
    public String add(){
       decidedzoneService.save(model,subareaid);
       return LIST;
    } 
    
    public String pageQuery(){
      DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Decidedzone.class);
      pagebean.setDetachedCriteria(detachedCriteria);
      decidedzoneService.pageQuery(pagebean);
      javaToJson(pagebean,new String[]{"currentPage","detachedCriteria","subareas","decidedzones"});
      
      return NONE;
   }
    
    /*
     * 
     * 调用crm服务，获取未关联到定区的客户
     * /
     */
   public String findLisNotAssociation(){
        List<Customer> list = proxy.findListNotAssociation();
        javaToJson(list,new String[]{});
        return null;
   }
   
   public String findLisHasAssociation(){
       String id = model.getId();
       List<Customer> list = proxy.findListHasAssociation(id);
       javaToJson(list,new String[]{});
       return null;
   }
   
   //接收客户的id
   List<Integer> customerIds;
   
  public void setCustomerIds(List<Integer> customerIds) {
    this.customerIds = customerIds;
  }

  
  
  //调用crm将客户关联到定区
   public String assigncustomerstodecidedzone(){
        
        proxy.assigncustomerstodecidedzone(model.getId(),customerIds);
        return LIST;
   }
   
}






