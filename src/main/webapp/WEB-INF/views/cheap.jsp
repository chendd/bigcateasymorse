<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<LINK href="<%=request.getContextPath() %>/css/div_css.css" rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath() %>/css/css_new.css" rel="stylesheet" type="text/css">

<title>特惠酒店</title>
<style type="text/css">
<!--
#main_left {
	position:absolute;
	visibility: visible;
	z-index:2;
	margin-left: 15%
}
#main_center{
	position:absolute;
	width:50%;
	height:176px;
	z-index:1;
	top: 20%;
	left: 40%;
	
}

-->
</style>
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div id="main" >
<div id="main_left">
<form action="findhotel.do" method="post">

城市名称  <input type="text" name="cityname" size="10" /><br />
入住日期   <input type="text" name="cityname" size="10" /><br />
离店日期   <input type="text" name="cityname" size="10"  /><br />
酒店名称  <input type="text" name="cityname" size="10" /><br />
房价范围   <input type="text" name="cityname" size="5"  />-<input type="text" name="cityname" size="5"  /><br />
酒店靠近  <input type="text" name="cityname" size="10"  /><br />
<a href="javascript:document.forms[0].submit();"><img alt="搜索" src="images/button_find11.gif" /></a>

</form>
</div>

<div id="main_center">
<div align="right"><img alt="" src="images/icon_tishi02.gif"></div>

</div>
</div>
</body>
</html>