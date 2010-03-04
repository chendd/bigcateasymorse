<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
	rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/rand_number.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/friend.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
<script type="text/javascript">
function sendMessage(){
	var id = '${daily.id}';
	var word = $('word').value;
	if(word!=''){
		var rand = $F('input1');
		rand = rand.toUpperCase();
		if(rand==code){
			createCode();
		var url = '<%=request.getContextPath()%>/createDailyComment.do';
		var pars = 'id='+id+'&word='+word;
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :sendOk
		});
		}
		else{
			alert("验证码错误");
			createCode();
			}
		}
	
	function sendOk(originalRequest){
		jsonRaw = originalRequest.responseText;
		if(jsonRaw=='ok'){
			getComments('${daily.id}','1');
			}
		}
}
function getChannels(id) {
	var url = '<%=request.getContextPath()%>/getDailyChannels.do';
	var pars = 'id='+id;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse2
	});
	function showResponse2(originalRequest){
		jsonRaw = originalRequest.responseText;
		channels = eval("(" + jsonRaw + ")");
		var val = "<table width='90%' border='0' cellspacing='11'><tr><td width='100%'><a href="+'"javascript:getDailies('+"'${user.id}','','','1'"+')"'+">全部分类</a></td></tr>";
		for(i=0;i<channels.results.length;i++){
			val = val+"<tr><td><a href='<%=request.getContextPath()%>/blogList/${daily.user.id}/"+channels.results[i].id+"/'>"+channels.results[i].name+"</a>("+channels.results[i].dailyCount+")</td></tr>";
			}
		val = val+"</table>";
		$('module2').innerHTML = val;
		}
}
function getComments(id,pageNo) {
	var url = '<%=request.getContextPath()%>/getDailyComments.do';
	var pars = 'id='+id;
	if(pageNo!=''){
		pars = pars+"&pageNo="+pageNo;
		}
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse4
	});
	function showResponse4(originalRequest){
		jsonRaw = originalRequest.responseText;
	
		var val = "<table width='90%' border='0' cellspacing='11'>";
		
		if(jsonRaw){
		
			comments = eval("(" + jsonRaw + ")");
			for(i=0;i<comments.results.length;i++){
				val = val+"<tr><td width='20%'><a href='<%=request.getContextPath()%>/home/"+comments.results[i].userId+"/'><img width='50' src='<%= application.getAttribute("IMAGE_URL")%>"+comments.results[i].userFace+"'/></a></td><td width='70%'><div><a href='<%=request.getContextPath()%>/home/"+comments.results[i].userId+"/'>"+comments.results[i].realName+"</a> "+comments.results[i].addDate+"</div><div>"+comments.results[i].comment+"</div></td><td>";
				<c:if test="${sessionUser.id==daily.user.id}">val += "<a href='#' onclick=\"deleteCom('"+comments.results[i].id+"')\">删除</a>";  </c:if>
				val +="</td></tr>";
				}
			val = val + "<tr><td colspan='3'><div align='center'>";
			


			var click = 'getComments(\'${daily.id}\',\'[no]\')';
			var pa = pagination(comments.pageSum,comments.no,comments.isNext,comments.isPrevious,click);
			val +=pa;
			val = val + "</div></td></tr>";
			
	
			val = val+"</table>";
		}
		
		$('module4').innerHTML = val;
		}
}

function deleteCom(id){
	var flag = confirm("确定删除?");
	if(flag){
		var url = '<%=request.getContextPath()%>/deleteDailyComment.do';
		var pars = 'id='+id;
		
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :deleteOk
		});
		}
	
	
}
function deleteOk(originalRequest){
	jsonRaw = originalRequest.responseText;
	if(jsonRaw=="ok"){
		getComments('${daily.id}','1');
		}

	
	
}

function getHistories(id) {
	var url = '<%=request.getContextPath()%>/getDailyHistories.do';
	var pars = 'id='+id+"&pageSize=5";
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse5
	});
	function showResponse5(originalRequest){
		jsonRaw = originalRequest.responseText;
		var val = "<table width='90%' border='0' cellspacing='11'>";
		histories = eval("(" + jsonRaw + ")");
		for(var i=0;i<histories.results.length;i++){
			val = val + "<tr><td width='20%'><img width='50' src='<%= application.getAttribute("IMAGE_URL")%>"+histories.results[i].userFace+"'/></td><td width='80%'><a href='<%=request.getContextPath()%>/home/"+histories.results[i].userId+"/'>"+histories.results[i].realName+"</a><br />"+histories.results[i].visitDate+"</td></tr>";
			}
		val = val+"</table>";
		$('module5').innerHTML = val;
		}
}

