<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		<script type="text/javascript">
function checkPic() {
	var location = document.getElementById('image').value;
	if (location == "") {
		alert("请先选择图片文件");
		return false;
	}
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


</script>
		<div class="module">
			<div class="title">
				<h2>
					创建新的小组
				</h2>
			</div>
			<div>
				<form name="picForm" id="picForm"
					action="<%=request.getContextPath()%>/createGroup.do" method="post"
					enctype="multipart/form-data" onsubmit="return checkPic();">
					<table width="100%" style="text-align: left;">
						<tr>
							<td width="20%">
								小组图片
							</td>
							<td>
								<input type="file" name="file" size="10" id="image" />
							</td>
						</tr>
						<tr>
							<td>
								小组名称
							</td>
							<td>
								<input type="text" name="name" id="name" />
							</td>
						</tr>
						<tr>
							<td>
								小组介绍
							</td>
							<td>
								<textarea rows="5" cols="80" name="description"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								小组类型
							</td>
							<td>
								<input type="radio" name="type" value="0" checked="checked" />
								允许所有人加入
								<input type="radio" name="type" value="1" />
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
