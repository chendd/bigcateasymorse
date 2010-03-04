<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<script type="text/javascript">
function checkPrm(){
	var name = $('name').value;
	var description = $('description').value;
	var tag1 = $('tag1').value;
	var mess = '';
	if(name==''){
		mess += '请填写标题<br />';
		}
	if(description==''){
		mess += '请填写简介<br />';
		}
	if(tag1==''){
		mess += '第一个标签必填<br />';
		}
	if(mess!=''){
		$('mess').style.display='';
		$('mess').innerHTML=mess;
		return false;
		}
	return true;
}
</script>
<div class="side">
	<div class="module">
		<div class="title">
			<h2>
				视频设置
			</h2>
		</div>
		<div class="moduleval">
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/video/upload">上传视频</a>
			</p>
			<p class="sideButton">
				<a
					href="<%=request.getContextPath()%>/video/myvideolist/${sessionUser.id}/addDate/1">视频列表</a>
			</p>
		</div>
	</div>
</div>
<div class="main">
<div class="module">
<div class="title"><h2>编辑视频</h2></div>
<div id="info" class="reDiv">
			<form action="<%=request.getContextPath()%>/modifyVideo.do"
				method="post" onsubmit="return checkPrm();">
				<table width="90%">
					<tr>
						<td width="10%">
							标题
						</td>
						<td>
							<input type="text" name="name" id="name" value="${video.name }" />
							<input type="hidden" name="videoId" value="${video.id }" />
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							简介
						</td>
						<td>
							<textarea rows="5" cols="50" id="description" name="description">${video.description }</textarea>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							分类
						</td>
						<c:if test="${channel.id==video.channel.id}"></c:if>
						<td>
							<c:forEach items="${channels}" var="channel">
								<input type="radio" name="channel" value="${channel.id }"
									<c:if test="${channel.id==video.channel.id}">checked</c:if> />${channel.name } </c:forEach>
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							标签
						</td>
						<td>
							标签1
							<input type="text" name="tag1" id="tag1" size="2"
								value="${tags[0].name }" />
							&nbsp;&nbsp;标签2
							<input type="text" name="tag2" size="2" value="${tags[1].name }" />
							&nbsp;&nbsp;标签3
							<input type="text" name="tag3" size="2" value="${tags[2].name }" />
							&nbsp;&nbsp; 标签4
							<input type="text" name="tag4" size="2" value="${tags[3].name }" />
							&nbsp;&nbsp;标签5
							<input type="text" name="tag5" size="2" value="${tags[4].name }" />
							&nbsp;&nbsp;
						</td>
						<td></td>
					</tr>
				</table>
				<p align="center">
					<input type="submit" value="确定" />
				</p>
			</form>
		</div>
</div>
		</div>
