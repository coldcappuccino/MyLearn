package com.itheima.bos.utils;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


public class PageBean {
   private int CurrentPage;
   private DetachedCriteria detachedCriteria;
   private int pageSize;
   private int total;
   private List rows; 
   
  public int getCurrentPage() {
    return CurrentPage;
  }
  
  public void setCurrentPage(int currentPage) {
    CurrentPage = currentPage;
  }
  
  public DetachedCriteria getDetachedCriteria() {
    return detachedCriteria;
  }
  
  public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
    this.detachedCriteria = detachedCriteria;
  }
  
  public int getPageSize() {
    return pageSize;
  }
  
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
  
  public int getTotal() {
    return total;
  }
  
  public void setTotal(int total) {
    this.total = total;
  }
  
  public List getRows() {
    return rows;
  }
  
  public void setRows(List rows) {
    this.rows = rows;
  }
   
}








