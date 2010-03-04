<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript">
 	window.onload = function(){
 		getVideoOrder('<%=request.getContextPath()%>/getVideoList.do','addDate','resultVideolist','1');
 		getLikeVideo('<%=request.getContextPath()%>/getMayLikeVideo.do','','resultlikevideo');
 		getBrowseHistoryVideo('<%=request.getContextPath()%>/getMyBrowseHistory.do','','resultbrowsehistory');
 		getMyCommentVideo('<%=request.getContextPath()%>/getMyCommentVideo.do','','resultcommenthistory');
 		getMyVideoList('<%=request.getContextPath()%>/getMyVideoPage.do','','resultmyvideolist');
	}
	
	function getMyCommentVideo(url,pars,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var showResult = function (originalRequest){
			jsonRaw = originalRequest.responseText;
			if (jsonRaw) {
				videoes = eval("(" + jsonRaw + ")");
				var length = videoes.results.length;
				if (length > 5) {
					length = 10;
				} else {
					length = 5;
				}
				var val = "<table width='98%'  >";
				for (i = 0; i < length; i++) {
					if (i % 5 == 0) {
						val = val + "<tr>";
					}
					if (i < videoes.results.length) {
						val = val
								+ "<td valign='top' width='120px'><img width='110' src='<%=application.getAttribute("IMAGE_URL")%>"
								+ videoes.results[i].image
								+ "' /><br />"
								+ "<a href='<%=request.getContextPath()%>/video/"+videoes.results[i].id+"/'>"+videoes.results[i].name + "</a><br />播放："
								+ videoes.results[i].browseCount + "<br />评论："
								+ videoes.results[i].commentCount + "</td>";
					} else {
						val = val + "<td width='20%'>&nbsp;</td>";
					}
					if (i % 5 == 4) {
						val = val + "</tr>";
					}
				}
				val = val + "</table>";
				var click = "getMyCommentVideo('<%=request.getContextPath()%>/getMyCommentVideo.do?pageNo=[no]','','resultcommenthistory')";
				var pa = pagination(videoes.pageSum,videoes.no,videoes.next,videoes.pre,click);
				val +=pa;
				$(resultId).innerHTML = val;
			} else {
				$(resultId).innerHTML = '查无相关记录';
			}
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getBrowseHistoryVideo(url,pars,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var showResult = function (originalRequest){
			jsonRaw = originalRequest.responseText;
			if (jsonRaw) {
				videoes = eval("(" + jsonRaw + ")");
				var length = videoes.results.length;
				if (length > 5) {
					length = 10;
				} else {
					length = 5;
				}
				var val = "<table width='98%'  >";
				for (i = 0; i < length; i++) {
					if (i % 5 == 0) {
						val = val + "<tr>";
					}
					if (i < videoes.results.length) {
						val = val
								+ "<td  valign='top' width='120px'><img width='110' src='<%=application.getAttribute("IMAGE_URL")%>"
								+ videoes.results[i].image
								+ "' /><br />"
								+ "<a href='<%=request.getContextPath()%>/video/"+videoes.results[i].id+"/'>"+videoes.results[i].name + "</a><br />播放："
								+ videoes.results[i].browseCount + "<br />评论："
								+ videoes.results[i].commentCount + "</td>";
					} else {
						val = val + "<td width='20%'>&nbsp;</td>";
					}
					if (i % 5 == 4) {
						val = val + "</tr>";
					}
				}
				val = val + "</table>";
				var click = "getBrowseHistoryVideo('<%=request.getContextPath()%>/getMyBrowseHistory.do?pageNo=[no]','','resultbrowsehistory')";
				var pa = pagination(videoes.pageSum,videoes.no,videoes.next,videoes.pre,click);
				val +=pa;
				$(resultId).innerHTML = val;
			} else {
				$(resultId).innerHTML = '查无相关记录';
			}
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getMyVideoList(url,pars,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var showResult = function (originalRequest) {
			jsonRaw = originalRequest.responseText;
			if (jsonRaw) {
				videoes = eval("(" + jsonRaw + ")");
				var length = videoes.results.length;
				if (length > 5) {
					length = 10;
				} else {
					length = 5;
				}
				var val = "<table width='98%'  >";
				for (i = 0; i < length; i++) {
					if (i % 5 == 0) {
						val = val + "<tr>";
					}
					if (i < videoes.results.length) {
						val = val
								+ "<td valign='top' width='120px'><img width='110' src='<%=application.getAttribute("IMAGE_URL")%>"
								+ videoes.results[i].image
								+ "' /><br />"
								+ "<a href='<%=request.getContextPath()%>/video/"+videoes.results[i].id+"/'>"+videoes.results[i].name + "</a><br />播放："
								+ videoes.results[i].browseCount + "<br />评论："
								+ videoes.results[i].commentCount + "</td>";
					} else {
						val = val + "<td width='20%'>&nbsp;</td>";
					}
					if (i % 5 == 4) {
						val = val + "</tr>";
					}
				}
				val = val + "</table>";
				var click = "getMyVideoList('<%=request.getContextPath()%>/getMyVideoPage.do?pageNo=[no]','','resultmyvideolist')";
				var pa = pagination(videoes.pageSum,videoes.no,videoes.next,videoes.pre,click);
				val +=pa;
				$(resultId).innerHTML = val;
			} else {
				$(resultId).innerHTML = '查无相关记录';
			}
	}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getLikeVideo(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result='<table width="98%" >';
			result+='<tr>';
			for(var i=0;i<jsonResult.length;i++){
				result += '<td class="itable" width="120px" valign="top">'+
				'<img  width=\'110\' src=\''+'<%=application.getAttribute("IMAGE_URL")%>'+jsonResult[i].imageUrl+
				'\' onclick=\'getVideo('+jsonResult[i].video.id+')\'/><br/>'+
				'<a href=\'<%=request.getContextPath()%>/video/'+jsonResult[i].video.id+'/\'>'+jsonResult[i].name+'</a><br/>'+
				'发布者：<a href=\'<%=request.getContextPath()%>/home/'+jsonResult[i].video.user.id+'/\'>'+jsonResult[i].video.user.realName+'</a><br/>'+
				'播放：'+jsonResult[i].video.browseCount+
				'<br/>评论：'+jsonResult[i].video.commentCount+'</td>';
			}	result+='</tr>';
			result +='</table>';
			
			$(resultId).innerHTML = result;		
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getVideoOrder(url,ord,resultId,pageNo){
		$('commend').style.color='#0071BC';
		$('addDate').style.color='#0071BC';
		$('browseCount').style.color='#0071BC';
		$('collectionCount').style.color='#0071BC';
		$('point').style.color='#0071BC';
		$('commentcount').style.color='#0071BC';

		if(ord=='commend'){
			$('commend').style.color='#C92103';
			}
		if(ord=='addDate'){
			$('addDate').style.color='#C92103';

		}
		if(ord=='browseCount'){
			$('browseCount').style.color='#C92103';

		}
		if(ord=='collectionCount'){
			$('collectionCount').style.color='#C92103';

		}
		if(ord=='point'){
			$('point').style.color='#C92103';

		}
		if(ord=='commentcount'){
			$('commentcount').style.color='#C92103';

		}
		
			var pars = 'order='+ord+'&pageNo='+pageNo;
			var showResult = function (originalRequest){
			
				var jsonResult = JSON.parse(originalRequest.responseText);
				var m = Math.ceil(jsonResult.results.length/5);
				var result ='<table width="98%" >';
				for(var j=0;j<m;j++){
					result+='<tr>';
					for(var i=j*5;i<j*5+5;i++){
						if(i<jsonResult.results.length){

							result += '<td class="itable" width="120px" valign="top"><a href="<%=request.getContextPath()%>/video/'+jsonResult.results[i].id+'/"><img width="110" src="<%=application.getAttribute("IMAGE_URL")%>'+jsonResult.results[i].image+'" /><br />'+jsonResult.results[i].name+'</a><br/>'+
							'发布者: <a href="<%=request.getContextPath()%>/home/'+jsonResult.results[i].user.id+'/">'+jsonResult.results[i].user.realName+'</a><br />'+
							'播放: '+jsonResult.results[i].browseCount+'<br />'+
							'评论: '+jsonResult.results[i].commentCount+'</td>';

							}
						else{
						result += '<td class="itable" width="250">&nbsp;</td>';
							}
						}
					result+='</tr>';

					}
				
				
			
			
				result +="</table>";

				var click = 'getVideoOrder(\''+url+'\',\''+ord+'\',\''+resultId+'\',\'[no]\')';
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
				
				$(resultId).innerHTML=result;
	
			}
			var getAjax = new Ajax.Request(url,{
				method:'post',parameters:pars,onComplete:showResult
			});
	}
	function getVideo(videoId){
		alert(videoId);
		
	}
</script>
<div class="module">
	<div class="title">
		<h2>

			<a id="commend" style="TEXT-DECORATION: none"
				href="javascript:getVideoOrder('<%=request.getContextPath()%>/getVideoList.do','commend','resultVideolist','1')">推荐</a>|
			<a id="addDate" style="TEXT-DECORATION: none"
				href="javascript:getVideoOrder('<%=request.getContextPath()%>/getVideoList.do','addDate','resultVideolist','1')">最新发布</a>|
			<a id="browseCount" style="TEXT-DECORATION: none"
				href="javascript:getVideoOrder('<%=request.getContextPath()%>/getVideoList.do','browseCount','resultVideolist','1')">人气最旺</a>|
			<a id="collectionCount" style="TEXT-DECORATION: none"
				href="javascript:getVideoOrder('<%=request.getContextPath()%>/getVideoList.do','collectionCount','resultVideolist','1')">收藏最多</a>|
			<a id="point" style="TEXT-DECORATION: none"
				href="javascript:getVideoOrder('<%=request.getContextPath()%>/getVideoList.do','point','resultVideolist','1')">打分最高</a>|
			<a id="commentcount" style="TEXT-DECORATION: none"
				href="javascript:getVideoOrder('<%=request.getContextPath()%>/getVideoList.do','commentcount','resultVideolist','1')">评论最多</a>

		</h2>
	</div>
	<div class="reDiv" id="resultVideolist">
		<img
			src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div>


<div class="module">
	<div class="title">
		<h2>
			你一定会喜欢的
		</h2>
	</div>

	<div id="resultlikevideo" class="reDiv" align="left">
		<img src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div>
			<c:if test="${sessionUser==null}"></c:if><c:if test="${sessionUser!=null}">
<div class="module">
	<div class="title">
		<h2>
			我看过的
		</h2>
	</div>

	<div id="resultbrowsehistory" class="reDiv" >
		<img
			src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div>

<div class="module">
	<div class="title">
		<h2>
			我评论过的
		</h2>
	</div>

	<div id="resultcommenthistory" class="reDiv">
		<img
			src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div>
<div class="module">
	<div class="title">
	<c:if test="${not empty sessionUser }">
			<span> <a href="<%=request.getContextPath()%>/video/upload">上传视频</a>
				<a
				href="<%=request.getContextPath()%>/video/myvideolist/${sessionUser.id}/addDate/1">编辑列表</a>
			</span>
		</c:if>
		<h2>
			我的视频
		</h2>
	
	</div>
	<div id="resultmyvideolist" class="reDiv" >
		<img
			src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div></c:if>
