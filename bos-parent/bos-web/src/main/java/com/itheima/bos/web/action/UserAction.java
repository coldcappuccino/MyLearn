package com.itheima.bos.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.itheima.bos.domain.User;
import com.itheima.bos.service.IUserService;
import com.itheima.bos.utils.BOSUtils;
import com.itheima.bos.utils.MD5Utils;
import com.itheima.bos.web.action.base.BaseAction;
import com.itheima.crm.Customer;
import com.itheima.crm.ICustomerService;



@Controller
@Scope("prototype")
public class UserAction extends BaseAction<User> {
     
  
     private String checkcode;
     
     public void setCheckcode(String checkcode) {
         this.checkcode = checkcode;
     }

    
     @Autowired
     private IUserService userService;
     
     //用户登录，使用shiro框架提供的方式进行认证操作
     public String login(){
     
         String validatecode = (String) ServletActionContext.getRequest().getSession().getAttribute("key");
      
         if(StringUtils.isNotBlank(checkcode) && checkcode.equals(validatecode)){
                Subject subject = SecurityUtils.getSubject();//subject对象类似User,当前用户对象，状态为未认证
                AuthenticationToken token = new UsernamePasswordToken(model.getUsername(),MD5Utils.md5(model.getPassword())); //创建用户密码令牌对象
                try{
                   subject.login(token);  
                }catch(Exception e){
                   e.printStackTrace();
                   return LOGIN;
                }
                User user = (User) subject.getPrincipal();
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", user);
                return HOME;
         }else{
           
             this.addActionError("验证码错误");
             return LOGIN;
         } 
          
     }
     
     //
     public String logout(){
       ServletActionContext.getRequest().getSession().invalidate();
       return LOGIN;
     }
     
     
     //
     public String editPassword(){
         String f = "1";
         //
         User user = BOSUtils.getLoginUser();
         try{
             userService.editPassword(user.getId(),model.getPassword());
         }catch(Exception e){
             f="0";
             e.printStackTrace();
         }
         
         
          try {
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            ServletActionContext.getResponse().getWriter().print(f);
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          };
      
         return NONE;
     }
     
     private String[] roleIds;
     
    public void setRoleIds(String[] roleIds) {
      this.roleIds = roleIds;
    }
    
    
    public String add(){
       String password = model.getPassword();
       model.setPassword(MD5Utils.md5(password));
       userService.save(model,roleIds);
       return LIST;
    }
    
    public String pageQuery(){
       DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
       pagebean.setDetachedCriteria(detachedCriteria);
       userService.pageQuery(pagebean);
       this.javaToJson(pagebean,new String[]{"roles","noticebills"});
       return NONE;
    }
}










