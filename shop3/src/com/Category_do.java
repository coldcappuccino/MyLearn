package com;
import java.sql.ResultSet;
import java.util.*;


public class Category_do {
   condb cdb = null;
   
   public Category_do(){
	   cdb = new condb();
   }
   
   //�������
   public void add(Category actegory){
	   
	   int c_id = actegory.GetcagID();
	   String c_Name = actegory.GetcagName();
	   
	   try {
			
			cdb.executeUpdate("INSERT INTO category (id,cag_name) VALUES ("+c_id+",'"+c_Name+"')");    
	
		} catch (Exception e) {
			e.printStackTrace();
		} 
   }
   
   //�޸���Ŀ
   public void modify(Category category){
	   try {
			
			String  c_name=category.GetcagName();
			int c_id=category.GetcagID();
			cdb.executeUpdate("UPDATE category SET  cag_name='"+c_name+"' WHERE id="+c_id);
		
		}catch (Exception e) {
			e.printStackTrace();
		} 
   }
   
   //ɾ����Ŀ
   public void delete(int id){
	   
	   try{
		   cdb.executeUpdate("delete from category WHERE id="+id);
	   }catch(Exception e){
		   e.printStackTrace();
	   }
   }
   
   //�õ�������Ŀ
   public Collection getall(){
	   
		   Collection c = new ArrayList();
		   ResultSet rs = null;
		try{
		   rs = cdb.executeQuery("select * from category");
		   
		   while(rs.next()){
			   Category a = new Category();
			   a.SetcagID(rs.getInt("id"));
			   a.SetcagName(rs.getString("cag_name"));
			   c.add(a);
		   }
		   
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   
	  return c;
   }  
   
   //����ID�õ���Ŀ
   public Category getbyID(int id){
	   Category a = new Category();
	   ResultSet c = null;
	   try{
		   
		   c = cdb.executeQuery("SELECT * FROM  category WHERE id ="+id);
		   
		   if(c.next()){
			   a.SetcagID(c.getInt("id"));
			   a.SetcagName(c.getString("cag_name"));
		   }
		   
	   }catch(Exception e){
		   e.printStackTrace();
	   }
	   return a;
   }
   
}












