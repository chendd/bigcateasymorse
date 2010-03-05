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

<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script type="text/javascript">

function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	 window.location.href="getVideoes.do?pageNo="+val; 
}

function selectAll(){
	
	var aa = document.getElementsByName("ids");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;

}

function doit(pageNo){
	document.form.action="deleteCandidateVideo.do?pageNo="+pageNo+"&type=all";
	var i = confirm("确定执行?");
	   if(i){
	   document.form.submit();
	   };
}

</script>
<div class="module">
<div class="title">
<h2>推荐视频待选列表</h2>
</div>
<div class="reDiv">
<form action="" method="post" name="form">
<div align="center">
			<a href="getCandidateVideoes.do?pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="getCandidateVideoes.do?pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="getCandidateVideoes.do?pageNo=${pagination.no+1}">下一页</a></c:if>
			<a href="getCandidateVideoes.do?pageNo=${pagination.pageSum}">尾页</a>		
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
<table width="808" border="0" id="mytable">
  <tr>
    <td width="26"><div align="center"></div></td>
    <td width="118"><div align="center">备选视频</div></td>
    <td width="279"><div align="center">推荐原因</div></td>
    <td width="104"><div align="center">推荐人</div></td>
    <td width="115"><div align="center">推荐时间</div></td>
    <td width="126"><div align="center">操作</div></td>
  </tr>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center"><input type="checkbox" name="ids" value="${result.id }"/></div></td>
    <td><div align="center"><a href="getVideo.do?id=${result.video.id }">${result.video.name }</a></div></td>
    <td><div align="center">${result.sake }</div></td>
    <td><div align="center">${result.recommender.name }</div></td>
    <td><div align="center"><fmt:formatDate
				value="${result.recommendDate }" type="both" /></div></td>
    <td><div align="center"><a href="deleteCandidateVideo.do?id=${result.id }&pageNo=${pagination.no }">删除</a></div></td>
  </tr>
</c:forEach>
</table>


</form>

<div align="center">
<input type="checkbox" id="all" onclick="selectAll();"/>全选&nbsp;&nbsp;&nbsp;&nbsp;批量处理：
	<select name="tp" id="tp">
		<option value="delete">删除</option>
	</select>
<button onclick="doit('${pagination.no }')">执行</button> 

</div>
</div>
</div>



<script type="text/javascript">
tableHelper('mytable');
	
</script>
</body>
</html>