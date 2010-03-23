<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.*"%>
<%
	Date dates = new Date();
	String dateString = MessageFormat.format(
			"{0,date,yyyy-MM-dd HH:mm:ss}", dates);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="<%=request.getContextPath()%>/bgcss/css/admin.css"
	type="text/css" rel="stylesheet">
</HEAD>
<BODY>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
	<TR height=28>
		<TD
			background="<%=request.getContextPath()%>/bgcss/images/title_bg1.jpg">当前位置:
		</TD>
	</TR>
	<TR>
		<TD bgColor=#b1ceef height=1></TD>
	</TR>
	<TR height=20>
		<TD
			background="<%=request.getContextPath()%>
			/bgcss/images/shadow_bg.jpg"></TD>
	</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
	<TR height=100>
		<TD align=middle width=100><IMG height=100
			src="<%=request.getContextPath()%>/bgcss/images/admin_p.gif" width=90></TD>
		<TD width=60>&nbsp;</TD>
		<TD>
		<form
			action="<%=request.getContextPath()%>/webadmin/addusersumbit.do"
			method="post">
		<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>

			<TR>
				<TD>当前时间：<%=dateString%></TD>
			</TR>
			<tr>
				<td>
				<hr />
				用&nbsp;户&nbsp;名&nbsp;：<input type="text" name="adminUserName"></input></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input
					type="password" name="adminUserPassword"></input></td>
			</tr>
			<tr>
				<td>确认密码：<input type="password" name="adminUserPasswords"></input>
				</td>
			</tr>
			<tr>
				<td>用户类型：<select name="adminType">
					<option value="超级管理员">超级管理员</option>
					<option value="普通管理员">普通管理员</option>
					<option value="酒店合作伙伴">酒店合作伙伴</option>
				</select></td>
			</tr>
			<tr>
				<td>用户类型：<select name="hotelBeanId">
					<c:forEach items="${hotellist}" var="item">
						<option value="${item.id }">${item.hotelName}</option>
						
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>联系电话：<input type="text" name="phone"></input></td>
			</tr>
			<tr>
				<td>即时通讯：<input type="text" name="imNumber"></input></td>
			</tr>
			<tr>
				<td><br />
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" name="submits" value="确认"></input></td>
			</tr>
		</TABLE>
		</form>
		</TD>
	</TR>
	<TR>
		<TD colSpan=3 height=10></TD>
	</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
	<TR height=20>
		<TD></TD>
	</TR>


	<TR height=20>
		<TD></TD>
	</TR>
</TABLE>

</body>
</html>