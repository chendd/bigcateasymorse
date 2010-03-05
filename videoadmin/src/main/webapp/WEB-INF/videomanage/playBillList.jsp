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
<body>
<div align="center" >
<div align="left"><a href="toPlayBillCreate.do">新增节目单</a></div>
<form action="" name="form" method="post">

<script type="text/javascript">
function deleteit(id){
	 var i = confirm("确定删除?");
	   if(i){
		   location = "updatePlayBill.do?id="+id+'&pageNo=${pagination.no}&method=delete';
	   }
	
	
	
}
var win=null;
function getVideoes(id){
	if(win == null){
		win= new Window({className: "dialog",  width:350, height:500, zIndex: 100, resizable: true, title: "用户列表", showEffect:Effect.BlindDown, hideEffect: Effect.SwitchOff, draggable:true, wiredDrag: true})
		}	
	
	win.getContent().innerHTML= "<img src='images/loading.gif' />";
	win.setStatusBar("Status bar info");
	win.showCenter();  
	
	 var url = 'getPlayBill.do';
    
	  var pars = 'method=ajax&id=' + id;

	 	
	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse });
	      
	            
             
             }


function showResponse(originalRequest){
	jsonRaw = originalRequest.responseText;
	 pagination = eval("(" + jsonRaw + ")");

	 var val = "<table  width='160' border='0'><tr style='color: red;'><td width='30'></td><td width='30'><div align='center'>ID</div></td><td width='100'><div align='center'>视频名称</div></td></tr>";
	 for (i = 0; i < pagination.results.length; i++) {
		 val = val +"<tr style='color: white;'><td><div align='center'><input type='checkbox' name='uids' value='"+pagination.results[i].id+"'/></div></td><td><div align='center'>"+pagination.results[i].id+"</div></td><td><div align='center'>"+pagination.results[i].name+"</div></td></tr>";
		 }
	 val=val+"</table><br />";

	
	 val = val+'<br /><button onclick="delVideoAndPlayBill('+"'"+pagination.id+"'"+')">删除</button>';
	 win.getContent().innerHTML= val;

	
	 
 		}



function delVideoAndPlayBill(id){
	var ids = '0';
	var uids = document.getElementsByName("uids");
	  for (var i=0; i<uids.length; i++){
		  if(uids[i].checked){
			  ids += ','+uids[i].value;
			  }
		
		  }
	  if(ids!='0'){

		  ids = ids.substring(2);
		  var url = 'updatePlayBill.do';
		    
		  var pars = 'method=delMid&id=' + id+"&uids="+ids;

		 	
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
		location.reload()
		}

	
}
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
	document.form.action="updatePlayBill.do?pageNo="+pageNo+"&method=all";
	var i = confirm("确定执行?");
	   if(i){
	   document.form.submit();
	   };
}

</script>
<div align="center">

			<a href="getPlayBills.do?pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="getPlayBills.do?pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="getPlayBills.do?pageNo=${pagination.no+1}">下一页</a></c:if>
			<a href="getPlayBills.do?pageNo=${pagination.pageSum}">尾页</a>		
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
<table id="mytable" width="884" border="0">
  <tr>
    <td width="34"><div align="center"></div></td>
    <td width="118"><div align="center">名称</div></td>
    <td width="120"><div align="center">图片</div></td>
    <td width="135"><div align="center">简介</div></td>
    <td width="131"><div align="center">创建时间</div></td>
    <td width="88"><div align="center">创建用户</div></td>
    <td width="62"><div align="center">视频数量</div></td>
    <td width="155"><div align="center">操作</div></td>
  </tr>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
 <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center"><input type="checkbox" value="${result.id }" name="ids"/></div></td>
    <td><div align="center">${result.name }</div></td>
    <td><div align="center"><img src="<%=request.getContextPath() %>${result.imagesUrl }"/></div></td>
    <td><div align="center">${result.description }</div></td>
    <td><div align="center"><fmt:formatDate
				value="${result.addDate }" type="both" /></div></td>
    <td><div align="center">${result.user.userName }</div></td>
    <td><div align="center"><a href="#" onclick="getVideoes('${result.id }');">${fn:length(result.videoes)}</a></div></td>
    <td><div align="center">
<a href="#" onclick="deleteit('${result.id}');">删除</a> <a href="getPlayBill.do?id=${result.id }">修改</a>  

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


</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>

</html>