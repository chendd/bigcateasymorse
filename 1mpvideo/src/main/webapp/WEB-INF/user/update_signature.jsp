<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/bajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/editor/insertContent.js"></script>

<script type="text/javascript">
function checkit(){
	var title = $F('title');
	var otext1=$F('otext1');
	var otext2=$F('otext2');
	var message = '';
	if(title==''||otext1==''||otext2==''){
		message = '标题和内容都不能为空';
	}
	if(message!=''){
		$('mss').style.display='';
		$('mss').innerHTML=message;
		return false;
	}
	else{
		return true;
	}


		
	}
	function winload(funobj){
		if (document.all)
			window.attachEvent('onload',funobj)
		else
			window.addEventListener('load',funobj,false);
	}

	function iCon(){
		var ic1 = new  insertContent();
		ic1.texturl_id="otext3";
		ic1.editer_id="rte";
		ic1.done();
	}

	winload(iCon);
</script>
<div class="side">
	<div class="module">
		<div class="title">
			<h2>
				博客设置
			</h2>
		</div>
		<div class="moduleval">
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/face/">修改头像</a>
			</p>
			<p class="sideButton">
				<a>个性签名</a>
			</p>
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				账户设置
			</h2>
		</div>
		<div class="moduleval">
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/info/">个人资料</a>
			</p>
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/email/">电子邮件</a>
			</p>
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/password/">修改密码</a>
			</p>
		</div>
	</div>
</div>
<div class="main">
<div class="module">
	<div class="title">
		<span><a
			href="<%=request.getContextPath()%>/home/${sessionUser.id }/">返回您的首页</a>
		</span>
		<h2>
			修改头像
		</h2>
	</div>
	<c:if test="${not empty message }">
		<div
			style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
			${message }
		</div>
	</c:if>
	<div class="moduleval" style="height: 300px">
		<form action="<%=request.getContextPath()%>/updateSignature.do"
			method="post">
			<script language=javascript>
	
	window.$=function(obj){return typeof(obj)=="string"?document.getElementById(obj):obj}
	

	
</script>

<IFRAME id="rte" src="<%=request.getContextPath()%>/js/editor/editor.jsp?target1=otext1&target2=otext2" frameBorder=0 style="width:450Px;height:300Px;"></IFRAME>
<input type="hidden" value="" name="signature" id="otext1">
<input type="hidden" value="" name="otext2" id="otext2">
<input type="hidden" value="<%=request.getContextPath()%>/getSignature.do?i=1" id="otext3" />

			<input type="submit" value="修改" />
		</form>
	</div>
</div>
</div>