<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page import="com.video.util.Pagination"%><html>

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
var win=null;
function getOtherUsers(id,pageNo){
	if(win == null){
		win= new Window({className: "dialog",  width:350, height:500, zIndex: 100, resizable: true, title: "用户列表", showEffect:Effect.BlindDown, hideEffect: Effect.SwitchOff, draggable:true, wiredDrag: true})
		}	
	
	win.getContent().innerHTML= "<img src='images/loading.gif' />";
	win.setStatusBar("Status bar info");
	win.showCenter();  
	
	 var url = 'getGroupUsers.do';
    
	  var pars = 'type=notin&id=' + id+"&pageNo="+pageNo;

	 	
	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse1 });
	      
	            
             
             }

function getUsers(id,pageNo){
	if(win == null){
		win= new Window({className: "dialog",  width:350, height:500, zIndex: 100, resizable: true, title: "用户列表", showEffect:Effect.BlindDown, hideEffect: Effect.SwitchOff, draggable:true, wiredDrag: true})
		}	
	
	win.getContent().innerHTML= "<img src='images/loading.gif' />";
	win.setStatusBar("Status bar info");
	win.showCenter();  
	
	 var url = 'getGroupUsers.do';
    
	  var pars = 'type=in&id=' + id+"&pageNo="+pageNo;

	 	
	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse2 });
	      
	            
             
             }

function showResponse1(originalRequest){
	jsonRaw = originalRequest.responseText;
	 pagination = eval("(" + jsonRaw + ")");

	 var val = "<table  width='230' border='0'><tr style='color: red;'><td width='30'></td><td width='100'><div align='center'>ID</div></td><td width='100'><div align='center'>用户名</div></td></tr>";
	 for (i = 0; i < pagination.results.length; i++) {
		 val = val +"<tr><td><div align='center'><input type='checkbox' name='uids' value='"+pagination.results[i].id+"'/></div></td><td><div align='center'>"+pagination.results[i].id+"</div></td><td><div align='center'>"+pagination.results[i].userName+"</div></td></tr>";
		 }
	 val=val+"</table><br />";

	 if(pagination.next){
	
		 val=val+'<a href="#" onclick="getOtherUsers('+"'"+pagination.groupId+"'"+",'"+(Number(pagination.no)+1)+"'"+')">下一页</a> ';
		 }
	 if(pagination.previous){
		 val=val+'<a href="#" onclick="getOtherUsers('+"'"+pagination.groupId+"'"+",'"+(Number(pagination.no)-1)+"'"+')">上一页</a> ';
		 }
	 val = val+'<br /><button onclick="addUsers('+"'"+pagination.groupId+"'"+')">确定</button>';
	 win.getContent().innerHTML= val;

	
	 
 		}

function showResponse2(originalRequest){
	jsonRaw = originalRequest.responseText;
	 pagination = eval("(" + jsonRaw + ")");

	 var val = "<table  width='230' border='0'><tr style='color: red;'><td width='30'></td><td width='100'><div align='center'>ID</div></td><td width='100'><div align='center'>用户名</div></td></tr>";
	 for (i = 0; i < pagination.results.length; i++) {
		 val = val +"<tr><td><div align='center'><input type='checkbox' name='uids' value='"+pagination.results[i].id+"'/></div></td><td><div align='center'>"+pagination.results[i].id+"</div></td><td><div align='center'>"+pagination.results[i].userName+"</div></td></tr>";
		 }
	 val=val+"</table><br />";

	 if(pagination.next){
	
		 val=val+'<a href="#" onclick="getOtherUsers('+"'"+pagination.groupId+"'"+",'"+(Number(pagination.no)+1)+"'"+')">下一页</a> ';
		 }
	 if(pagination.previous){
		 val=val+'<a href="#" onclick="getOtherUsers('+"'"+pagination.groupId+"'"+",'"+(Number(pagination.no)-1)+"'"+')">上一页</a> ';
		 }
	 val = val+'<br /><button onclick="delUsers('+"'"+pagination.groupId+"'"+')">确定</button>';
	 win.getContent().innerHTML= val;

	
	 
 		}


