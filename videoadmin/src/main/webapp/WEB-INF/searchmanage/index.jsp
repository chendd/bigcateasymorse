<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function clean(cleanid,cleanname){
		if(confirm('该操作将会清空'+cleanname+'栏目下的所有内容!')){
			window.location.href='cleanSearchChannel.do?id='+cleanid;
		}
	}
	
	function deleteChannel(cleanid,cleanname){
		if(confirm('该操作将会删除'+cleanname+'栏目及该栏目下的所有内容!')){
			window.location.href='deleteSearchChannel.do?id='+cleanid;
		}
	}
</script>
<table id="formattable" width="356" border="0" align="center">
	<tr>
		<th width="119">
			<div align="center">
				名称
			</div>
		</th>
		<th width="288">
			<div align="center">
				操作
			</div>
		</th>
	</tr>
	<c:forEach items="${keywordChannelList}" var="channel">
		<tr>
			<td>
				<div align="center">
					${channel.name }
				</div>
			</td>
			<td>
				<div align="center">
					<a href="updateSearchChannel.do?id=${channel.id }">修改</a>
					<a href="addSystemKeyword.do?id=${channel.id }">添加关键词</a>
					<a href="javascript:clean('${channel.id}','${channel.name}')">清空</a>
					<a
						href="javascript:deleteChannel('${channel.id}','${channel.name}')">删除</a>
				</div>
			</td>
		</tr>
	</c:forEach>
</table>

