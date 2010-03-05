<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	photo.style.display="";
}


</script>
<div align="center"  style="text-align: center;">
<fieldset style="width: 50%">


<legend>圈子修改</legend>
<div id="photo" style="display: none">
 <form name="picForm" action="updateGroup.do?id=${group.id }&type=photo" method="post"
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
<form action="updateGroup.do?type=one" method="post" name="form1">

<table width="490" border="0">
  <tr>
    <td width="137"><div align="center">圈子ID：</div></td>
    <td width="330"><div align="center"><input type="text" name="id" readonly="readonly" value="${group.id }"/></div></td>
  </tr>
  <tr>
    <td><div align="center">圈子名称：</div></td>
    <td><div align="center"><input type="text" name="name"  value="${group.name }"/></div></td>
  </tr>
  <tr>
    <td><div align="center">圈子图标：</div></td>
    <td><div align="center"><img src="<%=request.getContextPath() %>${group.image }"/></div></td>
  </tr>
  <tr>
    <td><div align="center">圈主：</div></td>
    <td><div align="center">${group.owner.userName}</div></td>
  </tr>
  <tr>
    <td><div align="center">圈子介绍：</div></td>
    <td><div align="center">
<textarea rows="5" cols="40" name="descrption">${group.descrption }</textarea>
</div></td>
  </tr>
  <tr>
    <td><div align="center"></div></td>
    <td><div align="left"><button onclick="submitit();">修改</button> <button onclick="showPhoto();">修改头像</button></div></td>
  </tr>
</table>
 

  
  </form>

</fieldset>
</div>

</body>
</html>