<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="addSystemKeyword.do" method="post">
	<table width="283" border="0" align="center">
		<input type="hidden" name="flag" value="1" />
		<input type="hidden" name="action" value="${action }" />
		<tr>
			<td width="85">
				所属分类 ：
			</td>
			<td width="188">
				<select name="channelId">
					<c:forEach var="keywordChannels" items="${keywordChannelList}">
						<c:if test="${keywordChannels.id==keywordChannel.id}">
							<c:set var="select" value="selected" />
						</c:if>
						<c:if test="${keywordChannels.id!=keywordChannel.id}">
							<c:set var="select" value="" />
						</c:if>
						<option value="${keywordChannels.id }"${select }>
							${keywordChannels.name }
						</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				关键词：
			</td>
			<td>
				<input type="text" name="name" />
			</td>
		</tr>
		<tr>
			<td>
				点击量：
			</td>
			<td>
				<input type="text" name="viewTimes" value="0" />
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<input type="submit" name="Submit2" value="提交" />
				<input type="button" name="Submit3" value="取消"
					onclick="javascript:history.go(-1);" />
			</td>
		</tr>
	</table>
</form>