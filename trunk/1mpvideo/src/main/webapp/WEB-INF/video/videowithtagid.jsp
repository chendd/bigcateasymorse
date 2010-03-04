<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<script type="text/javascript">
	function toPage(){
		var pageindex = document.getElementById("pages").selectedIndex;
		var pageurl = document.getElementById("pages").options[pageindex].value;
		window.location.href=pageurl;
	}

	function getContentTag(url,pars,resultId){
		if(url=='<%=request.getContextPath()%>/getMyVideoTag.do'){
			var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
			if(flag!='ok'){
				$(resultId).innerHTML = flag;
				return ;
			}
		}
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result='';
			for(var i=0;i<jsonResult.length;i++){
				result += '<a href=\'<%=request.getContextPath()%>/tag/video/add_date/'+jsonResult[i].id+'/'+jsonResult[i].name+'/1/\'>'+jsonResult[i].name+'</a>&nbsp;&nbsp;';
				if(i%5==4){
					result = result+'<br />';
					}
			}
			$(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	function searchTag(){
		var searchkey = ${'searchVideoTagKey'}.value;
		window.location.href='<%=request.getContextPath()%>/search/video/add_date/'+searchkey+'/1/';
	}
</script>

<div class="side">
<div class="module">
		<div class="title">
			<h2>
				标签搜索
			</h2>
		</div>
		<div class="reDiv">
			<input type="text" name="searchVideoTagKey" id="searchVideoTagKey" />
			<input type="button" value="搜索" onclick="searchTag()" />
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				您会感兴趣的标签
			</h2>
		</div>

		<div id="resultinterestvideotag" class="reDiv">
			<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
<script type="text/javascript">	getContentTag('<%=request.getContextPath()%>/getLikeVideoTag.do','','resultinterestvideotag');</script>
		</div>
	</div>

</div>

<div class="main">
<div class="module">
<div class="title"><h2>关于“${name }”的视频</h2></div>
<div class="reDiv">


	<label style="color: #C92103">排列方式:</label>
	<a <c:if test="${orderBy=='add_date'}">style="color: #C92103;TEXT-DECORATION: none"</c:if> 
		href="<%=request.getContextPath()%>/tag/video/add_date/
		<c:if test="${not empty id  }">${id }/</c:if>
		<c:if test="${not empty name  }" >${name }/</c:if>1/">上传时间</a>
	<a <c:if test="${orderBy=='browse_count'}">style="color: #C92103;TEXT-DECORATION: none"</c:if> 
		href="<%=request.getContextPath()%>/tag/video/browse_count/<c:if test="${not empty id  }">${id }/</c:if>
				<c:if test="${not empty name  }" >${name }/</c:if>1/">播放次数</a>
	<a <c:if test="${orderBy=='commentcount'}">style="color: #C92103;TEXT-DECORATION: none"</c:if> 
		href="<%=request.getContextPath()%>/tag/video/commentcount/<c:if test="${not empty id   }">${id }/</c:if>
				<c:if test="${not empty name  }" >${name }/</c:if>1/">评论次数</a>
	<a <c:if test="${orderBy=='collectionCount'}">style="color: #C92103;TEXT-DECORATION: none"</c:if> 
		href="<%=request.getContextPath()%>/tag/video/collectionCount/<c:if test="${not empty id  }">${id }/</c:if>
				<c:if test="${not empty name  }" >${name }/</c:if>1/">收藏次数</a>


<div id="content">

	<table width="98%">
<c:forEach var="i" begin="0" end="9" step="1">
<c:if test="${i%5==0}"><tr></c:if>
<c:if test="${not  empty pagination.results[i] }"><td width="130px">
<img width="110px" src="<%= application.getAttribute("IMAGE_URL")%>${pagination.results[i].image }" />
<br /><a href="<%=request.getContextPath()%>/video/${pagination.results[i].id }/">${pagination.results[i].name
				}</a>
			<br />
			发布者${length }:
			<a href="<%=request.getContextPath()%>/home/${pagination.results[i].user.id }/">${pagination.results[i].user.realName
				}</a>
			<br />
			播放:${pagination.results[i].browseCount }
			<br />
			评论:${pagination.results[i].commentCount }
</td></c:if>
<c:if test="${empty pagination.results[i] }"><td width="20%"></td></c:if>
<c:if test="${i%5==4}"></tr></c:if>
</c:forEach>
</table>

<c:set var="url" value="${pageContext.request.contextPath}/tag/video"></c:set>
<c:if test="${not empty orderBy  }">
<c:set var="url" value="${url}/${orderBy }"></c:set>
</c:if>
<c:if test="${not empty id  }">
<c:set var="url" value="${url}/${id }"></c:set>
</c:if>
<c:if test="${not empty name  }">
<c:set var="url" value="${url}/${name }"></c:set>
</c:if>


	
<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>

	
</div>


</div>

</div>
</div>