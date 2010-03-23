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


<h3><font style="font-family: '新宋体'; color: #C2B8FC">用户列表：</font></h3>
<TABLE cellSpacing=0 cellPadding=0 width="70%" border=1>
	<tr align="center" bgcolor="#F0FFF4">
		<td>酒店名称</td>
		<td>公司全称</td>
		<td>酒店星级</td>
		<td>联系电话</td>
		<td>申请时间</td>
		<td>操&nbsp;&nbsp;&nbsp;作</td>
	</tr>
	<c:forEach items="${applyhotels}" var="item">
		<tr align="center">
			<td>${item.hotelName}</td>
			<td>${item.companyName}</td>
			<td>${item.hotelType}</td>
			<td>${item.hotelPhone }</td>
			<td>${item.applyTime}</td>

			<td><input type="hidden" name="id" value="${item.id }" /><a
				href="<%=request.getContextPath()%>/webadmin/hoteldetailmsg.do?id=${item.id}">详情</a>|<a
				href="<%=request.getContextPath()%>/webadmin/deleteadminuser.do?id=${item.id}">删除</a></td>
		</tr>
	</c:forEach>
</TABLE>
</body>
</html>