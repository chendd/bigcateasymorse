<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript">
function checkit(){
	var name = document.getElementById("name").value;
	var num3gp = document.getElementById("num3gp").value;
	var videoSize = document.getElementById("videoSize").value;
	var videoTime = document.getElementById("videoTime").value;
	var re = /^[0-9]{1,8}$/;
	if(name==''){
		document.getElementById("nameInfo").innerHTML="名称不能为空";
		document.getElementById("name").focus();
		return false;
		}
	
	if(!num3gp.match(re)){
		document.getElementById("num3gpInfo").innerHTML="请输入正确数字";
		document.getElementById("num3gp").focus();
		return false;
		}
	if(!videoSize.match(re)){
		document.getElementById("videoSizeInfo").innerHTML="请输入正确数字";
		document.getElementById("videoSize").focus();
		return false;
		}
	if(!videoTime.match(re)){
		document.getElementById("videoTimeInfo").innerHTML="请输入正确数字";
		document.getElementById("videoTime").focus();
		return false;
		}
	



		document.form.submit();
	
	

	
}


</script>
<div align="center">
<fieldset style="width: 50%">
<legend>用户上传视频修改</legend>
<form action="updateUploadVideo.do" method="post" name="form" >
<table width="599" border="0">
  <tr>
    <td width="119">ID：</td>
    <td width="243"><input type="text" name="id" value="${video.id }" readonly="readonly"/></td>
    <td width="215">&nbsp;</td>
  </tr>
  <tr>
    <td>名称：</td>
    <td><input type="text" name="name" value="${video.video.name }" /></td>
    <td><span id="nameInfo" style="color: red;"></span></td>
  </tr>
  <tr>
    <td>视频地址：</td>
    <td><a href="http://192.168.0.224/upload/uploadvideoes/${video.url }">http://192.168.0.224/upload/uploadvideoes/${video.url }</a></td>
    <td><span id="urlInfo" style="color: red;"></span></td>
  </tr>
  <tr>
    <td>视频类型：</td>
    <td>

<select name="videoType">
<option value="3gp" <c:if test="${video.videoType=='3gp'}">selected="selected"</c:if>>3gp</option>
<option value="flv" <c:if test="${video.videoType=='flv'}">selected="selected"</c:if>>flv</option>
<option value="avi" <c:if test="${video.videoType=='avi'}">selected="selected"</c:if>>avi</option>
<option value="rm" <c:if test="${video.videoType=='rm'}">selected="selected"</c:if>>rm</option>
<option value="rmvb" <c:if test="${video.videoType=='rmvb'}">selected="selected"</c:if>>rmvb</option>
<option value="wmv" <c:if test="${video.videoType=='wmv'}">selected="selected"</c:if>>wmv</option>
</select>
</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>视频分类：</td>
    <td>
<select name="channelId">

<c:forEach items="${channels}" var="channel">
<option  value="${ channel.id}" <c:if test="${channel.id == video.video.channel.id}">selected="selected"</c:if>>${ channel.name}</option>
</c:forEach>
</select>
</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>视频介绍：</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
<textarea rows="5" cols="30" name="description">${video.video.description }</textarea>
</td>
    <td>&nbsp;</td>
  </tr>
 <tr>
    <td>状态：</td>
    <td>

<input type="radio" name="stauts" <c:if test="${video.stauts==0}">checked="checked"</c:if>  value="0"/>未审 
<input type="radio" name="stauts" <c:if test="${video.stauts==1}">checked="checked"</c:if>  value="1"/>通过 
<input type="radio" name="stauts" value="-1"/>直接删除(源文件将一并删除)

</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>3gp数量：</td>
    <td><input type="text" name="num3gp" value="${video.num3gp }" id="num3gp"/></td>
     <td><span id="num3gpInfo" style="color: red;"></span></td>
  </tr>
  <tr>
    <td>视频大小</td>
    <td><input type="text" name="videoSize" value="${video.video.videoSize }" id="videoSize"/></td>
     <td><span id="videoSizeInfo" style="color: red;"></span></td>
  </tr>
  <tr>
    <td>视频时长</td>
    <td><input type="text" name="videoTime" value="${video.videoTime }" id="videoTime"/></td>
    <td><span id="videoTimeInfo" style="color: red;"></span></td>
  </tr>
  <tr>
    <td>上传时间：</td>
    <td><fmt:formatDate value="${video.video.addDate}" type="date"/></td>
    <td>

</td>
  </tr>
  <tr>
    <td>上传用户：</td>
    <td>${video.video.user.realName }</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><button onclick="checkit()">确定</button></td>
    <td>&nbsp;</td>
  </tr>
</table>



</form>
</fieldset>

</div>

</body>
</html>