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
<a href="<%=request.getContextPath()%>/vblog/mybox/">收件箱</a>
</p>
	<p class="sideButton">		
			<a >发件箱</a>
</p>
		</div>
	</div>
</div>
<div class="main">
	


	<div class="module">
		<div class="title">
			<h2>
				短信息
			</h2>
		</div>
		<div>
			<table width="90%">
				<tr>
					<th></th>
					<th>
						收件人
					</th>
					<th>
						邮件主题
					</th>
					<th>
						发送时间
					</th>
				</tr>
				<c:forEach items="${pagination.results}" var="whisper">
					<tr>
						<td width="10%">
							<input type="checkbox" value="${whisper.id}" />
						</td>
						<td width="20%">
							<a
								href="<%=request.getContextPath()%>/home/${whisper.toUser.id}/">${whisper.toUser.realName}</a>
						</td>
						<td width="30%">
							<a
								href="<%=request.getContextPath()%>/vblog/mymessage/read/${whisper.id}/">${whisper.title}</a>
						</td>
						<td width="40%">
							<fmt:formatDate value="${whisper.sendDate}" type="both" />
						</td>
					</tr>
				</c:forEach>
				
			</table>
<c:set var="url" value="${pageContext.request.contextPath}/vblog/mySendBox"></c:set>
	
<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>
		</div>
	</div>
</div>