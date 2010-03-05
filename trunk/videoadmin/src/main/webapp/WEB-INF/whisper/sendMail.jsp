<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	FCKeditor fckEditor = new FCKeditor(request, "message");
%>


<%@page import="net.fckeditor.FCKeditor"%>
<script type="text/javascript">
function checkit(){
	var title = document.getElementById('title').value;
	if(title==''){
		alert("标题必填");
		return false;
		}
	else{
		var i = confirm("确定发送?");
		if(i){
			return true;
			}
		else{
			return false;
			}
		}
	
}
</script>
<div class="module">
<div class="title">
<span>注意：发送后每位用户都会收到该邮件</span>
<h2>群发邮件</h2></div>

<c:if test="${param.status==1}">
<div
	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
发送成功</div>

</c:if>
<div class="reDiv">
<form action="sendMail.do" method="post" onsubmit="return checkit();">
<table width="90%">
<tr><td>标题:<input type="text" id="title" name="title"/></td></tr>
<tr><td>
<%
					fckEditor.setValue("");
					fckEditor.setToolbarSet("Topic");
				
					
					out.println(fckEditor);
				%>
</td></tr>
<tr>
<td>
<div align="center"><input type="submit" value="发送"/></div>
</td>

</tr>

</table>
</form>
</div>
</div>

