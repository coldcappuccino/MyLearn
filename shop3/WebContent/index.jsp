<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="com.Category,com.Category_do,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上书店</title>
</head>
<body>

<div id="header">
     <h1><span>致远书斋</span></h1>
   <ul id="mainNavigation">
    <li class="current"><a href="index.jsp"><strong>网站首页</strong></a></li>
    <li><a href="#"><strong>图书介绍</strong></a></li>
    <li><a href="#"><strong>信息</strong></a></li>
    <li><a href="#"><strong>畅销排行榜</strong></a></li>
  </ul>
  
  <%@include file="header.jsp"%>
</div>

<div id="content">
  <div id="mainContent">
   <div class="recommendation img-left">
			<h2>本周推荐</h2>
			<a href="#"><img src="img/book1.jpg" width="200" height="200"/></a>
			<h3>朱镕基讲话实录（全四册平装、双色印刷）</h3>
			<p>《朱镕基讲话实录》收入了朱镕基担任国务院副总理、国务院总理期间的重要讲话、谈话、文章、信件、批语等348篇，照片272幅，批语、书信及题词影印件30件，这些讲话、谈话、文章等从各个方面翔实记录了朱镕基领导中国经济的历程，内容涉及中国财税体制改革、金融体制改革、国有企业改革、社会保障体制改革、投融资体制改革、住房制度改革、应对亚洲金融危机冲击、治理通货膨胀等经济社会各领域重大问题。不仅是读者深入了解朱镕基经济社会管理思想、领导风格、个人魅力和心路历程最全面的读本，也是读者回顾和解读中国经济发展历程和基本规律的一部丰富史料。</p>
   </div>
   <div class="recommendation img-right">
			<h2>新书上市</h2>
			<a href="#"><img src="img/book2.jpg" width="200" height="200"/></a>
			<h3>海豹突击六队（海豹突击队员首次现身，揭底美国反恐行动中最隐秘的故事，真实呈现对抗恐怖分子的第一手资料）</h3>
			<p>本书作者是海豹六队一位退役狙击手和一位现役精英队员，他们以自己真实的经历，第一次向读者揭秘海豹队员最隐秘的故事，他们的成长、家庭、情感，以及完全身临其境的反恐行动、“沙漠风暴”行动和摩加迪沙行动。书中详细叙述了这支神秘部队在世界上最危险地区执行任务的场景，充满了真实的死亡气息。</p>
   </div>
   <div class="recommendation img-left">
			<h2>最受欢迎</h2>
			<a href="#"><img src="img/book3.jpg" width="200" height="200"/></a>
			<h3>蔡康永的说话之道（蔡康永说：外表绝对不是人生的决胜点！把说话练好，是最划算的事！）</h3>
			<p>蔡康永的说话之道》是蔡康永的第一本实用书，在“说话”多年之后，首次尝试教人“说话”。本书开端康永哥便许下宏愿：这本书会令“本来已经很讨人喜欢的你，在未来变得更讨人喜欢”。全书包括40篇精彩短文，每篇都是让谈话变美的醍醐味，并配以熊宝绘制的令人喷饭的搞笑插画，如同蔡康永的主持风格一样犀利俏皮，饶有情趣。</p>
   </div>
   <div class="recommendation multiColumn">
			<h2>相关推荐</h2>
			<ul>	
				<li><a href="#"><div><img src="image/ex1.jpg"/></div></a>
					<p>在日本，我忍不住又笑了——萨苏带你看日本<br/>
定　　价：￥35.00 </p></li>
				<li><a href="#"><div><img src="image/ex4.jpg"/></div></a>
					<p>春宴（安妮宝贝最新长篇小说） 　　　　　　　<br/>
定　　价：￥39.00</p></li>
				<li><a href="#"><div><img src="image/ex2.jpg"/></div></a>
					<p>虫图腾（中国首部驱虫秘术式悬疑小说）<br/>
定　　价：￥28.00</p></li>
				<li><a href="#"><div><img src="image/ex3.jpg"/></div></a>
					<p>百年孤独（加西亚·马尔克斯巅峰杰作）<br/>
定　　价：￥39.50 </p></li>
			</ul>
   </div>
 </div> 
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
	            Category_do category_do = new Category_do();
			    Collection c = category_do.getall(); 
			    
			    Iterator iterator = c.iterator();
			    while(iterator.hasNext()){
			    	Category category = (Category) iterator.next();
			    
	        %>
	        <li><a href="products.jsp?id=<%=category.GetcagID()%>"><span><%=category.GetcagName()%></span></a></li>
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

  <%
      List list = new ArrayList();
      list.add("aaa");
      session.setAttribute("aaa","ccc");
      String str = (String)session.getAttribute("aaa");
    %>
    
    <%=session.getAttribute("aaa")%>


</body>
</html>










