<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.easymorse.hotel.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=request.getContextPath()%>/bgcss/css/admin.css"
	type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

<h3><font style="font-family: '新宋体'; color: #C2B8FC">用户列表：</font></h3>
<form action="<%=request.getContextPath() %>/hotel/addroomsubmit.do" method="post">
<TABLE cellSpacing=0 cellPadding=0 width="90%" border=1>
	<tr>
		<td>酒店名称</td>
		<td><input name="hotelName"
			  /></td>
		<td>房间价钱</td>
		<td><input name="roomPrice"
			/></td>
	</tr>
	<tr>
		<td>房间描述</td>
		<td><input name="roomDescription"
			  /></td>
		<td>是否预定</td>
		<td><input type="radio" name="isBookeds" value = "true">已经预定<br>
		<input type="radio" name="isBookeds" value = "false">没有预定</td>
	</tr>
	
<tr>
		
		<td>
		<input type="submit" value="提交 "></input></td>
		
	</tr>
</TABLE>
</form>
</body>
</html>