package edu.neusoft.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.Rource_Role_Dao;
import edu.neusoft.springmvc.model.Rource_Role;

@Service
public class Rource_Role_Service {
  
     @Resource
     private Rource_Role_Dao r_r_d;
     
     public List<Rource_Role> selectResource(int roleid){
            
         return r_r_d.selectResource(roleid);
     }
}
