<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=request.getContextPath()%>/bgcss/css/admin.css"
	type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>


<h3><font style="font-family: '新宋体'; color: #C2B8FC">房间信息：</font></h3>
<TABLE cellSpacing=0 cellPadding=0 width="70%" border=1>
	<tr align="center" bgcolor="#F0FFF4">
		<td>酒店名称</td>
		<td>房间价钱</td>
		<td>房间描述</td>
		<td>是否预定</td>
		
		<td>操&nbsp;&nbsp;&nbsp;作</td>
	</tr>
	<c:forEach items="${roomlist}" var="item">
		<tr align="center">
			<td>${item.hotelBean.hotelName}</td>
			<td>${item.roomPrice}</td>
			<td>${item.roomDescription}</td>

			<td>没有</td>
			<td><input type="hidden" name="id" value="${item.id }" /><a
				href="<%=request.getContextPath()%>/webadmin/deleteroom.do?id=${item.id}">删除</a></td>
		</tr>
	</c:forEach>
</TABLE>
<!--<a href="<%=request.getContextPath()%>/hotel/addroom.do">新添房屋</a>-->
</body>
</html>