package com;


public class product {
    private int pro_id;
    private String pro_name;
    private String pro_introduce;
    private float pro_price;
    private String picture;
    private int pro_cag;
    
    public int getPro_cag() {
    	return pro_cag;
    }
    public void setPro_cag(int proCag) {
    	pro_cag = proCag;
    }

    public int getPro_id() {
    	return pro_id;
    }
    public void setPro_id(int proId) {
    	pro_id = proId;
    }
    public String getPro_name() {
    	return pro_name;
    }
    public void setPro_name(String proName) {
    	pro_name = proName;
    }
    public String getPro_details() {
    	return pro_introduce;
    }
    public void setPro_details(String proDetails) {
    	pro_introduce = proDetails;
    }
    public float getPro_price() {
    	return pro_price;
    }
    public void setPro_price(float proPrice) {
    	pro_price = proPrice;
    }
    public String getPicture() {
    	return picture;
    }
    public void setPicture(String picture) {
    	this.picture = picture;
    }
    
}

