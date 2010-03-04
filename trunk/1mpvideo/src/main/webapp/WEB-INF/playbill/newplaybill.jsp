<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function checkPic() {
		
		var playbillname = $('playbillname').value;
	
		if(playbillname==""){
			alert("标题不能为空");
			return false;
		}
		
		return true;
	}
</script>
<div class="side">
<div class="module">
<div class="title"><h2>节目单设置</h2></div>
<div class="moduleval">
<p class="sideButton"><a >创建节目单</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/playbill/myplaybilllist/${sessionUser.id }/addDate/1/">节目单列表</a></p>
</div>
</div>
</div>

<div class="main">
<div class="module">
<div class="title"><h2>创建节目单</h2></div>
<div class="reDiv">
<form name="picForm" id="picForm"
	action="<%=request.getContextPath()%>/addPlaybill.do" method="post"
	 onsubmit="return checkPic();">
	<table width="434" height="149" border="0">
		<tr>
			<td width="86">
				标题
				<input type="hidden" name="id" value="${id }" />
			</td>
			<td width="196">
				<input type="text" name="name" id="playbillname">
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
						<option value="${channel.id }">
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
				<textarea name="description"></textarea>
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