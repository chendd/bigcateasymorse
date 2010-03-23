<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<title>hotel book</title>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="page_header">
	<div id="page_title">
	<h1>
	<img src="<%=request.getContextPath() %>/images/header_logo.gif" width="25" height="26" alt="laiyuan hotel book" />
	
	</h1>
	</div>
<!--	<div id="header_search">-->
<!--		<form method="post" action="">-->
<!--		<div>-->
<!--	-->
<!--		<input type="text" />-->
<!--		<input type="image" src="images/search_button.gif" class="submit" />-->
<!--		</div>-->
<!--		</form>-->
<!--	</div>-->
<div id="header_search">
<%
 if(null!= session.getAttribute("the_user")){
%>
	 
欢迎<%=session.getAttribute("the_user") %>登录 &nbsp;&nbsp;&nbsp;| <a href="exit.do">退出</a>

<%}else{
%>
[<a href="login.do">登录</a>&nbsp;|&nbsp;<a href="register.do">注册</a>]
<%} %>
</div>
</div>

<div id="page_menu">
	<ul id="menu">
		<li><a href="<%=request.getContextPath() %>/index.do">首页</a></li>
		<li><a href="<%=request.getContextPath() %>/ibooks.do">酒店预定</a></li>
		<li><a href="<%=request.getContextPath() %>/liansuo.do">连锁酒店</a></li>
		<li><a href="<%=request.getContextPath() %>/criticism.do">酒店点评</a></li>
		
		<li><a href="<%=request.getContextPath() %>/hoteljoin.do">合作伙伴</a></li>
	</ul>
</div>

</body>
</html>