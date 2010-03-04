<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.video.domain.Playbill"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/player/swfobject.js"></script>
<link href="<%=request.getContextPath()%>/js/dialog/dialog.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/friend.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/rand_number.js"></script>
<script type="text/javascript">

var playid = '${videoId}';
if(playid==''){
	playid = '${videoes[0].id}';
}
	window.onload = function(){
	 	getPlaybillComment('<%=request.getContextPath()%>/getPlaybillCommentList.do','commentlist','<%=((Playbill) request.getAttribute("playbill")).getId()%>',1);
	 	getUserUsePlaybill('<%=request.getContextPath()%>/getUserUsePlaybill.do','<%=((Playbill) request.getAttribute("playbill")).getUser()
							.getId()%>','user');
							getOtherPlaybill('<%=request.getContextPath()%>/getOtherPlaybill.do','id=<%=((Playbill) request.getAttribute("playbill")).getUser()
									.getId()%>&noExistId=<%=((Playbill) request.getAttribute("playbill")).getId()%>','1','otherplaybill');
		getNewPlaybill('<%=request.getContextPath()%>/getNewPlaybill.do','','newplaybillresult');
		getUserLike('<%=request.getContextPath()%>/getMayLikeVideo.do','','otherlikeresult');
	}
	function getUserLike(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result='';
			for(var i=0;i<jsonResult.length;i++){
				result += '<div style=\'width:120px\' id=\'resultlikevideo'+i+'\'>'+
				'<img width=\'110px\' src=\''+'<%= application.getAttribute("IMAGE_URL")%>'+jsonResult[i].imageUrl+
				'\' onclick=\'getVideo('+jsonResult[i].video.id+')\'/><br/>'+
				'<a href=\'<%=request.getContextPath()%>/video/'+jsonResult[i].video.id+'/\'>'+jsonResult[i].name+'</a><br/>'+
				'发布者：<a href=\'<%=request.getContextPath()%>/home/'+jsonResult[i].video.user.id+'/\'>'+jsonResult[i].video.user.realName+'</a><br/>'+
				'播放：'+jsonResult[i].video.browseCount+
				'<br/>评论：'+jsonResult[i].video.commentCount+'</div>';
			}	
			document.getElementById(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}


	function getPlaybillComment(url,resultId,playbillId,no){
		var pars = 'videoId='+playbillId+'&pageNo='+no;
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result ='<table width="90%"  style="table-layout:fixed;text-align:left">';
			for(var i =0;i<jsonResult.results.length;i++){
				result+='<tr ><td width="100px" rowspan="2"><img width="60" src=\''+'<%=application.getAttribute("IMAGE_URL")%>'+
				jsonResult.results[i].user.face+'\'/></td><td><a href=\'<%=request.getContextPath()%>/home/'+
				jsonResult.results[i].user.id+'/\'>'+jsonResult.results[i].user.realName+
				'</a> 在 '+formatDate(new Date(jsonResult.results[i].commentDate['time']),'yyyy-MM-dd HH:mm:ss')
				+'说:</td></tr><tr><td width="400px"  style="word-break : break-all; overflow:hidden;">'+jsonResult.results[i].comment+'</td></tr>';
			}
			result +="</table>";
		

				var click = 'getPlaybillComment(\''+url+'\',\''+resultId+'\','+'\''+playbillId+'\',\'[no]\')';
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
			document.getElementById(resultId).innerHTML = result;
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
		alert(title);
		var url=this.location.href; 
		alert(url);
		if (document.all) 
			window.external.AddFavorite(url,title); 
		else 
		if (window.sidebar) 
			window.sidebar.addPanel(title,url,"") 
		
	}
	function subscribeplaybill(url,pars){
		var showResult = function (originalRequest){
			var subpb = '';
			var nosubpb = 'none';
			var jsonResult = JSON.parse(originalRequest.responseText);
			if(jsonResult){
				subpb = 'none';
				nosubpb = '';
			}
			
			document.getElementById('subscribeplaybill').style.display=subpb;
			document.getElementById('cancelsubscribeplaybill').style.display=nosubpb;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	function commitcomment(url,playbillId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			document.getElementById(resultId).innerHTML = flag;
			return ;
		}
		var pars = 'comment='+escape(encodeURIComponent(document.getElementById('commentcontent').value))+'&playbillId='+playbillId;
		var showResult = function (originalRequest){
	document.getElementById('commentcontent').value='';
		getPlaybillComment('<%=request.getContextPath()%>/getPlaybillCommentList.do','commentlist','<%=((Playbill) request.getAttribute("playbill")).getId()%>',1);
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
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
	function sendMessage(toUserId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			document.getElementById(resultId).innerHTML = flag;
			return ;
		}
		
		var x=(window.screen.width-510)/2;
		var y=(window.screen.height-300)/2;
		//window.showModalDialog('sendmessage.jsp?toUserId='+toUserId+'&sendUserId='+sendUserId,"","dialogHeight:500px; dialogWidth:600px; location:no; status:no; help:no; scroll:no");
		window.open('<%=request.getContextPath()%>/sendmessage.jsp?toUserId='+toUserId, 'newwindow', 'height=300, width=510, top='+y+', left='+x+', toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no') 
	}
	function getUserUsePlaybill(url,userId,resultId){
		var pars = 'userId='+userId;
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result = '<table><tr><td rowspan="5"><img width="90" src="<%= application.getAttribute("IMAGE_URL")%>'+jsonResult.face+'" /></td>'+
			'<td><a href="<%=request.getContextPath()%>/home/'+jsonResult.id+'/">'+
			jsonResult.realName+'</a>发布于'+formatDate(new Date(<%=((Playbill) request.getAttribute("playbill"))
							.getAddDate().getTime()%>),'yyyy-MM-dd HH:mm:ss')+'</td></tr>'+
			'<tr><td><a href="javascript:subscribeUser(\'<%=request.getContextPath()%>/subscribeUser.do\','+jsonResult.id+',\'subscribeuser\',\'userresult\')">订阅他</a>'+
			'<a href="#" onclick="sendRequest(\''+jsonResult.id+'\')">加他好友 </a><a href="javascript:sendMessage('+jsonResult.id+',\'userresult\')">密TA </a></td></tr>'+
			'<tr><td><a href="<%=request.getContextPath()%>/home/'+jsonResult.id+'/">查看他的主页</a></td></tr>'+
			'<tr><td>播放:'+jsonResult.browseCount+' 评论:'+jsonResult.commentCount+'</td></tr>'+
			'<tr><td>收藏:'+jsonResult.collectionCount+' 评分:'+jsonResult.pointSum+'</td></tr></table>';
			document.getElementById(resultId).innerHTML=result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	function addFriend(userId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			document.getElementById(resultId).innerHTML = flag;
			return ;
		}
		alert('未做');
	
	}
	
	function getOtherPlaybill(url,pars,pageNo,resultId){
		//var par = pars+ '&pageNo='+pageNo;
		//pars += '&pageNo='+pageNo;

		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result ='<table width="90%">';
			for(var i=0;i<jsonResult.results.length;i++){
				result += '<tr><td><a href="<%=request.getContextPath()%>/playbill/'+jsonResult.results[i].id+'/addDate/1/">'+jsonResult.results[i].name+'</a>'+
				'('+jsonResult.results[i].videoSize+'个视频)</td></tr>';
			}
			result+='</table>';
			//if(jsonResult.next){
			//	result += '<a href="getUserPlaybill.do?id='+jsonResult.condition.user.id+'">更多他的节目单...</a>';
			//}
			if(jsonResult.results.length==0){
				result ='该用户无其他节目单！';
			}
			
			
		
			

				var click = 'getOtherPlaybill(\''+url+'\',\''+pars+'\',\'[no]\','+'\''+resultId+'\')';
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
				document.getElementById(resultId).innerHTML=result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars+'&pageNo='+pageNo,onComplete:showResult
		});
	}
	

	function getNewPlaybill(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result ='<div style="margin:15px" align="left">';
			for(var i=0;i<jsonResult.results.length;i++){
				result += '<a href="<%=request.getContextPath()%>/playbill/'+jsonResult.results[i].id+'/addDate/1/">'+jsonResult.results[i].name+'</a>'+
				'('+jsonResult.results[i].videoSize+'个视频)<br/>';
			}
			result +='</div>';
			document.getElementById(resultId).innerHTML=result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	function subscribeUser(url,userId,divId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			document.getElementById(resultId).innerHTML = flag;
			return ;
		}
		var pars = 'id='+userId;
		var showResult = function (originalRequest){
			document.getElementById(divId).innerHTML='已订阅';
			document.getElementById(divId).style.color='gray';
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
</script>
<div class="main2">
<div class="module">
<div class="title"><h2>${playbill.name}</h2></div>
<div style="margin: 15px">
			<div id="flash">
				<p id="player1"> </p>

			</div>
			<div  align="left" class="itable" style="width:500px"><br/>
				简介:${playbill.description }
		<div id="copylink" onclick="copyurl();">
			<a>复制连接</a>
		</div>
		<div id="collection" onclick="addBookmark('${playbill.name }')">
			<a>收藏本页</a>
		</div>
			</div>

		</div>

</div>


<div class="module">
<div class="title"><h2>评评这个节目单</h2></div>
<div class="reDiv">
			<textarea rows="5" cols="50"
				style="width: 200"
				id="commentcontent"></textarea><br />
<input  type="text" size="10"   id="input1" />  
    <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 50px"  />
<a class='submitComment' href='#' onclick="commitcomment('<%=request.getContextPath()%>/addCommentWithPlaybill.do','${playbill.id }','commitcomment')"></a>
		
<div class="reDiv" id="mycommentresult">
		</div>
		<div id="commentlist">
			<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
<script type="text/javascript">createCode();</script>
		</div>
		<div id="goTop">
			<a href="#" onclick="document.getElementById('playbill').scrollTop=0">回到顶部</a>
		</div>



</div>
</div>



</div>

<div class="side2">

<div class="module">
		<div class="title">
			<h2>
				专辑视频列表
			</h2>
		</div>
		<div class="reDiv" style="width:98%;height:300px;overflow-x:hidden;overflow-y:scroll">
<table width="98%" border="0"  >
<c:forEach items="${videoes}" var="video">
<tr  >
<td width="10%"><img width="50" src="${IMAGE_URL }${video.image }"/></td><td width="45%"><a id="${video.id }" style="color: #C92103" href="#" onclick="palyit(this,'${video.url}');">${video.name }</a><div id="div${video.id }"></div></td><td>发布者：<a href="<%=request.getContextPath()%>/home/${video.user.id }">${video.user.realName }</a>
<input type="hidden" id="h${video.id }" value="${video.url }"/>
</td>
</tr>

</c:forEach>
</table>
</div>
	</div>
<div class="module">
		<div class="title">
			<h2>
				创建者
			</h2>
		</div>
		<div class="reDiv">
<div id="user" >
			<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
		<div id="userresult"></div>

</div>
	</div>

<div class="module">
		<div class="title">
			<h2>
				创建者的更多节目
			</h2>
		</div>
		<div id="otherplaybill" class="reDiv">
			<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>

<div class="module">
<div class="title"><h2>看过这个节目单的还喜欢</h2></div>
<div id="otherlikeresult" class="resultdiv" style="height: 450px" align="left">
			<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
</div>

<div class="module">
<div class="title"><h2>最新节目单</h2></div>
<div id="newplaybillresult" >
			<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
</div>

</div>


<script type="text/javascript">

var s1 = new SWFObject("<%=request.getContextPath()%>/js/player/player.swf","single","504","432","7");
s1.addParam("allowfullscreen","true");
s1.palyurl=document.getElementById("h"+playid).value;

s1.addParam('allowscriptaccess','always');
  s1.addParam('allownetworking','all');
s1.addParam('flashvars','&file='+s1.palyurl+'&controlbar=over&plugins=tipjar-1&logo=http://www.1mp.net.cn/video/logo.png&streamer=rtmp://124.42.74.136/oflaDemo&frontcolor=FFD700&skin=<%=request.getContextPath()%>/js/player/stylish.swf&autostart=true');
s1.write("player1");
document.getElementById(playid).style.color="#CAE83C";
document.getElementById('div'+playid).innerHTML="<img src='<%=request.getContextPath()%>/images/playing.png'/>&nbsp;正在播放...";
function palyit(thisinput,url){
	var id = thisinput.id;
	
	if(id!=playid){
		document.getElementById(playid).style.color="#C92103";
		document.getElementById('div'+playid).innerHTML='';
		thisinput.style.color="#CAE83C";
		document.getElementById('div'+thisinput.id).innerHTML="<img src='<%=request.getContextPath()%>/images/playing.png'/>&nbsp;正在播放...";

			s1.addParam('flashvars','&file='+url+'&controlbar=over&plugins=tipjar-1&logo=http://www.1mp.net.cn/video/logo.png&streamer=rtmp://192.168.0.99/oflaDemo&frontcolor=FFD700&skin=<%=request.getContextPath()%>/js/player/stylish.swf&autostart=true');
			s1.write("player1");
			alert(url);
			playid = id;
		}


}
</script>


