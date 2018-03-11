package edu.neusoft.springmvc.model;

public class shoppingcart {
    private int price;
    private int number;
    private int bookID;
    private int uid;
    
    public int getPrice() {
      return price;
    }
    
    public void setPrice(int price) {
      this.price = price;
    }
    
    public int getNumber() {
      return number;
    }
    
    public void setNumber(int number) {
      this.number = number;
    }
    
    public int getBookID() {
      return bookID;
    }
    
    public void setBookID(int bookID) {
      this.bookID = bookID;
    }
    
    public int getUid() {
      return uid;
    }
    
    public void setUid(int uid) {
      this.uid = uid;
    }
    
}
