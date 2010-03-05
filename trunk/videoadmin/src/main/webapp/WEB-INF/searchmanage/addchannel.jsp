<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="addSearchChannel.do" method="post">

	<input type="hidden" name="flag" value="1" />
	<table width="256" border="0" align="center">
		<span style="color: red; content: ">${errors }</span>
		<tr>
			<td width="68">
				分类名称:
			</td>
			<td width="178">
				<input type="text" name="name" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" name="Submit" value="提交" />
			</td>
			<td>
				<input type="button" name="Submit3" value="取消"
					onclick="javascript:history.go(-1);" />
			</td>
		</tr>
	</table>
</form>