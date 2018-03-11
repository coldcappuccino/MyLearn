<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <ul>
     <%
        String user = (String)session.getAttribute("username");
        if(user==null){
           user="";
        }
     %>
     <li><span><%=user%>欢迎你！</span></li>
     <li><a href="/shop3/index.jsp">返回首页</a></li>
     <%
        String url="";
        if(session.getAttribute("shop")==null){
        	url="/shop3/shop/ClearShopOk.jsp";
        }else{
        	url="/shop/shop/show.jsp";
        }
     %>
     <li><a href=<%=url%>><span>购物车</span></a></li>
     <li><a href="/shop3/reg_login/login.jsp"><span>登录</span></a></li>
     <li><a href="/shop3/reg_login/reg.jsp"><span>注册</span></a></li>
     <li><a href="/shop3/reg_login/reg.jsp"><span>注销</span></a></li>
   </ul>
</body>
</html>

