<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*,edu.neusoft.springmvc.model.Sale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>

<body>
    <div id="title">
       <ul id="list">
       
       </ul>
    </div>
    
    <div id="distribute">
       <p id="allpage"></p>
    </div>
    <script type="text/javascript">
        var currentPage = ${currentPage};
        var pageTimes = ${pageTimes};
        var Jsondata = ${sales};
        var data = eval(Jsondata);
        console.log(data);
        
        var i = 0;
        for(;i<data.length;i++){
        	var li1 = $("<li>用户ID:"+data[i].customerID+"</li>");
        	var li2 = $("<li>销售主题:"+data[i].title+"</li>");
            // console.log($li);
             $('#list').append(li1);
             $('#list').append(li2);
        }
        
        $('#allpage').text("一共"+pageTimes+"页");
        
        if(currentPage==1){
        	var span = $("<span>前一页</span>");
        	$('#distribute').append(span);
        }else{
        	var span = $("<a href='../sale/select?page="+(currentPage-1)+"'>前一页</a>");
        	$('#distribute').append(span);
        }
        
        for(var p =1;p<=pageTimes;p++){
        	if(p==currentPage){
        	    var label = $("<span>"+p+"</span>");
        	    $('#distribute').append(label);
        	}else{
        		var label = $("<a href='../sale/select?page="+p+"'>"+p+"</a>");
        		$('#distribute').append(label);
        	}
        }
        
        if(currentPage==pageTimes){
        	var span = $("<span>后一页</span>");
        	$('#distribute').append(span);
        }else{
        	var span = $("<a href='../sale/select?page="+(currentPage+1)+"'>后一页</a>");
        	$('#distribute').append(span);
        }
    </script>
</body>
</html>





