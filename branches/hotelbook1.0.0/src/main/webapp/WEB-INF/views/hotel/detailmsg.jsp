<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.easymorse.hotel.*"%>
<%
	HotelBean hotelBean = (HotelBean) request
			.getAttribute("hotelMsgDetail");
%>
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
<TABLE cellSpacing=0 cellPadding=0 width="90%" border=1>
	<tr>
		<td>酒店名称</td>
		<td><input name="hotelName"
			value="<%=hotelBean.getHotelName()%>" disabled /></td>
		<td>酒店星级</td>
		<td><input name="hotelType"
			value="<%=hotelBean.getHotelType()%>" disabled /></td>
	</tr>
	<tr>
		<td>联系电话</td>
		<td><input name="hotelPhone"
			value="<%=hotelBean.getHotelPhone()%>" disabled /></td>
		<td>申请时间</td>
		<td><input name="applyTime"
			value="<%=hotelBean.getApplyTime()%>" disabled /></td>
	</tr>
	<tr>
		<td>公司全称</td>
		<td><input name="companyname"
			value="<%=hotelBean.getCompanyName()%>" disabled /></td>
		<td>酒店地址</td>
		<td><input name="hoteladress"
			value="<%=hotelBean.getHotelAddress()%>" disabled /></td>
	</tr>
	<tr>
		<td>公司全称</td>
		<td colspan="3"><input rows="3" cols="100" name="companyname" 
			 disabled value="<%=hotelBean.getCompanyName()%>"/></td>
		
	</tr>
	<tr>
		<td>酒店简介</td>
		<td colspan="3"><textarea rows="3" cols="100" name="introduce" 
			 disabled ><%=hotelBean.getHotelIntroduce() %></textarea></td>	
	</tr>
<tr><form action="<%=request.getContextPath() %>/webadmin/updatehotel.do" method="post">
		<td>审核</td>
		<td colspan="2"><input type="radio" name="checkup" value = "true">通过<br>
		<input type="radio" name="checkup" value = "false">不通过
		</td>
		<td>
		<input type="hidden" value="<%=hotelBean.getId() %>" name="id" /> 
		<input type="submit" vlaue="提交"></input></td>
		</form>
	</tr>
</TABLE>
</body>
</html>