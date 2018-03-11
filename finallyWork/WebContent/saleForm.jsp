<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
           添加
   <form action="sale/add"  method="POST">
                     销售机会序号:<input type="text" name="UUID"><br/>
 	       销售机会主题<input type="text" name="Title"><br/> 
 	       客户ID:<input type="text" name="CustomerID"><br/>
 	       提供人:<input type="text" name="Provider"><br/>
 	        负责人:<input type="text" name="PrincipallID"><br/> 
 	  <input type="submit" value="提交">
   </form>
   
   <br/>
           
            删除
   <form action="sale/delete" method="POST">
                       销售机会序号:<input type="text" name="UUID"><br/>
      <input type="submit" value="提交">
   </form>
   
   <br/>
   
            修改
   <form action="sale/update" method="POST">
                          销售机会序号:<input type="text" name="UUID"><br/>
 	            销售机会主题<input type="text" name="Title"><br/> 
 	           客户ID:<input type="text" name="CustomerID"><br/>
 	           提供人:<input type="text" name="Provider"><br/>
 	           负责人:<input type="text" name="PrincipallID"><br/> 
 	  <input type="submit" value="提交">
   </form>
   
   <br/>
   <a href="sale/select">查询所有</a>
</body>
</html>





















