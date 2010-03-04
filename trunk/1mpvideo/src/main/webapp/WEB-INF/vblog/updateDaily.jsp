<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<div class="module">
			<div class="title">
				<h2>修改日志</h2>
			</div>
			<div align="center">
				<div id="mss" 
	style="display: none;border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
${message }</div>
				<form action="<%=request.getContextPath()%>/updateDaily.do" method="post" onsubmit="return checkit();">
					<table width="90%">
						<tr>
							<td>
								标题
							</td>
							<td>
								<input type="hidden" name="id" value="${daily.id }"/>
								<input type="text" name="title" value="${daily.title }"/>
							</td>
						</tr>
						<tr>
							<td>
								分类
							</td>
							<td>
								<select name="channelId">
									<c:forEach var="channel" items="${channels}">

										<option value="${channel.id }" <c:if test="${daily.channel.id==channel.id }">selected="selected"</c:if>>
											${channel.name }
										</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								正文
							</td>
							<td>
									<script language=javascript>
	
	window.$=function(obj){return typeof(obj)=="string"?document.getElementById(obj):obj}
	

	
</script>

<IFRAME id="rte" src="<%=request.getContextPath()%>/js/editor/editor.jsp?target1=otext1&target2=otext2" frameBorder=0 style="width:600Px;height:400Px;"></IFRAME>
<input type="hidden" value="" name="otext1" id="otext1">
<input type="hidden" value="" name="otext2" id="otext2">
<input type="hidden" value="<%=request.getContextPath()%>/getDaily.do?id=${daily.id }" id="otext3" />
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<input type="submit" value="更新日志" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
