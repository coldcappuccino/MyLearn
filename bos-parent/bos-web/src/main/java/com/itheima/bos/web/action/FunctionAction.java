package com.itheima.bos.web.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.Function;
import com.itheima.bos.service.IFunctionService;
import com.itheima.bos.web.action.base.BaseAction;

@Controller
@Scope("prototype")
public class FunctionAction extends BaseAction<Function>{
     
    @Autowired
    private IFunctionService service;
    
    //查询所有权限，返回json数据
    public String listajax(){
      List<Function> list =  service.findAll();
      javaToJson(list,new String[]{"parentFunction","roles"});
      return NONE;
    } 
    
    //添加一条权限
    public String add(){
       service.add(model);
       return LIST;
    }
    
    //生成数据表格
    public void PageQuery(){
       DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
       pagebean.setDetachedCriteria(detachedCriteria);
       String page = model.getPage();
       pagebean.setCurrentPage(Integer.parseInt(page));
       service.PageQuery(pagebean);
       javaToJson(pagebean,new String[]{"parentFunction","roles","children"});
    }
    
    
    //根据当前登录人查询对应的菜单数据，返回json
    public String findMenu(){
       List<Function> list = service.findMenu();
       this.javaToJson(list,new String[]{"parentFunction","roles","children"});
       return NONE;
    }
}













