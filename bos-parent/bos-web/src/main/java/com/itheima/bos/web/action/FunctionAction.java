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
    
    //��ѯ����Ȩ�ޣ�����json����
    public String listajax(){
      List<Function> list =  service.findAll();
      javaToJson(list,new String[]{"parentFunction","roles"});
      return NONE;
    } 
    
    //���һ��Ȩ��
    public String add(){
       service.add(model);
       return LIST;
    }
    
    //�������ݱ��
    public void PageQuery(){
       DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
       pagebean.setDetachedCriteria(detachedCriteria);
       String page = model.getPage();
       pagebean.setCurrentPage(Integer.parseInt(page));
       service.PageQuery(pagebean);
       javaToJson(pagebean,new String[]{"parentFunction","roles","children"});
    }
    
    
    //���ݵ�ǰ��¼�˲�ѯ��Ӧ�Ĳ˵����ݣ�����json
    public String findMenu(){
       List<Function> list = service.findMenu();
       this.javaToJson(list,new String[]{"parentFunction","roles","children"});
       return NONE;
    }
}













