<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function delete_video(videoId,videoName){
	if(confirm('确认删除视频'+videoName+'?')){
		document.location.href='${pageContext.request.contextPath}/playbill/modify/video/delete/'+
		${pagination.condition.id }+'/'+videoId+'/';
	}
}
function toPage(){
		var pageindex = document.getElementById("pages").selectedIndex;
		var pageurl = document.getElementById("pages").options[pageindex].value;
		window.location.href=pageurl;
}
</script>
<div class="side">
<div class="module">
<div class="moduleval">
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/modify/${pagination.condition.id }">编辑节目单</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/modify/image/${pagination.condition.id}">更换图片</a></p>
<p class="sideButton"><a >编辑视频</a></p>
</div>
</div>
</div>
<div class="main">
<div class="module">
<div class="title"><h2>编辑视频</h2></div>
<div class="reDiv">

<table width="403" border="0" align="center">
	<tr>
		<th width="253" scope="col">
			视频
		</th>
		<th width="95" scope="col">
			操作
		</th>
	</tr>
	<c:forEach var="video" items="${pagination.results}">
		<tr>
			<td>
				<a href="<%=request.getContextPath()%>/video/${video.id }/">${video.name}</a>
			</td>
			<td>
				<a href="#" onclick="delete_video('${video.id }','${video.name }')">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>

<c:set var="url" value="${pageContext.request.contextPath}/playbill/modify/video/${pagination.condition.id }"></c:set>

<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>


</div>

</div>

</div>
