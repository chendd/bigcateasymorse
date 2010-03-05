<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
function selectAll(){
	var keywordIds = document.getElementsByName("keywordId");
	for(var i=0;i<keywordIds.length;i++){
		keywordIds[i].checked = document.getElementById('checkAll').checked;
	}
}
function getKeyword(){
	var channelindex = document.getElementById("keywordChannelId").selectedIndex;
	var channelId = document.getElementById("keywordChannelId").options[channelindex].value;
	window.location.href="getKeyword.do?id="+channelId+"&flag=1";
}
function addKeyword(){
	var channelindex = document.getElementById("keywordChannelId").selectedIndex;
	var channelId = document.getElementById("keywordChannelId").options[channelindex].value;
	window.location.href="addSystemKeyword.do?id="+channelId+"&action=keywordindex";
}
function deleteKeywords(){
	if(confirm('确认删除关键字?')){
		document.forms[0].submit();
	}
}
function deleteKeyword(keywordId){
	if(confirm('确认删除关键字?')){
		window.location.href="deleteKeyword.do?id="+keywordId;
	}
}
</script>
<form action="deleteKeyword.do" method="post">
	<p align="center">
		<select name="keywordChannelId" id="keywordChannelId"
			onchange="getKeyword();">
			<c:forEach var="keywordChannel" items="${keywordChannelList}">
				<c:if test="${keywordChannelId==keywordChannel.id}">
					<c:set var="select" value="selected" />
				</c:if>
				<c:if test="${keywordChannelId!=keywordChannel.id}">
					<c:set var="select" value="" />
				</c:if>
				<option value="${keywordChannel.id }"${select }>
					${keywordChannel.name }
				</option>
			</c:forEach>
		</select>
	</p>
	<table id="formattable" width="728" border="0" align="center">
		<tr>
			<th width="69">
				<input type="checkbox" id="checkAll" onclick="selectAll();" />
				选择
			</th>
			<th width="139">
				名称
			</th>
			<th width="70">
				今日点击
			</th>
			<th width="70">
				昨日点击
			</th>
			<th width="74">
				前天点击
			</th>
			<th width="86">
				总点击
			</th>
			<th width="190">
				操作
			</th>
		</tr>
		<c:forEach var="keyword" items="${keywordList}">
			<tr>
				<td>
					<input type="checkbox" id="keywordId" name="keywordIds"
						value="${keyword.id }" />
				</td>
				<td>
					${keyword.name }
				</td>
				<td>
					${keyword.today }
				</td>
				<td>
					${keyword.yesterday }
				</td>
				<td>
					${keyword.beforeYesterday }
				</td>
				<td>
					${keyword.viewTimes }
				</td>
				<td>
					<a href="updateSystemKeyword.do?id=${keyword.id }">修改</a>
					<a href="javascript:deleteKeyword(${keyword.id });">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<input type="button" value="删除" onclick="deleteKeywords();" />
		<input type="button" value="添加" onclick="addKeyword();" />
	</div>
</form>