<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<div class="side">
	<div class="module">
		<div class="title">
			<h2>
				信箱
			</h2>
		</div>
		<div>
		<p class="sideButton">
<a href="<%=request.getContextPath()%>/myFriends/1/1">我的好友</a>
</p>
	<p class="sideButton">		
			<a href="<%=request.getContextPath()%>/myFriends/2/1">和我兴趣相投的朋友</a>
</p>
		</div>
	</div>
</div>








<div class="main">
<div class="module">

			<div class=title ><h2>
<c:if test="${type==1}">我的好友</c:if>
<c:if test="${type==2}">和我兴趣相投的朋友</c:if>
</h2></div>
			<div class="reDiv">
<table width="98%">
<c:forEach begin="1" var="i" end="${pagination.size/5}" step="1">
<c:if test="${not empty pagination.results[(i-1)*5] }">
<tr>
<c:forEach begin="${(i-1)*5}" var="j" end="${i*5-1}" step="1">
<c:if test="${not empty pagination.results[j] }">
<td width="20%" align="center">
<img width="70" src="<%= application.getAttribute("IMAGE_URL")%>${pagination.results[j].face }"><br />
<a href="">${pagination.results[j].realName }</a><br />

</td>
</c:if>
<c:if test="${empty pagination.results[j] }">
<td width="20%">&nbsp;

</td>
</c:if>
</c:forEach>

</tr>
</c:if>
</c:forEach>

</table>
	<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${pageContext.request.contextPath}/myFriends/${type }/${pageSize}"></h:pagination>
</div>

</div>
</div>
