<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/friend.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/rand_number.js"></script>
<script type="text/javascript">
	function sendMessage() {
		var id = '${sessionUser.id}';
		var tid = '${user.id}';
		var word = $('word').value;
		if (word == '') {
			alert('留言不能为空');
		}
		if (id == '') {
			alert('请先登录');
		}

		if (word != ''&&id!='') {
			var rand = $F('input1');
			rand = rand.toUpperCase();
			if(rand==code){
				createCode();
			
			var url = '<%=request.getContextPath()%>/createBlogWord.do';
			var pars = 'id=' + tid + '&word=' + word;
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

		function sendOk(originalRequest) {
			jsonRaw = originalRequest.responseText;
			if (jsonRaw == 'ok') {
				getModule2('${user.id}');
			}
		}
	}

	

	function getModule1(id,pageNo) {
		var url = '<%=request.getContextPath()%>/getMyFriends.do';
		var pars = 'pageSize=6&id=' + id+'&pageNo='+pageNo;
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse1
		});
	}
	function showResponse1(originalRequest) {
		
		jsonRaw = originalRequest.responseText;
		if (jsonRaw) {
			paginations = eval("(" + jsonRaw + ")");
			var val = "<table width='98%' cellspacing='11'>";
			for (i = 0; i < 6; i++) {
				if (i % 3 == 0) {
					val = val + "<tr>";
				}
				if (i < paginations.results.length) {
					
					val = val
							+ "<td width='30%'><a href=''><img width='50' src='<%= application.getAttribute("IMAGE_URL")%>"
							+ paginations.results[i].face
							+ "'/></a><br/><a href='<%=request.getContextPath()%>/home/"
							+ paginations.results[i].id + "/'>"
							+ paginations.results[i].realName + '</a>';

					if('${user.id}'=='${sessionUser.id}'){
						val += '<br /><a href="javascript://void(0)"  onclick="deleteFriend(\''+paginations.results[i].id+'\')">删除</a>';
						}
					val += '</td>';
				} else {
					val = val + "<td width='30%'></td>";

				}
				if (i % 3 == 2) {
					val = val + "</tr>";
				}
			}
			val = val + "</table>";
		
			var click = 'getModule1(\'${user.id}\',\'[no]\')';
			
			var pa = pagination(paginations.pageSum,paginations.no,paginations.next,paginations.previous,click);
			val += pa;
			document.getElementById("modeul1").innerHTML = val;
		} else {
			document.getElementById("modeul1").innerHTML = '查无相关记录';
		}
	}
	function deleteFriend(id){
		var i = confirm("确认删除？");
		if(i){
			var url = '<%=request.getContextPath()%>/deleteFriend.do';
			var pars = 'id='+id;
			new Ajax.Request(url, {
				method :'post',
				parameters :pars,
				onComplete :deleteOk
			});

			
			}
		function deleteOk(originalRequest){
			jsonRaw = originalRequest.responseText;
			if(jsonRaw=='ok'){
				getModule1('${user.id}','1');
				
				}
			}
		}
	function getModule2(id,pageNo) {
		var url = '<%=request.getContextPath()%>/getMyBlogWords.do';
		var pars = 'id=' + id+'&pageNo='+pageNo;
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse2
		});
	}
	function deleteCom(id){
		var flag=confirm("确认删除？");
		if(flag){
			var url = '<%=request.getContextPath()%>/deleteBlogWord.do';
			var pars = 'id=' + id;
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
			getModule2('${sessionUser.id}');
			}
		}
	function showResponse2(originalRequest) {
		var uid = '${user.id}';
		var myid = '${sessionUser.id}'; 
	
		jsonRaw = originalRequest.responseText;
		if (jsonRaw) {
			words = eval("(" + jsonRaw + ")");
			var val = "<table  border=0 >";
			for (i = 0; i < words.results.length; i++) {
				val = val
						+ "<tr><td width='60' valign='top'><img width='50' src='<%= application.getAttribute("IMAGE_URL")%>"
						+ words.results[i].image+ "'/></td><td  width='300' style='word-break : break-all; overflow:hidden;'><a href='<%=request.getContextPath()%>/home/"
						+ words.results[i].userId + "/'>"
						+ words.results[i].realName + "</a>&nbsp;&nbsp;"
						+ words.results[i].addDate + "　　　　　　　　<a href='#' onclick=\"deleteCom('"+words.results[i].id+"')\">删除</a><br />"
						+ words.results[i].words + "</td>";
				if(uid==myid){
					val +="<td ></td>";
					}
				else{
					val +="<td>&nbsp;</td>";

					}
				val+="</tr>";
			}			
			val = val
					+ "</table>";
					var click = 'getModule2(\'${user.id}\',\'[no]\')';
					var pa = pagination(words.pageSum,words.no,words.next,words.pre,click);
					val +=pa;	
						
			document.getElementById("modeul2").innerHTML = val;
		} else {
			
		}
	}

	function getModule4(id,pageNo) {
		var url = '<%=request.getContextPath()%>/getMyVideoes.do';
		var pars = 'id=' + id+'&pageNo='+pageNo;
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse4
		});

	}
	function showResponse4(originalRequest) {
		jsonRaw = originalRequest.responseText;
		if (jsonRaw) {
			videoes = eval("(" + jsonRaw + ")");
			var length = videoes.results.length;
			if (length > 4) {
				length = 8;
			} else {
				length = 4;
			}
			var val = "<table width='100%'  >";
			for (i = 0; i < length; i++) {
				if (i % 4 == 0) {
					val = val + "<tr>";
				}
				if (i < videoes.results.length) {
					val = val
							+ "<td class='itable' width='120px' valign='top' width='25%'><a href='<%=request.getContextPath()%>/video/"+videoes.results[i].id+"/'><img src='<%= application.getAttribute("IMAGE_URL")%>"
							+ videoes.results[i].image+ "' width='120'/><br />"
							+ videoes.results[i].name + "</a><br />播放："
							+ videoes.results[i].browseCount + "<br />评论："
							+ videoes.results[i].commentCount + "</td>";
				} else {
					val = val + "<td width='20%'>&nbsp;</td>";
				}
				if (i % 4 == 3) {
					val = val + "</tr>";
				}
			}
			val = val + "</table>";
			var click = 'getModule4(\'${user.id}\',\'[no]\')';
			var pa = pagination(videoes.pageSum,videoes.no,videoes.next,videoes.pre,click);
			val +=pa;
			document.getElementById("modeul4").innerHTML = val;
		} else {
			document.getElementById("modeul4").innerHTML = '查无相关记录';
		}
	}

	function getModule5(id,pageNo) {
		var url = '<%=request.getContextPath()%>/getMyPlayBills.do';
		var pars = 'pageNo='+pageNo+'&id=' + id;
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse5
		});
	}
	function showResponse5(originalRequest) {
		jsonRaw = originalRequest.responseText;
		playBills = eval("(" + jsonRaw + ")");
		var length = playBills.results.length;
		if (length > 5) {
			length = 10;
		} else {
			length = 5;
		}
		var val = "<table width='90%' border='0' >";
		for (i = 0; i < length; i++) {
			if (i % 4 == 0) {
				val = val + "<tr>";
			}
			if (i < playBills.results.length) {
				val = val
						+ "<td width='25%'><a href='<%=request.getContextPath()%>/playbill/"+playBills.results[i].id+"/addDate/'><img src='<%= application.getAttribute("IMAGE_URL")%>"
						+ playBills.results[i].image
						+ "' width='120'/></a><br />"
						+ playBills.results[i].name + "<br />视频数："
						+ playBills.results[i].videoSize + "</td>";
			} else {
				val = val + "<td width='25%'>&nbsp;</td>";
			}
			if (i % 4 == 3) {
				val = val + "</tr>";
			}
		}
		val = val + "</table>";
		var click = 'getModule5(\'${user.id}\',\'[no]\')';
		var pa = pagination(playBills.pageSum,playBills.no,playBills.next,playBills.pre,click);
		val +=pa;
		document.getElementById("modeul5").innerHTML = val;
	}

	function getModule6(id) {
		var url = '<%=request.getContextPath()%>/getMyDailies.do';
		var pars = 'pageSize=4&id=' + id;
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse6
		});
	}
	function showResponse6(originalRequest) {
		jsonRaw = originalRequest.responseText;
		if (jsonRaw) {
			dailies = eval("(" + jsonRaw + ")");
			var val = "<table width='98%' border='0' cellspacing='11'>";
			for (i = 0; i < dailies.results.length; i++) {
				val = val + "<tr><td width='100%'><div class='daily'>"
						+ dailies.results[i].title + "<div>标签：";
				for (j = 0; j < dailies.results[i].tags.length; j++) {
					val = val + "<a href=''>" + dailies.results[i].tags[j].name
							+ "</a> ";
				}
				val = val + "<div><div><p>" + dailies.results[i].log
						+ "</p></div><div>评论：("
						+ dailies.results[i].commentCount + ") 浏览："
						+ dailies.results[i].browseTimes + " 分类："
						+ dailies.results[i].channelName
						+ "<a href='<%=request.getContextPath()%>/blog/"+dailies.results[i].id+"/'>全文</a></div></div></td></tr>"
			}
			val = val + "</table>";
			document.getElementById("modeul6").innerHTML = val;
		} else {
			document.getElementById("modeul6").innerHTML = '查无相关记录';
		}
	}

	function getModule7(id) {
		var url = '<%=request.getContextPath()%>/getBlogHistories.do';
		var pars = 'id=' + id + "&pageSize=5";
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse7
		});
		function showResponse7(originalRequest) {
			jsonRaw = originalRequest.responseText;
			if (jsonRaw) {
				var val = "<table width='98%' border='0' cellspacing='11'>";
				histories = eval("(" + jsonRaw + ")");
				for ( var i = 0; i < histories.results.length; i++) {
					val = val
							+ "<tr><td width='80px'><a href='<%=request.getContextPath()%>/home/"
							+ histories.results[i].userId + "/'><img width='50' src='<%= application.getAttribute("IMAGE_URL")%>"
							+ histories.results[i].userFace
							+ "'/></a></td><td width='200px'><a href='<%=request.getContextPath()%>/home/"
							+ histories.results[i].userId + "/'>"
							+ histories.results[i].realName + "</a><br />"
							+ histories.results[i].visitDate + "</td></tr>";
				}
				val = val + "</table>";
				$('module7').innerHTML = val;
			} else {
				$('module7').innerHTML = '无相关记录';
			}
		}
	}


	function getModule8(pageNo) {
		var url = '<%=request.getContextPath()%>/getEvents.do';
		var pars = 'pageNo=' + pageNo ;
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse8
		});
		function showResponse8(originalRequest) {
			jsonRaw = originalRequest.responseText;
			if (jsonRaw) {
				var val = "<table width='98%' border='0' cellspacing='5'>";
				paginations = eval("(" + jsonRaw + ")");
				
				for ( var i = 0; i < paginations.results.length; i++) {
				
					val += "<tr><td ><a href='<%=request.getContextPath()%>/home/"+paginations.results[i].user.id+"'>"+paginations.results[i].user.realName+"</a></td><td><a href='<%=request.getContextPath()%>/"+paginations.results[i].url+"'>"+paginations.results[i].description+"</a></td><td>"+formatDate(new Date(paginations.results[i].addDate['time']),'yyyy-MM-dd HH:mm:ss')+"</td></tr>";
						
				}
				val = val + "</table>";
			
				
				$('module8').innerHTML = val;
			} else {
				$('module8').innerHTML = '无相关记录';
			}
		}
	}

	function subscribe(type){
		var uid ='${sessionUser.id}';
		if(uid==''){
			alert('请先登录');
			}
		else{
			var suid = '${user.id}';
			location.href = "<%=request.getContextPath()%>/subscribeUser2.do?suid="+suid+"&type="+type;
			}
		
		}
