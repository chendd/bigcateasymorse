<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.video.util.Pagination"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
function findDailyByChannelId(){
	var channelindex = document.getElementById("channelIdString").selectedIndex;
	var channelId = document.getElementById("channelIdString").options[channelindex].value;
	window.location.href="dailyList.do?channelId="+channelId;
}

function selectAllDaily(){
	var dailyIds = document.getElementsByName("dailyId");
	for(var i=0;i<dailyIds.length;i++){
		dailyIds[i].checked = document.getElementById('selectAll').checked;
	}
}

function moveDaily(){
	var moveChannelindex = document.getElementById("moveChannelIdString").selectedIndex;
	var moveChannelId = document.getElementById("moveChannelIdString").options[moveChannelindex].value;
	
	var channelindex = document.getElementById("channelIdString").selectedIndex;
	var channelId = document.getElementById("channelIdString").options[channelindex].value;
	
	document.getElementById("moveChannelId").value=moveChannelId;
	document.getElementById("method").value="move";
	document.getElementById("channelId").value = channelId;
	
	document.forms[0].submit();
}

function findDaily(){
	var dailyTitle = document.getElementById("findDailyTitle");
	var keyWord = document.getElementById("keyWord");
	
	var channelindex = document.getElementById("channelIdKey").selectedIndex;
	var channelId = document.getElementById("channelIdKey").options[channelindex].value;
	
	if(dailyTitle.value=="日志标题"){
		dailyTitle.value="";
	}
	
	if(keyWord.value=="关键字"){
		keyWord.value="";
	}
	
	document.getElementById("channelId").value = channelId;
	document.getElementById("method").value="find";
	document.forms[0].submit();
}
function clean(keytext){
	keytext.value="";
}
function toPage(){
	var pageindex = document.getElementById("pages").selectedIndex;
	var pageurl = document.getElementById("pages").options[pageindex].value;
	window.location.href=pageurl;
}
function deleteDaily(actionid,actionname){
if(confirm('确认删除日志'+actionname+'?')){
	document.getElementById("method").value="deleteDaily";
	document.getElementById("actionId").value=actionid;
	document.forms[0].submit();
	}
}
function deleteDailys(){
	document.getElementById("method").value="deleteDailys";
	document.forms[0].submit();
}
function topDaily(actionid){
	document.getElementById("method").value="topDaily";
	document.getElementById("actionId").value=actionid;
	document.forms[0].submit();
}
function recommendDaily(actionid){
	document.getElementById("method").value="recommend";
	document.getElementById("actionId").value=actionid;
	document.forms[0].submit();
}
</script>
<form action="dailyList.do" method="post">
	<input type="hidden" id="moveChannelId" name="moveChannelId" />
	<input type="hidden" id="method" name="method" />
	<input type="hidden" id="channelId" name="channelId" />
	<input type="hidden" id="actionId" name="id" />
	<p>
		所在栏目：
		<select name="channelIdString" onchange="findDailyByChannelId()">
			<option value="all">
				所有
			</option>
			<c:forEach items="${dailyChannelList}" var="dailyChannels">
				<c:choose>
					<c:when test="${dailyChannels.id==channelId}">
						<c:set value="selected=&quot;seleced&quot;" var="channelselect" />
					</c:when>
					<c:otherwise>
						<c:set value="" var="channelselect" />
					</c:otherwise>
				</c:choose>
				<option value="${dailyChannels.id }"${channelselect } >
					${dailyChannels.name }
				</option>
			</c:forEach>
		</select>
	</p>
	<table id="formattable" width="810" border="0" align="center">
		<tr>
			<th width="65">
				<div align="center">
					选中
					<input type="checkbox" id="selectAll" name="selectAll" value="all"
						onclick="selectAllDaily()" />
				</div>
			</th>
			<th width="48">
				<div align="center">
					ID
				</div>
			</th>
			<th width="133">
				<div align="center">
					文章标题
				</div>
			</th>
			<th width="74">
				<div align="center">
					作者
				</div>
			</th>
			<th width="53">
				<div align="center">
					点击数
				</div>
			</th>
			<th width="127">
				<div align="center">
					文章属性
				</div>
			</th>
			<th width="280">
				<div align="center">
					操作
				</div>
			</th>
		</tr>
		<c:forEach items="${dailyPage.results}" var="daily">
			<tr>
				<td>
					<div align="center">
						<input type="checkbox" name="dailyId" value="${daily.id }" />
					</div>
				</td>
				<td>
					<div align="center">
						${daily.id }
					</div>
				</td>
				<td>
					<div align="center">
						${daily.title }
					</div>
				</td>
				<td>
					<div align="center">
						${daily.user.userName }
					</div>
				</td>
				<td>
					<div align="center">
						${daily.browseTimes }
					</div>
				</td>
				<td>
					<div align="center">
						<c:if test="${daily.topDate!=null}">顶</c:if>
						<c:if test="${daily.topDate==null}">&nbsp; &nbsp; 
						</c:if>
						<c:if test="${daily.hotDate!=null}">热</c:if>
						<c:if test="${daily.hotDate==null}">&nbsp; &nbsp; 
						</c:if>
						<c:if test="${daily.recommendDate!=null}">荐</c:if>
						<c:if test="${daily.recommendDate==null}">
						</c:if>
					</div>
				</td>
				<td>
					<div align="center">
						<a href="initUpdateDaily.do?id=${daily.id }">修改</a>
						<a href="javascript:deleteDaily(${daily.id },'${daily.title }')">删除</a>
						<a href="moveDaily.do?id=${daily.id }">移动</a>
						<c:if test="${daily.topDate!=null}">置顶</c:if>
						<c:if test="${daily.topDate==null}">
							<a href="javascript:topDaily(${daily.id })">置顶</a>
						</c:if>
						<c:if test="${daily.recommendDate!=null}">设为推荐</c:if>
						<c:if test="${daily.recommendDate==null}">
							<a href="javascript:recommendDaily(${daily.id })">设为推荐</a>
						</c:if>

					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<input type="button" value="删除所选日志" onclick="deleteDailys()" />
		<input type="button" value="所选日志移动到" onclick="moveDaily()" />
		<select name="moveChannelIdString">
			<c:forEach items="${dailyChannelList}" var="dailyChannels">
				<c:choose>
					<c:when test="${dailyChannels.id==dailyForm.channelIdString}">
						<c:set value="selected=&quot;seleced&quot;" var="parent" />
					</c:when>
					<c:otherwise>
						<c:set value="" var="channel" />
					</c:otherwise>
				</c:choose>
				<option value="${dailyChannels.id }"${channel } >
					${dailyChannels.name }
				</option>
			</c:forEach>
		</select>
	</div>
	<div align="center">
		<div align="center">
			<a
				href="dailyList.do?pageNo=1<c:if test="${not(empty findDailyTitle) }">&findDailyTitle=${findDailyTitle }</c:if>
				<c:if test="${not(empty keyWord )}" >&keyWord=${keyWord }</c:if>
				<c:if test="${not(empty method )}" >&method=${method }</c:if>
				<c:if test="${not(empty channelId) }" >&channelId=${channelId }</c:if>">首页</a>

			<c:if test="${dailyPage.previous}">
				<a
					href="dailyList.do?pageNo=${dailyPage.no-1}<c:if test="${not(empty findDailyTitle) }">&findDailyTitle=${findDailyTitle }</c:if>
				<c:if test="${not(empty keyWord )}" >&keyWord=${keyWord }</c:if>
				<c:if test="${not(empty method )}" >&method=${method }</c:if>
				<c:if test="${not(empty channelId) }" >&channelId=${channelId }</c:if>">上一页</a>
			</c:if>
			<c:if test="${!dailyPage.previous}">上一页
			</c:if>
			<c:if test="${dailyPage.next}">
				<a
					href="dailyList.do?pageNo=${dailyPage.no+1}<c:if test="${not(empty findDailyTitle) }">&findDailyTitle=${findDailyTitle }</c:if>
				<c:if test="${not(empty keyWord )}" >&keyWord=${keyWord }</c:if>
				<c:if test="${not(empty method )}" >&method=${method }</c:if>
				<c:if test="${not(empty channelId) }" >&channelId=${channelId }</c:if>">下一页</a>
			</c:if>
			<c:if test="${!dailyPage.next}">下一页</c:if>
			<a
				href="dailyList.do?pageNo=${dailyPage.pageSum}<c:if test="${not(empty findDailyTitle) }">&findDailyTitle=${findDailyTitle }</c:if>
				<c:if test="${not(empty keyWord )}" >&keyWord=${keyWord }</c:if>
				<c:if test="${not(empty method )}" >&method=${method }</c:if>
				<c:if test="${not(empty channelId) }" >&channelId=${channelId }</c:if>">尾页</a>
			页次：${dailyPage.no}/${dailyPage.pageSum}页 ${dailyPage.size}个日志/页 转到
			<select onchange="toPage()" id="pages">
				<%
					Pagination pagin = (Pagination) request.getAttribute("dailyPage");
					for (int i = 1; i <= pagin.getPageSum(); i++) {
				%>
				<option <%if(pagin.getNo()==i){%> selected="selected" <%} %>
					value="dailyList.do?pageNo=<%=i%><c:if test="${not(empty findDailyTitle) }">&findDailyTitle=${findDailyTitle }</c:if>
				<c:if test="${not(empty keyWord )}" >&keyWord=${keyWord }</c:if>
				<c:if test="${not(empty method )}" >&method=${method }</c:if>
				<c:if test="${not(empty channelId) }" >&channelId=${channelId }</c:if>"><%=i%></option>
				<%
					}
				%>
			</select>
		</div>
		<div align="center">
			日志搜索：
			<input type="text" value="日志标题" name="findDailyTitle"
				id="findDailyTitle" onclick="clean(this)" />
			<input type="text" value="关键字" name="keyWord" id="keyWord"
				onclick="clean(this)" />
			栏目：
			<select name="channelIdKey">
				<option value="all">
					所有
				</option>
				<c:forEach items="${dailyChannelList}" var="dailyChannels">
					<c:choose>
						<c:when test="${dailyChannels.id==dailyForm.channelIdString}">
							<c:set value="selected=&quot;seleced&quot;" var="parent" />
						</c:when>
						<c:otherwise>
							<c:set value="" var="channel" />
						</c:otherwise>
					</c:choose>
					<option value="${dailyChannels.id }"${channel } >
						${dailyChannels.name }
					</option>
				</c:forEach>
			</select>
			<input type="button" name="find" onclick="findDaily()" value="搜索" />
		</div>
	</div>
</form>