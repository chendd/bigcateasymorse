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
				视频栏目管理
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<div align="center">
				管理导航:
				<a href="videoChannelIndex.do">视频栏目管理首页</a>|
				<a href="addVideoChannel.do">添加视频栏目</a>|
				<a href="uniteVideoChannel.do">视频栏目合并</a>
			</div>
		</td>
	</tr>
</table>
