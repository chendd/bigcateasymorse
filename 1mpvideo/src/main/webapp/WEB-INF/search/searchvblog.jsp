<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>


	<div class="module">
		<div class="title">
			<h2>
				关于${key }的播客   共${pagination.recordSum }项
			</h2>
		</div>
		<div class="reDiv">

			

			<div id="content">


				<table width="90%">
					<c:forEach var="i" begin="0" end="${pagination.size}" step="1">
						<c:if test="${i%5==0}">
							<tr>
						</c:if>
						<c:if test="${not empty pagination.results[i] }">
							<td width="20%">
								<img
									src="<%=application.getAttribute("IMAGE_URL")%>${pagination.results[i].face }" />
								<br />
								<a
									href="<%=request.getContextPath()%>/home/${pagination.results[i].id }/">${pagination.results[i].realName
									}</a>
								<br />
								<c:if test="${pagination.results[i].gender=='m'}">男</c:if>
								<c:if test="${pagination.results[i].gender=='f'}">女</c:if>
								<c:if test="${pagination.results[i].gender=='s'}">保密</c:if>
								&nbsp;&nbsp;
								<c:if test="${not empty pagination.results[i].birthday }">${pagination.results[i].age}岁</c:if>
								<br />
								节目:${pagination.results[i].videoCount}&nbsp;&nbsp;被关注:${pagination.results[i].beSubscribeCount}<br />
								好友:${pagination.results[i].friendCount}&nbsp;&nbsp;积分:${pagination.results[i].score}<br />
							</td>
						</c:if>
						<c:if test="${empty pagination.results[i] }">
							<td width="20%">
								&nbsp;
							</td>
						</c:if>
						<c:if test="${i%5==4}">
							</tr>
						</c:if>
					</c:forEach>
				</table>

				<c:set var="url"
					value="${pageContext.request.contextPath}/search/video"></c:set>
				
					<c:set var="url" value="${url}/addDate"></c:set>
				
				<c:if test="${not empty key  }">
					<c:set var="url" value="${url}/${key }"></c:set>
				</c:if>
				<h:pagination next="${pagination.next}" pre="${pagination.previous}"
					no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>
			</div>
		</div>
	</div>

