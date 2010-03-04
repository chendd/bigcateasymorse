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
		 self.location = "<%=request.getContextPath()%>/groups/"+keyword+"/1";
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/1";

		}
	
	
}


function nextPage(){
	var keyword='${keyword}';
	if(keyword!=''){
		 self.location = "<%=request.getContextPath()%>/groups/"+keyword+"/${pagination.no+1}";
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/${pagination.no+1}";

		}
	
}
function prePage(){
	var keyword='${keyword}';
	if(keyword!=''){
		 self.location = "<%=request.getContextPath()%>/groups/"+keyword+"/${pagination.no-1}";
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/${pagination.no-1}";

		}
}
function toPage(){
	var obj=document.getElementById('pages');
	var keyword='${keyword}';
	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	if(keyword!=''){
		 self.location = "<%=request.getContextPath()%>/groups/"+keyword+"/"+val;
		}
	else{
		self.location = "<%=request.getContextPath()%>/groups/"+val;

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
			搜索"${keyword }"的小组
		</h2>
	</DIV>


	<DIV class="reDiv">
		<table width="90%">
		<c:forEach  items="${pagination.results}" var="group">
		<tr>
		<td ><img src="<%= application.getAttribute("IMAGE_URL")%>${group.image}"/></td>
		<td>

	<c:set var="replay" value="<font size='3px'   color='yellow'>${keyword }</font>"/>
		<a href="<%=request.getContextPath()%>/group/${group.id }/">${fn:replace(group.name,keyword,replay)}</a><br />
		<p>${fn:replace(group.descrption,keyword,replay)}</p>
		圈主:<a href="<%=request.getContextPath()%>/home/${group.owner.id }/">${group.owner.realName}</a>&nbsp;
		小组类型:<c:if test="${group.auditType==0}">公开</c:if><c:if test="${group.auditType==1}">私有</c:if>&nbsp;
		创建时间:<fmt:formatDate value="${group.addDate}" type="both"/>&nbsp;
		成员:${group.memberCount }
		</td>
		</tr>
		</c:forEach>
		
		</table>
<c:if test="${empty keyword }">
<c:set var="url" value="${pageContext.request.contextPath}/groups"></c:set>
</c:if>
<c:if test="${not empty keyword }">
<c:set var="url" value="${pageContext.request.contextPath}/groups/${keyword }"></c:set>
</c:if>
	
<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>
	</DIV>
</DIV>



</div>
