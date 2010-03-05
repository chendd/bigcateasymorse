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
function submitit(){

	document.form1.submit();
}
var  img=null;
function checkPic(picForm){
 var location=picForm.pic.value;
 if(location==""){
  alert("请先选择图片文件");
  return false;
 }
 var point = location.lastIndexOf(".");
 var type = location.substr(point);
 if(type==".jpg"||type==".gif"||type==".JPG"||type==".GIF"){
  img=document.createElement("img");  
  img.src=location;
  if(img.fileSize>1024000){
   alert("图片尺寸请不要大于100KB");
   return false;
  }else
     return true;
 }
 else{
  alert("只能输入jpg或者gif格式的图片");
  return false;
 }
 return true;
 
}
function changesrc(){
	document.getElementById('yourpic').src=picForm.pic.value;

}
function showPhoto(){
	if(photo.style.display=="none"){
		photo.style.display="";
		}
	else{
		photo.style.display="none";
		}
	
}


</script>
<div align="center">

<fieldset style="width: 50%">

<legend>节目单修改</legend>

<div id="photo" style="display: none">
 <form name="picForm" action="updatePlayBill.do?id=${playbill.id }&method=image" method="post"
      enctype="multipart/form-data" onsubmit="return checkPic(picForm);" target="hidden_frame">
<table width="100%" border="0">
     <tr>
      <td>
      <div align="center"><img border="1" id="yourpic"
       onload="javascript:if(this.width>175)this.width=175;if(this.height>150)this.height=150;">
      </div>
      </td>
     </tr>
    
     <tr>

      <td>

      <div align="center"><input type="file" name="file" size="10"
       id="pic" onchange="changesrc()" />
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
</div>

      </td>

     </tr>

     <tr>
      <td>

	
      <div align="center"><input type="submit" value="上传照片" /></div>

      </td>
     </tr>
</table>
</form>
</div>

<form action="updatePlayBill.do?method=info" method="post" name="form">
<table width="603" border="0">
 <tr>
    <td width="97">节目单ID：</td>
    <td width="368"><input type="text" name="id" value="${playbill.id }" readonly="readonly"/></td>
  </tr>
  <tr>
    <td >节目单名称：</td>
    <td ><input type="text" name="name" value="${playbill.name }"/></td>
  </tr>
 <tr>
    <td>节目单图片：</td>
    <td><img src="<%=request.getContextPath() %>${playbill.imagesUrl }"/></td>
  </tr>
  <tr>
    <td>节目单介绍：</td>
    <td></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
<textarea rows="5" cols="30" name="description" >${playbill.description }</textarea>
</td>
  </tr>
  <tr>
    <td>添加时间：</td>
    <td><fmt:formatDate
				value="${playbill.addDate }" type="both" /></td>
  </tr>
  <tr>
    <td>视频数量：</td>
    <td>${fn:length(playbill.videoes)}</td>
  </tr>

  <tr>
    <td>添加用户：</td>
    <td>${playbill.user.userName }</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value="修改"/> <button onclick="showPhoto();">修改图片</button></td>
  </tr>
</table>

</form>

</fieldset>

</div>

</body>
</html>