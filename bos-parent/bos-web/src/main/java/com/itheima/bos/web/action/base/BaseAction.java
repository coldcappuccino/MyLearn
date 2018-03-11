package com.itheima.bos.web.action.base;

import java.io.IOException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.itheima.bos.domain.Region;
import com.itheima.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
 
  public static final String HOME = "home";
  public static final String LIST = "list";
  protected T model;        //
  
  //
  protected PageBean pagebean = new PageBean();
  public void setPage(int page) {
     pagebean.setCurrentPage(page);
 }


  public void setRows(int rows) {
     pagebean.setPageSize(rows);
  }
 
  
  //
  public void javaToJson(Object o,String[] excludes){
      JsonConfig jsonConfig = new JsonConfig();
  
      jsonConfig.setExcludes(excludes);
      
      String json = JSONObject.fromObject(o,jsonConfig).toString();
      ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
      
      try {
         ServletActionContext.getResponse().getWriter().print(json);
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
  }
  
  public void javaToJson(List o,String[] excludes){
    JsonConfig jsonConfig = new JsonConfig();

    jsonConfig.setExcludes(excludes);
    
    String json = JSONArray.fromObject(o,jsonConfig).toString();
    ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
    
    try {
       ServletActionContext.getResponse().getWriter().print(json);
    } catch (IOException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
    }
}
  
  public BaseAction() {
    ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
    
    Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
    Class<T> entityClass = (Class<T>) actualTypeArguments[0];
 
    try {
      model = entityClass.newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public T getModel() {
    // TODO Auto-generated method stub
    return model;
  }

}
