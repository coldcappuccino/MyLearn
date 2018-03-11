package edu.neusoft.springmvc.model;

public class Book {
   private String price;
   private String describe;
   private String picture;
   private String cagID;
   private int bookID;
   private String bookname;
   
   public String getPrice(){
      return price;
   }
    
   public void setPrice(String price) {
      this.price = price;
   }
    
   public String getDescribe() {
      return describe;
   }
    
   public void setDescribe(String describe) {
      this.describe = describe;
   }
    
   public String getPicture() {
      return picture;
   }
    
   public void setPicture(String picture) {
      this.picture = picture;
   }
    
   public String getCagID() {
      return cagID;
   }
    
   public void setCagID(String cagID) {
      this.cagID = cagID;
   }
    
   public int getBookID() {
      return bookID;
   }
    
   public void setBookID(int bookID) {
      this.bookID = bookID;
   }
    
   public String getBookname() {
      return bookname;
   }
    
   public void setBookname(String bookname) {
      this.bookname = bookname;
   }
      
}
