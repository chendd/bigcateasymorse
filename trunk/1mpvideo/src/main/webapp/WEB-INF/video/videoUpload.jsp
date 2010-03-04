<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
<link href="<%=request.getContextPath()%>/js/swfupload/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/swfupload/swfupload.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/swfupload/swfupload.queue.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/swfupload/fileprogress.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/swfupload/handlers.js"></script>
<script type="text/javascript">

var swfu;

window.onload = function() {
	var settings = {
		flash_url : "<%=request.getContextPath()%>/js/swfupload/swfupload.swf",
		upload_url: "<%=request.getContextPath()%>/uploadFile.do?id=${sessionUser.id}",	// Relative to the SWF file
		
		file_size_limit : "200 MB",
		file_types : "*.3gp;*.flv;*.wmv;*.rmvb;*.rm;*.mpg",
		file_types_description : "All Files",
		file_upload_limit : 1,
		file_queue_limit : 1,
		custom_settings : {
			progressTarget : "fsUploadProgress",
			cancelButtonId : "btnCancel"
		},
		debug: false,

		// Button settings
		button_image_url: "<%=request.getContextPath()%>/js/swfupload/TestImageNoText_65x29.png",	// Relative to the Flash file
		button_width: "65",
		button_height: "29",
		button_placeholder_id: "spanButtonPlaceHolder",
		button_text: '<span class="theFont">选择</span>',
		button_text_style: ".theFont { font-size: 16; }",
		button_text_left_padding: 12,
		button_text_top_padding: 3,
		
		// The event handler functions are defined in handlers.js
		file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete	// Queue plugin event
	};

	swfu = new SWFUpload(settings);
 };




		function checkPrm(){
			alert("ppp:"+$('videoId').value);
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
					注意事项
				</h2>
			</div>
			<div class="reDiv">
				<ul>
					<li>
						请勿上传色情或违法反动视频
					</li>
					<li>
						上传文件最大200MB，过大会被系统自动拒绝
					</li>
					<li>
						你的上传,表示你默认同意我们的内容协议
					</li>

				</ul>

			</div>
		</div>
	</div>
	<div class="main">
		<div class="module">
			<div class="title">
				<h2>
					上传新视频:${name }
				</h2>
			</div>
			<div id="loader" style="margin: 30px">
				
	<form id="form1" action="" method="post" enctype="multipart/form-data">
		

			<div class="fieldset flash" id="fsUploadProgress">
			
			</div>
		
			<div>

				<span id="spanButtonPlaceHolder"></span>
				<input id="btnCancel" type="button" value="取消" onclick="swfu.cancelQueue();" disabled="disabled" style="margin-left: 2px; font-size: 8pt; height: 29px;" />
			</div>

	</form>

			</div>
			<div id="mess"
				style="display: none; text-align: left; width: 500px; border: 1px solid rgb(204, 204, 204); margin: 10px auto; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">


			</div>
			
				<form action="<%=request.getContextPath()%>/finishUpload.do"
					method="post" onsubmit="return checkPrm();">
<input type="hidden" name="videoId" id="videoId" />
<div id="info" class="reDiv" style="display: none">
					<table width="90%">
						<tr>
							<td width="10%">
								标题
							</td>
							<td>

								<input type="text" name="name" id="name" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								简介
							</td>
							<td>
								<textarea rows="5" cols="50" id="description" name="description"></textarea>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								分类
							</td>

							<td>
								<c:forEach items="${channels}" var="channel">
									<input type="radio" name="channel" value="${channel.id }"
										checked="checked" />${channel.name } </c:forEach>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								标签
							</td>
							<td>
								标签1
								<input type="text" name="tag1" id="tag1" size="2" />
								&nbsp;&nbsp;标签2
								<input type="text" name="tag2" size="2" />
								&nbsp;&nbsp;标签3
								<input type="text" name="tag3" size="2" />
								&nbsp;&nbsp; 标签4
								<input type="text" name="tag4" size="2" />
								&nbsp;&nbsp;标签5
								<input type="text" name="tag5" size="2" />
								&nbsp;&nbsp;

							</td>
							<td></td>
						</tr>

					</table>
					<p align="center">
						<input type="submit" value="确定" />
					</p>

</div>
				</form>

			
		</div>
	</div>