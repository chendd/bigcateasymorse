<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.video.domain.User"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<%
User user = (User) request.getAttribute("user");
int year = 0;
int month = 0;
int day = 0;
if(user.getBirthday()!=null){
	year = user.getBirthday().getYear();
	month = user.getBirthday().getMonth()+1;
	day = user.getBirthday().getDate();
}
%>

<script type="text/javascript">
function submitit(){
	document.form1.action="updateUser.do?type=one";
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

<div class="module">
<div class="title">
<h2>会员修改</h2>
</div>
<div class="reDiv">
<form action="updateUser.do?type=one" method="post"  name="form1">



 <table width="717" border="0">


  <tr>
    <td width="139">Email：</td>
    <td width="302"><input type="text" readonly="readonly" name="email" id="email" value="${user.email }" /></td>
   <td width="254"></td>
  </tr>
  <tr>
    <td>用户名：</td>
    <td><input type="text" name="userName" id="userName" value="${user.userName }" readonly="readonly"/></td>
    <td><span id="regeuserNameinfo" class=""></span></td>
  </tr>

  <tr>
    <td>昵称：</td>
    <td><input type="text" name="fullName" value="${user.realName }"/></td>
    <td><span style="color: red;">${messages.realName }</span></td>
  </tr>
 <tr>
    <td>头像：</td>
    <td><img src="${IMAGE_URL }/${user.face }"/></td>
    <td></td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>

		<input type="radio" value="m" <c:if test="${user.gender eq 'm'}">checked="checked"</c:if>  name="gender"/>男 <input type="radio" value="f" name="gender" <c:if test="${user.gender eq 'f'}">checked="checked"</c:if> />女 <input type="radio" value="s" name="gender" <c:if test="${user.gender eq 's'}">checked="checked"</c:if>/>保密
	</td>
    <td></td>
  </tr>




  
  <tr>
    <td>&nbsp;</td>
    <td>
		<button onclick="submitit();">修改</button> <button disabled="disabled" onclick="showPhoto();">修改头像</button>
		
</td>
    <td>&nbsp;</td>
  </tr>


</table>
 

  
  </form>
</div>
</div>

<div style="text-align: left;">

<div align="center"  style="text-align: center;">
<fieldset style="width: 50%">


<div id="photo" style="display: none">
 <form name="picForm" action="updateUserFace.do?id=${user.id }&type=photo" method="post"
      enctype="multipart/form-data" onsubmit="return checkPic(picForm);" target="hidden_frame">
<table width="100%" border="0">
     <tr>
      <td>
      <div align="center"><img border="1" id="yourpic" src="/1mpAdmin/${user.face }"
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


</fieldset>
</div>
</div>

</body>
</html>