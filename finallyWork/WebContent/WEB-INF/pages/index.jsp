<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,edu.neusoft.springmvc.model.Category"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <p>图书种类</p>
    <ul>
    <%
     // List list = session.getAttribute("list");
    %>
    
     <%
      List <Category>list = new ArrayList(); 
      list = (List)request.getAttribute("list");
      
      for(Category category:list){
         %>
           <li><a href="../product/showproduct?id=<%=category.GetcagID()%>"><span><%=category.GetcagName()%></span></a></li>
         <%
      }
    %>
    </ul>
</body>
</html>