function deleteDaily(){
	var i = confirm("删除后该日志有关的信息都将被删除");
	var id='${daily.id}';
	var userId='${sessionUser.id}';
	if(i&&userId!=''){
		self.location='<%=request.getContextPath()%>/deleteDaily.do?id='+id;
		}
	
}
</script>

<div class="side">
	<DIV class="module">
		<DIV class=title>
			<h2>
				${daily.user.realName }
			</h2>
		</DIV>
		<DIV>
			<table width="98%" border="0">
				<tr>
					<td width="33%">
						<img src="<%= application.getAttribute("IMAGE_URL")%>${daily.user.face }" width="120">
					</td>
					<td width="19%">
						<p>
							&nbsp;
						</p>
					</td>
					<td width="48%">
						<c:if test="${daily.user.id!=sessionUser.id}">
							<p>
								<a href="">订阅TA节目</a>
							</p>
							<p>
								<a href="">订阅TA日志</a>
							</p>
						</c:if>
						<c:if test="${daily.user.id==sessionUser.id}">
							<p>
								<a href="<%=request.getContextPath()%>/user/info/">修改个人资料</a>
							</p>
							<p>
								<a href="<%=request.getContextPath()%>/user/face/">修改我的头像</a>
							</p>
						</c:if>
					</td>
				</tr>
			</table>
			<table width="98%" border="0">
				<tr>
					<td>
						<p style="text-align: left;">
							性别：
							<c:if test="${daily.user.gender=='m'}">男</c:if>
							<c:if test="${daily.user.gender=='f'}">女</c:if>
							<c:if test="${daily.user.gender=='s'}">保密</c:if>
							年龄:${daily.user.age }
							<br>
							位置：${daily.user.area }
							<br>
							
							订阅：${daily.user.subscribeCount } 被订阅：${daily.user.beSubscribeCount }
							<br>
							视频：${daily.user.videoCount } 节目单：${daily.user.playBillCount }
							<br>
							<c:if test="${daily.user.id!=sessionUser.id}">
								<a href="#" onclick="sendRequest('${daily.user.id}')">加为好友</a>
								<a
									href="<%=request.getContextPath()%>/vblog/sendmessage/${daily.user.id }/">给TA蜜语</a>
								<br>
								<a
									href="<%=request.getContextPath()%>/group/sendinvite/${ daily.user.id}/">邀请加入圈子</a>
							</c:if>
							<c:if test="${daily.user.id==sessionUser.id}">
								<a href="<%=request.getContextPath()%>/vblog/mybox/">信箱</a>
								<br />
								<a href="<%=request.getContextPath()%>/vblog/writedaily/">写日志</a>
							</c:if>
						</p>
					</td>
				</tr>
			</table>
		</DIV>
	</DIV>
	<DIV class="module">
		<DIV class=title>
			<h2>
				日志分类
			</h2>
		</DIV>
		<DIV id='module2' style="margin: 15px;text-align: left;">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif" width="20" />
			<script type="text/javascript">getChannels('${daily.user.id}')</script>
		</DIV>
	</DIV>
	<DIV class="module">
		<DIV class=title>
			<h2>
				谁来过
			</h2>
		</DIV>
		<DIV id='module5'>
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif" width="20" />
			<script type="text/javascript">getHistories('${daily.id}')</script>
		</DIV>
	</DIV>
</div>
<div class="main">
	<DIV class="module">
		<DIV class=title>
<c:if test="${sessionUser.id==daily.user.id}"><span><a href="#" onclick="deleteDaily();">删除</a><a href="<%=request.getContextPath()%>/vblog/updatedaily/${daily.id }/">修改</a></span></c:if>

			<h2>
				${daily.title }
			</h2>

		</DIV>
		<DIV id='module3' style="text-align: left;margin: 15px;">
			${daily.log }
		</DIV>
	</DIV>
	<DIV class="module">
		<DIV class=title>
			<h2>
				评论
			</h2>
		</DIV>
<div class="reDiv">
<textarea id='word' rows='5' cols='40'></textarea><br />
<input  type="text" size="10"   id="input1" />  
    <input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 50px"  />
<a class='submitComment' href='#' onclick='sendMessage()'></a>
</div>
		<DIV id='module4' align="left">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif" width="20" />
			<script type="text/javascript">
			createCode();
			getComments('${daily.id}','1')</script>
		</DIV>
	</DIV>
</div>