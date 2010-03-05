<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.video.util.Pagination"%><html>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/jquery/jquery.tablesorter.js"></script>

	
	<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script type="text/javascript">
function selectAll(){
	var aa = document.getElementsByName("ids");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;

}
function del(id,pageNo){
	document.form.action="deleteUser.do?id="+id+"&pageNo="+pageNo;
	   var i = confirm("确定删除?");
	   if(i){
	   document.form.submit();
	   }
	
}

function lock(id,pageNo){
	document.form.action="updateUser.do?id="+id+"&pageNo="+pageNo+"&type=lockOne";
	var i = confirm("确定锁定?");
	   if(i){
	   document.form.submit();
	   };
}

function doit(pageNo){
	
	var operateType;
	var operateTypes = document.getElementsByName("operateType");
	for(var i=0;i<operateTypes.length;i++){
		if(operateTypes[i].checked)
			operateType = operateTypes[i].value;
		}
	if(operateType == "delete"){
		
		document.form.action="deleteUser.do?pageNo="+pageNo+"&type=delAll";
		var i = confirm("确定删除?");
		   if(i){
		   document.form.submit();
		   };
		}
	
	else if(operateType == "lock"){
		document.form.action="updateUser.do?pageNo="+pageNo+"&type=lock";
		var i = confirm("确定锁定?");
		   if(i){
		   document.form.submit();
		   };
		}
	else{
		
		document.form.action="updateUser.do?pageNo="+pageNo+"&type=move";
		var i = confirm("确定移动?");
		   if(i){
		   document.form.submit();
		   };
		  
		}
	
	
	
}
function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	 window.location.href="getUsers.do?pageNo="+val; 
}

function userselect(){

	document.form.action="getUsers.do";
	document.form.submit();
	
}
</script>
<script type="text/javascript">
$(document).ready(function() {
	$("#mytable").tableSorter({
		stripingRowClass: ['odd','even'],	
		stripRowsOnStartUp: true		
	});
});
</script>

<div class="module">
<div class="title">
<span><a href="toUserCreate.do">添加新会员</a></span>
<h2>会员管理</h2>
</div>
<div class="reDiv">
<form action="" name="form" method="post">
<div align="center">

<table id="mytable" width="931" border="0">
	<tr>
		<th width="45">
		<div align="center">选中</div>
		</th>
		<th width="51">
		<div align="center">ID</div>
		</th>
		<th width="71">
		<div align="center">用户名</div>
		</th>
		<th width="75">
		<div align="center">昵称</div>
		</th>
		<th width="59">
		<div align="center">性别</div>
		</th>
<th width="40">
		<div align="center">头像</div>
		</th>
		<th width="117">
		<div align="center">用户组</div>
		</th>
		<th width="101">
		<div align="center">最后登陆IP</div>
		</th>
		<th width="102">
		<div align="center">最后登陆时间</div>
		</th>
		<th width="57">
		<div align="center">登陆次数</div>
		</th>
		<th width="54">
		<div align="center">状态</div>
		</th>
		<th width="113">
		<div align="center">操作</div>
		</th>
	</tr>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
	<tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
		<td>
		<div align="center"><input type="checkbox" name="ids" value="${result.id }"></div>
		</td>
		<td>
		<div align="center">${result.id }</div>
		</td>
		<td>
		<div align="center">${result.userName }</div>
		</td>
		<td>
		<div align="center">${result.realName }</div>
		</td>
		<td>
		<div align="center">
			<c:if test="${result.gender=='m'}">男</c:if>
			<c:if test="${result.gender=='f'}">女</c:if>
		</div>
		</td>
<td><img width="40" src="${IMAGE_URL }/${result.face }"/></td>
		<td>
		<div align="center">
			<c:if test="${result.grade==0}">普通会员</c:if>
			<c:if test="${result.grade==1}">高级会员</c:if>
		</div>
		</td>
		<td>
		<div align="center">${result.lastLoginIp }</div>
		</td>
		<td>
		<div align="center"><fmt:formatDate
				value="${result.lastLoginDate }" type="both" /></div>
		</td>
		<td>
		<div align="center">${result.loginTimes }</div>
		</td>
		<td>
		<div align="center">
			<c:if test="${result.status == 0}">删除</c:if>
			<c:if test="${result.status == 1}">正常</c:if>
			<c:if test="${result.status == 2}">锁定</c:if>
	</div>
		</td>
		<td>
		<div align="center">
			<a href="getUser.do?id=${result.id}">修改</a> <a href="#" onclick="lock('${result.id}','${pagination.no }');"><c:if test="${result.status == 1}">锁定</c:if><c:if test="${result.status == 2}">解锁</c:if></a> <a href="#" onclick="del('${result.id}','${pagination.no }');">删除</a>
		</div>
		</td>

	</tr>
</c:forEach>
	
	
	
		
	
</table>
<div align="center">
<input type="checkbox" id="all" name="all" onclick="selectAll();"/>选中本页显示的所有用户
操作：<input checked="checked" type="radio"  name="operateType"
			value="delete" />删除 <input  type="radio" name="operateType"
			value="lock" />锁定 <input type="radio" name="operateType" value="move" />移动到
			<select name="moveto" id="moveto">
				<option value="0">普通用户</option>
				<option value="1">高级用户</option>
			</select>
<button onclick="doit('${pagination.no }')">执行</button>
		</div>

	<div align="center">
			<a href="<c:if test="${empty selectType}">getUsers.do?</c:if><c:if test="${not empty selectType }">getUsers.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="<c:if test="${empty selectType}">getUsers.do?</c:if><c:if test="${not empty selectType }">getUsers.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="<c:if test="${empty selectType}">getUsers.do?</c:if><c:if test="${not empty selectType }">getUsers.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no+1}">下一页</a></c:if>
			<a href="<c:if test="${empty selectType}">getUsers.do?</c:if><c:if test="${not empty selectType }">getUsers.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.pageSum}">尾页</a>		
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
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户高级查询:
<select name="selectType" >
	<option value="userName">用户名</option>
	<option value="realName">昵称</option>
	
</select>
<input type="text" name="keyword" size="5"/><button onclick="userselect();">执行</button>
</form>
</div>
</div>





<script type="text/javascript">
tableHelper('mytable');
	
</script>
