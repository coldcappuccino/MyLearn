package edu.neusoft.springmvc.service;

import java.util.List;



import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.Role_User_Dao;
import edu.neusoft.springmvc.model.Role_User;

@Service
public class Role_User_Service {
     
   @Resource
   private Role_User_Dao r_u_d;
   
   public Role_User selectRole_User(int uid){
       return r_u_d.selectRole_User(uid);
   }
   
   public void setRole(Role_User r_u){
        r_u_d.setRole(r_u);
   }
}
