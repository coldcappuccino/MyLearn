package com.itheima.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class ProductService {

  public List<Product> findhotProduct() {
    // TODO Auto-generated method stub
     ProductDao dao = new ProductDao();
     List<Product> hotProductList = null;
     
     try {
       hotProductList =  dao.findhotProduct();
     } catch (SQLException e) {
      // TODO Auto-generated catch block
       e.printStackTrace();
     }
     
     return hotProductList;
  }

  public List<Product> findnewProduct() {
    // TODO Auto-generated method stub
    ProductDao dao = new ProductDao();
    List<Product> newProductList = null;
    
    try {
      newProductList =  dao.findnewProduct();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
    return newProductList;
  }

  public PageBean findProductListByCid(String cid,int currentPage,int currentCount) {
      //封装一个pagebean,返回web层
      PageBean<Product> pageBean = new PageBean<Product>();
      ProductDao dao = new ProductDao();
      
      //封装当前页
      pageBean.setCurrentPage(currentPage);
      //每页显示的条数
      pageBean.setCurrentCount(currentCount);
      //封装总条数
      int TotaoCount = 0;
      try {
        TotaoCount = dao.getCount(cid);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      pageBean.setTotalCount(TotaoCount);
      
      //封装总页数
      int totalPage = (int) Math.ceil(1.0*TotaoCount/currentCount);
      pageBean.setTotalPage(totalPage);
      
      //当前页显示的数据
      int index = (currentPage-1)*currentCount;
      List<Product> list = null;
      try {
        list = dao.findProductByPage(cid,index,currentCount);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      pageBean.setList(list);
      return pageBean;
  }

  public Product findProductByPid(String pid) {
     ProductDao dao = new ProductDao();
     Product product = null;
     
     try {
      product = dao.findProductByPid(pid);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
     return product;
  }

  public void submitOrder(Order order) {
      // TODO Auto-generated method stub
      ProductDao dao = new ProductDao();
      try {
        //1、开启事务
        DataSourceUtils.startTransaction();
        //2、调用dao存储order表数据的方法
        dao.addOrders(order);
        //3、调用dao存储orderitem表数据的方法
        dao.addOrderItem(order);
        
      } catch (SQLException e) {
        try {
          DataSourceUtils.rollback();
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
        e.printStackTrace();
      } finally {
        try {
          DataSourceUtils.commitAndRelease();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }

  public void updateOrderAdrr(Order order) {
    // TODO Auto-generated method stub
    ProductDao dao = new ProductDao();
    try {
      dao.updateOrderAdrr(order);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateOrderState(String r6_Order) {
      ProductDao dao = new ProductDao();
      try {
        dao.updateOrderState(r6_Order);
      } catch (SQLException e) {
        e.printStackTrace();
      }
  }
  
  //获得用户的指定订单集合
  public List<Order> findAllOrders(String uid) {
     // TODO Auto-generated method stub
     ProductDao dao = new ProductDao();
     List<Order> orderList = null;
     try {
       orderList = dao.findAllOrders(uid);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
     return orderList;
  }

  public List<Map<String,Object>> findOrderItems(String oid) {
    // TODO Auto-generated method stub
     ProductDao dao = new ProductDao();
     List<Map<String,Object>> orderItemList = null;
     
     try {
       orderItemList = dao.findAllOrdersItems(oid);
     } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
     }
     
     return orderItemList;
    
  }

}






