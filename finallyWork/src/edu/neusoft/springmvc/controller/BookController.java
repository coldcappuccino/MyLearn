package edu.neusoft.springmvc.controller;

import java.io.File;
import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.neusoft.springmvc.model.Book;
import edu.neusoft.springmvc.service.BookService;


@Controller
@RequestMapping("product")
public class BookController {
    
  @Resource
  private BookService bookservice; 
  
  @RequestMapping("showproduct")
  public String showproduct(String id,HttpSession session,HttpServletRequest req){
      
      List<Book> list = null;   
      list = bookservice.findproduct(id);
      
      req.setAttribute("list",list);
      return "show";
  }
  
  
  
  @RequestMapping("calculate")
  public String calculate(HttpServletRequest req,HttpSession session){
    
    List<Book> list = (List<Book>) session.getAttribute("Cart");
    int i = 0;
    int count = 0;
    for(Book book:list){
        int num =  Integer.parseInt(req.getParameter(""+i));
        System.out.println(num+"aaaa");
        count += num*Integer.parseInt(book.getPrice());
    }
    req.setAttribute("count",count);
    return "pay";
  }
  
  @RequestMapping(value="/add",method=RequestMethod.POST)
  public String addbook(MultipartFile myfile,HttpServletRequest req,HttpSession session){  
     String path = "C:"+File.separator+"Users"+File.separator+"LZW"+File.separator+"workspace"+File.separator+"finallyWork"+File.separator+"WebContent"+File.separator+"image"+File.separator; 
     String fileName = myfile.getOriginalFilename();
     String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
     System.out.println(prefix);
     
     if(!prefix.equals("jpg")&&!prefix.equals("png")){
       String msg = "上传的文件格式非法";
       session.setAttribute("upfilemsg",msg);
       return "admin/addbook";
     }
     
     File targetFile = new File(path, fileName);
     if(targetFile.exists()){
         String msg = "上传的文件已经存在";
         session.setAttribute("upfilemsg",msg);
         return "admin/addbook";
     }
     
     
     String bookID = (String)req.getParameter("bookID");
     String bookname = (String)req.getParameter("bookname");
     String cagID = (String)req.getParameter("cagID");
     String describe = (String)req.getParameter("describe");
     String price = (String)req.getParameter("price");
     int id = Integer.parseInt(bookID);
     
     Book book = new Book();
     book.setBookID(id);
     book.setBookname(bookname);
     book.setCagID(cagID);
     book.setDescribe(describe);
     book.setPicture(fileName);
     book.setPrice(price);
     
     bookservice.addBook(book);
     try 
     {  
       myfile.transferTo(targetFile);  
       String msg = "上传的文件已经存在";
       session.setAttribute("upfilemsg",msg);
     } catch (Exception e) {  
       e.printStackTrace();  
     }
 
     return "admin/addbook";
  }
  
  @RequestMapping("delete")
  public String deletebook(int bookID){
    bookservice.deleteBook(bookID);
    return "admin/del";
  }
  
}














