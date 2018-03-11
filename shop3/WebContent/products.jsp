<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div id="header">
  <h1><span>致远书斋</span></h1>
 <%@include file="header.jsp"%>
</div>

<div>
   <%
      int id =Integer.parseInt(request.getParameter("id"));
      out.println(id);
      product_do product_do1= new product_do(); 
      Collection c = product_do1.getAllbyID(id);
      out.println(c);
      product product1 = null;
      Iterator iterator = c.iterator();
      while(iterator.hasNext()){
    	  product1 = (product)iterator.next();
          String pic = "img/"+product1.getPicture();
    %>
      <div class="recommendation img-left">
          <h1><a href="#"><img src=<%=pic%> width="200" height="200"/></a></h1>
          <h3><span><%=product1.getPro_name() %></span></h3>
          <p><%=product1.getPro_details() %></p>
          <p>$<span><%=product1.getPro_price()%></span><a href="shop/shop.jsp?id=<%=product1.getPro_id()%>">购买</a></p>
      </div>
    <% 
      }
     %>
</div>

<div id="sideBar">
		<div id="searchBox">
			<span>
				<form><input name="" type="text" /><input name="" type="submit" value="查询商品" /></form>
			</span>
		</div>
		<div id="listBox">
			<span>
			<h2>图书分类</h2>
			<ul>
			
	<%	
	//查询所有图书分类，制作网页左侧分类导航
	    Category_do category_do=new Category_do();
	    Collection c1 = category_do.getall();
	    Iterator iterator1 = c1.iterator();
	    int i=0;
	    while (iterator1.hasNext()) {
		   Category category = (Category) iterator1.next();		 
		   
    %>  					
	    <li><a href="products.jsp?id=<%=category.GetcagID() %>"><%=category.GetcagName() %></a></li>		
    <%
     }
    %>				
				
			</ul>
			</span>
		</div>
		<div class="extraBox">
		<span>
			<h2>推荐功能</h2>
			<p>在线读书</p>
			<p>二手书</p>
			<p>精品套装书</p>
			<p>社区</p>
		</span>
		</div>
				<div id="listBox">
			<span>
			<h2>十大畅销书</h2>
			<ul>
				<li><a href="#">杉杉来吃</a></li>
				<li><a href="#">鲁班的诅咒</a></li>
				<li><a href="#">卑鄙的圣人：曹操2</a></li>
				<li><a href="#">百年孤独</a></li>
				<li><a href="#">蒋介石：1887-1975 下</a></li>
				<li><a href="#">虫图腾</a></li>
				<li><a href="#">不一样的卡梅拉</a></li>
				<li><a href="#">幸福的1001种方法</a></li>
				<li><a href="#">海瑞官场笔记</a></li>
			</ul>
			</span>
		</div>

	</div>
</div>
<%@include file="footer.jsp" %>

</body>
</html>



