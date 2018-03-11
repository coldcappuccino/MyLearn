package edu.neusoft.springmvc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.shoppingcart_Dao;
import edu.neusoft.springmvc.model.shoppingcart;

@Service
public class shoppingcart_Service {
    
     @Resource
     shoppingcart_Dao s_d;
     
     public int addshoppingcart(shoppingcart shop){
        return s_d.addCart(shop);
     }
}
