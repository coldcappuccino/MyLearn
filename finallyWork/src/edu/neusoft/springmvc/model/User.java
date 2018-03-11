package edu.neusoft.springmvc.model;

import java.util.List;

public class User {
  
  private String username;
  private String password;
  private int uid;
  
  private List <resource> resources;
   
  public List<resource> getResources() {
    return resources;
  }

  public void setResources(List<resource> resources) {
    this.resources = resources;
  }

  public int getUid(){
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
   
}
