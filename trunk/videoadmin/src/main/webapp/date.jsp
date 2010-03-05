<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
 <script type="text/javascript" src="js/calendar/popcalendar.js"></script>
<title>Insert title here</title>
</head>

<body bgcolor="#CCCCCC" text="#000000" >
<form name='mainform' method='post'>
<input type=text size=20 maxlength=20 value='' id="date1" readonly="readonly"> 
<a href="javascript:;" onclick='showCalendar(this, document.getElementById("date1"), "yyyy-mmmm-dd",null,0,-1,-1)'>时间</a>
<img src="images/popcalendar.gif" onclick='showCalendar(this, document.getElementById("date1"), "yyyy-mmmm-dd",null,0,-1,-1)'/>
<input type=text size=20 maxlength=20 value='' id="date2">
<a href="javascript:;" onclick='showCalendar(this, document.getElementById("date2"), "yyyy-mmmm-dd",null,0,-1,-1)'>时间</a>
</form>
</body>
</html>