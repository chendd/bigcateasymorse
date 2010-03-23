<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
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
		<TD background="<%=request.getContextPath()%>
			/bgcss/images/shadow_bg.jpg"></TD>
	</TR>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
	<TR height=100>
		<TD align=middle width=100><IMG height=100
			src="<%=request.getContextPath()%>/bgcss/images/admin_p.gif"
			width=90></TD>
		<TD width=60>&nbsp;</TD>
		<TD>
		<TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>

			<TR>
				<TD>当前时间：<%=dateString%></TD>
			</TR>
			<tr><td><hr />新密码：<input type="password"  name="adminUserPassword"></input></td></tr>
			<tr><td>重复密码：<input type="password"  name="adminUserPasswords"></input>
			<input type="hidden" value="1" name="id" /> 
			</td></tr>
			<tr><td><input type="submit"  name="submits" value="确认"></input></td></tr>
		</TABLE>
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