function addUsers(id){
	var ids = '0';
	var uids = document.getElementsByName("uids");
	  for (var i=0; i<uids.length; i++){
		  if(uids[i].checked){
			  ids += ','+uids[i].value;
			  }
		
		  }
	  if(ids!='0'){

		  ids = ids.substring(2);
		  var url = 'updateGroupAndUser.do';
		    
		  var pars = 'type=add&id=' + id+"&uids="+ids;

		 	
		  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: addOk });
		      
		  }
	  else{
		  win.close();
			win = null;
		  }
	 
	
}

function delUsers(id){
	var ids = '0';
	var uids = document.getElementsByName("uids");
	  for (var i=0; i<uids.length; i++){
		  if(uids[i].checked){
			  ids += ','+uids[i].value;
			  }
		
		  }
	  if(ids!='0'){

		  ids = ids.substring(2);
		  var url = 'updateGroupAndUser.do';
		    
		  var pars = 'type=remove&id=' + id+"&uids="+ids;

		 	
		  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: addOk });
		      
		  }
	  else{
		  win.close();
			win = null;
		  }
	 
	
}

function addOk(originalRequest){
	jsonRaw = originalRequest.responseText;
	if(jsonRaw=='ok'){
		win.close();
		win = null;
		}

	
}


	
		
		
	

//-----------------------
function lock(id,pageNo){
	document.form.action="updateGroup.do?id="+id+"&pageNo="+pageNo+"&type=lock";
	var i = confirm("确定锁定?");
	 if(i){
		   document.form.submit();
		   };
}
function del(id,pageNo){
	document.form.action="updateGroup.do?id="+id+"&pageNo="+pageNo+"&type=delete";
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

function doit(pageNo){
	document.form.action="updateGroup.do?pageNo="+pageNo+"&type=all";
	var i = confirm("确定执行?");
	   if(i){
	   document.form.submit();
	   };
}

function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	 window.location.href="getGroups.do?pageNo="+val; 
}


</script>

<div class="module">
<div class="title">
<h2>圈子列表</h2>
</div>
<div class="reDiv">
<form action="" method="post" name="form">
<table id="mytable" width="859" border="0">
  <tr >
    <th width="34"><div align="center"></div></th>
    <th width="78"><div align="center">圈名</div></th>
    <th width="151"><div align="center">圈子介绍</div></th>
    <th width="68"><div align="center">圈主</div></th>
    <th width="125"><div align="center">建圈时间</div></th>
    <th width="80"><div align="center">图片</div></th>
    <th width="60"><div align="center">状态</div></th>
    <th width="211"><div align="center">操作</div></th>
  </tr>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center">
<input type="checkbox" name="ids" value="${result.id }" />
</div></td>
    <td><div align='center'>${result.name}</div></td>
    <td><div align="center">${result.descrption }</div></td>
    <td><div align="center"><a href="getUser.do?id=${ result.owner.id}">${result.owner.userName }</a></div></td>
    <td><div align="center"><fmt:formatDate
				value="${result.addDate }" type="both" /></div></td>
    <td><div align="center">
<img src="${IMAGE_URL }/${result.image }" height="60" />
</div></td>
    <td><div align="center">
<c:if test="${result.flag==1}">正常</c:if><c:if test="${result.flag==2}">锁定</c:if>
</div></td>
    <td><div align="center">
<a href="#" onclick="getUsers('${result.id}','1');">现有成员</a> <a href="#" onclick="getOtherUsers('${result.id}','1');">添加用户</a> <a href="#" onclick="del('${result.id}','${pagination.no }');">删除</a> <a href="#" onclick="lock('${result.id}','${pagination.no }')">锁定</a>
 <a href="toGroupUpdate.do?id=${result.id}" >修改</a>
</div></td>
  </tr>
</c:forEach>
</table>
<div align="center">
			<a href="<c:if test="${empty selectType}">getGroups.do?</c:if><c:if test="${not empty selectType }">getGroups.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="<c:if test="${empty selectType}">getGroups.do?</c:if><c:if test="${not empty selectType }">getGroups.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="<c:if test="${empty selectType}">getGroups.do?</c:if><c:if test="${not(empty selectType)}">getGroups.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no+1}">下一页</a></c:if>
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
		<option value="lock">锁定</option>
		<option value="delete">删除</option>
	</select>
<button onclick="doit('${pagination.no }')">执行</button>
</div>


</form>
</div>
</div>



<script type="text/javascript">
tableHelper('mytable');
	
</script>
