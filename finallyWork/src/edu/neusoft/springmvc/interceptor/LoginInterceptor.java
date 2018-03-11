package edu.neusoft.springmvc.interceptor;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.neusoft.springmvc.model.User;
import edu.neusoft.springmvc.service.UserService;

public class LoginInterceptor implements HandlerInterceptor{
  
  @Resource
  private UserService userService;
  @Override
  public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
    // TODO Auto-generated method stub
    
  }

  public boolean preHandle(HttpServletRequest req, HttpServletResponse arg1, Object arg2) throws Exception {
     User user =  (User)req.getSession().getAttribute("currentuser");
     
     if(user==null){
       String loginCookieUserName = "";  
       String loginCookiePassword = "";
       Cookie[] cookies = req.getCookies();  
       if(cookies!=null){
           for(Cookie cookie : cookies){
               if("loginUserName".equals(cookie.getName())){  
                   loginCookieUserName = cookie.getValue();
               }else if("loginPassword".equals(cookie.getName())){  
                   loginCookiePassword = cookie.getValue();
               }     
           }   
           user = userService.userlogin(loginCookieUserName);
           if(user!=null&&user.getPassword().equals(loginCookiePassword)){
             req.getSession().setAttribute("currentuser",user);
           }
       }
     }
     return true;
  }

}










