<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@page import="com.video.domain.Playbill"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
	rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/friend.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript">
	window.onload = function(){
	 	getPlaybillComment('<%=request.getContextPath()%>/getPlaybillCommentList.do','commentlist','<%=request.getAttribute("playbillId")%>',1);
	 
		getOtherPlaybill('<%=request.getContextPath()%>/getOtherPlaybill.do','id=<%=((Playbill) request.getAttribute("playbill")).getUser()
							.getId()%>&noExistId=<%=((Playbill) request.getAttribute("playbill")).getId()%>','1','otherplaybill');
		getNewPlaybill('<%=request.getContextPath()%>/getNewPlaybill.do','','newplaybillresult');
		getUserLike('<%=request.getContextPath()%>/getMayLikeVideo.do','','otherlikeresult');
	}
	function sendMessage(toUserId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var x=(window.screen.width-510)/2;
		var y=(window.screen.height-300)/2;
		//window.showModalDialog('sendmessage.jsp?toUserId='+toUserId+'&sendUserId='+sendUserId,"","dialogHeight:500px; dialogWidth:600px; location:no; status:no; help:no; scroll:no");
		window.open('<%=request.getContextPath()%>/sendmessage.jsp?toUserId='+toUserId, 'newwindow', 'height=300, width=510, top='+y+', left='+x+', toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no') 
	}
	
	function getUserLike(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result='';
			for(var i=0;i<jsonResult.length;i++){
				result += '<div  style=\'width:120px\' id=\'resultlikevideo'+i+'\'>'+
				'<img width=\'110px\' src=\''+'<%= application.getAttribute("IMAGE_URL")%>'+jsonResult[i].imageUrl+
				'\' onclick=\'getVideo('+jsonResult[i].video.id+')\'/><br/>'+
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
	function getPlaybillComment(url,resultId,playbillId,no){
		var pars = 'playbillId='+playbillId+'&pageNo='+no;
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result ='<table width="100%">';
			for(var i =0;i<jsonResult.results.length;i++){
			result+='<tr ><td width="20%" rowspan="2"><img width="70" src=\''+'<%= application.getAttribute("IMAGE_URL")%>'+jsonResult.results[i].user.face+'\'/></td>'+
			'<td><a href=\'<%=request.getContextPath()%>/home/'+jsonResult.results[i].user.id+'/\'>'+jsonResult.results[i].user.realName+
			'</a> 在 '+formatDate(new Date(jsonResult.results[i].commentDate['time']),'yyyy-MM-dd HH:mm:ss')+
			'说:</td></tr><tr><td>'+jsonResult.results[i].comment+'</td></tr>';
			}
			result+='</table>';
			var previous = '上一页';
			var next ='下一页';
			if(jsonResult.previous){
				previous = '<a href="javascript:getPlaybillComment(\'<%=request.getContextPath()%>/getPlaybillCommentList.do\',\'commentlist\','+
				'\'<%=request.getAttribute("playbillId")%>\',\''+(jsonResult.no-1)+'\')">上一页</a>';
			}
			if(jsonResult.next){
				next = '<a href="javascript:getPlaybillComment(\'<%=request.getContextPath()%>/getPlaybillCommentList.do\',\'commentlist\','+
				'\'<%=request.getAttribute("playbillId")%>\',\''+(jsonResult.no+1)+'\')">下一页</a>';
			}
			var pageNoOption ='';
			for(var i=1;i<jsonResult.pageSum+1;i++){
				if(i==no){
					pageNoOption +='<option selected >'+i+'</option>';
				}else{
					pageNoOption +='<option>'+i+'</option>';
				}
			}
			
				var click = 'getPlaybillComment(\'<%=request.getContextPath()%>/getPlaybillCommentList.do\',\'commentlist\','+'\'<%=request.getAttribute("playbillId")%>\',\'[no]\')';
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
			$(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	
	}
	
	function copyurl(){
		var clipBoardContent=this.location.href; 
		window.clipboardData.setData("Text",clipBoardContent);
		alert("复制成功!"); 
	}
	function addBookmark(title) {
		var url=this.location.href; 
		if (document.all) 
			window.external.AddFavorite(url,title); 
		else 
		if (window.sidebar) 
			window.sidebar.addPanel(title,url,"") 
	}
	function subscribeplaybill(url,pars,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var showResult = function (originalRequest){
			var subpb = '';
			var nosubpb = 'none';
			var jsonResult = JSON.parse(originalRequest.responseText);
			if(jsonResult){
				subpb = 'none';
				nosubpb = '';
			}
			$('subscribeplaybill').style.display=subpb;
			$('cancelsubscribeplaybill').style.display=nosubpb;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	function commitcomment(url,playbillId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var pars = 'comment='+escape(encodeURIComponent($('commentcontent').value))+'&playbillId='+playbillId;
		var showResult = function (originalRequest){
		$('commentcontent').value='';
		getPlaybillComment('<%=request.getContextPath()%>/getPlaybillCommentList.do','commentlist','<%=request.getAttribute("playbillId")%>',1);
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function replaceString(concartString){
		var newString = concartString.replace(/\\/g,'\\').replace(/\#/g,'\\#');
		return newString;
	}
	function toCommentPage(url,pages){
		var pageindex = document.getElementById(pages).selectedIndex;
		getCommentList(url,'','',pageindex);
	}
	function toPage(pages){
		var pageindex = document.getElementById(pages).selectedIndex;
		var pageurl = document.getElementById(pages).options[pageindex].value;
		window.location.href=pageurl;
	}
	
	
	
	function addFriend(userId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		alert(userId+'未做！');
	}
	
	function subscribeUser(url,userId,divId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			$(resultId).innerHTML = flag;
			return ;
		}
		var pars = 'id='+userId;
		var showResult = function (originalRequest){
			$(divId).innerHTML='已订阅';
			$(divId).style.color='gray';
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getOtherPlaybill(url,pars,pageNo,resultId){
		pars += '&pageNo='+pageNo;
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result ='<table width="90%">';
			for(var i=0;i<jsonResult.results.length;i++){
				result += '<tr><td><a href="<%=request.getContextPath()%>/playbill/'+jsonResult.results[i].id+'/addDate/1/">'+jsonResult.results[i].name+'</a>'+
				'('+jsonResult.results[i].videoSize+'个视2频)</td></tr>';
			}
			result+='</table>';
			//if(jsonResult.next){
			//	result += '<a href="getUserPlaybill.do?id='+jsonResult.condition.user.id+'">更多他的节目单...</a>';
			//}
			if(jsonResult.results.length==0){
				result ='该用户无其他节目单！';
			}
			
			
			
				var click = 'getOtherPlaybill(\'<%=request.getContextPath()%>/getOtherPlaybill.do\',\'id=<%=((Playbill) request.getAttribute("playbill")).getUser().getId()%>&noExistId=<%=((Playbill) request.getAttribute("playbill")).getId()%>\',[no],\'otherplaybill\')';
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
			$(resultId).innerHTML=result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function getNewPlaybill(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result ='<div style="margin:15px" align="left" class="itable">';
			for(var i=0;i<jsonResult.results.length;i++){
				result += '<img src="../../../images/sp.gif">&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/playbill/'+jsonResult.results[i].id+'/addDate/1/">'+jsonResult.results[i].name+'</a>'+
				'('+jsonResult.results[i].videoSize+'个视频)<br/>';
			}
			result +='</div>';
			$(resultId).innerHTML=result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
</script>
<div class="side">
	<DIV class="module">
		<DIV class=title>
			<h2>
				创建者
			</h2>
		</DIV>
		<DIV class="reDiv">
			<table width="98%" border="0">
				<tr>
					<td>
						<img src="<%= application.getAttribute("IMAGE_URL")%>${videoUser.face }" width="120">
					</td>
					<td >
						<p>&nbsp;
							
						</p>
					</td>
					<td >
					
							<p>
							<a href="<%=request.getContextPath()%>/home/${videoUser.id }/">${videoUser.realName
							}</a>
						<br />	<br />
						
						<a href="#" onclick="sendRequest('${sessionUser.id }','${videoUser.id}')">加为好友</a>
					<a href="<%=request.getContextPath()%>/vblog/sendmessage/${videoUser.id }/">给TA蜜语</a>
						<br />	<br />
						<a href="<%=request.getContextPath()%>/home/${videoUser.id }/">查看TA的主页</a>
							</p>
							
						
						
					</td>
				</tr>
			</table>
		
		</DIV>
	</DIV>
	<div class="module">
		<div class="title">
			<h2>
				看过这个节目单的还喜欢
			</h2>
		</div>
		<div id="otherlikeresult" class="resultdiv" style="height: 450px" align="left">
			<img src='<%= application.getAttribute("IMAGE_URL")%>/images/blue-loading.gif' />
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				最新节目单
			</h2>
		</div>
		<div id="newplaybillresult">
			<img src='<%= application.getAttribute("IMAGE_URL")%>/images/blue-loading.gif' />
		</div>
	</div>
</div>
<div class="main">
	<div class="module">
		<div class="title">
			<h2>
				${playbill.name }
			</h2>
		</div>
		<div style="margin: 15px; text-align: left;" class="itable">
			<p>
				简介：${playbill.description }
			</p>
			<p>
				<a href="javascript:copyurl()">复制链接</a>
				<a href="javascript:addBookmark('${playbill.name  }')">收藏本页</a>
			</p>
		</div>
	</div>
	<div class="module">
		<c:if test="${subscribeFlag}">
			<c:set value="style='display: none;'" var="subscribeplaybill" />
			<c:set value="" var="cancelsubscribeplaybill" />
		</c:if>
		<c:if test="${!subscribeFlag}">
			<c:set value="" var="subscribeplaybill" />
			<c:set value="style='display: none;'" var="cancelsubscribeplaybill" />
		</c:if>
		<div class="title">
			<span>
				<div id="subscribeplaybill"
					onclick="subscribeplaybill('<%=request.getContextPath()%>/subscribePlaybill.do','action=true&playbillId=${playbill.id }','subscribeplaybillresult')"${subscribeplaybill }>
					<a >订阅节目单</a>
					<div id="subscribeplaybillresult"></div>
				</div>
				<div id="cancelsubscribeplaybill"
					onclick="subscribeplaybill('<%=request.getContextPath()%>/subscribePlaybill.do','action=false&playbillId=${playbill.id }')"${cancelsubscribeplaybill }>
					<a>取消订阅</a>
				</div> </span>
			<h2>
				共${pagination.recordSum }个视频
				<a
					href="<%=request.getContextPath()%>/playbill/${playbill.id }/play/">全部播放</a>
			</h2>
		</div>
		<div align="right"><br />
			<a
				href="<%=request.getContextPath()%>/playbill/${playbillId }/addDate/1/">按时间排序</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="<%=request.getContextPath()%>/playbill/${playbillId }/browseCount/1/">按播放次数排序</a>&nbsp;&nbsp;
		</div>
       <div class="reDiv">
<table width="98%">
<c:forEach begin="1" end="${pagination.size}" step="1" var="i">
<c:if test="${i%4==1}">
<tr>
</c:if>
<c:if test="${not empty pagination.results[i-1] }"><td valign="top" width="28%">

<img width="110px" src="<%= application.getAttribute("IMAGE_URL")%>${pagination.results[i-1].image }" />
<br /><div style="width:120px">
					<a
						href="<%=request.getContextPath()%>/playbill/${playbill.id }/play/${pagination.results[i-1].id }/">${pagination.results[i-1].name
						}</a>
					<br />
					发布者:
					<a href="<%=request.getContextPath()%>/home/${pagination.results[i].user.id }/">${pagination.results[i-1].user.realName
						}</a>
					<br />
					播放:${pagination.results[i-1].browseCount }
					<br />
					评论:${pagination.results[i-1].commentCount }
</div></td></c:if>
<c:if test="${empty pagination.results[i-1] }"><td>&nbsp;</td width="25%"></c:if>
<c:if test="${i%4==4}">
</tr>
</c:if>

</c:forEach>
</table>

</div>


		
<c:set var="url" value="${pageContext.request.contextPath}/playbill/${playbillId }/${order }"></c:set>
<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${url }"></h:pagination>
	
	</div>
	<div class="module">
		<div class="title">
			<h2>
				评评这个节目单
			</h2>
		</div>
		<div id="mycomment" style="margin: 15px; text-align: left;">
			<textarea rows="5" cols="60" id="commentcontent"></textarea>
			<div id="commitcomment"
				onclick="commitcomment('<%=request.getContextPath()%>/addCommentWithPlaybill.do','${playbillId }','commitcomment')">
				写好了
			</div>
		</div>
		<div id="commentlist" style="margin: 15px;text-align: left;">
			<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
		<div id="goTop">
			<a href="#" onclick="document.getElementById('playbill').scrollTop=0">回到顶部</a>
		</div>
	</div>
</div>