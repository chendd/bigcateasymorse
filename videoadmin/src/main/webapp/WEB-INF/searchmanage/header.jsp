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
<table width="329" border="0" align="center">
	<tr>
		<td width="55">
			<a href="addSearchChannel.do">添加分类</a>
		</td>
		<td width="55">
			<a href="indexSearchChannel.do">分类管理</a>
		</td>
		<td width="70">
			<a href="getKeyword.do">关键词管理</a>
		</td>
		<td width="70">
			<a href="keywordChannelOrder.do">分类排序</a>
		</td>
	</tr>
</table>

