package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Category;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;

public class CategoryDao {

  public List<Category> findAllCategory() throws SQLException {
    // TODO Auto-generated method stub
    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    String sql = "select * from category";
    
    return runner.query(sql,new BeanListHandler<Category>(Category.class));
  }

}
