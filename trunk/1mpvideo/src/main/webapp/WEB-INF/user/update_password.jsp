<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page import="com.video.domain.User"%>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5/md5.js"></script>
<div class="side">
<script type="text/javascript">
function checkit(){
	
	var password_old = document.getElementById('password_old').value;
	var password_new = document.getElementById('password_new').value;
	var password_re = document.getElementById('password_re').value;
	var re = /^[0-9a-zA-Z_]{6,12}$/;
	if(password_old==''||password_new==''||password_re==''){
		document.getElementById('message').innerHTML="请完整填写";
		document.getElementById('message').style.display='';
		return false;
		}
	else if(password_new!=password_re){
		document.getElementById('message').innerHTML="两次密码不匹配";
		document.getElementById('message').style.display='';
		return false;
		}
	else if(!password_new.match(re)){
		document.getElementById('message').innerHTML="密码格式为6到12位数字或字母组成";
		document.getElementById('message').style.display='';
		return false;

		}
	
	 else{
		 document.getElementById('password_old').value=hex_md5(password_old);
		 document.getElementById('password_new').value=hex_md5(password_new);
		 document.getElementById('password_re').value=hex_md5(password_new);
		return true;
		 }

	
}

</script>
<div class="module">
<div class="title">
<h2>博客设置</h2>
</div>
<div class="moduleval">
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/face/">修改头像</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/signature/">个性签名</a></p>
</div>
</div>


<div class="module">
<div class="title">
<h2>账户设置</h2>
</div>
<div class="moduleval">
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/info/">个人资料</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/email/">电子邮件</a></p>
<p class="sideButton"><a >修改密码</a></p>


</div>
</div>

</div>
<div class="main">
<div class="module">
<div class="title"><span><a
	href="home.do?id=${sessionUser.id }">返回您的首页</a></span>
<h2>修改密码</h2>
</div>
<c:if test="${not empty message }">
<div
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
${message }</div>
</c:if>
<div id="message"
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;display: none;">
</div>

<div class="moduleval" style="theight: 200px;text-align: center;">

<form action="<%=request.getContextPath()%>/updatePassword.do" method="post">
<table width="300px" style="margin: auto;">
<tr><td>旧密码：</td><td><input name="password_old" id="password_old" type="password" value="" /></td><td></td></tr>
<tr><td>新密码：</td><td><input name="password_new" id="password_new" type="password" value="" /></td><td></td></tr>
<tr><td>确认新密码：</td><td><input name="password_re" id="password_re" type="password" value="" /></td><td></td></tr>
</table>

<p>
 <input type="submit" value="修改" onclick="return checkit();"/>
</p>
</form>
</div>
</div>
</div>




