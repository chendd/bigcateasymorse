<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5/md5.js"></script>
<script type="text/javascript">
function checkit(){
var password = document.getElementById('password').value;
var passwordAgain = document.getElementById('passwordAgain').value;
var mss='';
if (password.length==0 
		|| password.length<6
		|| password.length>16
		|| password.match('"') 
		|| password.match("'") 
		|| password.match(" ")){
	mss = '格式不正确，6-16个字符，不能含空格、「"」及「\'」';
		
	}
else if(password!=passwordAgain){
	mss = '两次密码数据不一致，请重输';
	
}

if(mss==''){
	alert('ok');
	document.getElementById('password').value=hex_md5(password);
    document.getElementById('passwordAgain').value=document.getElementById('password').value;
	return true;
}
else{
	
	document.getElementById('mss').style.display='';
	document.getElementById('mss').innerHTML=mss;
	return false;
}
	
}
</script>
<div class="side2">

<div class="module">
<div class="title"><h2>你还可以</h2></div>
<div class="reDiv">
<ul>
<li>重新尝试<a href="<%=request.getContextPath()%>/login">登录</a></li>

<li>返回<a href="<%=request.getContextPath()%>/">首页</a></li>
</ul>
</div>
</div>
</div>



<div class="main2">
<div class="module">
<div class="title"><h2>重设密码</h2></div>
<div class="reDiv">

<c:if test="${success!=true}">
<c:if test="${not empty message }">
<div
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
${message }</div>
</c:if>
<div id="mss"
	style="display: none;border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
</div>
<form action="" method="post" onsubmit="return checkit();" >
<table width="90%">
<tr><td>输入密码：<input type="password" name="password" id="password"/></td></tr>
<tr><td>确认密码：<input type="password" name="passwordAgain" id="passwordAgain"/></td></tr>
<tr><td><input type="submit" value="提交"/></td></tr>
</table>
</form>
</c:if>
<c:if test="${success==true}">
<div
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
修改成功，现在就去<a href="<%=request.getContextPath()%>/login">登录</a>吧</div>


</c:if>
</div>
</div>
</div>

