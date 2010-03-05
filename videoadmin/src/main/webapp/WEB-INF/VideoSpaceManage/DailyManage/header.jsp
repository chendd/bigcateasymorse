<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="js/jquery/jquery.js"></script>
<script type="text/javascript" src="js/jquery/jquery.tablesorter.js"></script>
<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#formattable").tableSorter({
		stripingRowClass: ['odd','even'],	
		stripRowsOnStartUp: true		
	});
});
</script>
<table width="400" border="0" align="center">
	<tr>
		<td>
			<a href="addDaily.do">添加日志</a>
		</td>
		<td>
			<a href="dailyList.do">管理日志</a>
		</td>
		<td>
			<a href="dailyReplyList.do">评论管理</a>
		</td>
		<td>
			<a href="dailyChannelManage.do">分类管理</a>
		</td>
		<td>
			<a href="manageTemplate.do">模版管理</a>
		</td>
	</tr>
</table>
