<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="side">
<div class="module">

			<div class=title ><h2></h2></div>
			<div class="reDiv">
<p class="sideButton"><a >我订阅的</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/myFans/1">订阅我的</a></p>
</div>
</div>
</div>


<div class="main">
<div class="module">

			<div class=title ><h2>我订阅的</h2></div>
			<div class="reDiv">
<table width="90%">
<c:forEach begin="1" var="i" end="${pagination.size/5}" step="1">
<c:if test="${not empty pagination.results[(i-1)*5].passiveUser }">
<tr>
<c:forEach begin="${(i-1)*5}" var="j" end="${i*5-1}" step="1">
<c:if test="${not empty pagination.results[j].passiveUser }">
<td width="20%">
<img width="100" src="<%= application.getAttribute("IMAGE_URL")%>${pagination.results[j].passiveUser.face }"><br />
<a href="">${pagination.results[j].passiveUser.realName }的首页</a><br />
节目:${pagination.results[j].passiveUser.videoCount } 被关注:${pagination.results[j].passiveUser.beSubscribeCount }<br />
好友:${pagination.results[j].passiveUser.friendCount } 积分:${pagination.results[j].passiveUser.score } 
</td>
</c:if>
<c:if test="${empty pagination.results[j].passiveUser }">
<td width="20%">
&nbsp;
</td>
</c:if>
</c:forEach>

</tr>
</c:if>
</c:forEach>

</table>
	<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${pageContext.request.contextPath}/myFans/${pageSize}"></h:pagination>
</div>

</div>
</div>
