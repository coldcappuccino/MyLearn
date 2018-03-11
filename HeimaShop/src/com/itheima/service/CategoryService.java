package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.CategoryDao;
import com.itheima.domain.Category;
import com.itheima.domain.Product;

public class CategoryService {

  public List<Category> findAllCategory() {
    // TODO Auto-generated method stub
    CategoryDao dao = new CategoryDao();
    List<Category> categoryList = null;
    
       try {
        categoryList =  dao.findAllCategory();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
       
      return categoryList;
  }

}
