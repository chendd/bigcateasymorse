<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.video.util.Pagination"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>

<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script type="text/javascript">
function deleteit(id,pageNo){
	document.form.action="deleteUploadVideo.do?pageNo="+pageNo+"&id="+id;
	var i = confirm("确定删除?");

	   if(i){
	   document.form.submit();
	   };
}

function selectAll(){
	
	var aa = document.getElementsByName("ids");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;

}
function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	var status = '${status}';
	var url = "getUploadVideoes.do?pageNo="+val; 
	if(status!=''){
		url = "getUploadVideoes.do?pageNo="+val+"&status"+status; 
		}
	 window.location.href=url; 
}
function doit(pageNo){
	document.form.action="deleteUploadVideo.do?pageNo="+pageNo+"&type=all";
	var i = confirm("确定执行?");
	   if(i){
	   document.form.submit();
	   };
}


function priview(id){
	window.open('priview.do?id='+id+'','','width=500,height=350')
	//Dialog.alert({url: "priview.do?id="+id, options: {method: 'post'}}, 
  //          {className: "alphacube", width:540,height:500, okLabel: "Close"});
}
</script>
<div class="module">
<div class="title"><h2>

<a href="getUploadVideoes.do" style="TEXT-DECORATION: none;<c:if test="${empty status }">color: #C92103</c:if>">全部</a> <a href="getUploadVideoes.do?status=0" style="TEXT-DECORATION: none;<c:if test="${status==0}">color: #C92103</c:if>">未审核</a> <a href="getUploadVideoes.do?status=1" style="TEXT-DECORATION: none;<c:if test="${status==1}">color: #C92103</c:if>">已审核</a>
</h2></div>
<div class="reDiv">
<div align="center">

			<a href="getUploadVideoes.do?pageNo=1<c:if test="${not  empty status }">&status=${status }</c:if>">首页</a>
			
			<c:if test="${pagination.previous}"><a href="getUploadVideoes.do?pageNo=${pagination.no-1}<c:if test="${not  empty  status }">&status=${status }</c:if> ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="getUploadVideoes.do?pageNo=${pagination.no+1}<c:if test="${not  empty status }">&status=${status }</c:if>">下一页</a></c:if>
			<a href="getUploadVideoes.do?pageNo=${pagination.pageSum}<c:if test="${not  empty status }">&status=${status }</c:if>">尾页</a>		
		     页次：${pagination.no}/${pagination.pageSum}页  ${pagination.size}条记录/页     转到
			<select onchange="toPage();" id="pages">
				<%
				Pagination pagin = (Pagination)request.getAttribute("pagination");
				for(int i=1;i<=pagin.getPageSum();i++){
					
				
				%>
				<option  <%if(pagin.getNo()==i){%>selected="selected"<%} %>  value="<%=i %>"><%=i %></option>
				<%} %>
			</select>
		</div>
<form action="" name="form" method="post">

	<table width="900" border="0" id="mytable">
  <tr>
    <td width="29"><div align="center"></div></td>
    <td width="83"><div align="center">名称</div></td>

    <td width="118"><div align="center">上传时间</div></td>
    <td width="71"><div align="center">上传用户</div></td>
    <td width="68"><div align="center">视频类型</div></td>
    <td width="69"><div align="center">视频分类</div></td>
    <td width="68"><div align="center">时长</div></td>
    <td width="75"><div align="center">大小</div></td>
<td width="75"><div align="center">状态</div></td>
<td width="85"><div align="center">转换状态</div></td>
    <td width="120"><div align="center">操作</div></td>
  </tr>

 <c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center"><input type="checkbox" name="ids" value="${result.id }"/></div></td>
    <td><div align="center">${result.video.name }</div></td>

    <td><div align="center"><fmt:formatDate value="${result.video.addDate }" type="date"/></div></td>
    <td><div align="center"><a href="getUser.do?id=${result.video.user.id }">${result.video.user.realName }</a></div></td>
    <td><div align="center">${result.videoType }</div></td>
    <td><div align="center">${result.video.channel.name }</div></td>
    <td><div align="center">${result.videoTime}</div></td>
    <td><div align="center">${result.video.videoSize }</div></td>
<td><div align="center"><c:if test="${result.stauts==0}">未审</c:if><c:if test="${result.stauts==1}">通过</c:if></div></td>
<td><div align="center">

<c:if test="${result.convertStatus==0}">等待转换</c:if>
<c:if test="${result.convertStatus==4}"><label style="color: blue;">转换完毕</label></c:if>

</div></td>
    <td><div align="center">
<a href="#" onclick="deleteit('${result.id }','${pagination.no}');">删除</a> <a href="getUploadVideo.do?id=${result.id }">编辑</a> 
<a href="#" onclick="priview('${result.id}')">预览</a>
</div></td>
  </tr>
</c:forEach>
</table>

<div align="center">
<input type="checkbox" id="all" onclick="selectAll();"/>全选&nbsp;&nbsp;&nbsp;&nbsp;批量处理：
	<select name="tp" id="tp">
		<option value="delete">删除</option>
	</select>
<button onclick="doit('${pagination.no }')">执行</button> 

</div>

</form>

</div>
</div>

<div align="center">





</div>

</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>
</html>