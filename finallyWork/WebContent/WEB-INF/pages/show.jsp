<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,edu.neusoft.springmvc.model.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

    <%
      List <Book>list = null; 
      list = (List<Book>)request.getAttribute("list");
      
      for(Book book:list){
         String pic = "../image/"+book.getPicture();
         %>
           <form action="../buySys/addCart">
              <ul>
                 <li><%=book.getBookname()%></li>
                 <li><img src=<%=pic%> width="200" height="200"/></li>
                 <li> <p><%=book.getDescribe()%></p></li>
                 <li>数量<input type="text" name="number"/></li>
                 <li><span>价格:<%=book.getPrice()%></li>
                 <li><input type="hidden" name="price" value="<%=book.getPrice()%>"/></li>
                 <li><input type="hidden" name="bookID" value="<%=book.getBookID()%>"/></li>
              </ul>
               <input type="submit" value="添加到购物车">
           </form>
        <%
      }
    %>
</body>
</html>