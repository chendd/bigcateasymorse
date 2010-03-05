<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.video.util.Pagination"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<!-- prototype -->
<script type="text/javascript" src="js/window/prototype.js"></script>

<!--prototype window -->
<script type="text/javascript" src="js/window/effects.js"></script>
<script type="text/javascript" src="js/window/window.js"></script>
<script type="text/javascript" src="js/window/window_effects.js"></script>
<link href="themes/default.css" rel="stylesheet" type="text/css"></link>
<link href="themes/spread.css" rel="stylesheet" type="text/css"></link>
<link href="themes/lighting.css" rel="stylesheet" type="text/css"></link>
<link href="themes/alphacube.css" rel="stylesheet" type="text/css"></link>
<link href="themes/alert.css" rel="stylesheet" type="text/css"></link>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>

<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script type="text/javascript">
function deleteit(id){
	var i = confirm("确定删除？");
	if(i){
		window.self.location="deleteNotice.do?id="+id;
		}
	
}

	
</script>
<div align="center">
<form action="" method="post" name="form">
<div align="left">
<label>分类：</label>
<select id="channel" onchange="toChannel();">
<option value="all">全部</option>
<c:forEach items="${channels}" var="channel">

	<option value="${channel.id }" <c:if test="${pagination.condition.channel.id==channel.id}">selected="selected"</c:if>>${channel.name }</option>
</c:forEach>
</select>
</div>


<table border="0" id="mytable">

  <tr>
  
    <td ><div align="center">ID</div></td>
    <td ><div align="center">公告名称</div></td>
    <td ><div align="center">公告内容</div></td>
    <td ><div align="center">公告时间</div></td>
    <td ><div align="center">操作</div></td>
 
  </tr>

<c:forEach items="${notices}" var="notice" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
  <td ><div align="center">${notice.id }</div></td>
    <td ><div align="center">${notice.name }</div></td>
    <td ><div align="center">${notice.notice }</div></td>
    <td ><div align="center">
<fmt:formatDate value="${notice.date }" type="date"/>
</div></td>
    <td ><div align="center"><a href="toUpdateNotice.do?id=${notice.id }">修改</a>||<a href="javascript:deleteit('${notice.id }');">删除</a></div></td>
  </tr>
</c:forEach>
</table>

</form>


</div>

</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>

</html>