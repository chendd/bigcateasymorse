<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="util.dao.*"%>
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
		<td>用户名</td>
		<td>用户权限</td>
		<td>联系电话</td>
		<td>即时通讯</td>
		<td>创建时间</td>
		<td>操&nbsp;&nbsp;&nbsp;作</td>
	</tr>
	<c:forEach items="${userlist}" var="item">
		<tr align="center">
			<td>${item.adminUserName }</td>
			<td>${item.adminType }</td>
			<td>${item.phone }</td>
			<td>${item.imNumber }</td>
			<td>${item.registerTime }</td>

			<td><input type="hidden" name="id" value="${item.id }" /><a
				href="<%=request.getContextPath()%>/webadmin/editadminuser.do?id=${item.id}&pageno=${pagination.no }">修改</a>|<a
				href="<%=request.getContextPath()%>/webadmin/deleteadminuser.do?id=${item.id}">删除</a></td>
		</tr>
	</c:forEach>
</TABLE>
共<font color="red">${pagination.pageSum }</font>页,
每页<font color="red">${pagination.size }</font>条,
<c:if test="${pagination.first!=true}">
<a href="<%=request.getContextPath()%>/webadmin/adminuserlist.do?pageno=1">首页</a>
</c:if>
<c:if test="${pagination.previous==true}">
<a href="<%=request.getContextPath()%>/webadmin/adminuserlist.do?pageno=${pagination.no-1}">上一页</a>
</c:if>
<c:if test="${pagination.next==true}">
<a href="<%=request.getContextPath()%>/webadmin/adminuserlist.do?pageno=${pagination.no+1}">下一页</a>
</c:if>
<c:if test="${pagination.last!=true}">
<a href="<%=request.getContextPath()%>/webadmin/adminuserlist.do?pageno=${pagination.pageSum}">末页</a>
</c:if>
<%
	if (null != request.getAttribute("thesign")) {
%>
<div id="edit">
<hr />
<br />
<form action="<%=request.getContextPath()%>/webadmin/addusersumbit.do?pageno=${pagination.no}"
	method="post">
<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>


	<tr>
		<td>
		<hr />
		用&nbsp;户&nbsp;名&nbsp;：<input type="text" name="adminUserName"
			value="${theuser.adminUserName} "></input></td>
	</tr>
	<tr>
		<td>用户类型：<select name="adminType">
			<option value="超级管理员">超级管理员</option>
			<option value="普通管理员">普通管理员</option>
			<option value="酒店合作伙伴">酒店合作伙伴</option>
		</select></td>
	</tr>
	<tr>
		<td>用户类型：<select name="partner">
			<option value="">超级管理员</option>
			<option value="普通管理员">普通管理员</option>
			<option value="酒店合作伙伴">酒店合作伙伴</option>
		</select></td>
	</tr>
	<tr>
		<td>联系电话：<input type="text" name="phone" value="${theuser.phone}"></input>
		</td>
	</tr>
	<tr>
		<td>即时通讯：<input type="text" name="imNumber"
			value="${theuser.imNumber}"></input> <input type="hidden"
			value="${theuser.id }" name="id" /> <input type="hidden"
			value="${theuser.registerTime }" name="registerTimes" /></td>
	</tr>
	<tr>
		<td><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; <input
			type="submit" name="submits" value="确认"></input></td>
	</tr>
</TABLE>
</form>
</div>
<%
	request.setAttribute("thesign", null);
	}
%>

</body>
</html>