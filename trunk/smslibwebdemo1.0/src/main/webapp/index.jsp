<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>填写短信发送单</h2>
<form action="sendsms.jsp">
手机号码:<input name="phonenum" type="text" /> <br />
短信内容:<textarea name="msg" rows="5" cols="30"></textarea> <br />
发送端口:<input name="smsPort" type="text" /> (默认值是－1)<br />
<input  type="submit" value="发送"/>
</form>
</body>
</html>
