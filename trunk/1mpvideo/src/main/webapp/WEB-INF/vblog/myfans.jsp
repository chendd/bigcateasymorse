<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="side">
<div class="module">

			<div class=title ><h2></h2></div>
			<div >
<p class="sideButton"><a href="<%=request.getContextPath()%>/myFans/1/1">我关注的</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/myFans/2/1">关注我的</a></p>
</div>
</div>
</div>


<div class="main">
<div class="module">

			<div class=title ><h2>
<c:if test="${type==1}">我关注的</c:if>
<c:if test="${type==2}">关注我的</c:if>
</h2></div>
			<div class="reDiv">
<table width="95%">
<c:forEach begin="1" var="i" end="${pagination.size/5}" step="1">
<c:if test="${not empty pagination.results[(i-1)*5].user }">
<tr>
<c:forEach begin="${(i-1)*5}" var="j" end="${i*5-1}" step="1">
<c:if test="${not empty pagination.results[j].user }">
<td width="27%">
<img width="65" src="<%= application.getAttribute("IMAGE_URL")%>${pagination.results[j].user.face }"><br />
<a href="">${pagination.results[j].user.realName }</a><br />
节目:${pagination.results[j].user.videoCount } 被关注:${pagination.results[j].user.beSubscribeCount }<br />
好友:${pagination.results[j].user.friendCount } 积分:${pagination.results[j].user.score } 
</td>
</c:if>
<c:if test="${empty pagination.results[j].user }">
<td width="20%">&nbsp;

</td>
</c:if>
</c:forEach>

</tr>
</c:if>
</c:forEach>

</table>
	<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${pageContext.request.contextPath}/myFans/${type }/${pageSize}"></h:pagination>
</div>

</div>
</div>
