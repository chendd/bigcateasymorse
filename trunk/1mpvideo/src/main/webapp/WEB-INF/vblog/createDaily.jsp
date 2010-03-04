<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/editor/bajax.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/editor/insertContent.js"></script>


<script type="text/javascript">
	function checkit() {
		var title = $F('title');
		var otext1 = $F('otext1');
		var otext2 = $F('otext2');
		var message = '';
		if (title == '' || otext1 == '' || otext2 == '') {
			message = '标题和内容都不能为空';
		}
		if (message != '') {
			$('mss').style.display = '';
			$('mss').innerHTML = message;
			return false;
		} else {
			return true;
		}

	}
	function winload(funobj) {
		if (document.all)
			window.attachEvent('onload', funobj)
		else
			window.addEventListener('load', funobj, false);
	}

	function iCon() {
		var ic1 = new insertContent();
		ic1.texturl_id = "otext3";
		ic1.editer_id = "rte";
		ic1.done();
	}

	winload(iCon);
</script>

<div class="module">
<div class="title">
<h2>发布新日志</h2>
</div>
<div align="center">
<div id="mss"
	style="display: none; border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
${message }</div>

<form action="<%=request.getContextPath()%>/createDaily.do"
	method="post" onsubmit="return checkit();">
<table width="90%">
	<tr>
		<td>标题</td>
		<td><input type="text" id="title" name="title" /></td>
	</tr>
	<tr>
		<td>分类</td>
		<td><select name="channelId">
			<c:forEach var="channel" items="${channels}">
				<option value="${channel.id }">${channel.name }</option>
			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td>标签</td>
		<td><input type="text" name="tags" />(多个可用;隔开)</td>
	</tr>

	<tr>
		<td>小组</td>
		<td>
			
			<select name="gids" multiple="multiple">
<c:forEach items="${groups}" var="group">
			<option value="${group.id }">${group.name }</option>
</c:forEach>
			</select>
<div>同时发表到小组话题中，请选择小组，按住ctrl键可进行多选</div>
		</td>
	</tr>

	<tr>
		<td>正文</td>
		<td><script language=javascript>
	window.$ = function(obj) {
		return typeof (obj) == "string" ? document.getElementById(obj) : obj
	}
</script> <IFRAME id="rte"
			src="<%=request.getContextPath()%>/js/editor/editor.jsp?target1=otext1&target2=otext2"
			frameBorder=0 style="width: 600Px; height: 400Px;"></IFRAME> <input
			type="hidden" value="" name="otext1" id="otext1"> <input
			type="hidden" value="" name="otext2" id="otext2"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="发布日志" /></td>
	</tr>
</table>
</form>
</div>
</div>


