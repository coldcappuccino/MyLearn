package edu.neusoft.springmvc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.neusoft.springmvc.model.User;
import edu.neusoft.springmvc.model.shoppingcart;
import edu.neusoft.springmvc.service.shoppingcart_Service;

@Controller
@RequestMapping("buySys")
public class buySysController {
    
  @Resource
  shoppingcart_Service s_c_s;
  
  @RequestMapping("addCart")
  public String shoppingCart(shoppingcart shopcart,HttpSession session,HttpServletRequest req){
    
      User user = (User)session.getAttribute("currentuser");
      shopcart.setUid(user.getUid());
      int number = s_c_s.addshoppingcart(shopcart);
      System.out.println(number);
      return "tempCart";
  }
  
  
}
