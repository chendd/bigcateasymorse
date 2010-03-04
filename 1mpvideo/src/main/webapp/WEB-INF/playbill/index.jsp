<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">


	 window.onload = function()
 	{
  		getContentBill('<%=request.getContextPath()%>/getNonsuchPlaybill.do','','resultnonsuchplaybill');
  		getContentMySubscribeBill('<%=request.getContextPath()%>/getMySubscribePlaybill.do','','resultmysubscribeplaybill');
  		getContentMyBill('<%=request.getContextPath()%>/getMyPlaybillAjax.do','','resultmyplaybill');
	 }
 
	function getContentBill(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var m = Math.ceil(jsonResult.length/5);
			var result='<table width="90%">';
			for(var j =0;j<m;j++){
				result += '<tr>';
				for(var i=j*5;i<j*5+5;i++){
				if(i<jsonResult.length){
					result+='<td  class="itable" width="20%"><img src=\''+'<%=application.getAttribute("IMAGE_URL")%>'+jsonResult[i].image+
					'\' onclick=\'getPlaybill('+jsonResult[i].playbill.id+')\'/><br/>'+
					'<a href=\'<%=request.getContextPath()%>/nosuchPlaybill/'+jsonResult[i].id+'/'+jsonResult[i].playbill.id+'/addDate/\'>'+jsonResult[i].name+'</a><br/>'+
					'单主：<a href=\'<%=request.getContextPath()%>/home/'+jsonResult[i].playbill.user.id+'/\'>'+jsonResult[i].playbill.user.realName+'</a><br/>'+
					'视频数:'+jsonResult[i].playbill.videoSize+'<br/>'+
					'浏览次数:'+jsonResult[i].browseCount+'<br/>'+
					'<a href=\'<%=request.getContextPath()%>/playbill/'+jsonResult[i].playbill.id+'/play/\'>直接播放</a></td>';
					}
				else{
					result+='<td width="20%">&nbsp;</td>';
					}
					}
				result += '</tr>';

				}
		
			
			$(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getContentMySubscribeBill(url,pars,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText).results;
			var result='';
			if(jsonResult!=''){
				var m = Math.ceil(jsonResult.length/5);
				result='<table width="90%">';
				for(var i=0;i<m;i++){
					result +='<tr>';
					for(var j=5*i;j<5*i+5;j++){
						if(j<jsonResult.length){
							result +='<td  class="itable" width="20%"><img src=\''+'<%=application.getAttribute("IMAGE_URL")%>'+jsonResult[j].imagesUrl+'\' onclick=\'getPlaybill('+jsonResult[j].id+')\'/><br/>'+
							'<a href=\'<%=request.getContextPath()%>/playbill/'+jsonResult[j].id+'/addDate/\'>'+jsonResult[j].name+'</a><br/>'+
							'单主：<a href=\'<%=request.getContextPath()%>/home/'+jsonResult[j].user.id+'/\'>'+jsonResult[j].user.realName+'</a><br/>'+
							'视频数:'+jsonResult[j].videoSize+'<br/>'+
							'浏览次数:'+jsonResult[j].browseCount+'<br/>'+
							'<a href=\'<%=request.getContextPath()%>/playbill/'+jsonResult[j].id+'/play/\'>直接播放</a></td>';
							}else{
								result +='<td width="20%">&nbsp;</td>';
							}
					}
					result +='</tr>';
				}
			}
			if(result.length==0){
				result='您还没有订阅任何节目单！';
			}
			$(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getContentMyBill(url,pars,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText).results;
			var result='';
			if(jsonResult!=''){
				for(var i=0;i<jsonResult.length;i++){
					result += '<div id=\'resultlikevideo'+i+'\'>'+
					'<span class="itable"><img src=\''+'<%=application.getAttribute("IMAGE_URL")%>'+jsonResult[i].imagesUrl+
					'\' onclick=\'getPlaybill('+jsonResult[i].id+')\'/><br/>'+
					'<a href=\'<%=request.getContextPath()%>/playbill/'+jsonResult[i].id+'/addDate/\'>'+jsonResult[i].name+'</a><br/>'+
					'视频数:'+jsonResult[i].videoSize+'<br/>'+
					'浏览次数:'+jsonResult[i].browseCount+'<br/>'+
					'<a href=\'<%=request.getContextPath()%>/playbill/'+jsonResult[i].id+'/play/\'>直接播放</a></span></div>';
				}
			}
			if(result.length==0){
				result='您还没有创建任何节目单！';
			}
			$(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
			
	function getPlaybill(playbillId){
		alert(playbillId);
	}
	
	function getUser(userId){
		alert(userId);
	}
	
	function getPlaybillOrder(orders){
		window.document.getElementById('orderBy').value=orders;
		window.document.forms[0].submit();
	}
	
	function toPage(){
		var pageindex = document.getElementById("pages").selectedIndex;
		var pageurl = document.getElementById("pages").options[pageindex].value;
		window.location.href=pageurl;
	}
</script>

<div class="module">
	<div class="title">
		<h2>
			精品节目单
		</h2>
	</div>
	<div id="resultnonsuchplaybill" class="resultdiv">
		<img
			src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div>
<c:if test="${sessionUser==null}"></c:if><c:if test="${sessionUser!=null}">
<div class="module">
	<div class="title">
		<h2>
			我订阅的节目单
		</h2>
	</div>
	<div id="resultmysubscribeplaybill">
		<img
			src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div>
</c:if>
<form id="playbillorder" name="playbill" method="post"
	action="<%=request.getContextPath()%>/playbill/index/">
	<input type="hidden" id="orderBy" name="orderBy" value="addDate" />
	<input type="hidden" id="no" name="no" value="1" />
	<div class="module">
		<div class="title">
			<h2>

				<a
					<c:if test="${orderBy=='addDate'}">style="TEXT-DECORATION: none;color:#C92103"</c:if>
					<c:if test="${orderBy!='addDate'}">style="TEXT-DECORATION: none"</c:if>
					href="javascript:getPlaybillOrder('addDate')">最新发布</a>|
				<a
					<c:if test="${orderBy=='browseCount'}">style="TEXT-DECORATION: none;color:#C92103"</c:if>
					<c:if test="${orderBy!='browseCount'}">style="TEXT-DECORATION: none"</c:if>
					href="javascript:getPlaybillOrder('browseCount')">人气最旺的</a>|
				<a
					<c:if test="${orderBy=='subscribe'}">style="TEXT-DECORATION: none;color:#C92103"</c:if>
<c:if test="${orderBy!='subscribe'}">style="TEXT-DECORATION: none"</c:if>
					href="javascript:getPlaybillOrder('subscribe')">订阅最多的</a>|
				<a
					<c:if test="${orderBy=='comments'}">style="TEXT-DECORATION: none;color:#C92103"</c:if>
<c:if test="${orderBy!='comments'}">style="TEXT-DECORATION: none"</c:if>
					href="javascript:getPlaybillOrder('comments')">评论最多的</a>
			</h2>
		</div>
		<div id="resultplaybilllist" class="resultdiv">
			<table width="90%">
				<tr>
					<c:forEach begin="0" end="4" var="i" step="1">
						<c:if test="${not empty pagination.results[i] }">
							<td width="20%" class="itable">
								<img
									src="<%=application.getAttribute("IMAGE_URL")%>${pagination.results[i].imagesUrl }" />
								<br />
								<a
									href="<%=request.getContextPath()%>/playbill/${pagination.results[i].id }/addDate/">${pagination.results[i].name
									}</a>
								<br />
								单主:
								<a
									href="<%=request.getContextPath()%>/home/${pagination.results[i].user.id }/">${pagination.results[i].user.realName
									}</a>
								<br />
								视频数:${pagination.results[i].videoSize }
								<br />
								浏览次数:${pagination.results[i].browseCount }
								<br />
								<a
									href='<%=request.getContextPath()%>/playbill/${pagination.results[i].id }/play/'>直接播放</a>
							</td>

						</c:if>
						<c:if test="${empty pagination.results[i] }">
							<td width="20%">&nbsp;
								
							</td>
						</c:if>
					</c:forEach>
				</tr>
			</table>


		</div>
		<c:set var="url"
			value="${pageContext.request.contextPath}/playbill/index/${orderBy }"></c:set>



		<h:pagination next="${pagination.next}" pre="${pagination.previous}"
			no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>

	</div>

</form>
<c:if test="${sessionUser==null}"></c:if><c:if test="${sessionUser!=null}">

<div class="module">
	<div class="title">
		<c:if test="${ empty sessionUser }">
			<span><a href="<%=request.getContextPath()%>/playbill/add">${sessionUser }新建节目单</a>
				<a
				href="<%=request.getContextPath()%>/playbill/myplaybilllist/${sessionUser.id}/addDate/1">编辑列表</a>
			</span>
		</c:if>

		<h2>
			我的节目单
		</h2>
	</div>
	<div>

	</div>
	<div id="resultmyplaybill" class="resultdiv">
		<img
			src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
	</div>
</div></c:if>