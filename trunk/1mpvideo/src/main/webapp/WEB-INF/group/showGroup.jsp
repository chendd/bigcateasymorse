<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/json/formatdate.js"></script>
<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
	rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog/dialog.js"></script>
<script type="text/javascript">
function deleteGroup(){
	var id = '${group.id}';
	var flag = confirm("你确定解散小组？这样该小组的相关信息将永久删除");
	if(flag){
		self.location="<%=request.getContextPath()%>/deleteGroup.do?id="+id;
		}

	
}

function deleteGroupAndUser(){
	var showResponse = function(originalRequest){
		var strValue = originalRequest.responseText;
		if(strValue=='ok'){
			showDetail('');
			$('dialogVal').innerHTML='你已成功退出该圈子';
			$('msgShut').onclick=function(){window.location.href="<%=request.getContextPath()%>/group/${group.id}/"; };	
			}
	}
	var id = '${group.id}';
	var url ="<%=request.getContextPath()%>/createGroupAndUser.do";
	pars = "id="+id+"&type=del";
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse
	});
}

function createGroupAndUser(){
	var showResponse = function(originalRequest){
		var strValue = originalRequest.responseText;
		
		if(strValue=='ok'){
			showDetail('');
			$('dialogVal').innerHTML='恭喜，你成功加入该圈子';
			$('msgShut').onclick=function(){window.location.href="<%=request.getContextPath()%>/group/${group.id}/"; };	
			}
	}
	
	var id = '${group.id}';
	var url ="<%=request.getContextPath()%>/createGroupAndUser.do";
	pars = "id="+id+"&type=add";
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse
	});
}
function sendMess(){
	
	var showResponse = function(originalRequest){
		var strValue = originalRequest.responseText;
		
		if(strValue=='ok'){
			$('dialogVal').innerHTML='申请已经发送，请等待圈主审核';
			}
	}
	var mess = $('mess').value;
	if(mess==''){
		alert('请填写申请理由');
		}
	var id = '${group.id}';
	var url ="<%=request.getContextPath()%>/createGroupRequest.do";
	pars = "id="+id+"&word="+mess;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse
	});
	
	
}
function showDiv(){
	var userId='${sessionUser.id}';
	if(userId!=''){
		
		
	var auditType = '${group.auditType}';
	if(auditType=='1'){
		 showDetail('');
		}
	else if(auditType=='0'){
		createGroupAndUser();

		}
	}
}
function getVideoHistory(id,pageNo){

	var url = '<%=request.getContextPath()%>/getGroupBrowseHistory.do';
	var pars = "id="+id+"&pageNo="+pageNo;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse2
	});

	function showResponse2(originalRequest){
		var jsonRaw = JSON.parse(originalRequest.responseText);
		if (jsonRaw) {
			var row = jsonRaw.size/2;
			var val = "<table width=98%>";
			for(var r=0;r<row;r++){
				val += "<tr>";
				for(var i=r*2;i<r*2+2;i++){
					if(i<jsonRaw.results.length){
						val+='<td width="120px" valign="top"><img width="100px" src="<%=application.getAttribute("IMAGE_URL")%>'+jsonRaw.results[i].image+'" /><br />'+
						'<a href="<%=request.getContextPath()%>/video/'+jsonRaw.results[i].id+'/">'+jsonRaw.results[i].name+'</a><br />'+
						'发布者:<a href="<%=request.getContextPath()%>/home/'+jsonRaw.results[i].user.id+'/">'+jsonRaw.results[i].user.realName+'</a><br />'+
						'播放:'+jsonRaw.results[i].browseCount+'<br />'+
						'评论:'+jsonRaw.results[i].commentCount+'</td>';
						}
					else{
						val+="<td>&nbsp</td>";
						}
					}
				val += "</tr>";

				}
			val += "</table>";
		
			var click = 'getVideoHistory(\'${group.id}\',\'[no]\')';
			var pa = pagination(jsonRaw.pageSum,jsonRaw.no,jsonRaw.next,jsonRaw.previous,click);
			val +=pa;
			$('videohistory').innerHTML=val;
			
		}
	}
	
}

function getTopics(id,pageNo){
	var url = '<%=request.getContextPath()%>/getMyGroupTopices.do'
		pars = "id="+id+"&pageNo="+pageNo;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse1
	});
	function showResponse1(originalRequest){
		var strValue = originalRequest.responseText;
		var jsonValue = eval("(" + strValue + ")");
		var val = '<div align="center">查无记录</div>';
		document.getElementById('v').innerHTML=jsonValue.recordSum+"个话题";
		if(jsonValue.results.length>0){
			val ="<table width='580px' ><tr class='name'><td width='350px'>话题</td><td width='50px'>回复</td><td width='50px'>点击</td><td width='80px'>组名称</td><td width='80px'>发布人</td><td width='80px'>时间</td></tr>"
				for(i=0;i<jsonValue.results.length;i++){
					val = val+"<tr class='itable'><td><a href='<%=request.getContextPath()%>/group/topic/"+jsonValue.results[i].id+"/'>"+jsonValue.results[i].title+"</a></td><td>"+jsonValue.results[i].commentCount+"</td><td>"+jsonValue.results[i].browseCount+"</td><td>${group.name}</td><td><div align='center'>"+jsonValue.results[i].user.realName+"</div></td><td>"+formatDate(new Date(jsonValue.results[i].addDate['time']),'yyyy-MM-dd')+"</td></tr>";
					}
			val = val +"</table>";
			var click = 'getTopics(\'${group.id}\',\'[no]\')';
			var pa = pagination(jsonValue.pageSum,jsonValue.no,jsonValue.next,jsonValue.previous,click);
			val +=pa;
		
			}
	
		$('topic').innerHTML=val;
		
		}
	
}


