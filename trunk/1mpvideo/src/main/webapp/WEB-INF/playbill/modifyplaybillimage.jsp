<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">


function checkit(){

	var urls = document.getElementsByName('image');
	for(var i =0;i<urls.length;i++){
		if(urls[i].checked){
			return true;
			}
		
		}
	return false;
}
</script>
<div class="side">
<div class="module">
<div class="moduleval">
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/modify/${playbill.id }">编辑节目单</a></p>
<p class="sideButton"><a >更换图片</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/modify/video/${playbill.id }/1/">编辑视频</a></p>
</div>
</div>
</div>
<div class="main">
<div class="module">
<div class="title"><h2>更换图片</h2></div>
<div class="reDiv">

<form name="picForm" id="picForm"
	action="${pageContext.request.contextPath}/modifyPlaybillImage.do"
	method="post" onsubmit="return checkit();" >
<table width="98%" >
	<c:forEach begin="1" end="${size}" step="1" var="i" >
	<c:if test="${i%5==1}"><tr></c:if>
	<c:if test="${not empty videoes[i-1] }">
	<td width="20%"><img width="80" src="${IMAGE_URL }${videoes[i-1].image}"/><br />
<input type="radio" name="image" value="${videoes[i-1].image}"  
<c:if test="${playbill.imagesUrl==videoes[i-1].image }">checked="checked"</c:if>
 />
</td>
	</c:if>
<c:if test="${empty videoes[i-1] }">
<td width="20%">&nbsp;</td>
</c:if>
    <c:if test="${i%5==0}"></tr></c:if>
	</c:forEach>
</table>
<input type="hidden" name="id" value="${playbill.id }"/>
	<input type="submit" name="Submit" value="修改"  
<c:if test="${empty videoes[0] }">disabled="disabled"</c:if>
>
</form>
</div>

</div>

</div>
