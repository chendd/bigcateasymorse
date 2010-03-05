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
var winn=null;

function getPlayBills(pageNo){
	if(winn == null){
		winn= new Window({className: "dialog",  width:350, height:500, zIndex: 100, resizable: true, title: "用户列表", showEffect:Effect.BlindDown, hideEffect: Effect.SwitchOff, draggable:true, wiredDrag: true})
		}	
	
	winn.getContent().innerHTML= "<img src='images/loading.gif' />";
	winn.setStatusBar("Status bar info");
	winn.showCenter();  
	
	 var url = 'getPlayBills.do';
    
	  var pars = 'type=ajax&pageNo='+pageNo;

	 	
	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse1 });
	      
	            
             
             }

function showResponse1(originalRequest){
	jsonRaw = originalRequest.responseText;
	 pagination = eval("(" + jsonRaw + ")");

	 var val = "<table  width='230' border='0'><tr style='color: red;'><td width='30'></td><td width='100'><div align='center'>ID</div></td><td width='100'><div align='center'>用户名</div></td></tr>";
	 for (i = 0; i < pagination.results.length; i++) {
		 val = val +"<tr><td><div align='center'><input type='radio' name='pid' value='"+pagination.results[i].id+"'/></div></td><td><div align='center'>"+pagination.results[i].id+"</div></td><td><div align='center'>"+pagination.results[i].name+"</div></td></tr>";
		 }
	 val=val+"</table><br />";

	 if(pagination.next){
	
		 val=val+'<a href="#" onclick="getPlayBills('+"'"+(Number(pagination.no)+1)+"'"+')">下一页</a> ';
		 }
	 if(pagination.previous){
		 val=val+'<a href="#" onclick="getPlayBills('+"'"+(Number(pagination.no)-1)+"'"+')">上一页</a> ';
		 }
	 val = val+'<br /><button onclick="updatePlayBill()">确定</button>';
	 winn.getContent().innerHTML= val;

	
	 
 		}




function updatePlayBill(){
	var ids = '0';
	var pid='';
	var sids = document.getElementsByName("ids");
	  for (var i=0; i<sids.length; i++){
		  if(sids[i].checked){
			  ids += ','+sids[i].value;
			  }
		
		  }
	 var pids = document.getElementsByName('pid');
	  for (var j=0; j<pids.length; j++){
		  if(pids[j].checked){
			  pid = pids[j].value;
			  }
		
		  }
	  if(ids!='0'&&pid!=''){

		  ids = ids.substring(2);
		 
		  var url = 'updatePlayBill.do';
		    
		  var pars = 'method=mid&vids='+ids+'&pid='+pid;

		 	
		  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: selectOk });
		      
		  }
	  else{
		  winn.close();
			winn = null;
		  }
	 
	
}

function selectOk(originalRequest){
	jsonRaw = originalRequest.responseText;
	if(jsonRaw=='ok'){
		winn.close();
		winn = null;
		}

	
}


	





var win=null;
function getComments(id,pageNo){
	if(win == null){
		win= new Window({className: "dialog",  width:350, height:500, zIndex: 100, resizable: true, title: "用户列表", showEffect:Effect.BlindDown, hideEffect: Effect.SwitchOff, draggable:true, wiredDrag: true})
		}	
	
	win.getContent().innerHTML= "<img src='images/loading.gif' />";
	win.setStatusBar("Status bar info");
	win.showCenter();  
	
	 var url = 'getComments.do';
    
	  var pars = 'type=getComm&id=' + id;

	 	
	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse });
	      
	            
             
             }


