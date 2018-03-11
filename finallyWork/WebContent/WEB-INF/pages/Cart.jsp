<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,edu.neusoft.springmvc.model.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <form action="calculate">
    <%
       List<Book> list =(List<Book>)session.getAttribute("Cart");
       int name = 0;
       for(Book book:list){
       %>
	      <ul>
	      <li><%=book.getBookname()%></li>
	      <li><span>价格:<%=book.getPrice()%></span></li>
	      <li><span><input type="text" name=<%=name%> size="2">本</span></li>
	      <li><a href="del.jsp?id=<%=name%>">删除</a></li>
	      </ul>
      <%
      }
    %>
     <span> <input type="submit" name="ok"  value="订单确认"></span>
    </form>
</body>
</html>