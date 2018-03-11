package edu.neusoft.springmvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.neusoft.springmvc.dao.BookDao;
import edu.neusoft.springmvc.model.Book;

@Service
public class BookService {
    
  @Resource
  private BookDao bookDao;
  
  public List<Book> findproduct(String cagid){
    
       return bookDao.findproduct(cagid);   
  }
  
  public Book findbybookid(int bookid){
     
     return bookDao.findbybookid(bookid);
  }
  
  public void addBook(Book book){
      bookDao.addBook(book);
  }
  
  public void deleteBook(int id){
     bookDao.deleteBook(id);
  }
}
