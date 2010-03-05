<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.video.util.Pagination"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
function selectAllDailyReply(){
	var dailyReplyIds = document.getElementsByName("dailyReplyId");
	for(var i=0;i<dailyReplyIds.length;i++){
		dailyReplyIds[i].checked = document.getElementById('dailyReplySelectAll').checked;
	}
}

function deleteDailyReply(comment,dailyReplyId){
if(confirm('确认删除评论'+comment+'?')){
	document.location.href="deleteDailyReply.do?id="+dailyReplyId;
	}
}

</script>
<form action="dailyReplyList.do" method="post">
	<p>
		查找评论：
		<input type="text" name="keyword" />
		<input type="submit" name="Submit" value="提交" />
		请输入查询的内容。如果为空，则查找所有评论
	</p>
</form>
<form action="deleteDailyReply.do" method="post">
	<table id="formattable" width="880" border="0">
		<tr>
			<th>
				选择
				<input type="checkbox" id="dailyReplySelectAll"
					name="dailyReplySelectAll" value="All"
					onclick="selectAllDailyReply()" />
			</th>
			<th>
				评论
			</th>
			<th>
				所属日志
			</th>
			<th>
				评分
			</th>
			<th>
				用户名
			</th>
			<th>
				评论日期
			</th>
			<th>
				操作
			</th>
		</tr>
		<c:forEach items="${dailyReplyPage.results}" var="dailyReply">
			<tr>
				<td width="49">
					<input type="checkbox" id="dailyReplyId" name="dailyReplyId"
						value="${dailyReply.id }" />
				</td>
				<td width="198">
					${dailyReply.comment }
				</td>
				<td width="65">
					${dailyReply.daily.title }
				</td>
				<td width="66">
					${dailyReply.point }
				</td>
				<td width="161">
					${dailyReply.user.userName }
				</td>
				<td width="147">
					${dailyReply.addDate }
				</td>
				<td width="112">
					<a href="updateDailyReply.do?id=${dailyReply.id }">修改</a>
					<a
						href="javascript:deleteDailyReply('${dailyReply.comment }','${dailyReply.id }')">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center"><input type="submit" name="deletAll" value="删除选中评论" /></p>
</form>
<div align="center">
	<div align="center">
		<a
			href="dailyReplyList.do?pageNo=1<c:if test="${not empty keyword  }">&keyword=${keyword }</c:if>">首页</a>

		<c:if test="${dailyReplyPage.previous}">
			<a
				href="dailyReplyList.do?pageNo=${dailyReplyPage.no-1}<c:if test="${not empty keyword  }">&keyword=${keyword }</c:if>">上一页</a>
		</c:if>
		<c:if test="${!dailyReplyPage.previous}">上一页
			</c:if>
		<c:if test="${dailyReplyPage.next}">
			<a
				href="dailyReplyList.do?pageNo=${dailyReplyPage.no+1}<c:if test="${not  empty keyword  }">&keyword=${keyword }</c:if>
				">下一页</a>
		</c:if>
		<c:if test="${!dailyReplyPage.next}">下一页</c:if>
		<a
			href="dailyReplyList.do?pageNo=${dailyReplyPage.pageSum}<c:if test="${not empty keyword  }">&keyword=${keyword }</c:if>
				">尾页</a>
		页次：${dailyReplyPage.no}/${dailyReplyPage.pageSum}页
		${dailyReplyPage.size}个评论/页 转到
		<select onchange="toPage()" id="pages">
			<%
				Pagination pagin = (Pagination) request
						.getAttribute("dailyReplyPage");
				for (int i = 1; i <= pagin.getPageSum(); i++) {
			%>
			<option <%if(pagin.getNo()==i){%> selected="selected" <%} %>
				value="dailyReplyList.do?pageNo=<%=i%><c:if test="${not empty keyword  }">&keyword=${keyword }</c:if>
				"><%=i%></option>
			<%
				}
			%>
		</select>
	</div>