<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
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
function oprate(pageNo){
	document.form.action="whisper.do?type=oprate&pageNo="+pageNo;
	var i = confirm("确定执行");
	   if(i){
	   document.form.submit();
	   };
}
function deleteById(id,pageNo){
	document.form.action="whisper.do?type=deleteById&pageNo="+pageNo+"&id="+id;
	var i = confirm("确定删除?");
	   if(i){
	   document.form.submit();
	   };
}

function findWhisper(){
	document.form.action="whisper.do?type=select";
	 document.form.submit();
	
}


function selectAll(){
	var aa = document.getElementsByName("ids");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;

}


function showText(id){

	Dialog.alert({url: "showNotice.do?id="+id, options: {method: 'post'}}, 
            {className: "alphacube", width:540,height:500, okLabel: "Close"});
}
</script>

<div class="module">
<div class="title"><h2>通知列表</h2></div>
<div class="reDiv">
<form action="" method="post" name="form">



<div  align="center" >
	
<table class="test" id="crossTable" width="90%" border="0">
  
<thead>
<tr>
    <th ><div align="center"></div></th>
    <th ><div align="center">标题</div></th>
    <th ><div align="center">内容</div></th>
    <th ><div align="center">发送时间</div></th>
    <th ><div align="center">管理操作</div></th>
  </tr>
</thead>
<tbody>
<c:forEach items="${pagination.results}" var="result" varStatus="stat">
  <tr ${stat.count%2==0? "bgcolor='#F1D1FA'":""}>
    <td><div align="center">
<input type="checkbox" name="ids" value="${result.id}"/>
</div></td>
    <td><div align="center">${result.title}</div></td>
    <td><div align="center"><a href="#" onclick="showText('${result.id}');">预览</a></div></td>
    <td><div align="center"><fmt:formatDate value="${result.sendDate}" type="both"/></div></td>
    <td><div align="center"> <a href="#" onclick="deleteById('${result.id}','${pagination.no}');">删除</a></div></td>
  </tr>
</c:forEach>
</tbody>
</table>

</div>
<div align="center"><input type="checkbox" id="all" name="all" onclick="selectAll();"/>全选 批量管理

<select name="tp">
	
	<option value="delete">删除</option>
</select>
<button onclick="oprate('${pagination.no}');">执行</button>
</div>
</form>


</div>

</div>


<script type="text/javascript">
tableHelper('crossTable');
	
</script>
</body>
</html>