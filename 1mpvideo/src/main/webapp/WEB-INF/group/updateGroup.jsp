<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="text/javascript">
function checkPic() {
	var location = document.getElementById('image').value;
	if (location != "") {
		var point = location.lastIndexOf(".");
		var type = location.substr(point);
		if (type == ".jpg" || type == ".gif" || type == ".JPG"
				|| type == ".GIF") {
			img = document.createElement("img");
			
			if (img.fileSize > 102400) {
				alert("图片尺寸请不要大于100KB");
				return false;
			} else
				return true;
		} else {
			alert("只能输入jpg或者gif格式的图片");
			return false;
		}
	}
	else{
	return true;
		}
}
</script>
<div class="module">
	<div class="title">
		<h2>
			设置小组
		</h2>
	</div>
	<div>
		<form name="picForm" id="picForm"
			action="<%=request.getContextPath()%>/updateGroup.do" method="post"
			enctype="multipart/form-data" onsubmit="return checkPic();">
			<table width="100%" style="text-align: left;">
				<tr>
					<td width="20%">
						小组图片
					</td>
					<td>
						<img
							src="<%=application.getAttribute("IMAGE_URL")%>${group.image }" />
						<br />
						<input type="file" name="file" size="10" id="image" />
					</td>
				</tr>
				<tr>
					<td>
						小组名称
					</td>
					<td>
						${group.name }
						<input type="hidden" name="id" value="${group.id }" />
					</td>
				</tr>
				<tr>
					<td>
						小组介绍
					</td>
					<td>
						<textarea rows="5" cols="80" name="description">${group.descrption }</textarea>
					</td>
				</tr>
				<tr>

					<td>
						小组类型
					</td>
					<td>
						<input type="radio" name="type" value="0"
							<c:if test="${group.auditType==0 }">checked="checked"</c:if> />
						允许所有人加入
						<input type="radio" name="type" value="1"
							<c:if test="${group.auditType==1 }">checked="checked"</c:if> />
						需要管理员审核加入
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="确定" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
