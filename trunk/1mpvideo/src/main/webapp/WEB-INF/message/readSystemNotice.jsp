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
<a href="<%=request.getContextPath()%>/vblog/mybox/">收件箱</a></p>

<p class="sideButton">
			<a href="<%=request.getContextPath()%>/vblog/mySendBox/">发件箱</a></p>
		</div>
	</div>
</div>
<div class="main">
	<div class="module">
		<div class="title">
			<span> <a href="<%=request.getContextPath()%>/vblog/mybox/">返回收件箱</a>
			</span>
			<h2>
				系统信息-${systemNotice.title }
				<fmt:formatDate value="${systemNotice.sendDate }" type="both" />
			</h2>
		</div>
		<div>

<c:if test="${systemNotice.type==0 }">
				<table width="90%">
					<tr>
						<td width="70%" class="itable">
							${systemNotice.message}
						</td>
						<td width="30%">


						</td>
					</tr>
				</table>

			</c:if>

			<c:if test="${systemNotice.type==1 }">
				<table width="90%">
					<tr>
						<td width="70%" class="itable">
							${systemNotice.message}
						</td>
						<td width="30%">


						</td>
					</tr>
				</table>

			</c:if>
			<c:if test="${systemNotice.type==2 }">
				<table width="90%" class="itable">
					<tr>
						<td width="70%" >
							<a href="<%=request.getContextPath()%>/group/${systemNotice.module.id }/">${systemNotice.module.name}</a>的邀请，附加信息：
							<br />
							${systemNotice.message}
						</td>
						<td width="30%">
							<c:if test="${systemNotice.status==0||systemNotice.status==1}">
								<a
									href="<%=request.getContextPath()%>/group/invite/agree/${systemNotice.id }/">接受邀请</a>
							</c:if>
							<c:if test="${systemNotice.status==2}">你接受了邀请</c:if>
						</td>
					</tr>
				</table>
			</c:if>
			<c:if test="${systemNotice.type==4 }">
				<table width="90%">
					<tr>
						<td width="70%">
							<a href="<%=request.getContextPath()%>/home/${systemNotice.module.id }/">${systemNotice.module.name}</a>想加你为好友，附加信息：
							<br />
							${systemNotice.message}
						</td>
						<td width="30%">
							<c:if test="${systemNotice.status==0||systemNotice.status==1}">
								<a
									href="<%=request.getContextPath()%>/vblog/friend/request/agree/${systemNotice.id }/">接受邀请</a>
							</c:if>
							<c:if test="${systemNotice.status==2}">你已同意对方的好友请求，并将对方加为你的好友</c:if>
						</td>
					</tr>
				</table>
			</c:if>
		</div>
	</div>
</div>
