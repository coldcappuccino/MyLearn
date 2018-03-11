package edu.neusoft.springmvc.dao;

import edu.neusoft.springmvc.model.User;

public interface UserDao {
   
    public User userlogin(String username);
    
    public int userRegister(User user);
    
    public User SelectAllResource(int uid);
}
