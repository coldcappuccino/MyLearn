package edu.neusoft.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adminer")
public class AdminController {
    
    @RequestMapping("select")
    public String slelect(int id){
      
      if(id == 1){
         return "../category/index";
      }else if(id == 2){
         System.out.println("aaaa");
         return "admin/addbook";
      }else if(id ==3){
        return "admin/del";
      }else if(id ==4){
        return "admin/setRight";
      }else{
        return "../category/index";
      }
    }
}
