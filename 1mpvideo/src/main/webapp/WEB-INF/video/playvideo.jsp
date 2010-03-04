<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.video.domain.Video"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/player/swfobject.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/friend.js"></script>
<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
	rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/friend.js"></script>

<script src="<%=request.getContextPath()%>/js/jquerystar/jquery.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquerystar/jquery.rater.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/rand_number.js"></script>
<link href="<%=request.getContextPath()%>/js/jquerystar/common.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/js/jquerystar/jquery.rater.css"
	rel="stylesheet" />
<script type="text/javascript">
	window.onload = function(){
	 	getVideoComment('<%=request.getContextPath()%>/getVideoCommentList.do','commentlist','<%=((Video) request.getAttribute("video")).getId()%>',1);
		getOtherVideo('<%=request.getContextPath()%>/getOtherVideo.do','<%=((Video) request.getAttribute("video")).getUser()
									.getId()%>','<%=((Video) request.getAttribute("video")).getId()%>','resultothervideo',1);
		getOtherUser('<%=request.getContextPath()%>/getOtherUser.do','<%=((Video) request.getAttribute("video")).getUser()
									.getId()%>','<%=((Video) request.getAttribute("video")).getId()%>','resultplayhistory',1);
		getUserLike('<%=request.getContextPath()%>/getMayLikeVideo.do','','resultuserlike');
	
	}
	function getVideoComment(url,resultId,videoId,no){
		var pars = 'videoId='+videoId+'&pageNo='+no;
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
		

				var click = 'getVideoComment(\''+url+'\',\''+resultId+'\','+'\''+videoId+'\',\'[no]\')';
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
			document.getElementById(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	
	}
	
	function commitcomment(url,videoId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			document.getElementById(resultId).innerHTML = flag;
			return ;
		}
		var text=document.getElementById('commentcontent');
		var text_length=String_Trim(text.value).length;
		if(text_length<5){
			alert('请认真填写评论');
			return ;
		}
		if(text_length>50){
			alert('评论请小于50字');
			return;
		}
		var rand = document.getElementById('input1').value;
		rand = rand.toUpperCase();
		if(rand==code){
			createCode();
		var pars = 'comment='+escape(encodeURIComponent(document.getElementById('commentcontent').value))+'&videoId='+videoId;
		var showResult = function (originalRequest){
			document.getElementById('commentcontent').value='';
			getVideoComment('<%=request.getContextPath()%>/getVideoCommentList.do','commentlist',videoId,1);
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
		}
		else{
			alert("验证码错误");
			createCode();
			}
	}
	function String_Trim(str){
		return str.replace(/(^\s*)|(\s*$)/g, "").replace(/(^\s*)/g, "").replace(/(\s*$)/g, "");
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
	
	function getOtherVideo(url,userId,videoId,resultId,pageNo){
			var pars = 'userId='+userId+'&videoId='+videoId+'&pageNo='+pageNo;
			var showResult = function (originalRequest){
				var jsonResult = JSON.parse(originalRequest.responseText);
				
				if(jsonResult.results.length>0){
				var m = jsonResult.size;
				if(m%2==1){
m+=1;
					}
				var result = "<table width='95%'>";
				for(var i=0;i<m;i++){
					if(i%2==0){
						result += "<tr>";
						}
					if(i<jsonResult.results.length){
						result += '<td valign="top" width="130"><a href="<%=request.getContextPath()%>/video/'+
						jsonResult.results[i].id+'/"><img width=110 src="<%=application.getAttribute("IMAGE_URL")%>'+
						jsonResult.results[i].image+'" /><br />'+jsonResult.results[i].name+
						'</a><br />发布者:<a href="<%=request.getContextPath()%>/home/'+jsonResult.results[i].user.id+'/">'+
						jsonResult.results[i].user.realName+'</a><br />播放:'+jsonResult.results[i].browseCount+
						'<br />评论:'+jsonResult.results[i].commentCount+'</td>';
						}
					if(i>=jsonResult.results.length){
						result += "<td width+'50%'>&nbsp;</td>";
						}
					if(i%2==1){
						result += "</tr>";
						}
					
					
				}
				result +="</table>";
			

				var click = 'getOtherVideo(\''+url+'\',\''+userId+'\',\''+videoId+'\',\''+resultId+'\',\'[no]\')';
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
				
				document.getElementById(resultId).innerHTML=result;
				}
				else{
					document.getElementById(resultId).innerHTML='';
					}
				
			}
			var getAjax = new Ajax.Request(url,{
				method:'post',parameters:pars,onComplete:showResult
			});
	}
	
	
	function getOtherUser(url,userId,videoId,resultId,pageNo){
		
			var pars = 'userId='+userId+'&videoId='+videoId+'&pageNo='+pageNo;
			
			var showResult = function (originalRequest){
			
				var jsonResult = JSON.parse(originalRequest.responseText);
				var result ='<table width="90%">';
				for(var i=0;i<jsonResult.size;i++){
					if(i%2==0){
						result += '<tr>';
						}
					if(i<jsonResult.results.length){
						result += '<td width="50%" ><img width="50" src="<%=application.getAttribute("IMAGE_URL")%>'+jsonResult.results[i].face+'" /><br />'+
						'<a href="<%=request.getContextPath()%>/home/'+jsonResult.results[i].id+'/">'+
						jsonResult.results[i].userName+'</a></td>';
						}
					if(i>=jsonResult.results.length){
					
						result += '<td width="50%">&nbsp;</td>';
						}
					if(i%2==1){
						result += '</tr>';
						}
					
				}
				result += '</table>';


				var click = 'getOtherUser(\''+url+'\',\'${sessionUser.id}\',\''+videoId+'\','+'\''+resultId+'\',\'[no]\')';

			
				var pa = pagination(jsonResult.pageSum,jsonResult.no,jsonResult.next,jsonResult.previous,click);
				result +=pa;
				document.getElementById(resultId).innerHTML=result;
			}
			var getAjax = new Ajax.Request(url,{
				method:'post',parameters:pars,onComplete:showResult
			});
	}
	
	function getUserLike(url,pars,resultId){
		var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			var result='<table width="95%">';
			var size ;
			if(jsonResult.length%2==1){
				size = jsonResult.length+1;

				}
			else{
				size = jsonResult.length;
				}
			for(var i=0;i<size;i++){
				if(i%2==0){
					result += '<tr>';
					}
				if(i<jsonResult.length){
					result += '<td width="50%" valign="top" ><a href=\'<%=request.getContextPath()%>/video/'+jsonResult[i].video.id+'/\'><img  width="110" src=\''+'<%=application.getAttribute("IMAGE_URL")%>'+jsonResult[i].imageUrl+
					'\' onclick=\'getVideo('+jsonResult[i].video.id+')\'/><br/>'+jsonResult[i].name+'</a><br/>'+
					'发布者：<a href=\'<%=request.getContextPath()%>/home/'+jsonResult[i].video.user.id+'/\'>'+
					jsonResult[i].video.user.realName+'</a><br/>'+
					'播放：'+jsonResult[i].video.browseCount+
					'<br/>评论：'+jsonResult[i].video.commentCount+'</td>';
					}
				if(i>=jsonResult.length){
				
					result += '<td width="50%">&nbsp;</td>';
					}
				if(i%2==1){
					result += '</tr>';
					}


				
				
			}	
			result += '</table>';
			document.getElementById(resultId).innerHTML = result;
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function updateVideo(url,videoId,action,actionId,noActionId,resultId){
		var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
		if(flag!='ok'){
			document.getElementById(resultId).innerHTML = flag;
			return ;
		}
		var pars = 'videoId='+videoId+'&action='+action;
		var showResult = function (originalRequest){
			document.getElementById(actionId).style.display='none';
			document.getElementById(noActionId).style.display='';
		}
		var getAjax = new Ajax.Request(url,{
			method:'post',parameters:pars,onComplete:showResult
		});
	}
	
	function addToPlaybill(videoId){
		var x=(window.screen.width-800)/2;
		var y=(window.screen.height-500)/2;
		window.open('<%=request.getContextPath()%>/getMyPlaybill.do?pageNo=1&videoId='+videoId, 'newwindow', 'height=500, width=800, top='+y+', left='+x+', toolbar=no, menubar=no, location=no')
	}
	function copyurl(){
		var clipBoardContent=this.location.href; 
		window.clipboardData.setData("Text",clipBoardContent);
		alert("复制成功!"); 
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
	function setPoint(){
		for(var i=1;i<6;i++){
			var pid='point'+i;
			alert(pid);
			var pp= document.getElementById(pid);
			alert(pp.value);
			pp.disabled=true;
		}
	}
</script>

<div class="main2">


	<div class="module">
		<div class="title">
			<h2>
				${video.name}
			</h2>

		</div>
		<div style="margin: 15px">
			<div id="flash">
				<p id="player1">
				</p>
				<script type="text/javascript">
	var s1 = new SWFObject("<%=request.getContextPath()%>/js/player/player.swf","single","504","432","7");
	s1.addParam("allowfullscreen","true");

	s1.addParam('allowscriptaccess','always');
	  s1.addParam('allownetworking','all');
	s1.addParam('flashvars','&file=${video.url}&controlbar=over&plugins=tipjar-1&logo=http://192.168.1.104/video/logo.png&streamer=rtmp://192.168.1.104/oflaDemo&frontcolor=FFD700&skin=<%=request.getContextPath()%>/js/player/stylish.swf&autostart=true');
	s1.write("player1");
	function replay(){
		s1.write("player1");
		}

</script>
			</div>
			<div align="center">
				<table width="500px">
					<tr>
						<td rowspan="2" width="15%">
							<a href="#"><img width="50"
								src="<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/ding.jpg"
								onclick="updateVideo('<%=request.getContextPath()%>/updateVideo.do',${video.id },'top','top','notop','playactionresult')" /></a>
						</td>
						<td width="20%">
							<div id="addplaybill" onclick="addToPlaybill('${video.id }')">
								<a href="#">添加到节目单</a>
							</div>
						</td>
						<td width="20%">
							<div id="collection"
								onclick="updateVideo('<%=request.getContextPath()%>/updateVideo.do',${video.id },'collection','collection','nocollection','playactionresult')">
								<a href="#">收藏</a>
							</div>
							<div id="nocollection" style="display: none; color: gray;">
								<a href="#">已收藏</a>
							</div>
						</td>
						<td width="20%">
							<div id="down">
								下载视频
							</div>
						</td>
						<td width="25%">
							<div id="playactionresult"></div>
						</td>
					</tr>
					<tr>
						<td>
							<div  id="notify"
								onclick="updateVideo('<%=request.getContextPath()%>/updateVideo.do',${video.id },'notify','notify','nonotify','playactionresult')">
								<a href="#">举报这个视频</a>
							</div>
						</td>
						<td>
							<div id="question">
								看不了啊
							</div>
						</td>
						<td>
							<div id="sharevideo" onclick="copyurl();">
								<a href="#">分享这个视频</a>
							</div>
						</td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<span id="rateStatus">评分</span>
<a style="background-color:  " title="重播" href="#" onclick="replay();">重播</a>
						</td>
						<td colspan="2">

							<div id="point"></div>
							<script>
							function pointVideo(url,resultId,videoId,point){
								var pars = 'videoId='+videoId+'&point='+point;
								var showResult = function (originalRequest){
									$('#point').rater(null , {maxvalue:5,curvalue:point,enabled:false});
									document.getElementById('point_result').innerHTML =originalRequest.responseText;
									return;
								}
								var getAjax = new Ajax.Request(url,{
									method:'post',parameters:pars,onComplete:showResult
								});
							}
							
							$('#point').rater(null , {maxvalue:5,curvalue:2.5} , function(el , value) {
								var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
								if(flag!='ok'){
									document.getElementById('point_result').innerHTML = flag;
									return ;
								}
								pointVideo('<%=request.getContextPath()%>/pointVideo.do','',${video.id },value);
							});
							</script>
						</td>
						<td>
							<div id="point_result"></div>
						</td>
					</tr>

				</table>
			</div>
		</div>

	</div>



	<div class="module">
		<div class="title">
			<h2>
				评评这个视频
			</h2>
		</div>


		<div class="reDiv">
			<textarea rows="5" cols="50"
				style="width: 200"
				id="commentcontent"></textarea><br />
<input  type="text" size="10"   id="input1" />  
    <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 50px"  />
<a class='submitComment' href="javascript:commitcomment('<%=request.getContextPath()%>/addCommentWithVideo.do','${video.id }','mycommentresult')"></a>
			

		</div>
		<div class="reDiv" id="mycommentresult">
		</div>
		<div id="commentlist" style="margin: 15px;">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
<script type="text/javascript">createCode();</script>
		</div>
		<div id="goTop">
			<a href="#" onclick="document.getElementById('play').scrollTop=0">回到顶部</a>
		</div>
	</div>


</div>
<div class="side2">

	


<DIV class="module">
		<DIV class=title>
			<h2>
				会员介绍
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
							}</a>发布于
						<fmt:formatDate value="${video.addDate }" type="date" />
						<br />	<br />
						
						<a href="#" onclick="sendRequest('${sessionUser.id }','${videoUser.id}')">加为好友</a>
					<a href="javascript:sendMessage('${videoUser.id}')">密TA </a>
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
				作者其他视频
			</h2>
		</div>
		<div id="resultothervideo" class="reDiv">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>


	<div class="module">
		<div class="title">
			<h2>
				有谁看过这个视频
			</h2>
		</div>
		<div id="resultplayhistory">
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				观看这个视频的人还喜欢
			</h2>
		</div>
		<div  class="reDiv" id="resultuserlike" >
			<img
				src='<%=application.getAttribute("IMAGE_URL")%>/1mpweb/images/blue-loading.gif' />
		</div>
	</div>

</div>