</script>
<div id="center">
	<div class="side">

		<DIV class="module">

			<DIV class=title>
				<h2>
					关于这个小组
				</h2>
			</DIV>

			<DIV id='' class="reDiv">
				<table width="90%">
	<tr><td><a	href="<%=request.getContextPath()%>/group/${group.id }/videolist/">${videoes.recordSum}个视频</a></td></tr>
<tr><td><a	href="<%=request.getContextPath()%>/group/${group.id }/memberlist/">${members.recordSum}个成员</a></td></tr>
<tr><td><a id="v" href="<%=request.getContextPath()%>/group/${group.id }/topiclist/"></a></td></tr>
</table>
				
				
			</DIV>

		</DIV>

<c:if test="${sessionUser.id==group.owner.id}">
<DIV class="module">

			<DIV class=title>
				<h2>
					管理操作
				</h2>
			</DIV>

			<DIV >
<p class="sideButton"><a href="">群发小组公告</a></p>
<p class="sideButton"><a href="">成员管理</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/group/update/${group.id }/">小组设置</a></p>
<p class="sideButton"><a href="#" onclick="deleteGroup();">解散小组</a></p>

			
			</DIV>

		</DIV>

</c:if>


		<DIV class="module">

			<DIV class=title>
				<h2>
					最新加入成员
				</h2>
			</DIV>

			<DIV id=''>
				<table width="90%">
					<c:if test="${fn:length(members.results)/3>0}">
						<tr>
							<c:forEach var="i" begin="0" end="2" step="1">
								<c:if test="${fn:length(members.results)>i}">
									<td width="20%">
										<img
											src="<%= application.getAttribute("IMAGE_URL")%>${  members.results[i].user.face}"
											width="50" />
										<br />
										<a
											href="<%=request.getContextPath()%>/home/${members.results[i].user.id }/">${
											members.results[i].user.realName }</a>
									</td>
								</c:if>
								<c:if test="${fn:length(members.results)<=i}">
									<td width="20%">&nbsp;
										
									</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:if>
					<c:if test="${fn:length(members.results)/3>1}">
						<tr>
							<c:forEach var="i" begin="3" end="5" step="1">
								<c:if test="${fn:length(members.results)>i}">
									<td width="20%">
										<img
											src="<%= application.getAttribute("IMAGE_URL")%>${ members.results[i].user.face}"
											width="50" />
										<br />
										<a
											href="<%=request.getContextPath()%>/home/${members.results[i].user.id }/">${members.results[i].user.realName}</a>
									</td>
								</c:if>
								<c:if test="${fn:length(members.results)<=i}">
									<td width="20%">&nbsp;
										
									</td>
								</c:if>
							</c:forEach>
						</tr>

					</c:if>

				</table>
			</DIV>

		</DIV>


		<DIV class="module">

			<DIV class=title>
				<h2>
					组员最近看过的视频
				</h2>
			</DIV>

			<DIV id='videohistory' class="reDiv">
