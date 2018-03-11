package com.itheima.bos.web.interceptor;
import com.itheima.bos.utils.BOSUtils;
import org.aopalliance.intercept.Invocation;
import org.apache.struts2.ServletActionContext;

import com.itheima.bos.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


public class BOSLoginInterceptor extends MethodFilterInterceptor{

  
  protected String doIntercept(ActionInvocation invocation) throws Exception {
 
     User user = BOSUtils.getLoginUser();
     if(user == null){
         return "login";
         
     }
     return invocation.invoke();
     
  }

  
}
