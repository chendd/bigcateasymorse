<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
User user = (User) session.getAttribute("sessionUser");
int year = 0;
int month = 0;
int day = 0;
if(user.getBirthday()!=null){
	year = user.getBirthday().getYear();
	month = user.getBirthday().getMonth()+1;
	day = user.getBirthday().getDate();
}
%>
<%@page import="com.video.domain.User"%><div class="side">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/area/pcasunzip.js"></script>

<div class="module">
<div class="title">
<h2>博客设置</h2>
</div>
<div class="moduleval">
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/face/">修改头像</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/signature/">个性签名</a></p>
</div>
</div>


<div class="module">
<div class="title">
<h2>账户设置</h2>
</div>
<div class="moduleval">
<p class="sideButton"><a >个人资料</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/email/">电子邮件</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/password/">修改密码</a></p>


</div>
</div>

</div>
<div class="main">
<div class="module">
<div class="title"><span><a
	href="<%=request.getContextPath()%>/home/${sessionUser.id }/">返回您的首页</a></span>
<h2>修改个人资料</h2>
</div>
<c:if test="${not empty message }">
<div
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
${message }</div>
</c:if>

<div class="moduleval" style="theight: 300px;">

<form action="<%=request.getContextPath()%>/updateInfo.do" method="post">

<table style="width: 90%;border-bottom: 2px silver solid;">
<tr><td width="15%"><label style="color: navy"><b>基本资料</b></label></td><td></td></tr>
<tr><td>登录ID：</td><td>${sessionUser.userName }</td></tr>
<tr><td>昵称：</td><td><input type="text" name="realName" value="${sessionUser.realName }"/></td></tr>
<tr><td>所在地区：</td><td>
<select id="province" name="province">

</select>
<select id="city" name="city">

</select>
<select id="area" name="area">

</select>
</td></tr>
<tr><td>性别：</td><td><input type="radio" name="gender" value="m" <c:if test="${sessionUser.gender eq 'm'}">checked="checked"</c:if> />男 
<input type="radio" name="gender" value="f" <c:if test="${sessionUser.gender eq 'f'}">checked="checked"</c:if> />女
</td></tr>
<tr><td>生日：</td><td>
<select name="year">
		<option>年</option>
		<%for(int i=1909;i<2009;i++){
			%>
			<option value="<%=i %>" <%if(year==i-1900){%>selected="selected"<%}%>><%=i %></option>
			<%
			
		} %>
	</select>

	<select name="month">
		<option>月</option>
		<%for(int i=1;i<13;i++){
			%>
			<option value="<%=i %>" <%if(month==i){%>selected="selected"<%}%>><%=i %></option>
			<%
			
		} %>
	</select>

<select name="day">
		<option>日</option>
		<%for(int i=1;i<32;i++){
			%>
			<option value="<%=i %>" <%if(day==i){%>selected="selected"<%}%>><%=i %></option>
			<%
			
		} %>
	</select>

</td></tr>
</table>



<table style="width: 90%;border-bottom: 2px silver solid;">
<tr><td width="15%"><label style="color: navy"><b>联系信息</b></label></td><td></td></tr>

<tr><td >QQ：</td><td><input type="text" name="qq" value="${sessionUser.qq }"/></td></tr>
<tr><td >手机：</td><td><input type="text" name="mobilePhone" value="${sessionUser.mobilePhone }"/></td></tr>

</table>
<p>
<input type="submit" value="修改"/>
</p>
</form>


</div>
</div>
</div>

<script type="text/javascript">
<%
	String area = user.getArea();
	if(area==null||area.equals("")){
		area = "--请选择省份--;--请选择城市--;--请选择地区--";
	}

	String[] areas = area.split(";");

%>

new PCAS("province","city","area","<%=areas[0]%>","<%=areas[1]%>","<%=areas[2]%>");


</script>


