<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	 window.onload = function()
 	{
  		getContentTag('<%=request.getContextPath()%>/getNewVideoTag.do','','resultnewvideotag');
 	 	getContentTag('<%=request.getContextPath()%>/getHotVideoTag.do','','resulthotvideotag');
	  	getContentTag('<%=request.getContextPath()%>/getMyVideoTag.do','','resultmyvideotag');
	  	getContentVideo('<%=request.getContextPath()%>/getMayLikeVideo.do','','resultlikevideo');
	  	getContentTag('<%=request.getContextPath()%>/getLikeVideoTag.do','','resultinterestvideotag');
	  	getContentUser('<%=request.getContextPath()%>/getTagStrongUser.do','','resultstronguserwithvideotag');
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
			
			if(jsonResult.length>1){
				for(var i=0;i<jsonResult.length;i++){
					result += '<a href=\'<%=request.getContextPath()%>/tag/video/add_date/'+jsonResult[i].id+'/'+jsonResult[i].name+'/1/\'>'+jsonResult[i].name+'</a>&nbsp;&nbsp;';
					if(i%10==9){
						result = result+'<br />';
						}
				}
			}
			if(jsonResult.length<=1){
				result='您还没有创建任何标签！';
			}
			$(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getContentUser(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result='<table width="90%">';
			for(var i=0;i<jsonResult.length;i++){
				result += '<tr><td rowspan="2"><div align="left"><img width="60" src=\''+
				'<%=application.getAttribute("IMAGE_URL")%>'+jsonResult[i].user.face+'\'/></div></td>'+
				'<td><div align="left"><a href=\'<%=request.getContextPath()%>/home/'+jsonResult[i].user.id+'/\'>'+
				jsonResult[i].user.realName+'</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href=\'<%=request.getContextPath()%>/home/'+
				jsonResult[i].user.id+'/\'>TA的博客</a></div></td></tr><tr><td><div align="left">添加标签：'+
				jsonResult[i].countTag+'</div></td></tr>';
			
			}
			result += '</table>';
			$(resultId).innerHTML = result;		
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getContentVideo(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result='';
			for(var i=0;i<jsonResult.length;i++){
				result += '<div id=\'resultlikevideo'+i+'\'>'+
				'<img src=\''+'<%=application.getAttribute("IMAGE_URL")%>'+jsonResult[i].imageUrl+'\'/><br/>'+
				'<a href=\'<%=request.getContextPath()%>/video/'+jsonResult[i].video.id+'/\'>'+jsonResult[i].name+'</a><br/>'+
				'发布者：<a href=\'<%=request.getContextPath()%>/home/'+jsonResult[i].video.user.id+'/\'>'+jsonResult[i].video.user.realName+'</a><br/>'+
				'播放：'+jsonResult[i].video.browseCount+
				'<br/>评论：'+jsonResult[i].video.commentCount+'</div>';
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
				关于标签
			</h2>
		</div>

		<div id="" class="reDiv">
			<a href="">小编有话说</a>
			<br />
			<a href="">【视频】怎么编辑标签</a>
			<br />
			<a href="">什么是标签 </a>
			<br />
			<a href="">你想知道什么是标签 </a>
			<br />
			<a href="">翻阅标签编辑指南</a>
			<br />
			<a href="">什么是巡查员? </a>
			<br />
			<a href="">（如何加入）</a>
			<br />
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				您会感兴趣的标签
			</h2>
		</div>

		<div id="resultinterestvideotag" class="reDiv">
			<img src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				标签强人
			</h2>
		</div>

		<div id="resultstronguserwithvideotag" class="reDiv">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>
</div>

<div class="main">

	<div class="module">
		<div class="title">
			<h2>
				最新标签
			</h2>
		</div>

		<div id="resultnewvideotag" class="reDiv">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				最热标签
			</h2>
		</div>

		<div id="resulthotvideotag" class="reDiv">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>
<c:if test="${sessionUser==null}"></c:if><c:if test="${sessionUser!=null}">

	<div class="module">
		<div class="title">
			<h2>
				我的标签
			</h2>
		</div>

		<div id="resultmyvideotag" class="reDiv">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div></c:if>
	<div class="module">
		<div class="title">
			<h2>
				你一定会喜欢的
			</h2>
		</div>
		<div id="resultlikevideo" class="reDiv">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>
</div>