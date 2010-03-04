<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
function selectIt(){
	var keyword = document.getElementById('condition').value;
	if(keyword!=''){
		 self.location = "<%=request.getContextPath()%>/groups/topices/"+keyword+"/1";
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/topices/1";

		}
}

function nextPage(){
	var keyword='${keyword}';
	if(keyword!=''){
		 self.location = "<%=request.getContextPath()%>/groups/topices/"+keyword+"/${pagination.no+1}";
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/topices/${pagination.no+1}";
		}
}
function prePage(){
	var keyword='${keyword}';
	if(keyword!=''){
		 self.location = "<%=request.getContextPath()%>/groups/topices/"+keyword+"/${pagination.no-1}";
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/topices/${pagination.no-1}";
		}
}
function toPage(){
	var obj=document.getElementById('pages');
	var keyword='${keyword}';
	var index=obj.selectedIndex; 
	var val = obj.options[index].value;
	if(keyword!=''){
		 self.location = "<%=request.getContextPath()%>/groups/topices/"+keyword+"/"+val;
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/topices/"+val;
		}
}
</script>

<div class="side">
<div class="module">
<div class="title"><h2>继续搜索</h2></div>
<div class="reDiv">
		<input class="color" type="text" value="${keyword }" id="condition" name="condition" size="10"/>&nbsp;  
<button class="sou" onclick="selectIt();">&nbsp;</button>
</div>
</div>
</div>
<div class="main">
<DIV class="module">
	<DIV class=title>
		<h2>
			搜索"${keyword }"相关话题
		</h2>
	</DIV>
	<DIV class="reDiv">
		<table width="580px">
			<tr class='name'>
				<td width="350px">
					<div >
						话题
					</div>
				</td>
				<td width="50px">
					<div >
						回复
					</div>
				</td>
				<td width="50px">
					<div >
						点击
					</div>
				</td>
				<td width="80px">
					<div >
						组名称
					</div>
				</td>
				<td width="80px">
					<div >
						发布人
					</div>
				</td>
				<td width="80px">
					<div >
						时间
					</div>
				</td>
				<td>
					<div ></div>
				</td>
			</tr>
			<c:forEach items="${pagination.results}" var="topic">
				<tr>
					<td>
						<div >
							<a href="<%=request.getContextPath()%>/group/topic/${topic.id}/">${topic.title}</a>
						</div>
					</td>
					<td>
						<div >
							${topic.commentCount }
						</div>
					</td>
					<td>
						<div >
							${topic.browseCount }
						</div>
					</td>
					<td>
						<div >
							<a
					href="<%=request.getContextPath()%>/group/${topic.group.id }/">${topic.group.name }</a>
						</div>
					</td>
					<td>
						<div >
							<a href="<%=request.getContextPath()%>/home/${topic.user.id }/">${topic.user.realName }</a>
						</div>
					</td>

					<td>
						<div >
							<fmt:formatDate value="${topic.addDate}" type="date" />
						</div>
					</td>
					<c:if test="${group.owner.id==sessionUser.id}">
						<td>
							<div >
								
							</div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
<c:if test="${empty keyword }">
<c:set var="url" value="${pageContext.request.contextPath}/groups/topices"></c:set>
</c:if>
<c:if test="${not empty keyword }">
<c:set var="url" value="${pageContext.request.contextPath}/groups/topices/${keyword }"></c:set>
</c:if>
		<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url}"></h:pagination>
	</DIV>
</DIV>



</div>

