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
function selectAll(){
	
	var aa = document.getElementsByName("ids");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;

}

function doit(pageNo){
	document.form.action="getComments.do?pageNo="+pageNo;
	var i = confirm("确定删除?");
	   if(i){
	   document.form.submit();
	   };
}

function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	 window.location.href="getComments.do?pageNo="+val; 
}

function showComment(val){

	Dialog.alert(val, 
            {width:300, height:100, okLabel: "close"
              });
         
}


</script>
<div class="module">
<div class="title">
<h2>视频评论</h2>
</div>
<div class="reDiv">
<form action="" method="post" name="form">
<table width="772" border="0" id="mytable">
  <tr>
    <td width="37" height="19"><div align="center"></div></td>
    <td width="114"><div align="center">评论</div></td>
    <td width="178"><div align="center">评论时间</div></td>
    <td width="136"><div align="center">对应视频</div></td>
    <td width="114"><div align="center">评论用户</div></td>
    <td width="153"><div align="center">操作</div></td>
  </tr>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center"><input name="ids" type="checkbox" value="${result.id }"/></div></td>
    <td><div align="center"><a href="javascript:void(0)" onclick="showComment('${result.comment}');">预览</a></div></td>
    <td><div align="center"><fmt:formatDate
				value="${result.commentDate }" type="both" /></div></td>
    <td><div align="center"><a href="">${result.video.name }</a></div></td>
    <td><div align="center"><a href="">${result.user.userName}</a></div></td>
    <td><div align="center"><a href="deleteComment.do?type=one&id=${ result.id}">删除</a></div></td>
  </tr>
</c:forEach>
</table>

<div align="center">
			<a href="<c:if test="${empty selectType}">getGroups.do?</c:if><c:if test="${not empty selectType }">getGroups.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="<c:if test="${empty selectType}">getGroups.do?</c:if><c:if test="${not empty selectType }">getGroups.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="<c:if test="${empty selectType}">getGroups.do?</c:if><c:if test="${not empty selectType }">getGroups.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no+1}">下一页</a></c:if>
			<a href="<c:if test="${empty selectType}">getGroups.do?</c:if><c:if test="${not empty selectType }">getGroups.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.pageSum}">尾页</a>		
		     页次：${pagination.no}/${pagination.pageSum}页  ${pagination.size}个记录/页     转到
			<select onchange="toPage();" id="pages">
				<%
				Pagination pagin = (Pagination)request.getAttribute("pagination");
				for(int i=1;i<=pagin.getPageSum();i++){
					
				
				%>
				<option  <%if(pagin.getNo()==i){%>selected="selected"<%} %>  value="<%=i %>"><%=i %></option>
				<%} %>
			</select>
		</div>
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



</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>
</html>