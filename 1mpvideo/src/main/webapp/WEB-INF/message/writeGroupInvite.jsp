<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div style="width: 80%; border: solid ridge;">
			<div id="title">
				邀请
				<a href="<%=request.getContextPath()%>/home/${user.id }/">${user.realName
					}</a> 加入你的小组
			</div>
			<div>
				<c:if test="${empty groups }">
你还没有创建或参加过小组 <br />
你可以： <br />
现在就<a href="">创建你的小组</a>，或者选择并加入一个<a
						href="<%=request.getContextPath()%>/group/list/">你喜欢的小组</a>！ <br />
				</c:if>
				<c:if test="${not empty groups }">
					<form action="<%=request.getContextPath()%>/createGroupInvite.do"
						method="post">
						<table width="100%">
							<tr>
								<td width="20%">
									小组名
								</td>
								<td width="80%">
									<select id="id" name="id">
										<c:forEach items="${groups}" var="group">
											<option value="${group.id }">
												${group.name }
											</option>
										</c:forEach>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									标题
								</td>
								<td>
									<input type="text" name="title" id="title"
										value="来自${sessionUser.realName }的小组邀请函" />
								</td>
							</tr>
							<tr>
								<td>
									内容
								</td>
								<td>
									<input type="hidden" name="uid" value="${user.id }" />
									<textarea rows="5" cols="30" name="message" id="message">挺喜欢你的节目，想邀请你参加这个小组。</textarea>
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="发送" />
								</td>
							</tr>
						</table>
					</form>
				</c:if>
			</div>
		</div>
	