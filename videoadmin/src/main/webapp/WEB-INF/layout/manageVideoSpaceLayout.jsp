<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet" id="css" />

<!-- calendar -->
<script type="text/javascript" src="js/calendar/date.js"></script>

<title>1MP后台管理系统</title>
</head>
<body>
<div id="main">
<div id="header"><tiles:insert attribute="header" /></div>
<div id="center">

<div id="left"><tiles:insert attribute="menu" /></div>
<div id="right">
<div id="bodyHeader"><tiles:insert attribute="bodyheader" /></div>
<div id="bodyBody"><tiles:insert attribute="bodybody" /></div>
</div>
</div>
<div id="footer"><tiles:insert attribute="footer" /></div>



</div>
</body>
</html>