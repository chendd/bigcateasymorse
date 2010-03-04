<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/window/prototype.js"></script>
		<title>1MP</title>
		<link href="<%=request.getContextPath()%>/css/style2.css"
			rel="stylesheet" type="text/css"></link>
<link href="<%=request.getContextPath()%>/css/header.css" rel="stylesheet" type="text/css"></link>
	</head>
	<body>
<div id="header">
				<tiles:insert attribute="header" />
			</div>
		<div id="main">
			
			<tiles:insert attribute="body" />
			<div id="footer">
				<tiles:insert attribute="footer" />
			</div>
		</div>
	</body>
</html>