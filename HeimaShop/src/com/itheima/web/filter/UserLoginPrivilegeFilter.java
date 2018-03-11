package com.itheima.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itheima.domain.User;

public class UserLoginPrivilegeFilter implements Filter{

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
        //У���û��Ƿ��¼
        System.out.println("aaaa");
        HttpServletRequest request= (HttpServletRequest)arg0;
        HttpSession session = request.getSession();
        HttpServletResponse response = (HttpServletResponse)arg1;
        //�ж��û��Ƿ��Ѿ���¼ δ��¼������벻ִ��
        
        User user = (User) session.getAttribute("user");
       
        if(user==null){
          //û�е�¼
          response.sendRedirect(request.getContextPath()+"/login.jsp");
          return;
        }
        
        chain.doFilter(arg0, arg1);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub
    
  }
    
}
