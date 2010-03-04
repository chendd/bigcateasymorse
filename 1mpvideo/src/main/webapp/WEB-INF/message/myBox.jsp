<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="side">
	<div class="module">
		<div class="title">
			<h2>
				信箱
			</h2>
		</div>
		<div>
		<p class="sideButton">
<a >收件箱</a>
</p>
	<p class="sideButton">		
			<a href="<%=request.getContextPath()%>/vblog/mySendBox/">发件箱</a>
</p>
		</div>
	</div>
</div>
<div class="main">
	<div class="module">
		<div class="title">
			<h2>
				系统信息
			</h2>
		</div>
		<div>
			<table width="90%">
				<tr>
					<th></th>
					<th>
						发件人
					</th>
					<th>
						邮件主题
					</th>
					<th>
						发送时间
					</th>
				</tr>
				<c:forEach items="${pagination2.results}" var="systemNotice">
					<tr>
						<td width="10%">
							<input type="checkbox" value="${systemNotice.id}" />
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
				<c:if test="${pagination2.next}">
					<tr>
						<td width="10%">&nbsp;
							
						</td>
						<td width="20%">&nbsp;
							
						</td>
						<td width="30%">&nbsp;
							
						</td>
						<td width="40%">
							<div align="right">
								<a style="color: red;"
									href="<%=request.getContextPath()%>/vblog/systemmessage/">查看更多</a>
							</div>
						</td>
					</tr>
				</c:if>
			</table>

		</div>

	</div>


	<div class="module">
		<div class="title">
			<h2>
				短信息
			</h2>
		</div>
		<div>
			<table width="90%">
				<tr>
					<th></th>
					<th>
						发件人
					</th>
					<th>
						邮件主题
					</th>
					<th>
						发送时间
					</th>
				</tr>
				<c:forEach items="${pagination1.results}" var="whisper">
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
				<c:if test="${pagination1.next}">
					<tr>
						<td width="10%">&nbsp;
							
						</td>
						<td width="20%">&nbsp;
							
						</td>
						<td width="30%">&nbsp;
							
						</td>
						<td width="40%">
							<div align="right">
								<a style="color: red;"
									href="<%=request.getContextPath()%>/vblog/mymessage/">查看更多</a>
							</div>
						</td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>
</div>
