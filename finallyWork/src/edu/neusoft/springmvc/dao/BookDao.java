package edu.neusoft.springmvc.dao;

import java.util.List;

import edu.neusoft.springmvc.model.Book;

public interface BookDao {
    public List<Book> findproduct(String cagid);
    
    public Book findbybookid(int bookid);
    
    public void addBook(Book book);
    
    public void deleteBook(int id);
}
