package edu.neusoft.springmvc.controller;

import java.io.IOException;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.neusoft.springmvc.model.Category;
import edu.neusoft.springmvc.service.CategoryService;;
@Controller
@RequestMapping("category")
public class CategoryController {
  
  @Resource
  private CategoryService categoryservice; 
  
   @RequestMapping("index")
   public String index(HttpSession session,HttpServletRequest req){
      List<Category>list = null;
      list = categoryservice.selectAllCategory();
      
      req.setAttribute("list",list);
      
      return "index";
   }
}
