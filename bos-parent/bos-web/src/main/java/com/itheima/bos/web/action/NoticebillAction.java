package com.itheima.bos.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Noticebill;
import com.itheima.bos.service.INoticebillService;
import com.itheima.bos.web.action.base.BaseAction;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;

//ҵ��֪ͨ������
@Controller
public class NoticebillAction extends BaseAction<Noticebill> {
     
     @Autowired
     private ICustomerService proxy;
     
     @Autowired
     private INoticebillService noticebillservice;
     
     public String fingCustomerByTelephone(){
        String telephone = model.getTelephone();
        Customer customer = proxy.findCustomerByTelephone(telephone);
        javaToJson(customer,new String[]{});
        return NONE;
     }
     
     //���һ���µ�
     public String add(){
       noticebillservice.add(model);
        return LIST;
     }
}
