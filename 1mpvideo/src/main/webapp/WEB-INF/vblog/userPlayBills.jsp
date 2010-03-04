<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="side">
<div class="module">

			<div class=title ><h2></h2></div>
			<div class="reDiv">
<p class="sideButton"><a href="<%=request.getContextPath()%>/user/${pagination.condition.id }/videoes/1">${pagination.condition.realName }的视频</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/blogList/${pagination.condition.id }">${pagination.condition.realName }的日志</a></p>
</div>
</div>
</div>


<div class="main">
<div class="module">

			<div class=title ><h2>
<a href="<%=request.getContextPath()%>/vblog/index/">播客</a> > <a href="<%=request.getContextPath()%>/home/${pagination.condition.id }/" > ${pagination.condition.realName }</a> > 节目单
</h2></div>
			<div class="reDiv">
<table width="90%">
<c:forEach begin="1" var="i" end="${pagination.size/4}" step="1">
<c:if test="${not empty pagination.results[(i-1)*4] }">
<tr>
<c:forEach begin="${(i-1)*4}" var="j" end="${i*4-1}" step="1">
<c:if test="${not empty pagination.results[j] }">
<td width="25%">
<img width="100" src="<%= application.getAttribute("IMAGE_URL")%>${pagination.results[j].imagesUrl }"><br />
<a href="">${pagination.results[j].name }</a><br />


</td>
</c:if>
<c:if test="${empty pagination.results[j] }">
<td width="20%">
&nbsp;
</td>
</c:if>
</c:forEach>

</tr>
</c:if>
</c:forEach>

</table>
	<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}"  pageSum="${pagination.pageSum}" url="${pageContext.request.contextPath}/user/${pagination.condition.id }/videoes"></h:pagination>
</div>

</div>
</div>
