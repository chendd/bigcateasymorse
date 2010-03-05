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

var  img=null;
function checkPic(picForm){
 var location=picForm.pic.value;
 if(location==""){
  alert("请先选择视频文件");
  return false;
 }
 var point = location.lastIndexOf(".");
 var type = location.substr(point);
 if(type==".3gp"||type==".avi"||type==".flv"||type==".rm"||type==".rmvb"||type==".wmv"||type==".mpg"){
  img=document.createElement("img");  
  img.src=location;
  if(img.fileSize>1024000){
   alert("图片尺寸请不要大于100KB");
   return false;
  }else
     return true;
 }
 else{
  alert("请上传正确格式的视频文件");
  return false;
 }
 return true;
 
}

</script>
<div align="center">
<fieldset style="width: 50%">
<legend>用户上传视频添加</legend>
<form action="createUploadVideo.do" method="post"  name="picForm"  enctype="multipart/form-data" onsubmit="return checkPic(picForm);" target="hidden_frame"  >
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
<table width="599" border="0">

  <tr>
    <td width="119">名称：</td>
    <td width="243"><input type="text" name="name" value="" id="name"/></td>
     <td width="215"><span id="nameInfo" style="color: red;"></span></td>
  </tr>
  <tr>
    <td>视频上传：</td>
    <td><input type="file" name="file" size="10"   id="pic"  />

</td>
    <td><span id="urlInfo" style="color: red;"></span></td>
  </tr>

  <tr>
    <td>视频分类：</td>
    <td>
<select name="channelId">

<c:forEach items="${channels}" var="channel">
<option  value="${ channel.id}" <c:if test="${channel.id == video.channel.id}">selected="selected"</c:if>>${ channel.name}</option>
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
<textarea rows="5" cols="30" name="description">${video.description }</textarea>
</td>
    <td>&nbsp;</td>
  </tr>

  <tr>
    <td>3gp数量：</td>
    <td><input type="text" name="num3gp" value="${video.num3gp }" id="num3gp"/></td>
     <td><span id="num3gpInfo" style="color: red;"></span></td>
  </tr>
 

 
  <tr>
    <td>上传用户：</td>
    <td><input type="text" name="userId"/></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value="确定"/></td>
    <td>&nbsp;</td>
  </tr>
</table>



</form>
</fieldset>

</div>

</body>
</html>