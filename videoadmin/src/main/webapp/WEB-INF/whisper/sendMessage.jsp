<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FCKeditor fckEditor = new FCKeditor(request, "message");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="net.fckeditor.FCKeditor"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript">
function sedMess(){
	document.form.action="whisper.do?type=send";
	var title = document.getElementById("title").value;
	if(title == ''){
		alert('标题不能为空');
		return false;
		}
	var i = confirm("确定发送?");
	   if(i){
		   document.form.submit();
	   };
	  
}

function delByGrade(){
	document.form.action="whisper.do?type=deleteByGrade";
	var i = confirm("确定删除?");
	   if(i){
		   document.form.submit();
	   };
	
}

function deleteByDate(){
	document.form.action="whisper.do?type=deleteByDate";
	var i = confirm("确定删除?");
	   if(i){
		   document.form.submit();
	   };
	
	
}

</script>
<form action="" method="post" name="form">
<div class="module">
<div class="title">
<h2>通知删除</h2>
</div>
<div class="reDiv">
<table width="748" height="178" border="0">
 
  <tr>
    <td>
		<div><label>批量删除短信: </label>
		<select name="delGrade">
<option value="all">所以会员</option>
<option value="0">普通会员</option>
<option value="1">高级会员</option>
</select>
		<button onclick="delByGrade();">确定</button>
	</div>
	</td>
  </tr>
<tr>
    <td>
	<div>
<label>批量删除指定日期内短信:</label> 
<select name="date">
<option value="7">一个星期前</option>
<option value="30">一个月前</option>
<option value="60">两个月前</option>
<option value="180">半年前</option>
<option value="all">所有短信</option>

</select> 
<input type="checkbox" name="all" value="all" />包括未读信息 <button onclick="deleteByDate();">确认</button>
</div>

</td>
  </tr>
  

</table>
</div>
</div>


<div class="module">
<div class="title">
<h2>群发通知</h2>
</div>
<div class="reDiv">
<table width="748">
  <tr>
    <td>
	<div>
标题：<input type="text" id="title" name="title"/><br />
收件人：
<select name="grade">
<option value="all">所以会员</option>
<option value="0">普通会员</option>
<option value="1">高级会员</option>
</select><br />

内容：<br />
<%
					fckEditor.setValue("");
					fckEditor.setToolbarSet("Topic");
				
					
					out.println(fckEditor);
				%>

</div>
</td>
  </tr>
  <tr>
    <td><button onclick="sedMess();">发送</button></td>
  </tr>
  
  
</table>
</div>
</div>





	</form>
	








</body>
</html>