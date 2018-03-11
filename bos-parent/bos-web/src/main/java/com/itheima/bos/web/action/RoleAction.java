package com.itheima.bos.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.web.action.base.BaseAction;

//��ɫ����
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
     
   @Autowired
   private IRoleService service;
  
  //��������������Ȩ�޵�id
   private String functionIds;
  
   public void setFunctionIds(String functionIds) {
     this.functionIds = functionIds;
   }
   
   //��ӽ�ɫ
   public String add(){
      service.add(model,functionIds);
      return LIST;
   }
   
   //��ɫ��ҳ��ѯ
   public void pageQuery(){
      DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Role.class);
      pagebean.setDetachedCriteria(detachedCriteria);
      service.pageQuery(pagebean);
      javaToJson(pagebean,new String[]{"functions","users"});
   }
   
   //��ѯ���еĽ�ɫ����
   public String listajax(){
      List<Role> list = service.findAll();
      this.javaToJson(list,new String[]{"functions","users"});
      return NONE;
   }
}












