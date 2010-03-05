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
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/jquery/jquery.tablesorter.js"></script>
<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script type="text/javascript">

function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	 window.location.href="getDailyTags.do?pageNo="+val; 
}

function selectAll(){
	
	var aa = document.getElementsByName("ids");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;

}


function lock(id,pageNo){
	document.form.action="updateDailyTag.do?id="+id+"&pageNo="+pageNo+"&type=lockOne";
	var i = confirm("确定锁定?");
	   if(i){
	   document.form.submit();
	   };


	   
}
function del(id,pageNo){
	
	document.form.action="updateDailyTag.do?id="+id+"&pageNo="+pageNo+"&type=deleteOne";
	var i = confirm("确定删除?");
	   if(i){
	   document.form.submit();
	   };
}

function doit(pageNo){
	document.form.action="updateDailyTag.do?pageNo="+pageNo+"&type=all";
	var i = confirm("确定执行?");
	   if(i){
	   document.form.submit();
	   };
}


function createTag(){
	document.form.action="createDailyTag.do";
	var i = confirm("确定添加?");
	   if(i){
	   document.form.submit();
	   };
}
</script>
<div align="center">
<form action="" method="post" name="form">
<div align="center">
			<a href="<c:if test="${empty selectType}">getTags.do?</c:if><c:if test="${not empty selectType }">getTags.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="<c:if test="${empty selectType}">getTags.do?</c:if><c:if test="${not empty selectType }">getTags.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="<c:if test="${empty selectType}">getTags.do?</c:if><c:if test="${not empty selectType }">getTags.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no+1}">下一页</a></c:if>
			<a href="<c:if test="${empty selectType}">getTags.do?</c:if><c:if test="${not empty selectType }">getTags.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.pageSum}">尾页</a>		
		     页次：${pagination.no}/${pagination.pageSum}页  ${pagination.size}个用户/页     转到
			<select onchange="toPage();" id="pages">
				<%
				Pagination pagin = (Pagination)request.getAttribute("pagination");
				for(int i=1;i<=pagin.getPageSum();i++){
					
				
				%>
				<option  <%if(pagin.getNo()==i){%>selected="selected"<%} %>  value="<%=i %>"><%=i %></option>
				<%} %>
			</select>
		</div>
<table width="701" border="0" id="mytable">

  <tr>
    <td width="51"><div align="center">选中</div></td>
    <td width="58"><div align="center">ID</div></td>
    <td width="103"><div align="center">标签</div></td>
    <td width="94"><div align="center">关联视频</div></td>
    <td width="118"><div align="center">添加时间</div></td>
    <td width="88"><div align="center">状态</div></td>
    <td width="148"><div align="center">操作</div></td>
  </tr>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center"><input type="checkbox" name="ids" value="${result.id}"/></div></td>
    <td><div align="center">${result.id}</div></td>
    <td><div align="center">${result.name}</div></atd>
    <td><div align="center">${fn:length(result.dailies)} </div></td>
    <td><div align="center"><fmt:formatDate value="${result.createDate}" type="date"/></div></td>
    <td><div align="center"><c:if test="${result.status==1}">正常</c:if><c:if test="${result.status==2}">锁定</c:if></div></td>

    <td><div align="center">
		<a href="#">修改</a> <a href="#" onclick="lock('${result.id}','${pagination.no }');"><c:if test="${result.status == 1}">锁定</c:if><c:if test="${result.status == 2}">解锁</c:if></a> <a href="#" onclick="del('${result.id}','${pagination.no }');">删除</a>
	</div></td>
  </tr>

</c:forEach>
<tr></tr>
  <tr>
    <td colspan="7">&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="all" onclick="selectAll();"/>全选&nbsp;&nbsp;&nbsp;&nbsp;批量处理：
	<select name="tp" id="tp">
		<option value="lock">锁定</option>
		<option value="delete">删除</option>
	</select>
&nbsp;&nbsp;
	<button onclick="doit('${pagination.no }')">执行</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label>添加标签：</label> <input type="text" name="name"/> <button onclick="createTag()">添加</button>
</td>
  </tr>
</table>
</form>
</div>
</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>
</html>