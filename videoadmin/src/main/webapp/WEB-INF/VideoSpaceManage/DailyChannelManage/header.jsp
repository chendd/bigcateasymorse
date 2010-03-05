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
<table width="961" border="0" align="center">
	<tr>
		<td>
			<div align="center">
				日志栏目管理
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center">
				管理导航:
				<a href="dailyChannelManage.do">日志栏目管理首页</a>|
				<a href="dailyChannelManage.do?method=add">添加日志栏目</a>|
				<a href="dailyChannelManage.do?method=root">一级栏目排序</a>|
				<a href="dailyChannelManage.do?method=child">N级栏目排序</a>|
				<a href="dailyChannelManage.do?method=reposition">复位所有日志栏目</a>|
				<a href="dailyChannelManage.do?method=unite">日志栏目合并</a>
			</div>
		</td>
	</tr>
</table>