</script>
<div class="side">
	<DIV class="module">
		<DIV class=title>
			<h2>
				${user.realName }
			</h2>
		</DIV>
		<DIV class="reDiv">
			<table width="98%" border="0">
				<tr>
					<td width="33%">
						<img src="<%= application.getAttribute("IMAGE_URL")%>${user.face }" width="120">
					</td>
					<td width="19%">
						<p>&nbsp;
							
						</p>
					</td>
					<td width="48%">
						<c:if test="${user.id!=sessionUser.id}">
							<p>
								<c:if test="${subscribeUser==false}">
								<a href="javascript://void(0);" onclick="subscribe('create')">订阅TA</a>
								</c:if>
								<c:if test="${subscribeUser==true}">
								<a href="javascript://void(0);" onclick="subscribe('delete')">取消订阅</a>
								</c:if>
								
							</p>
							
						</c:if>
						<c:if test="${user.id==sessionUser.id}">
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
							<c:if test="${user.gender=='m'}">男</c:if>
							<c:if test="${user.gender=='f'}">女</c:if>
							<c:if test="${user.gender=='s'}">保密</c:if>
							年龄:
							<c:if test="${not  empty user.birthday }">
							${user.age }
							</c:if>
							<c:if test="${empty user.birthday }">
							保密
							</c:if>
							<br>
							位置：
							${user.area }
							<br>
							积分:${user.score }
							<br>
							订阅：${user.subscribeCount } 被订阅：${user.beSubscribeCount }
							<br>
							视频：${user.videoCount } 节目单：${user.playBillCount }
							<br>
							<c:if test="${user.id!=sessionUser.id}">
								<a href="#" onclick="sendRequest('${sessionUser.id }','${user.id}')">加为好友</a>
								<a
									href="<%=request.getContextPath()%>/vblog/sendmessage/${user.id }/">给TA蜜语</a>
								<br>
								<a
									href="<%=request.getContextPath()%>/group/sendinvite/${ user.id}/">邀请加入圈子</a>
							</c:if>
							<c:if test="${user.id==sessionUser.id}">
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
				<c:if test="${sessionUser.id==user.id}">我的好友</c:if>
				<c:if test="${sessionUser.id!=user.id}">TA的好友</c:if>
			</h2>
		</DIV>
		<DIV id='modeul1' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
			<script type="text/javascript">
				getModule1('${user.id}','1');
			</script>
		</DIV>
	</DIV>


	<DIV class="module">
		<DIV class=title>
			<h2>
				谁来过
			</h2>
		</DIV>

		<DIV id='module7' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
			<script type="text/javascript">
				getModule7('${user.id}');
			</script>
		</DIV>
	</DIV>
	
	<DIV class="module">
		<DIV class=title>
			<span>共2条</span>
			<h2>
				访客留言
			</h2>
		</DIV>
