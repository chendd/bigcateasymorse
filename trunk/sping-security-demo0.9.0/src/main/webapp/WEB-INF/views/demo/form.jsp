<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>演示用表单</title>
</head>
<body>
<h1>演示表单</h1>
<form action="submit.do" method="post">
<p>
<label>用户名：<input type="text" name="name" value="${user.name }"/></label>
</p>
<p><input type="submit" /></p>
</form>
</body>
</html>