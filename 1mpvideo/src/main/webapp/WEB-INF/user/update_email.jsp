<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page import="com.video.domain.User"%><div class="side">
<script type="text/javascript">
function checkit(){
	
	var val = document.getElementById('email').value;
	
	var re = /^[_\.0-9a-zA-Z-]+[0-9a-zA-Z]@([0-9a-zA-Z][0-9a-zA-Z-]+\.)+[a-zA-Z]{2,3}$/; 
	 if (!val.match(re)){
	
		document.getElementById('message').innerHTML="邮箱格式错误";
		document.getElementById('message').style.display='';
		return false;
		 }
	 else{
		
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
<p class="sideButton"><a >电子邮件</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/password/">修改密码</a></p>


</div>
</div>

</div>
<div class="main">
<div class="module">
<div class="title"><span><a
	href="home.do?id=${sessionUser.id }">返回您的首页</a></span>
<h2>修改电子邮件</h2>
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

<form action="<%=request.getContextPath()%>/updateEmail.do" method="post">
<p>
电子邮件：<input name="email" id="email" type="text" value="${sessionUser.email }" />
</p>
<p>
 <input type="submit" value="修改" onclick="return checkit();"/>
</p>
</form>
</div>
</div>
</div>




