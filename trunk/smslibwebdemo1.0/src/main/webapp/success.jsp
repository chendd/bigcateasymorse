<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="cn.vsp.bean.*" %>
<%@ page  import="cn.vsp.dao.*" %>
<%@ page  import="cn.vsp.util.*" %>
<%@ page  import="org.apache.log4j.*" %>

<%

String smsSign = (String)request.getParameter("smsSign");
//String smsSign = (String)request.getAttribute("smsSign");
System.out.println(">>>>>>>smsSign="+smsSign);
SmsBeanDao smsBeanDao = new SmsBeanDao();
SmsBean smsBean = smsBeanDao.findSmsBeanBysmsSign(smsSign);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
<% if(smsBean != null){ %>
发送的手机号码是：<%=smsBean.getPhoneNum() %><br /> 
发送内容是：<%=smsBean.getMessage()  %>
<%} else{%>
<h2><font color="red">短信正在发送，请耐心等待！！！</font></h2>
<%} %>
</body>
</html>