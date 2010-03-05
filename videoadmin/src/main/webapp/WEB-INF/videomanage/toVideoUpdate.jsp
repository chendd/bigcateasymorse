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
<script type="text/javascript" src="js/window/prototype.js"></script>
<script type="text/javascript" src="js/player/swfobject.js"></script>
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


function showit(){
	if(re.style.display==""){
		re.style.display="none";
		}
	else{
		re.style.display="";
		}
	
}

function submitit(){

	document.form1.submit();
}
function updateit(){
	document.form.submit();
}

</script>
<div class="module">
<div class="title">
<h2>FLV视频修改</h2>
</div>
<div class="reDiv">
<div id="photo" style="display: none">
 <form name="picForm" action="updateVideo.do?id=${video.id }&type=image" method="post"
      enctype="multipart/form-data" onsubmit="return checkPic(picForm);" target="hidden_frame" >
<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
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


<form action="updateVideo.do" method="post" name="form">
<table width="650" border="0">
<tr>
<td>预览：</td>
<td>
<p id="player1"> </p>
<script type="text/javascript">
	var s1 = new SWFObject("js/player/player.swf","single","320","240","7");
	s1.addParam("allowfullscreen","true");

	s1.addVariable("autostart","true");
	s1.addVariable("image","preview.jpg");
	s1.addVariable("width","320");
	s1.addVariable("height","240");
	s1.addParam('flashvars','&file=${video.url}&streamer=rtmp://124.42.74.136/oflaDemo&skin=js/player/3dpixelstyle.swf');
	s1.write("player1");
</script>

</td>
</tr>
  <tr>
    <td width="140">视频ID：</td>
    <td width="500">
<input type="text" name="id" value="${video.id }" readonly="readonly"/>
</td>
  </tr>
  <tr>
    <td>视频名称：</td>
    <td>
<input type="text" name="name" value="${video.name }"/>
</td>
  </tr>
  <tr>
    <td>URL：</td>
    <td>
<input type="text" name="url" value="${video.url }"/>
</td>
  </tr>
  <tr>
    <td>截图：</td>
    <td><img src="<%=application.getAttribute("IMAGE_URL")%>/${video.image }"/></td>
  </tr>

  <tr>
    <td>分类：</td>
    <td>
<select name="channelId">
<c:forEach items="${channels}" var="channel">

<option value="${channel.id }" <c:if test="${channel.id==video.channel.id}">selected="selected"</c:if>>${channel.name }</option>
</c:forEach>
</select>

</td>
  </tr>
  <tr>
    <td>上传用户：</td>
    <td>${video.user.userName }</td>
  </tr>
  <tr>
    <td>大小：</td>
    <td>${video.videoSize }</td>
  </tr>
  <tr>
    <td>时长：</td>
    <td>${video.videoTime }</td>
  </tr>
  <tr>
    <td>人气：</td>
    <td>${video.browseCount }</td>
  </tr>
  <tr>
    <td>得分：</td>
    <td>${video.point }</td>
  </tr>
  <tr>
    <td>被顶次数：</td>
    <td>${video.pushCount }</td>
  </tr>
  <tr>
    <td>状态：</td>
    <td>

<input type="radio" name="flag" value="1"  <c:if test="${video.flag==1}">checked="checked"</c:if>/>正常 <input type="radio" name="flag" value="2"  <c:if test="${video.flag==2}">checked="checked"</c:if> />锁定
</td>
  </tr>
  <tr>
    <td>添加时间：</td>
    <td><fmt:formatDate
				value="${video.addDate }" type="both" /></td>
  </tr>
  <tr>
    <td>标签：</td>
    <td>

<input name="tag1" type="text" value="${tags[0].name }" size="5"/>
<input name="tag2" type="text" value="${tags[1].name }" size="5"/>
<input name="tag3" type="text" value="${tags[2].name }" size="5"/>
<input name="tag4" type="text" value="${tags[3].name }" size="5"/>
<input name="tag5" type="text" value="${tags[4].name }" size="5"/>
</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
<button onclick="updateit();">修改</button> <button disabled="disabled" onclick="showPhoto();">修改图片</button> <button onclick="showit();">推荐待选</button>
</td>
  </tr>

</table>

</form>
<div id="re" style="display: none;border: 4px solid navy;width: 400px">
<form action="createCandidateVideo.do?method=create" method="post" name="form1">
推荐原因：<br />
<textarea rows="5" cols="30" name="sake"></textarea><br />
<input type="hidden" name="videoId" value="${video.id }"/>
<button onclick="submitit();">添加</button>

</form>
</div>
</div>
</div>


</body>
</html>