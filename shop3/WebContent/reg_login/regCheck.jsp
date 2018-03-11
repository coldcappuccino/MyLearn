<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

 <div>
   <%
   int n=Integer.parseInt(request.getParameter("num"));
    if(n==0){
    	
     %>
            用户名已存在，请重新注册<a href="reg.jsp">返回</a>
    <%
    }else{
    	
    	response.sendRedirect("../index.jsp");
    }
    
   %>
   </div> 
</body>
</html>