<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js">

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/rand_number.js"></script>
<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
	rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog/dialog.js"></script>
<script type="text/javascript">
function sendMessage(){
	
	var id = '${topic.id}';
	var word = $('word').value;
	var uid = '${sessionUser}';
	if(word==''){
		alert('你好没有输入留言信息');
		}
	
	
	else{
		if(uid==''){
			alert('请先登录');
			}
		else{var rand = $F('input1');
		rand = rand.toUpperCase();
		if(rand==code){
			createCode();
			
			var url = '<%=request.getContextPath()%>/createTopicComment.do';
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

		}
	
	function sendOk(originalRequest){
		jsonRaw = originalRequest.responseText;
		if(jsonRaw=='ok'){
			getComments('${topic.id}','1');
			}
		
		}
	
	
}


function getComments(id,pageNo) {

	var url = '<%=request.getContextPath()%>/getTopicComments.do';
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
	
		
		var val = "<table width='90%' border='0'  cellspacing='11'>";
		
		if(jsonRaw){
			var vv = '';
			var uid = '${sessionUser.id}';
			var tid = '${topic.user.id}'
			comments = eval("(" + jsonRaw + ")");
			
			for(i=0;i<comments.results.length;i++){
				if(uid!=''&&uid==tid){
					vv="<a href='#' onclick=\"deleteCom('"+comments.results[i].id+"')\">删除</a>"
					}
				
				val = val+"<tr><td width='15%'><a href='<%=request.getContextPath()%>/home/"+comments.results[i].userId+"/'><img width='50' src='<%= application.getAttribute("IMAGE_URL")%>"+comments.results[i].userFace+"'/></a></td><td width='70%'><div><a href='<%=request.getContextPath()%>/home/"+comments.results[i].userId+"/'>"+comments.results[i].realName+"</a> "+comments.results[i].addDate+"</div><div>"+comments.results[i].comment+"</div></td><td>"+vv+"</td></tr>";
				}
			val = val + "<tr><td colspan='3'><div align='center'>";

			var click = 'getComments(\'${topic.id}\',\'[no]\')';
			var pa = pagination(comments.pageSum,comments.no,comments.isNext,comments.isPrevious,click);
			val +=pa;
			
			
			val = val + "</div></td></tr>";
			val = val+"</table>";
			
		}
		
	
		$('module4').innerHTML = val;
		}
	

}


function deleteCom(id){
	var flag = confirm("确定删除？");
	if(flag){
		var url = '<%=request.getContextPath()%>/deleteTopicComment.do';
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
			getComments('${topic.id}','1');
			}
		}
	
}

function deleteTopic(){
	var id = '${topic.id}';
	var groupId= '${topic.group.id}';

	var flag = confirm("确定删除？");
	if(flag){
		self.location="<%=request.getContextPath()%>/deleteTopic.do?id="+id+"&groupId="+groupId;
		}
	
}

</script>
<div id="center">

	<div class="side">
		<DIV class="module">
			<DIV class=title>
				<h2>小组</h2>
			</DIV>
			<DIV id=''>
				<a href="<%=request.getContextPath()%>/group/${topic.group.id }/">浏览小组</a>
			</DIV>
		</DIV>
<c:if test="${sessionUser.id==topic.user.id}">
	<DIV class="module">
			<DIV class=title>
				<h2>话题管理</h2>
			</DIV>
			<DIV class='reDiv'>
<p class="sideButton">
				<a href="<%=request.getContextPath()%>/group/topic/update/${topic.id }">修改</a>
</p>
<p class="sideButton">
				<a href="#" onclick="deleteTopic()">删除</a>
</p>
			</DIV>
		</DIV>
</c:if>


		<DIV class="module">
			<DIV class=title>
				<h2>
					小组最新话题
				</h2>
			</DIV>

			<DIV class="reDiv">
				<c:forEach items="${topices}" var="tp">
					<a href="<%=request.getContextPath()%>/group/topic/${tp.id }/">${tp.title
						}</a>
					<br />
				</c:forEach>

			</DIV>


		</DIV>


	</div>
	<div class="main">
		<DIV class="module">
			<DIV class=title>
				<h2>
					${topic.title }
				</h2>
			</DIV>
			<DIV class="reDiv">
				<table width="90%">

				<tr>
						<td width="10%">
							<img width="60" src="<%= application.getAttribute("IMAGE_URL")%>${topic.user.face }" />
						</td>
						<td width="90%" >
							
							
							

						</td>
					</tr>
					
					
					<tr>
						<td >
							
						</td>
						<td  >
							
								${topic.text }
							

						</td>
					</tr>
				
				</table>
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
			<DIV id='module4' class="reDiv">
				<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
					width="20" />
				<script type="text/javascript">
				createCode();

				getComments('${topic.id}','1')</script>
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
						<img src="<%= application.getAttribute("IMAGE_URL")%>/${group.image }"
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

