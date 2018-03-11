package com;
import java.sql.ResultSet;
import java.util.*;

public class product_do {
    condb cdb =  new condb();
    //跟据CategoryId得到属于某一分类的全部商品
    public Collection getAllbyID(int cagID){
    	Collection c = new ArrayList();
    	ResultSet rs = null;
    	try{
    		 product product1 = null;
    		 cdb.preparedstatment("SELECT * FROM products WHERE pro_cag= ? order by pro_id desc");
    		 cdb.setInt(1,cagID);
    		 rs = cdb.executeQuery(); 
    		/*
    		cdb.preparedstatment("SELECT * FROM products WHERE pro_cag = ? order by pro_id desc");
 			cdb.setInt(1,cagID);
 			product product = null;
 			rs = cdb.executeQuery();
    		product product1 = null;
    		*/
    		while (rs.next()) {
				product1 = new product();
				product1.setPro_id(rs.getInt("pro_id"));
				product1.setPro_name(rs.getString("pro_name"));
				product1.setPro_details(rs.getString("pro_details"));				
				product1.setPro_price(rs.getFloat("pro_price"));
				product1.setPicture(rs.getString("picture"));
				c.add(product1);
			}
    	}catch(Exception e){
    		e.getMessage();
    	}
    	
    	return c;
    }
    
    //添加商品
    public void addProduct(product product1){
    	try{
    	   cdb.preparedstatment("INSERT INTO products (pro_name,pro_details,pro_cag,pro_price,picture) VALUES ( ?,?,?,?,?)");
    	   cdb.setString(1,product1.getPro_name());
		   cdb.setString(2,product1.getPro_details());
		   cdb.setInt(3,product1.getPro_cag());
		   cdb.setFloat(4,product1.getPro_price());
		   cdb.setString(5,product1.getPicture());
			
		   cdb.executeUpdate();
    	}catch(Exception e){
    		e.getMessage();
    	}
    }
    
    //查询所有商品
    public Collection getAll(){
    	Collection c = null;
    	product product1 = new product();
    	try{
    		ResultSet rs = cdb.executeQuery("select * from products order by pro_id asc");
    		while(rs.next()){
				product1.setPro_id(rs.getInt("pro_id"));
				product1.setPro_name(rs.getString("pro_name"));
				product1.setPro_details(rs.getString("pro_details"));
				product1.setPro_cag(rs.getInt("pro_cag"));
				product1.setPro_price(rs.getFloat("pro_price"));
				product1.setPicture(rs.getString("picture"));
				c.add(product1);
    		}
    	}catch(Exception e){
    		e.getMessage();
    	}
    	
    	return c;
    }
    
    //删除商品信息
    public void deleID(int id){
    	try{
            cdb.executeUpdate("delete from products WHERE pro_id="+id);
    	}catch(Exception e){
    		e.getMessage();
    	}
    }
    
    //根据ID得到商品信息
    public product getByID(int id){
    	product product1 = new product();
    	try{
    	  ResultSet rs = cdb.executeQuery("SELECT * FROM products WHERE pro_id ="+id);
    	  if (rs.next()) {    	
				product1.setPro_id(rs.getInt("pro_id"));
				product1.setPro_name(rs.getString("pro_name"));
				product1.setPro_details(rs.getString("pro_details"));
				product1.setPro_cag(rs.getInt("pro_cag"));
				product1.setPro_price(rs.getFloat("pro_price"));
				product1.setPicture(rs.getString("picture"));			
		  }
    	}catch(Exception e){
    		e.getMessage();
    	}
    	
    	return product1;
    }
    
    //修改商品
    public void editProduct(product product1,int pro_id){
        try {
        	
        			cdb.preparedstatment("update products set pro_name=?,pro_details=?,pro_cag=?,pro_price=?,picture=? where pro_id="+pro_id);
        			cdb.setString(1, new String(product1.getPro_name().getBytes("ISO8859_1"),"UTF-8"));
        			cdb.setString(2, new String(product1.getPro_details().getBytes("ISO8859_1"),"UTF-8"));
        			cdb.setInt(3,product1.getPro_cag());
        			cdb.setFloat(4,product1.getPro_price());
        			cdb.setString(5,product1.getPicture());			
        			cdb.executeUpdate();

        		} catch (Exception e) {
        			e.getMessage();
        		}
    }
}






