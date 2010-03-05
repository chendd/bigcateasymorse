<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function clean(cleanid,cleanname){
		if(confirm('该操作将会清空'+cleanname+'栏目下的所有视频!')){
			window.location.href='cleanVideoChannel.do?id='+cleanid;
		}
	}
	
	function deleteChannel(cleanid,cleanname){
		if(confirm('该操作将会删除'+cleanname+'栏目及该栏目下的所有视频!')){
			window.location.href='deleteVideoChannel.do?id='+cleanid;
		}
	}
</script>
<span style="color: red;">${errors }</span>
<table id="formattable" width="696" border="0" align="center">
	<tr>
		<th width="161" >
			<div align="center">
				栏目名称
			</div>
		</th>
		<th width="168" >
			<div align="center">
				WAP名称
			</div>
		</th>
		<th colspan="5" >

			<div align="center">
				操作选项
			</div>
		</th>
	</tr>
	<c:forEach items="${videoChanneList}" var="videoChannel">
		<tr>
			<td >
				<div align="center">
					${videoChannel.name }
				</div>
			</td>
			<td >
				<div align="center">
					${videoChannel.wapName }
				</div>
			</td>

			<td width="95" >
				<div align="center">
					<a href="addVideoChannel.do?id=${videoChannel.id}">添加子栏目</a>
				</div>
			</td>
			<td width="68" >
				<div align="center">
					<a href="updateVideoChannel.do?id=${videoChannel.id}">修改设置</a>
				</div>
			</td>
			<td width="74" >
				<div align="center">
					<a href="moveVideoChannel.do?id=${videoChannel.id}">移动栏目</a>
				</div>
			</td>
			<td width="44" >
				<div align="center">
					<a
						href="javascript:clean('${videoChannel.id}','${videoChannel.name}')">清空</a>
				</div>
			</td>
			<td width="44" >
				<div align="center">
					<a
						href="javascript:deleteChannel('${videoChannel.id}','${videoChannel.name}')">删除</a>
				</div>
			</td>
		</tr>
	</c:forEach>
</table>