<script type="text/javascript">getVideoHistory('${group.id}','1');</script>
</DIV>


		</DIV>

		<DIV class="module">

			<DIV class=title>
				<h2>
					最近来的客人
				</h2>
			</DIV>

			<DIV class="reDiv2">
				<table width="90%">
					<c:forEach items="${histories}" var="history">
						<tr>
							<td width="30%">
								<img  src="<%= application.getAttribute("IMAGE_URL")%>${history.visiter.face }" width="50" />
							</td>
							<td>
								<a
									href="<%=request.getContextPath()%>/home/${history.visiter.id }/">${history.visiter.realName
									}</a>
								
								<br />
								<fmt:formatDate value="${history.visitDate}" type="both" />
							</td width="70%">
						</tr>
					</c:forEach>
				</table>
			</DIV>
		</DIV>
	</div>
	<div class="main">
		<DIV class="module">
			<DIV class=title>
				<h2>
					${group.name }
				</h2>
			</DIV>

			<DIV id=''>
				<table width="90%">
					<tr>
						<td rowspan="2" width="20%">
							<img src="<%= application.getAttribute("IMAGE_URL")%>${group.image }" />
						</td>
						<td width="80%">
							${group.descrption }
						</td>
					</tr>
					<tr>
						<td>
							组长:
							<a href="<%=request.getContextPath()%>/home/${group.owner.id}/">${group.owner.realName}</a>
							<c:if test="${empty groupAndUser}">
								<a href="#" onclick="showDiv();">加入小组</a>
							</c:if>
							<c:if test="${groupAndUser.rate<3}">
								<a href="#" onclick="deleteGroupAndUser();">退出小组</a>
							</c:if>
							<c:if test="${groupAndUser.rate==3}">
								<a href="#" onclick="deleteGroup();">解散小组</a>
							</c:if>
							<c:if test="${not empty groupAndUser }">
								<a href="<%=request.getContextPath()%>/group/${group.id }/topic/create/">发表话题</a>
							</c:if>
							<a href="">订阅话题</a>
						</td>
					</tr>
				</table>
			</DIV>
		</DIV>
		<DIV class="module">
			<DIV class=title>
				<h2>
					最新话题
				</h2>
			</DIV>

			<DIV id='topic' class="itable">
				<script type="text/javascript">getTopics('${group.id}','1')</script>
			</DIV>
		</DIV>
		<DIV class="module">
			<DIV class=title>
				<h2>
					组员最新发布的视频
				</h2>
			</DIV>
			<DIV id=''>
				<table width="90%">
					<c:if test="${fn:length(videoes.results)/4>0}">
						<tr>
							<c:forEach var="i" begin="0" end="3" step="1">
								<c:if test="${fn:length(videoes.results)>i}">
									<td width="25%" class='itable' valign="top">
										<img src="<%= application.getAttribute("IMAGE_URL")%>${ videoes.results[i].image}"
											width="100" />
										<br />
										<a href="<%=request.getContextPath()%>/video/${videoes.results[i].id}/">${videoes.results[i].name }</a>
										<br />
										发布者:
										<a
											href="<%=request.getContextPath()%>/home/${videoes.results[i].user.id }/">${videoes.results[i].user.realName
											}</a>
										<br />
										播放:${videoes.results[i].browseCount }
										<br />
										评论数:${videoes.results[i].commentCount }
									</td>
								</c:if>
								<c:if test="${fn:length(videoes.results)<=i}">
									<td width="20%">&nbsp;
										
									</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:if>
					<c:if test="${fn:length(videoes.results)/4>1}">
						<tr>
							<c:forEach var="i" begin="4" end="7" step="1">
								<c:if test="${fn:length(videoes.results)>i}">
									<td width="25%" class="itable" valign="top">
										<img src="<%= application.getAttribute("IMAGE_URL")%>${ videoes.results[i].image}"
											width="100" />
										<br />
										<a href="<%=request.getContextPath()%>/video/${videoes.results[i].id}/">${videoes.results[i].name }</a>
										<br />
										发布者:
										<a
											href="<%=request.getContextPath()%>/home/${videoes.results[i].user.id }/">${videoes.results[i].user.realName
											}</a>
										<br />
										播放:${videoes.results[i].browseCount }
										<br />
										评论数:${videoes.results[i].commentCount }
									</td>
								</c:if>
								<c:if test="${fn:length(videoes.results)<=i}">
									<td width="20%">&nbsp;
										
									</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:if>
				</table>
			</DIV>
		</DIV>
		<DIV class="module">
			<DIV class=title>
				<h2>
					组员最新发布的专辑
				</h2>
			</DIV>
			<DIV id=''>
				<table width="90%">
					<c:if test="${fn:length(playBills)/5>0}">
						<tr>
							<c:forEach var="i" begin="0" end="3" step="1">
								<c:if test="${fn:length(playBills)>i}">
									<td width="25%" class="itable">
										<img src="<%= application.getAttribute("IMAGE_URL")%>${ playBills[i].imagesUrl}" />
										<br />
										<a href="<%=request.getContextPath()%>/playbill/${playBills[i].id }/addDate/">${playBills[i].name }</a>
										<br />
										发布者:
										<a
											href="<%=request.getContextPath()%>/home/${playBills[i].user.id }/">${playBills[i].user.realName
											}</a>
										<br />
										视频数:${playBills[i].videoSize }
									</td>
								</c:if>
								<c:if test="${fn:length(playBills)<=i}">
									<td width="25%">&nbsp;
										
									</td>
								</c:if>
							</c:forEach>
						</tr>
					</c:if>
				</table>
			</DIV>
		</DIV>
	</div>
</div>
<div id="msgDiv">
	<div id="msgShut">
		关闭
	</div>
	<div id="msgDetail">
		<p></p>
		<div align="center" id="dialogVal">
			<table width="80%">
				<tr>
					<td width="20%">
						<img src="<%= application.getAttribute("IMAGE_URL")%>${group.image }"
							width="50" />
					</td>
					<td width="80%">
						需通过该群管理员的审核才能加入该群。
						<br />
						申请加入理由：
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<textarea id="mess" rows="5" cols="30"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<button onclick="sendMess();">
							确定
						</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div id="bgDiv">
</div>
