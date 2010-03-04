<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function check() {
		var playbillname = $('playbillname').value;
		if(playbillname==""){
			alert("标题不能为空");
			return false;
		}
	}
</script>
<div class="side">
<div class="module">
<div class="moduleval">
<p class="sideButton"><a >编辑节目单</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/modify/image/${playbill.id }">更换图片</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/modify/video/${playbill.id }/1/">编辑视频</a></p>
</div>
</div>
</div>

<div class="main">
<div class="module">
<div class="title"><h2>编辑节目单</h2></div>
<div class="reDiv">
<form name="playbillForm" id="playbillForm"
	action="<%=request.getContextPath()%>/modifyPlaybill.do" method="post"
	onsubmit="return checkPic();">
	<table width="434" height="149" border="0">
		<tr>
			<td width="86">
				标题
				<input type="hidden" name="id" value="${playbill.id }" />
				<input type="hidden" name="action" value="${action }" />
			</td>
			<td width="196">
				<input type="text" name="name" id="playbillname"
					value="${playbill.name }">
			</td>
			<td width="138" style="color: red;">
				${nameError }
			</td>
		</tr>
		<tr>
			<td>
				分类
			</td>
			<td>
				<select name="channelId">
					<c:forEach var="channel" items="${playbillChannels}">
						<option value="${channel.id }"
							<c:if test="${channel.id==playbill.channel.id }">selected</c:if>>
							${channel.name }
						</option>
					</c:forEach>
				</select>
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				简介
			</td>
			<td>
				<textarea name="description">${playbill.description }</textarea>
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
			<td>
				<input type="submit" name="Submit" value="提交">
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
	</table>
</form>

</div>

</div>

</div>
