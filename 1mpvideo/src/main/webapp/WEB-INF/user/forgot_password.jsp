<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
<div class="title"><h2>找回密码</h2></div>
<div class="reDiv">

<c:if test="${success!=true}">
<c:if test="${not empty  message }">
<div
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
${message }</div>
</c:if>
<form action="<%=request.getContextPath()%>/sendPassword.do" method="post" >
<table width="90%">
<tr><td>输入你注册时登记的Email地址:</td></tr>
<tr><td><input type="text" name="email"/></td></tr>
<tr><td><input type="submit" value="把密码发到我的邮箱"/></td></tr>
</table>
</form>
</c:if>
<c:if test="${success==true}">
<div
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
一封包含"重新设置密码" 链接的email已经发送到你的邮箱。</div>


</c:if>
</div>
</div>
</div>

