<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script>
	var xmlHttpReq;  
	//创建一个XmlHttpRequest对象  
	function createXmlHttpRequest()  
	{  
	  if(window.XMLHttpRequest)  
	  {  
	     xmlHttpReq = new XMLHttpRequest();//非IE浏览器  
	  }else  
	  {  
	     xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");//IE浏览器  
	  }  
	}

	//检测用户名是否已经被注册  
	function checkUser()  
	{  
	var username = document.getElementById("user").value;  
	if(username=="")  
	{  
	    alert("用户名必须填写！");  
	    return false;  
	}  
	//首先创建精灵对象  
	createXmlHttpRequest();  
	//指明准备状态改变时回调的函数名  
	xmlHttpReq.onreadystatechange=handle;  
	//尝试以异步的get方式访问某个URL  
	//请求服务器端的一个servlet  
	var url = "user/check?username="+username;  
	xmlHttpReq.open("get",url,true);  
	//向服务器发送请求  
	xmlHttpReq.send(null);  
	}  
	
	//状态发生改变时回调的函数  
	function handle()  
	{  
	    //准备状态为4  
	    if(xmlHttpReq.readyState==4)  
	    {  
	        //响应状态码为200，代表一切正常  
	       if(xmlHttpReq.status==200)  
	       {  
	           var res = xmlHttpReq.responseText;  
	           var result = document.getElementById("result");  
	           result.innerHTML = "<font color=red>"+res+"</font>";  
	       }  
	    }  
	}  
</script>
</head>
<body>
	<center><h1>表单注册</h1></center>  
	<hr>  
	姓名:  
	<input type="text" id="user">  
	<input type="button" value="检测用户名" onclick="checkUser()">  
	<span id="result"></span> 
</body>
</html>


