<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.easymorse.hotel.*"%>
<%
	HotelBean hotelBean = (HotelBean) request
			.getAttribute("hotelMsgDetails1");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="<%=request.getContextPath()%>/bgcss/css/admin.css"
	type="text/css" rel="stylesheet">
<title>Insert title here</title>
<script type="text/javascript">
function insertHtml(id){
	
	var s = document.getElementById("rooms");
	s.innerHTML="<form method='post' action='<%=request.getContextPath()%>/webadmin/addroom.do'>房间名称:<input type='text' name='roomName'   /><br />"+
					  "房间价格:<input type='text' name='roomPrice'  /><br />"+
					  "房间描述:<input type='text' name='roomDescription'  /><br />"+
					  "<input type='hidden' value='"+id+"' name='hotelId'  /><br />"+
					  "<input type='submit' value='提交'  /><br />"+
		"</form>";
}

</script>
</head>
<body>

<h3><font style="font-family: '新宋体'; color: #C2B8FC">酒店信息：</font></h3>
<%if(null==hotelBean){ %>
<TABLE cellSpacing=0 cellPadding=0 width="70%" border=1>
	<tr align="center" bgcolor="#F0FFF4">
		<td>酒店名称</td>
		<td>公司全称</td>
		<td>酒店星级</td>
		<td>联系电话</td>
		<td>申请时间</td>
		<td>操&nbsp;&nbsp;&nbsp;作</td>
	</tr>
	<c:forEach items="${hotelMsgDetails}" var="item">
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
<%} else{%>
<form action="<%=request.getContextPath() %>/webadmin/updatehotels.do" method="post">
<TABLE cellSpacing=0 cellPadding=0 width="90%" border=1>
	<tr>
		<td>酒店名称</td>
		<td><input name="hotelName"
			value="<%=hotelBean.getHotelName()%>"  /></td>
		<td>酒店星级</td>
		<td><input name="hotelType"
			value="<%=hotelBean.getHotelType()%>"  /></td>
	</tr>
	<tr>
		<td>联系电话</td>
		<td><input name="hotelPhone"
			value="<%=hotelBean.getHotelPhone()%>"  /></td>
		<td>申请时间</td>
		<td><input name="applyTimes"
			value="<%=hotelBean.getApplyTime()%>"  /></td>
	</tr>
	<tr>
		<td>公司全称</td>
		<td><input name="companyName"
			value="<%=hotelBean.getCompanyName()%>"  /></td>
		<td>酒店地址</td>
		<td><input name="hotelAddress"
			value="<%=hotelBean.getHotelAddress()%>"  /></td>
	</tr>
	<tr>
		<td>酒店简介</td>
		<td colspan="3"><textarea rows="3" cols="100" name="hotelIntroduce" 
			  ><%=hotelBean.getHotelIntroduce() %></textarea></td>	
	</tr>
<tr>
		
		<td>
		<input type="hidden" value="<%=hotelBean.getId() %>" name="id" /> 
		<input type="submit" value="修改"></input></td>
		
	</tr>
</TABLE>

</form>
<div>
<hr />
<input type="submit" value="增加房间"  onclick="insertHtml(<%=hotelBean.getId() %>);" />
</div>
<%} %>
<div id="rooms">

</div>
</body>
</html>