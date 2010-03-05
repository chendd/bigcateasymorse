<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<link href="css/style.css" type="text/css" rel="stylesheet" id="css"/>







<!-- validation -->
 <script type="text/javascript" src="js/validation/validation.js"></script>
<link href="js/validation/style.css" type="text/css" rel="stylesheet" id="css"/>
<title>1MP后台管理系统</title>

</head>
<body>
<div id="main">
<div id="header">
<tiles:insert attribute="header" />
</div>
<div id="center">

<div id="left">
<tiles:insert attribute="menu" />
</div>
<div id="right">
<tiles:insert attribute="body" />
</div>
</div>
<div id="footer">
<tiles:insert attribute="footer" />

</div>



</div>
</body>
</html>