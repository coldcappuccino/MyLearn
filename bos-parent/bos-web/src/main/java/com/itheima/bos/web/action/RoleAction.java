package com.itheima.bos.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Role;
import com.itheima.bos.service.IRoleService;
import com.itheima.bos.web.action.base.BaseAction;

//角色管理
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
     
   @Autowired
   private IRoleService service;
  
  //属性驱动，接受权限的id
   private String functionIds;
  
   public void setFunctionIds(String functionIds) {
     this.functionIds = functionIds;
   }
   
   //添加角色
   public String add(){
      service.add(model,functionIds);
      return LIST;
   }
   
   //角色分页查询
   public void pageQuery(){
      DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Role.class);
      pagebean.setDetachedCriteria(detachedCriteria);
      service.pageQuery(pagebean);
      javaToJson(pagebean,new String[]{"functions","users"});
   }
   
   //查询所有的角色数据
   public String listajax(){
      List<Role> list = service.findAll();
      this.javaToJson(list,new String[]{"functions","users"});
      return NONE;
   }
}












