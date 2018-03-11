package edu.neusoft.springmvc.model;

public class Sale {
    String UUID;
    String Title;
    String CustomerID;
    String PrincipallID;
    String Provider;
    
    public String getUUID() {
      return UUID;
    }
    public void setUUID(String uUID) {
      UUID = uUID;
    }
    public String getTitle() {
      return Title;
    }
    public void setTitle(String title) {
      Title = title;
    }
    public String getCustomerID() {
      return CustomerID;
    }
    public void setCustomerID(String customerID) {
      CustomerID = customerID;
    }
    public String getPrincipallID() {
      return PrincipallID;
    }
    public void setPrincipallID(String principallID) {
      PrincipallID = principallID;
    }
    
    public String getProvider() {
      return Provider;
    }
    
    public void setProvider(String provider) {
      Provider = provider;
    }
    public Sale() {
      super();
      // TODO Auto-generated constructor stub
    }
    public Sale(String uUID, String title, String customerID, String principallID, String provider) {
      super();
      UUID = uUID;
      Title = title;
      CustomerID = customerID;
      PrincipallID = principallID;
      Provider = provider;
    }
    
}