<div class="reDiv">
<textarea id='word' rows='4' cols='35'></textarea>
<input  type="text" size="10"   id="input1" /><input type="text" onclick="createCode()" readonly="readonly" id="checkCode" class="unchanged" style="width: 50px"  />　　<c:if test="${not empty sessionUser }"></c:if><c:if test="${empty sessionUser }"><a href="<%=request.getContextPath()%>/login/"><img src="<%=request.getContextPath()%>/images/log.gif" /></a><a href="<%=request.getContextPath()%>/register/"><img src="<%=request.getContextPath()%>/images/reg2.gif" /></a></c:if>
<a class='submitComment' href='#' onclick='sendMessage()'></a>
</div>
	  <DIV id='modeul2' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
			<script type="text/javascript">
			createCode();
				getModule2('${user.id}','1');
			</script>
		</DIV>
	</DIV>
</div>
<div class="main">

<c:if test="${sessionUser.id == user.id}">
<DIV class="module">
		<DIV class=title>
			<h2>
				订阅用户
			</h2>
		</DIV>

		<DIV id='module8' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
			<script type="text/javascript">
				getModule8('1');
			</script>
		</DIV>
	</DIV>
</c:if>
	<DIV class="module">
		<DIV class=title>
<span>
<c:if test="${user.id!=sessionUser.id}">
<a href="<%=request.getContextPath()%>/user/${user.id }/videoes/1">更多</a>
</c:if>
<c:if test="${user.id==sessionUser.id}">
<a href="<%=request.getContextPath()%>/video/myvideolist/1/addDate/1">更多</a>
</c:if>
</span>
			<h2>
				<c:if test="${sessionUser.id==user.id}">我发布的视频</c:if>
				<c:if test="${sessionUser.id!=user.id}">TA发布的视频</c:if>
				
			</h2>
		</DIV>

		<DIV id='modeul4' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
			<script type="text/javascript">
				getModule4('${user.id}','1');
			</script>
		</DIV>
	</DIV>



	<DIV class="module">
		<DIV class=title>
			<h2>
				个人介绍
			</h2>
		</DIV>
		<DIV id='modeul3' class="reDiv">
			<c:if test="${empty user.signature}">这家伙很懒，什么都没留下。。</c:if>
			<c:if test="${not empty user.signature }">${user.signature}</c:if>
		</DIV>
	</DIV>
	<DIV class="module">
		<DIV class=title>
<span><a href="">更多</a></span>
			<h2>
				<c:if test="${sessionUser.id==user.id}">我创建的节目单</c:if>
				<c:if test="${sessionUser.id!=user.id}">TA创建的节目单</c:if>
				
			</h2>
		</DIV>
		<DIV id='modeul5' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
			<script type="text/javascript">
				getModule5('${user.id}','1');
			</script>
		</DIV>
	</DIV>
	<DIV class="module">
		<DIV class=title>
			<span><a
				href='<%=request.getContextPath()%>/blogList/${user.id }/'>查看全部日志</a>
			</span>
			<h2>
				<c:if test="${sessionUser.id==user.id}">我的日志</c:if>
				<c:if test="${sessionUser.id!=user.id}">TA的日志</c:if>
				
			</h2>
		</DIV>
		<DIV id='modeul6' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
			<script type="text/javascript">
				getModule6('${user.id}');
			</script>
		</DIV>
	</DIV>
</div>
