<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 



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
<div class="title"><span><a href="<%=request.getContextPath()%>/group/${topic.group.id }">返回${topic.group.name }</a></span><h2>编辑话题</h2></div>
<div class="reDiv">
			<div id="mss" 
	style="display: none;border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
${message }</div>
<form action="<%=request.getContextPath()%>/updateTopic.do" method="post" name="form1" id="form1" onsubmit="return checkit();">
<table width="80%">
<tr><td width="10%">标题</td><td width="90%" ><div align="left"><input type="text" id="title" name="title" value="${topic.title }"/><input type="hidden"  name="id" value="${topic.id }"/></div></td></tr>
<tr><td>内容</td><td>
<script language=javascript>
	
	window.$=function(obj){return typeof(obj)=="string"?document.getElementById(obj):obj}
	

	
</script>

<IFRAME id="rte" src="<%=request.getContextPath()%>/js/editor/editor.jsp?target1=otext1&target2=otext2" frameBorder=0 style="width:600Px;height:400Px;"></IFRAME>
<input type="hidden" value="" name="otext1" id="otext1">
<input type="hidden" value="" name="otext2" id="otext2">
<input type="hidden" value="<%=request.getContextPath()%>/getTopic.do?id=${topic.id }" id="otext3" />

</td></tr>
<tr><td></td><td>
<input type="submit" value="提交" />
</td></tr>
</table>

</form>
</div>


</div>

