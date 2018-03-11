<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
     <p>${upfilemsg}</p> 
    <p>添加图书</p>
    <form action="../product/add" method="post" enctype="multipart/form-data">
                            上传图片:<input type="file" name="myfile" /><br/>
                            书籍ID:<input type="text" name="bookID"><br/>
                            种类ID:<input type="text" name="cagID"><br/>
                            书名:<input type="text" name="bookname"><br/>
                             描述:<input type="text" name="describe"><br/>
                             价格:<input type="text" name="price"><br/>
        <input type="hidden" name="picture" value=""><br/>
 	    <input type="submit" value="提交">
    </form>
</body>
</html>