package com.itheima.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.itheima.dao.AdminDao;
import com.itheima.domain.Order;
import com.itheima.domain.Product;

public class AdminService {

  
  public void saveProduct(Product product) {
    // TODO Auto-generated method stub
     AdminDao dao = new AdminDao();
       try {
        dao.saveProduct(product);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  }

  public List<Order> findAllOrders() {
     AdminDao dao = new AdminDao();
     List<Order> list = null;
     try {
      list = dao.findAllOrders();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
     return list;
  }

  public List<Map<String, Object>> findOrderInfoByOid(String oid) {
     AdminDao dao = new AdminDao();
     List<Map<String, Object>> list = null;
     try {
      list = dao.findOrderInfoByOid(oid);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
     return list;
  }

}
