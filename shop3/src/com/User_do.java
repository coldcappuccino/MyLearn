
package com;

import java.sql.ResultSet;
import java.util.Collection;

public class User_do {
    private condb cdb = new condb();
    
    //添加用户
    public int addUser(User user){
    	String name = user.getUser();
    	String password = user.getPsw();
    	String email = user.getEmail();
    	int n = 0;
    	try{
    		
    		ResultSet rs = null;
    		rs = cdb.executeQuery("SELECT * FROM user WHERE username ='"
    				+ user.getUser() + "'");
    		
    		if(!rs.next()){
	    		cdb.preparedstatment("insert into user values(?,?,?)");
	    		cdb.setString(1,name);
	    		cdb.setString(2,password);
	    		cdb.setString(3, email);
	    		
	    		cdb.executeUpdate();
	    		n =1;
    		}
    	}catch(Exception e){
    		 e.printStackTrace();
    	}
    	return n;
    }
    
    //查询用户
    public boolean checkUser(User u){
    	ResultSet rs = null;
    	try{
    	   rs= cdb.executeQuery("SELECT * FROM user WHERE username='"+u.getUser()+
    			"'and userpsw='"+u.getPsw()+"'");  
    	   if(rs.next()){
    		   return true;
    	   }
    	}catch(Exception e){
    		 e.printStackTrace();
    	}
    	return false;
    }
    
    //查询所有用户的信息
    public Collection Getall(){
    	Collection c = null;
    	User user = null;
    	try{
    		ResultSet rs = null;
    		rs = cdb.executeQuery("SELECT * FROM user");
    		while(rs.next()){
    		   user.setUser(rs.getString("username"));
    		   user.setPsw(rs.getString("userpsw"));
    		   user.setEmail(rs.getString("email"));
    		}
    	}catch(Exception e){
   		 e.printStackTrace();
   	    }
    	return c;
    }
    
    //重置密码
	public void initPsw(String userName,String psw) {
		try {
			cdb.executeUpdate("update user set userpsw='"+psw+"' where username='"+ userName+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








