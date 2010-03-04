<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>







<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>


<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/win/effects.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/win/win.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/win/win_effects.js"></script>

<link href="<%=request.getContextPath()%>/themes/default.css"
	rel="stylesheet" type="text/css"></link>


<link href="<%=request.getContextPath()%>/themes/alphacube.css"
	rel="stylesheet" type="text/css"></link>





<script type="text/javascript">
function infoTimeout() {
	Dialog.closeInfo()
}
function exportit() {
	var msnCount = document.getElementById('msnCount').value;
	var msnPass = document.getElementById('msnPass').value;
	if(msnCount==''||msnPass==''){
		alert("MSN帐号或密码不能为空!");
		}
	else{
	
	Dialog.info("Loading........", {
		className: "alphacube",
		width : 100,
		height : 50,
		showProgress : true
	});
	var url = '<%=request.getContextPath()%>/getMsnFriends.do';
	var pars = 'msnCount=' + msnCount + "&msnPass=" + msnPass;
	new Ajax.Request(url, {
		method : 'post',
		parameters : pars,
		onComplete : exportok
	});
	}
}
function exportok(originalRequest) {
	jsonRaw = originalRequest.responseText;
	setTimeout(infoTimeout, 1000)
	msnUsers = eval("(" + jsonRaw + ")");
	if(msnUsers.length>0){
	
	
	$('load').style.display='none';
	$('list').style.display='';
	var val = '<table width="98%"><tr><td ><input type="checkbox" id="all" onclick="selectAll();"/></td><td>全选</td><td></td></tr>';
	for(var i=0;i<msnUsers.length;i++){
		val+='<tr><td><input name="emails" value="'+msnUsers[i].email+'" type="checkbox" /></td><td>'+msnUsers[i].name+'</td><td>'+msnUsers[i].email+'</td></tr>';
		}
	val += '</table>';

	document.getElementById('friends').innerHTML=val;
	}
	else{
		$('message').style.display='';
		}
}

function selectAll(){
	
	var aa = document.getElementsByName("emails");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;

}

function checkit(){
	

}
</script>


<div class="side">
<div class="module">
<div class="title">
<h2>友情提示</h2>
</div>
<div class="reDiv">我们不会存储你的MSN密码，请放心使用。<br />
你也可以先改密码再导入，成功后再改回原始<br />
密码，确保密码安全。</div>
</div>
</div>


<div class="main">
<div class="module">
<div class="title">
<h2>导入好友</h2>
</div>
<div class="reDiv">
<div id="load">
<div id="message"
 	style="display: none;border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
抱歉，您的通讯录没有任何联系人。 </div>
<div>从我的MSN导入朋友名单，选择待邀请人并发送邀请邮件</div>

<table>
	<tr>
		<td>MSN账号：</td>
		<td><input type="text" name="msnCount" id="msnCount" /></td>
	</tr>
	<tr>
		<td>MSN密码：</td>
		<td><input type="password" name="msnPass" id="msnPass" /></td>
	</tr>
	<tr>
		<td></td>
		<td>
		<button onclick="exportit();">导入</button>
		</td>
	</tr>
</table>

</div>


<div id="list" style="display: none;">
<form action="<%=request.getContextPath()%>/sendMail.do" method="post">以下是该通讯录里的其他联系人，请选择邀请对象
<div id="friends"
	style="width: 80%; height: 250px; border: 1px silver solid; overflow-x: hidden; overflow-y: scroll;">


</div>
<br />
邀请留言：<br />
<textarea rows="5" cols="40" name="">
　　我的几个朋友开发了一个好玩的网站，叫开心网，现在正在进行测试。我的几个好友已经在上面注册了。如果你在开心网成为我的好友，你可以查看我的最新照片、日记、了解我的最新动态...
　　这个网站还可以在线听歌或点歌给好友、提供1G空间的网络硬盘；可以拥抱一下好友、向好友抛个媚眼、送礼物给好友；可以测测你跟朋友的姓名缘分...有很多好玩的功能。
</textarea> <br />
<br />
您的姓名：<input type="text" name="" value="${sessionUser.realName }" /><br />
<br />
<input type="submit" value="邀请" /> &nbsp;
<button>返回</button>

</form>
</div>


</div>





</div>
</div>

