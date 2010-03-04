<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<body>
	<script type="text/javascript">
	function checkit() {
		var text = document.getElementById('text').value;
		if (text == '') {
			alert("信息不能为空");
			return false;
		}
		else {
			return true;
		}
	
	}
</script>
	<div class="side">
		<div class="module">
			<div class="title">
				<h2>
					信箱
				</h2>
			</div>
			<div>
				<p class="sideButton">
<a href="<%=request.getContextPath()%>/vblog/mybox/">收件箱</a>
</p>
	<p class="sideButton">		
			<a href="<%=request.getContextPath()%>/vblog/mySendBox/">发件箱</a>
</p>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="module">
<c:if test="${sessionUser.id==whisper.toUser.id}">
			<div class="title">
				<span> <a href="<%=request.getContextPath()%>/vblog/mybox/">返回收件箱</a>
				</span>
				<h2>
					短信息
				</h2>
			</div>
			<div class="container fix">
				<div class="sortTable">
					发送时间：2008-10-15 20:18
					<br />
					来自：${whisper.fromUser.realName }
				</div>
				<div
					style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
					你正在查看的是一条普通短信，本站不会以任何形式在普通短信中发送官方的消息，请小心警惕。
				</div>
<div  style="width:95%" class="itable">${whisper.message }</div>
				<div class="sortTable">
					你的回复
				</div>
				<form action="<%=request.getContextPath()%>/createWhisper.do"
					method="post" name="form1" id="form1">
					<textarea rows="5" cols="60" id="text" name="text"></textarea>
					<input type="hidden" name="id" value="${whisper.fromUser.id}" />
					<br />
					<input type="submit" value="发送回复" onClick="return checkit();" />
			</div>
</c:if>


<c:if test="${sessionUser.id==whisper.fromUser.id}">
			<div class="title">
				<span> <a href="<%=request.getContextPath()%>/vblog/mySendBox/">返回发件箱</a>
				</span>
				<h2>
					短信息
				</h2>
			</div>
			<div class="reDiv">
				<div class="sortTable">
					发送时间：2008-10-15 20:18
					<br />
					发送给：${whisper.toUser.realName }
				</div>
			

				<pre style="text-align: left;">${whisper.message }</pre>
				<p class="msgContent" />
				
			</div>
</c:if>
		</div>
	</div>