package edu.neusoft.springmvc.dao;

import java.util.List;

import edu.neusoft.springmvc.model.Sale;

public interface SaleDao {
     public int add(Sale sale);
     
     public int delete(String id);
     
     public int update(Sale sale);
     
     public List<Sale> getall();
     
     public List<Sale> getbyPage(int startRow, int pageSize);
}
