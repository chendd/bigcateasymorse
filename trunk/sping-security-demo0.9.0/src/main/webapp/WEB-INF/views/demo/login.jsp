<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>自定义登陆</title>
</head>
<body>
<div class="error ${param.error == true ? '' : 'hide'}">登陆失败!!!!<br>
${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</div>
<form
	action="${pageContext.request.contextPath}/j_spring_security_check"
	style="width: 360px; text-align: center;">
<fieldset><legend>登陆</legend>
<table>
	<tr>
		<td>用户：</td>
		<td><input type="text" name="j_username" style="width: 150px;"
			value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}" /></td>
	</tr>
	<tr>
		<td>密码：</td>
		<td><input type="password" name="j_password"
			style="width: 150px;" /></td>
	</tr>
	<tr>
		<td>验证码:</td>
		<td><input type="text" name="validate" /></td>
		<td><img alt="图片" src="${pageContext.request.contextPath}/" /></td>
	</tr>
</table>
<input type="checkbox" name="_spring_security_remember_me" />两周之内不必登陆<br />
<input type="submit" value="登陆" /> <input type="reset" value="重置" /></fieldset>
</form>
</body>
</html>