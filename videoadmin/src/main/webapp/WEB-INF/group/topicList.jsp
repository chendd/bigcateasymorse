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
var win=null;
function getComments(id,pageNo){
	if(win == null){
		win= new Window({className: "dialog",  width:350, height:500, zIndex: 100, resizable: true, title: "用户列表", showEffect:Effect.BlindDown, hideEffect: Effect.SwitchOff, draggable:true, wiredDrag: true})
		}	
	
	win.getContent().innerHTML= "<img src='images/loading.gif' />";
	win.setStatusBar("Status bar info");
	win.showCenter();  
	
	 var url = 'getTopic.do';
    
	  var pars = 'type=getComm&id=' + id;

	 	
	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse });
	      
	            
             
             }


function showResponse(originalRequest){
	jsonRaw = originalRequest.responseText;
	 pagination = eval("(" + jsonRaw + ")");

	 var val = "<table  width='330' border='0'><tr style='color: red;'><td width='30'></td><td width='30'><div align='center'>ID</div></td><td width='100'><div align='center'>留言</div></td><td width='170'><div align='center'>时间</div></td></tr>";
	 for (i = 0; i < pagination.results.length; i++) {
		 val = val +"<tr style='color: white;'><td><div align='center'><input type='checkbox' name='uids' value='"+pagination.results[i].id+"'/></div></td><td><div align='center'>"+pagination.results[i].id+"</div></td><td><div align='center'>"+pagination.results[i].comment+"</div></td><td><div align='center'>"+pagination.results[i].commentDate+"</div></td></tr>";
		 }
	 val=val+"</table><br />";

	
	 val = val+'<br /><button onclick="delComment('+"'"+pagination.id+"'"+')">删除</button>';
	 win.getContent().innerHTML= val;

	
	 
 		}



function delComment(id){
	var ids = '0';
	var uids = document.getElementsByName("uids");
	  for (var i=0; i<uids.length; i++){
		  if(uids[i].checked){
			  ids += ','+uids[i].value;
			  }
		
		  }
	  if(ids!='0'){

		  ids = ids.substring(2);
		  var url = 'getTopic.do';
		    
		  var pars = 'type=del&id=' + id+"&uids="+ids;

		 	
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

function showText(id){

	Dialog.alert({url: "getTopic.do?type=showText&id="+id, options: {method: 'post'}}, 
            {className: "alphacube", width:540,height:500, okLabel: "Close"});
}

//---------------
function lock(id,pageNo){
	document.form.action="updateTopic.do?id="+id+"&pageNo="+pageNo+"&type=lock";
	var i = confirm("确定锁定?");
	 if(i){
		   document.form.submit();
		   };
}
function del(id,pageNo){
	document.form.action="updateTopic.do?id="+id+"&pageNo="+pageNo+"&type=delete";
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
	document.form.action="updateTopic.do?pageNo="+pageNo+"&type=all";
	var i = confirm("确定执行?");
	   if(i){
	   document.form.submit();
	   };
}


</script>
<div class="module">
<div class="title">
<h2>话题列表</h2>
</div>
<div class="reDiv">
<form action="" method="post" name="form">
<table width="950" border="0" id="mytable">
  <tr>
    <td width="24"><div align="center"></div></td>
    <td width="106"><div align="center">标题</div></td>
    <td width="154"><div align="center">内容</div></td>
    <td width="136"><div align="center">发表时间</div></td>
    <td width="55"><div align="center">发表用户</div></td>
    <td width="54"><div align="center">所在圈子</div></td>
    <td width="54"><div align="center">浏览次数</div></td>
    <td width="53"><div align="center">回复数量</div></td>
    <td width="55"><div align="center">是否推荐</div></td>
    <td width="34"><div align="center">状态</div></td>
    <td width="150"><div align="center">操作</div></td>
  </tr>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center"><input type="checkbox" name="ids" value="${result.id }" /></div></td>
    <td><div align="center">${result.title}</div></td>
    <td><div align="center">
<a href="#" onclick="showText('${result.id}');">预览</a>
</div></td>
    <td><div align="center"><fmt:formatDate
				value="${result.addDate }" type="both" /></div></td>
    <td><div align="center">${result.user.userName}</div></td>
    <td><div align="center">${result.group.name }</div></td>
    <td><div align="center">${result.browseCount }</div></td>
    <td><div align="center"><a href="#" onclick="getComments('${result.id}','1')">${fn:length(result.comments)}</a></div></td>
   <td><div align="center"><c:if test="${empty result.recommendDate}">否</c:if><c:if test="${not empty result.recommendDate }"><fmt:formatDate
				value="${result.recommendDate }" type="both" /></c:if></div></td>
  <td><div align="center"><c:if test="${result.flag==1}">正常</c:if><c:if test="${result.flag==2}">锁定</c:if></div></td>
    <td><div align="center">
 <a href="#" onclick="del('${result.id}','${pagination.no }');">删除</a> <a href="#" onclick="lock('${result.id}','${pagination.no }')">锁定</a>
 <a href="getTopic.do?id=${result.id}" >修改</a>
</div></td>
  </tr>
</c:forEach>
</table>

<div align="center">
			<a href="<c:if test="${empty selectType}">getTopices.do?</c:if><c:if test="${not empty selectType }">getTopices.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="<c:if test="${empty selectType}">getTopices.do?</c:if><c:if test="${not empty selectType }">getTopices.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="<c:if test="${empty selectType}">getTopices.do?</c:if><c:if test="${not empty selectType }">getTopices.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.no+1}">下一页</a></c:if>
			<a href="<c:if test="${empty selectType}">getTopices.do?</c:if><c:if test="${not empty selectType }">getTopices.do?selectType=${selectType }&keyword=${keyword }&</c:if>pageNo=${pagination.pageSum}">尾页</a>		
		     页次：${pagination.no}/${pagination.pageSum}页  ${pagination.size}个记录/页     
			
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




</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>
</html>