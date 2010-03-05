<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="net.fckeditor.FCKeditor"%>
<%@page import="com.video.domain.DailyReply"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<link href="../sample.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
<script type="text/javascript">
	function FCKeditor_OnComplete(editorInstance) {
		window.status = editorInstance.Description;
	}
	
	function tijiao(){
		if(confirm('确认修改该评论？')){
			document.forms[0].submit();
		}
	}
</script>
<%
	FCKeditor fckEditor = new FCKeditor(request, "comment");
%>
<form action="updateDailyReply.do" method="post">
	<input type="hidden" name="flag" value="1" />
	<input type="hidden" name="id" value="${dailyReply.id }" />
	<table width="616" border="0">
		<tr>
			<td width="86">
				回复内容：			</td>
			<td width="520">
				<%
					fckEditor.setValue("");
					fckEditor.setToolbarSet("Basic");

					if (request.getAttribute("dailyReply") != null) {
						fckEditor.setValue(((DailyReply) request
								.getAttribute("dailyReply")).getComment());
					}
					out.println(fckEditor);
				%><span id="errors">${commenterror }</span>			</td>
		</tr>
		<tr>
			<td>
			  回复时间：		    </td>
			<td>
				${dailyReply.addDate }			</td>
		</tr>
		<tr>
			<td>
			  评分：		    </td>
			<td>
				<input type="text" value="${dailyReply.point }" name="point" />
				<span id="errors">${pointerror }</span>			</td>
		</tr>
		<tr>
			<td>
			  回复用户：		    </td>
			<td>
				${dailyReply.user.userName }			</td>
		</tr>
		<tr>
			<td>
			  日志标题：		    </td>
			<td>
				${dailyReply.daily.title }			</td>
		</tr>
  </table>
	<input type="button" value="修改" onclick="tijiao()" />
</form>