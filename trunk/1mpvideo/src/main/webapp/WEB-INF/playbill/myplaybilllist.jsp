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
function select_all_playbill(){
	var dailyIds = document.getElementsByName("selectId");
	for(var i=0;i<dailyIds.length;i++){
		dailyIds[i].checked = document.getElementById('select_all').checked;
	}
}
</script>
<div class="side">
<div class="module">
<div class="title"><h2>节目单设置</h2></div>
<div class="moduleval">
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/add">创建节目单</a></p>
<p class="sideButton"><a >节目单列表</a></p>
</div>
</div>
</div>
<div class="main">
<div class="module">
<div class="title"><h2>节目单列表</h2></div>
<div class="reDiv">
<form action="${pageContext.request.contextPath}/deletePlaybill.do"
	method="post">
	<table width="95%" border="0" align="center">
		<tr>
			<th width="2%">
				<input type="checkbox" name="select_all"
					onclick="select_all_playbill()">
			</th>
			<th width="10%">
				<div align="center">标题</div>
			</th>
			<th width="15%">
				<div align="center"><a
					href="${pageContext.request.contextPath}/playbill/myplaybilllist/${sessionUser.id }/addDate/1">创建时间</a>
			</div></th>
			<th width="8%"><div align="center">
				<a
					href="${pageContext.request.contextPath}/playbill/myplaybilllist/${sessionUser.id }/playbillsize/1">视频</a>
			</div></th>
			<th width="8%"><div align="center">
				<a
					href="${pageContext.request.contextPath}/playbill/myplaybilllist/${sessionUser.id }/browseCount/1">播放</a>
			</div></th>
			<th width="8%"><div align="center">
				<a
					href="${pageContext.request.contextPath}/playbill/myplaybilllist/${sessionUser.id }/subscribecount/1">订阅</a>
			</div></th>
			<th width="8%"><div align="center">
				<a
					href="${pageContext.request.contextPath}/playbill/myplaybilllist/${sessionUser.id }/commentCount/1">评论</a>
			</div></th>
			<th width="8%"><div align="center">
				频道
			</div></th>
			<th><div align="center">
				操作
			</div></th>
		</tr>
		<c:if test="${pagination.results==null}">
			<tr>
				<td colspan="8">
					您还有没有节目单，请
					<a href="<%=request.getContextPath()%>/playbill/add">新建节目单</a>！
				</td>
			</tr>
		</c:if>
		<c:forEach items="${pagination.results}" var="playbill" varStatus="i">
			<tr>
				<td><div align="center">
					<input type="checkbox" name="selectId" id="select_id"
						value="${playbill.id }">
				</div></td>
				<td><div align="center">
					${playbill.name }
				</div></td>
				<td><div align="center">
					<fmt:formatDate value="${playbill.addDate }" type="both" />
				</div></td>
				<td><div align="center">
					${playbill.videoSize }
				</div></td>
				<td><div align="center">
					${playbill.browseCount }
				</div></td>
				<td><div align="center">
					${playbill.subscribeCount }
				</div></td>
				<td><div align="center">
					${playbill.commentCount }
				</div></td>
				<td><div align="center">
					${playbill.channel.name }
				</div></td>
				<td>
					<a
						href="${pageContext.request.contextPath}/playbill/modify/${playbill.id }">编辑</a>
					<a
						href="${pageContext.request.contextPath}/playbill/modify/image/${playbill.id }">更新图片</a>
					<c:if test="${playbill.videoSize==0}">
						<span style="color: gray">编辑视频</span>
					</c:if>
					<c:if test="${playbill.videoSize>0}">
						<a
							href="${pageContext.request.contextPath}/playbill/modify/video/${playbill.id }/1/">编辑视频</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="9">
				<input type="submit" name="Submit" value="删除">
			</td>
		</tr>
	</table>


<c:set var="url" value="${pageContext.request.contextPath}/playbill/myplaybilllist/${sessionUser.id }/${pagination.orderFieldName }"></c:set>


	
<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>
	
</form>


</div>

</div>

</div>