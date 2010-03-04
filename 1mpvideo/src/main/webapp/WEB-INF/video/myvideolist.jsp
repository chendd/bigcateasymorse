<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">

function toPage(){
		var pageindex = document.getElementById("pages").selectedIndex;
		var pageurl = document.getElementById("pages").options[pageindex].value;
		window.location.href=pageurl;
	}
function select_all_video(){
	var dailyIds = document.getElementsByName("selectId");
	for(var i=0;i<dailyIds.length;i++){
		dailyIds[i].checked = document.getElementById('select_all').checked;
	}
}
</script>
<div class="side">
	<div class="module">
		<div class="title">
			<h2>
				视频设置
			</h2>
		</div>
		<div class="moduleval">
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/video/upload">上传视频</a>
			</p>
			<p class="sideButton">
				<a
					href="<%=request.getContextPath()%>/video/myvideolist/${sessionUser.id}/addDate/1">视频列表</a>
			</p>
		</div>
	</div>
</div>
<div class="main">
	<div class="module">
		<div class="title">
			<h2>
				视频列表
			</h2>
		</div>
		<div class="reDiv">
			<form action="${pageContext.request.contextPath}/deleteMyVideo.do"
				method="post">
				<table width="95%" border="0" align="center">
					<tr>
						<th>
							<input type="checkbox" name="select_all"
								onclick="select_all_video()">
						</th>
						<th>
							名字
						</th>
						<th>
							<a
								href="${pageContext.request.contextPath}/video/myvideolist/${sessionUser.id }/addDate/1">创建时间</a>
						</th>
						<th>
							<a
								href="${pageContext.request.contextPath}/video/myvideolist/${sessionUser.id }/browseCount/1">播放</a>
						</th>
						<th>
							<a
								href="${pageContext.request.contextPath}/video/myvideolist/${sessionUser.id }/pushCount/1">顶</a>
						</th>
						<th>
							看
						</th>
						<th>
							频道
						</th>
						<th>
							操作
						</th>
					</tr>
					<c:if test="${pagination.results==null}">
						<tr>
							<td colspan="8">
								您还有没有视频，请
								<a href="<%=request.getContextPath()%>/video/upload">上传视频</a>！
							</td>
						</tr>
					</c:if>
					<c:forEach items="${pagination.results}" var="video" varStatus="i">
						<tr>
							<td>
								<input type="checkbox" name="selectId" id="select_id"
									value="${video.id }">
							</td>
							<td>
								${video.name }
							</td>
							<td>
								<fmt:formatDate value="${video.addDate }" type="both" />
							</td>
							<td>
								${video.browseCount }
							</td>
							<td>
								${video.pushCount }
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/video/${video.id }/">看看</a>
							</td>
							<td>
								${video.channel.name }
							</td>
							<td>
								<a
									href="${pageContext.request.contextPath}/video/modify/${video.id }">编辑</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="8">
							<input type="submit" name="Submit" value="删除">
						</td>
					</tr>
				</table>
				<c:set var="url"
					value="${pageContext.request.contextPath}/video/myvideolist/${sessionUser.id }/${pagination.orderFieldName }"></c:set>
				<h:pagination next="${pagination.next}" pre="${pagination.previous}"
					no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>
			</form>
		</div>
	</div>
</div>