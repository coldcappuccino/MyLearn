<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <div>
     <%@include file="../header.jsp"%>
     </div>
     
     <div>
        <form action="../Login" method="get">
           <p>用户名</p><input type="text" name="name">
           <p>密码</p><input type="text" name="password">
           <br>
           <input type="submit" value="登录">
           <input type="button" name="reg" value="注册" onclick="window.location.href('reg.jsp')"> <br>
        </form>
     </div>
     
     
</body>
</html>