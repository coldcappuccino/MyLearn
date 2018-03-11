<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"  import="java.util.*,edu.neusoft.springmvc.model.resource"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <p>选择要进行的操作</p>
    <ul>
    <%
        List<resource>list = (List<resource>)request.getAttribute("resource");
        for(resource item:list){
        %>
           <li><a href="../adminer/select?id=<%=item.getSourceID()%>"><%=item.getSourcename()%></a></li>
        <%
        }
    %>
    </ul>
</body>
</html>