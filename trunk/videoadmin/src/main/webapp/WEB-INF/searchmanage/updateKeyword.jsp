<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="updateSystemKeyword.do" method="post">
	<table width="283" border="0" align="center">
		<input type="hidden" name="flag" value="1" />
		<tr>
			<td>
				关键词：
			</td>
			<td>
				<input type="hidden" name="id" value="${keyword.id }" />
				<input type="hidden" name="channelId" value="${keyword.channelId }" />
				<input type="text" name="name" value="${keyword.name }" />
			</td>
		</tr>
		<tr>
			<td>
				点击量：
			</td>
			<td>
				<input type="text" name="viewTimes" value="${keyword.viewTimes }" />
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