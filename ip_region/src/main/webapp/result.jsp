<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="util.*"%>
<%
	RegionModel regionModel = (RegionModel)request.getAttribute("regionModel");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>地理位置</title>
</head>
<body>

国家： <%=regionModel.getCountry() %>
<br />
城市： <%=regionModel.getCity() %>
<br />
经度：<%=regionModel.getLongitude() %>
<br />
纬度：<%=regionModel.getLatitude() %>

</body>
</html>