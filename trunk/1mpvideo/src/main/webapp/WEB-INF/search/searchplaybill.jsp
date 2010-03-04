<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>

	<div class="module">
		<div class="title">
			<h2>
				关于${key }的节目单    共${pagination.recordSum }项
			</h2>
		</div>
		<div class="reDiv">
			<div id="orderterm">
				<label style="color: #C92103;">
					排列方式:
				</label>
				<a
					<c:if test="${pagination.orderFieldName=='addDate'}">style="color: #C92103;TEXT-DECORATION: none"</c:if>
					href="<%=request.getContextPath()%>/search/playbill/addDate/<c:if test="${not(empty key) }" >${key }/1/</c:if>">上传时间</a>
				<a
					<c:if test="${pagination.orderFieldName=='browseCount'}">style="color: #C92103;TEXT-DECORATION: none"</c:if>
					href="<%=request.getContextPath()%>/search/playbill/browseCount/<c:if test="${not(empty key) }" >${key }/1/</c:if>">播放次数</a>
				<a
					<c:if test="${pagination.orderFieldName=='commentCount'}">style="color: #C92103;TEXT-DECORATION: none"</c:if>
					href="<%=request.getContextPath()%>/search/playbill/commentCount/<c:if test="${not(empty key) }" >${key }/1/</c:if>">评论次数</a>
				<a
					<c:if test="${pagination.orderFieldName=='subscribecount'}">style="color: #C92103;TEXT-DECORATION: none"</c:if>
					href="<%=request.getContextPath()%>/search/playbill/subscribecount/<c:if test="${not(empty key) }" >${key }/1/</c:if>">收藏次数</a>
			</div>
			<div id="content">
				<table width="90%">
					<c:forEach var="i" begin="0" end="${pagination.size}" step="1">
						<c:if test="${i%5==0}">
							<tr>
						</c:if>
						<c:if test="${not(empty(pagination.results[i]))}">
							<td width="20%">
								<img
									src="<%=application.getAttribute("IMAGE_URL")%>${pagination.results[i].imagesUrl }" />
								<br />
								<a
									href="<%=request.getContextPath()%>/playbill/${pagination.results[i].id }/">${pagination.results[i].name
									}</a>
								<br />
								发布者${length }:
								<a
									href="<%=request.getContextPath()%>/home/${pagination.results[i].user.id }/">${pagination.results[i].user.realName
									}</a>
								<br />
								播放:${pagination.results[i].browseCount }
								<br />
								评论:${pagination.results[i].commentCount }
							</td>
						</c:if>
						<c:if test="${empty(pagination.results[i])}">
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
					value="${pageContext.request.contextPath}/search/playbill"></c:set>
				<c:if test="${not(empty pagination.orderFieldName) }">
					<c:set var="url" value="${url}/${pagination.orderFieldName }"></c:set>
				</c:if>
				<c:if test="${not(empty key) }">
					<c:set var="url" value="${url}/${key }"></c:set>
				</c:if>
				<h:pagination next="${pagination.next}" pre="${pagination.previous}"
					no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>
			</div>
		</div>
	</div>
