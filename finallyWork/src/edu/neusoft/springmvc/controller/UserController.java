package edu.neusoft.springmvc.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import edu.neusoft.springmvc.model.resource;
import edu.neusoft.springmvc.model.Role_User;
import edu.neusoft.springmvc.model.Rource_Role;
import edu.neusoft.springmvc.model.User;
import edu.neusoft.springmvc.service.ResourceService;
import edu.neusoft.springmvc.service.Role_User_Service;
import edu.neusoft.springmvc.service.Rource_Role_Service;
import edu.neusoft.springmvc.service.UserService;



@Controller
@RequestMapping("user")
public class UserController {
    
    @Resource
    private UserService userService;
    
    @Resource
    private Role_User_Service r_u_s;
    
    @Resource
    private Rource_Role_Service r_r_s;
    
    @Resource
    private ResourceService r_s;
    
    @RequestMapping("login")
    public String login(String username,String password,HttpServletRequest req,HttpSession session,HttpServletResponse rep) throws IOException{
         
         User user = (User)session.getAttribute("currentuser");
         String url = null;
         if(user!=null){
              url = dispacher(req,session,user);
              return url;
         }else{
           user = userService.userlogin(username);
           if(user==null||!user.getPassword().equals(password)){
               return "login";
           }else{
               //设置cookie
               Cookie userNameCookie = new Cookie("loginUserName", user.getUsername());  
               Cookie passwordCookie = new Cookie("loginPassword", user.getPassword());  
               userNameCookie.setMaxAge(60*60);  
               userNameCookie.setPath("/finallyWork");  
               passwordCookie.setMaxAge(60*60);  
               passwordCookie.setPath("/finallyWork");  
               rep.addCookie(userNameCookie);  
               rep.addCookie(passwordCookie);  
               
               session.setAttribute("currentuser",user);
             
               url = dispacher(req,session,user);
               return url;
           }
         }
    }
    
    //分发跳转
    public String dispacher(HttpServletRequest req,HttpSession session,User user){
       
        User user2 = userService.SelectAllResource(user.getUid());
        List <resource>list = user2.getResources();
        System.out.println(list.size());
        if(list.size()==1){
           return "redirect:/category/index"; 
        }else{
           req.setAttribute("resource",list);
           return "admin/select";
        }
    }
    
    
    @RequestMapping("register")
    public String register(User user,HttpSession session){
       // System.out.println(user.getUid()+user.getUsername());
        User tempuser = userService.userlogin(user.getUsername());
        String msg = null;
        if(tempuser!=null){
           msg="该用户名已经存在";
           session.setAttribute("registerMsg",msg);
           return "redirect:/register.jsp";
        }else{
           int number = userService.userRegister(user);
           Role_User r_u = new Role_User();
           r_u.setUid(user.getUid());
           r_u.setRoleID(1);
           r_u_s.setRole(r_u);
           msg="注册成功";
           session.setAttribute("registerMsg",msg);
           return "redirect:/register.jsp";
        }
    }
    
    
    @RequestMapping("setRole")
    public String setRole(Role_User r_u){
       System.out.println(r_u.roleID);
       System.out.println(r_u.uid);
       // r_u_s.setRole(r_u);
       return "admin/setRight";
    }
    
    @RequestMapping("check")
    public void check(HttpServletRequest req,HttpServletResponse rep){
        //解决返回中文乱码问题  
        rep.setCharacterEncoding("utf-8");  
        String user = (String)req.getParameter("username");
   
        System.out.println(user);  
        String msg = null;  
        if("许老师".equals(user))  
        {  
            msg = "用户名已经被占用!";  
        }else  
        {  
            msg = "用户名可以使用!";  
        }  
        try {
          rep.getWriter().println(msg);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }  
    }
}








