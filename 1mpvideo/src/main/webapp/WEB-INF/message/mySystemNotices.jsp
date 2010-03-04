<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function selectAll(){

	var aa = document.getElementsByName("ids");
	  for (var i=0; i<aa.length; i++)
	   aa[i].checked = document.getElementById('all').checked;
	
}
</script>

		<div class="module">

			<div class="title">
<span><a href="<%=request.getContextPath()%>/vblog/mybox/">返回</a></span>
				<h2>收件箱</h2>
			</div>
			<div class="reDiv">
<form action="<%=request.getContextPath()%>/deleteMessage.do?type=sys" method="post">
				<table width="90%">
					<tr>
						<td><input onclick="selectAll();"  name="all" type="checkbox"/></td>
						<td>
							发件人
						</td>
						<td>
							邮件主题
						</td>
						<td>
							发送时间
						</td>
					</tr>
					<c:forEach items="${pagination.results}" var="systemNotice">
						<tr>
							<td width="10%">
								<input type="checkbox" name="ids" value="${systemNotice.id}" />
							</td>
							<td width="20%">
								系统短信
							</td>
							<td width="30%">
								<a
									href="<%=request.getContextPath()%>/vblog/systemmessage/read/${systemNotice.id}/">${systemNotice.title}</a>
							</td>
							<td width="40%">
								<fmt:formatDate value="${systemNotice.sendDate}" type="both" />
							</td>
						</tr>
					</c:forEach>
				</table>
				<div align="center">
					<c:if test="${pagination.previous}">
						<a
							href="<%=request.getContextPath()%>/vblog/mymessage/${pagination.no-1 }/">上一页</a>
					</c:if>
					第${pagination.no }/${ pagination.pageSum}页
					<c:if test="${pagination.next}">
						<a
							href="<%=request.getContextPath()%>/vblog/mymessage/${pagination.no+1 }/">下一页</a>
					</c:if>
				</div>
<input type="submit" value="删除"/>
</form>
			</div>
		</div>
