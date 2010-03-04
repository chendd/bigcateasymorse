<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function getMyPlaybill(){
	$('myplaybilllist').style.display='';
	$('newplaybills').style.display='none';
	$('action').value='add';
}
function newPlaybill(){
	$('myplaybilllist').style.display='none';
	$('newplaybills').style.display='';
	$('action').value='new';
}
function toPage(){
		var pageindex = document.getElementById("pages").selectedIndex;
		var pageurl = document.getElementById("pages").options[pageindex].value;
		window.location.href=pageurl;
	}
</script>
<div id="myplaybill" onclick="getMyPlaybill()">
	【我的节目单】
</div>
<div id="newplaybill" onclick="newPlaybill()">
	【新建节目单】
</div>
<form action="<%=request.getContextPath()%>/addVideoToPlaybill.do">
	<input type="hidden" name="videoId" value="${videoId }" />
	<input type="hidden" name="action" id="action" value="add" />
	<div id="myplaybilllist">
		<c:if test="${pagination.size==0}">
		您还有没有节目单，请新建节目单！
		</c:if>
		<c:if test="${pagination.size>0}">
			<c:forEach items="${pagination.results}" var="playbill" varStatus="i">
				<div id="playbill${i.index }">
					<input type="radio" name="playbillId" value="${playbill.id }"
						checked="checked" />
					${playbill.name}
				</div>
			</c:forEach>
			<c:if test="${pagination.pageSum>1}">
				<div id="pagefooter" align="center">
					<a href="<%=request.getContextPath()%>/playbill/my/1/addvideo/${videoId }/">首页</a>
					<c:if test="${pagination.previous}">
						<a href="<%=request.getContextPath()%>/playbill/my/${pagination.no-1}/addvideo/${videoId }/">上一页</a>
					</c:if>
					<c:if test="${!pagination.previous}">上一页
			</c:if>
					<c:if test="${pagination.next}">
						<a href="<%=request.getContextPath()%>/playbill/my/${pagination.no+1}/addvideo/${videoId }/">下一页</a>
					</c:if>
					<c:if test="${!pagination.next}">下一页</c:if>
					<a href="<%=request.getContextPath()%>/playbill/my/${pagination.pageSum}/addvideo/${videoId }/">尾页</a>
					页次：${pagination.no}/${pagination.pageSum}页 ${pagination.size}个节目单/页
					转到
					<select onchange="toPage()" id="pages">
						<c:forEach begin="1" end="${pagination.pageSum}" var="i">
							<c:if test="${pagination.no==i}">
								<c:set var="selects" value="selected" />
							</c:if>
							<c:if test="${pagination.no!=i}">
								<c:set var="selects" value="" />
							</c:if>
							<option
								${selects }
					value="<%=request.getContextPath()%>/playbill/my/${i }/addvideo/${videoId }/">
								${i }
							</option>
						</c:forEach>
					</select>
				</div>
			</c:if>
			<input type="submit" value="加入节目单" />
		</c:if>
	</div>
	<div id="newplaybills" style="display: none;">
		节目单名称：
		<input type="text" name="playbillName" />
		类别:
		<select name="channelId">
			<c:forEach var="channel" items="${playbillChannels}">
				<option value="${channel.id }">
					${channel.name }
				</option>
			</c:forEach>
		</select>
		<input type="submit" value="加入节目单" />
	</div>
</form>