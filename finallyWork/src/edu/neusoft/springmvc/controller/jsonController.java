package edu.neusoft.springmvc.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.neusoft.springmvc.model.User;
import net.sf.json.JSONArray;



@Controller
@RequestMapping("json")
public class jsonController {
   
    @RequestMapping("test")
    public String test(String str){
      
      JSONArray jArray= JSONArray.fromObject(str);
      Collection collection = JSONArray.toCollection(jArray,User.class);
      List list = new ArrayList();
      
      
      Iterator it = collection.iterator();    
      while (it.hasNext()) {
        User bean= (User) it.next();
        System.out.println(bean.getUsername());
        System.out.println(bean.getPassword());
      }
       return null;
       
       
    }
}






