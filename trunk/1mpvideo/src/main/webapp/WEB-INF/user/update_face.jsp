<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.Random"%><script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/face/drag.js"></script>
<script language="javascript" type="text/javascript"
	src="<%=request.getContextPath()%>/js/face/ImageCopper.js"></script>
<script type="text/javascript">
</script>
<script language="javascript" type="text/javascript">
</script>
<script type="text/javascript">
	//校验上传文件
	function checkPic() {

		var location = document.getElementById('pic').value;
		if (location == "") {
			alert("请先选择图片文件");
			return false;
		}
		var point = location.lastIndexOf(".");
		var type = location.substr(point);
		if (type == ".jpg" || type == ".gif" || type == ".JPG"
				|| type == ".GIF") {
			img = document.createElement("img");
			
			if (img.fileSize > 1024000) {
				alert("图片尺寸请不要大于1000KB");
				return false;
			} else
				return true;
		} else {
			alert("只能输入jpg或者gif格式的图片");
			return false;
		}
		return true;

	}
	//图片上传后的回调函数
	function callback(url, width, height) {

		document.getElementById('cut_img').width = width;
		document.getElementById('cut_img').height = height;
		document.getElementById('cut_img').src = "${IMAGE_URL}"+"/"+url + "?"
				+ Math.round(Math.random() * 10000);
		
		document.getElementById('cut_url').value = url;
		
		document.getElementById('old').style.display = 'none';
		document.getElementById('new').style.display = '';
		imageinit();
		gripinit();
	}

	function hide(){
		document.getElementById('hide').style.display='none';
		}
</script>

<div class="side">
	<div class="module">
		<div class="title">
			<h2>
				博客设置
			</h2>
		</div>
		<div class="moduleval">
			<p class="sideButton">
				<a >修改头像</a>
			</p>
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/signature/">个性签名</a>
			</p>
		</div>
	</div>
	<div class="module">
		<div class="title">
			<h2>
				账户设置
			</h2>
		</div>
		<div class="moduleval">
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/info/">个人资料</a>
			</p>
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/email/">电子邮件</a>
			</p>
			<p class="sideButton">
				<a href="<%=request.getContextPath()%>/user/password/">修改密码</a>
			</p>
		</div>
	</div>
</div>
<div class="main">
	<div class="module">
		<div class="title">
			<span><a
				href="<%=request.getContextPath()%>/home/${sessionUser.id }/">返回您的首页</a>
			</span>
			<h2>
				修改头像
			</h2>
		</div>
		<div class="moduleval" style="height: 400px">
			<div style="float: left; width: 48%;">
				<div id="old">
					<p>
						当前头像
					</p>
					<img style="border: 5px double black;"
						src="<%= application.getAttribute("IMAGE_URL")%>${sessionUser.face }?<%=new Random().nextInt(10000) %>">
				</div>
				<div id="new" style="display: none;">
					<p>
						切割头像
					</p>
					<form name="imgForm" id="imgForm"
						action="<%=request.getContextPath()%>/saveFace.do" method="post"
						onsubmit="return getcutpos();">


						<div id="cut_div"
							style="border: 2px solid #888888; width: 284px; height: 266px; overflow: hidden; position: relative; top: 0px; left: 0px; margin: 4px; cursor: pointer;">
							<table
								style="border-collapse: collapse; z-index: 10; filter: alpha(opacity =             75); position: relative; left: 0px; top: 0px; width: 284px; height: 266px; opacity: 0.75;"
								cellspacing="0" cellpadding="0" border="0" unselectable="on">
								<tr>
									<td style="background: #cccccc; height: 73px;" colspan="3"></td>
								</tr>
								<tr>
									<td style="background: #cccccc; width: 82px;"></td>
									<td
										style="border: 1px solid #ffffff; width: 120px; height: 120px;"></td>
									<td style="background: #cccccc; width: 82px;"></td>
								</tr>
								<tr>
									<td style="background: #cccccc; height: 73px;" colspan="3"></td>
								</tr>
							</table>
							<img id="cut_img"
								style="position: relative; top: -266px; left: 0px" src="" />
						</div>
						<table cellspacing="0" cellpadding="0">
							<tr>
								<td>
									<img style="margin-top: 5px; cursor: pointer;"
										src="<%= application.getAttribute("IMAGE_URL")%>/js/face/images/_h.gif"
										alt="图片缩小"
										onmouseover="this.src='<%=request.getContextPath()%>/js/face/images/_c.gif'"
										onmouseout="this.src='<%=request.getContextPath()%>/js/face/images/_h.gif'"
										onclick="imageresize(false)" />
								</td>
								<td>
									<img id="img_track"
										style="width: 250px; height: 18px; margin-top: 5px"
										src="<%= application.getAttribute("IMAGE_URL")%>/js/face/images/track.gif" />
								</td>
								<td>
									<img style="margin-top: 5px; cursor: pointer;"
										src="<%= application.getAttribute("IMAGE_URL")%>/js/face/images/ah.gif"
										alt="图片放大"
										onmouseover="this.src='<%=request.getContextPath()%>/js/face/images/ac.gif'"
										onmouseout="this.src='<%=request.getContextPath()%>/js/face/images/ah.gif'"
										onclick="imageresize(true)" />
								</td>
							</tr>
						</table>
						<img id="img_grip"
							style="position: absolute; z-index: 100; left: -1000px; top: -1000px; cursor: pointer;"
							src="<%= application.getAttribute("IMAGE_URL")%>/js/face/images/grip.gif" />
						<div style="padding-top: 15px; padding-left: 5px;">
							<input type="hidden" name="cut_pos" id="cut_pos" value="" />
							<input type="hidden" name="cut_url" id="cut_url" value="" />
							<input type="submit" class="button" name="submit" id="submit"
								value=" 保存头像 " />
						</div>
					</form>
				</div>
			</div>
			<div style="float: right; width: 48%;">
				<p>
					更换头像
				</p>
				<form name="picForm" id="picForm"
					action="<%=request.getContextPath()%>/uploadFace.do" method="post"
					enctype="multipart/form-data" onsubmit="return checkPic();"
					target="hidden_frame">
					<div>
						<input type="file" name="file" size="10" id="pic" onchange="" />
						<input type="submit" value="上传" />
						<iframe name='hidden_frame' id="hidden_frame"
							style='display: none'></iframe>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>