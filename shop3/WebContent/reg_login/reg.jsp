<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <%@include file="../header.jsp"%>
    </div>
    <div>
        <form action="../Register" method="get">
                                           用户名<input type="text" name="username"><br>
                                           密码<input type="text" name="password"><br>
                                          邮箱<input type="text" name="email"><br>
            <input type="submit" value="提交">
        </form>
    </div>
</body>
</html>