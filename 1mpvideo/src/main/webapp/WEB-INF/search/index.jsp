<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
</script>
<div class="third">
	<div class="module">
		<div class="title">
			<h2>看看别人搜什么</h2>
		</div>
		<div class="reDiv">
<table width="90%">
			<c:forEach var="userKeyword" items="${userList}" varStatus="number">
<tr><td>
				<a href="<%=request.getContextPath()%>/search/video/add_date/${userKeyword.name }/1/">${userKeyword.name
					}</a>
			</td></tr>
			</c:forEach>
</table>
		</div>
	</div>
</div>


<div class="third">
	<c:forEach var="searchChannel" items="${searchChannelMap}" varStatus="stat">
<c:if test="${stat.count%2==1}">
	
		<div class="module">
			<div class="title">
				<h2>
					${searchChannel.key.name }
				</h2>
			</div>
			<div class="reDiv">
				<table width="90%">
					<c:forEach var="keyword" items="${searchChannel.value}"
						varStatus="number">
						<tr>
							<td>
								${number.index+1 }
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/search/video/add_date/${keyword.name }/1/">${keyword.name
									}</a>
							</td>
							<td>
								<c:if test="${keyword.change>0 }">
							↑
						</c:if>
								<c:if test="${keyword.change<0 }">
							↓
						</c:if>
								<fmt:formatNumber value="${keyword.change }" type="percent" />
							</td>
							<td>
								${keyword.viewTimes }
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
	</div>
</c:if>
</c:forEach>
</div>

<div class="third">
	<c:forEach var="searchChannel" items="${searchChannelMap}" varStatus="stat">
	<c:if test="${stat.count%2==0}">
		<div class="module">
			<div class="title">
				<h2>
					${searchChannel.key.name }
				</h2>
			</div>
			<div class="reDiv">
				<table width="90%">
					<c:forEach var="keyword" items="${searchChannel.value}"
						varStatus="number">
						<tr>
							<td>
								${number.index+1 }
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/search/video/add_date/${keyword.name }/1/">${keyword.name
									}</a>
							</td>
							<td>
								<c:if test="${keyword.change>0 }">
							↑
						</c:if>
								<c:if test="${keyword.change<0 }">
							↓
						</c:if>
								<fmt:formatNumber value="${keyword.change }" type="percent" />
							</td>
							<td>
								${keyword.viewTimes }
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
	
	</div>
</c:if>
</c:forEach>
</div>


