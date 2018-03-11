package edu.neusoft.springmvc.dao;

import java.util.List;

import edu.neusoft.springmvc.model.Role_User;

public interface Role_User_Dao {
     public  Role_User selectRole_User(int uid);
     
     public void setRole(Role_User r_u);
}
