<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="net.fckeditor.*"%>
<%@page import="com.video.domain.Daily"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="time" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<link href="../sample.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
<script type="text/javascript">
	function FCKeditor_OnComplete(editorInstance) {
		window.status = editorInstance.Description;
	}
</script>
<%
	FCKeditor fckEditor = new FCKeditor(request, "log");
%>
<form action="addDaily.do" method="post" name="dailyForm">
	<table width="815" border="0" align="center">
		<tr>
			<td colspan="2">
				<div align="center">
					--修改日志--
				</div>
			</td>
		</tr>
		<tr>
			<td width="98">
				所属栏目：
			</td>
			<td width="617">

				<select name="channelIdString">
					<c:forEach items="${dailyChannelList}" var="dailyChannels">
						<c:choose>
							<c:when test="${dailyChannels.id==daily.channelIdString}">
								<c:set value="selected=&quot;seleced&quot;" var="parent" />
							</c:when>
							<c:otherwise>
								<c:set value="" var="channel" />
							</c:otherwise>
						</c:choose>
						<option value="${dailyChannels.id }"${channel }>
							${dailyChannels.name }
						</option>
					</c:forEach>
				</select>
				<span id="errors"><html:errors property="channelId" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				所属用户ID:
			</td>
			<td>
				<input type="text" name="userId" value="${daily.userId }" />
				<span id="errors"><html:errors property="userId" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				文章标题：
			</td>
			<td>
				<input type="text" name="title" value="${daily.title }" />
				<span id="errors"><html:errors property="title" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				标签：
			</td>
			<td>
				<input type="text" name="tagsString"
					value="${daily.tagsString }" />
				*中间用“|”分开，不能出现&quot;&quot;'*?,.()等字符。
				<span id="errors"><html:errors property="tagsString" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				文章内容：
			</td>
			<td>
				<%
					fckEditor.setValue("");
					fckEditor.setToolbarSet("Basic");

					if (request.getAttribute("daily") != null) {
						fckEditor.setValue(((Daily) request
								.getAttribute("daily")).getLog());
					}
					out.println(fckEditor);
				%>
				<span id="errors"><html:errors property="log" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				文章阅读等级：
			</td>
			<td>
				<select name="grade">
					<c:forEach items="${readGradeList}" var="readGrade">
						<c:choose>
							<c:when test="${readGrade.id==daily.grade}">
								<c:set value="selected=&quot;seleced&quot;" var="readGrades" />
							</c:when>
							<c:otherwise>
								<c:set value="" var="readGrades" />
							</c:otherwise>
						</c:choose>
						<option value="${readGrade.id }"${readGrades }>
							${readGrade.name}
						</option>
					</c:forEach>
				</select>
				只有具有相应权限的人才能阅读此文章。
				<span id="errors"><html:errors property="grade" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				文章阅读点数：
			</td>
			<td>
				<input type="text" name="expense" value="${daily.expense }" />
				如果大于0，则用户阅读此文章时将消耗相应点数。（对游客和管理员无效）
				<span id="errors"><html:errors property="expense" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				包含图片：
			</td>
			<td>
				<input type="checkbox" name="checkbox" value="checkbox" />
				是（如果选中的话会在标题前面显示[图文]）
			</td>
		</tr>
		<tr>
			<td>
				文章性质：
			</td>
			<td>
				<input type="checkbox" name="top" value="true" />
				固顶文章
				<input type="checkbox" name="hot" value="true" />
				热点文章
				<input type="checkbox" name="recommend" value="true" />
				推荐文章
			</td>
		</tr>
		<tr>
			<td>
				文章评分等级:
			</td>
			<td>
				<input type="radio" name="point" value="1" />
				1分
				<input type="radio" name="point" value="2" />
				2分
				<input type="radio" name="point" value="3" checked="checked" />
				3分
				<input type="radio" name="point" value="4" />
				4分
				<input type="radio" name="point" value="5" />
				5分
				<span id="errors"><html:errors property="point" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				点击数初始值：
			</td>
			<td>
				<input type="text" name="browseTimes"
					value="${daily.browseTimes }" />
				这功能是提供给管理员作弊用的。不过尽量不要用呀！^_^
				<span id="errors"><html:errors property="browseTimes" /> </span>
			</td>
		</tr>
		<tr>
			<td>
				录入时间：
			</td>
			<td>
				<time:calendar name="addDateString" id="addDate" />
				-
				<select name="addDateHH">
					<%
						for (int i = 0; i < 24; i++) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%
						}
					%>
				</select>
				时 -
				<select name="addDatemm">
					<%
						for (int i = 0; i < 60; i++) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%
						}
					%>
				</select>
				分-
				<select name="addDatess">
					<%
						for (int i = 0; i < 60; i++) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%
						}
					%>
				</select>
				秒
				<span id="errors"><html:errors property="addDate" /> </span>
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" name="Submit" value="添加" />
				<input type="button" name="Submit2" value="预览" />
				<input type="button" name="Submit3" value="取消"
					onclick="javascript:history.go(-1);" />
			</td>
		</tr>
	</table>
</form>