function showResponse(originalRequest){
	jsonRaw = originalRequest.responseText;
	 pagination = eval("(" + jsonRaw + ")");

	 var val = "<table  width='330' border='0'><tr style='color: red;'><td width='30'></td><td width='30'><div align='center'>ID</div></td><td width='100'><div align='center'>评论</div></td><td width='170'><div align='center'>时间</div></td></tr>";
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
		  var url = 'getComment.do';
		    
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




function toChannel(){
	var obj=document.getElementById('channel');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;

	 window.location.href="getVideoes.do?channelId="+val;
	
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
	document.form.action="updateVideo.do?pageNo="+pageNo;
	var i = confirm("确定执行?");
	   if(i){
	   document.form.submit();
	   };
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
<div align="center">
			<a href="<c:if test="${empty selectType}">getVideoes.do?</c:if><c:if test="${not empty pagination.condition }">channelId=${pagination.condition.channel.id }&</c:if>pageNo=1">首页</a>
			
			<c:if test="${pagination.previous}"><a href="<c:if test="${empty pagination.condition}">getVideoes.do?</c:if><c:if test="${not empty pagination.condition }">getVideoes.do?channelId=${pagination.condition.channel.id }&</c:if>pageNo=${pagination.no-1} ">上一页</a></c:if>
			<c:if test="${pagination.next}"><a href="<c:if test="${empty pagination.condition}">getVideoes.do?</c:if><c:if test="${not empty pagination.condition }">getVideoes.do?channelId=${pagination.condition.channel.id}&</c:if>pageNo=${pagination.no+1}">下一页</a></c:if>
			<a href="<c:if test="${empty pagination.condition}">getVideoes.do?</c:if><c:if test="${not empty pagination.condition }">getVideoes.do?channelId=${pagination.condition.channel.id }&</c:if>pageNo=${pagination.pageSum}">尾页</a>		
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

<table width="939" border="0" id="mytable">

  <tr>
    <td width="27"><div align="center"></div></td>
    <td width="65"><div align="center">名称</div></td>
    <td width="49"><div align="center">分类</div></td>
    <td width="114"><div align="center">添加时间</div></td>
    <td width="70"><div align="center">上传用户</div></td>
    <td width="57"><div align="center">视频大小</div></td>
    <td width="53"><div align="center">时长</div></td>
    <td width="112"><div align="center">截图</div></td>
    <td width="42"><div align="center">人气</div></td>
    <td width="47"><div align="center">得分</div></td>
    <td width="43"><div align="center">顶数</div></td>
    <td width="49"><div align="center">状态</div></td>
    <td width="157"><div align="center">操作</div></td>
  </tr>

<c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center"><input type="checkbox" value="${result.id }" name="ids"/></div></td>
    <td><div align="center">${result.name }</div></td>
    <td><div align="center">${result.channel.name }</div></td>
    <td><div align="center"><fmt:formatDate
				value="${result.addDate }" type="both" /></div></td>
    <td><div align="center"><a href="getUser.do?id=${result.user.id }">${result.user.realName }</a></div></td>
    <td><div align="center">${result.videoSize }</div></td>
    <td><div align="center">${result.videoTime }</div></td>
    <td><div align="center"><img src="<%=application.getAttribute("IMAGE_URL")%>/${result.image }" width="80"/></div></td>
    <td><div align="center">${result.browseCount }</div></td>
    <td><div align="center">${result.point }</div></td>
    <td><div align="center">${result.pushCount }</div></td>
    <td><div align="center"><c:if test="${result.flag==1}">正常</c:if><c:if test="${result.flag==2}">锁定</c:if></div></td>
    <td><div align="center">
<a href="updateVideo.do?id=${result.id }&pageNo=${pagination.no }&type=delete" onclick="">删除</a> <a href="updateVideo.do?id=${result.id }&pageNo=${pagination.no }&type=lock" onclick="">锁定</a>  <a href="getVideo.do?id=${result.id }" >编辑</a>   <a href="#" onclick="getComments('${result.id}','1')">相关评论</a>
</div></td>
  </tr>
</c:forEach>
</table>
<div align="center">
<input type="checkbox" id="all" onclick="selectAll();"/>全选&nbsp;&nbsp;&nbsp;&nbsp;批量处理：
	<select name="tp" id="tp">
		<option value="lock">锁定</option>
		<option value="delete">删除</option>
	</select>
<button onclick="doit('${pagination.no }')">执行</button> 
<button onclick="getPlayBills('1');">选择添加专辑</button>
</div>
</form>


</div>

</body>
<script type="text/javascript">
tableHelper('mytable');
	
</script>

</html>