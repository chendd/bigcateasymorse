<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div style="width: 60%; border: solid aqua;">
			<div>
				收件箱
			</div>
			<div align="center">
				<table width="90%">
					<tr>
						<td></td>
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
					<c:forEach items="${pagination.results}" var="whisper">
						<tr>
							<td width="10%">
								<input type="checkbox" value="${whisper.id}" />
							</td>
							<td width="20%">
								<a
									href="<%=request.getContextPath()%>/home/${whisper.fromUser.id}/">${whisper.fromUser.realName}</a>
							</td>
							<td width="30%">
								<a
									href="<%=request.getContextPath()%>/vblog/mymessage/read/${whisper.id}/">${whisper.title}</a>
							</td>
							<td width="40%">
								<fmt:formatDate value="${whisper.sendDate}" type="both" />
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
			</div>
		</div>
