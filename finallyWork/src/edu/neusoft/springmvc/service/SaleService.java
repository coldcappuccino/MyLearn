package edu.neusoft.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.SaleDao;
import edu.neusoft.springmvc.model.Sale;

@Service
public class SaleService {
    
  @Resource
  private SaleDao saledao;
  
   public int add(Sale sale){
       return saledao.add(sale);
   }
   
   public int delete(String id){
      return saledao.delete(id);
   }
   
   public int update(Sale sale){
      return saledao.update(sale);
   }
   
   public List<Sale> getall(){
     
      return saledao.getall();
   }
   
   public List<Sale> getbyPage(int startRow, int pageSize){
      return saledao.getbyPage(startRow,pageSize);   
   }
   
}
