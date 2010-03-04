<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
	rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/json/json.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/json/formatdate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/sessionutil.js"></script>
<script type="text/JavaScript" src="<%=request.getContextPath()%>/js/rounded_corners_lite.inc.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog/dialog.js"></script>
<script type="text/javascript">
function search(k){
	var types;
	var key='';
	var type;
	if(k=='1'){
		types = document.getElementsByName('type');
		 key = document.getElementById('key').value;
		}
	else{
		 types = document.getElementsByName('type2');
		 key = document.getElementById('key2').value;

		}
	


	
	
	for(var i=0;i<types.length;i++){
		
		if(types[i].checked==true){
			type=types[i].value;
		
			break;
		}
		
	}
	
	document.location.href='<%=request.getContextPath()%>/search/'+type+'/addDate/'+key+'/1/';
}


 function aa()
	  {
	      /*
	      The new 'validTags' setting is optional and allows
	      you to specify other HTML elements that curvyCorners
	      can attempt to round.

	      The value is comma separated list of html elements
	      in lowercase.

	      validTags: ["div", "form"]

	      The above example would enable curvyCorners on FORM elements.
	      */
	          settings = {
	          tl: { radius: 10 },
	          tr: { radius: 10 },
	          bl: { radius: 10 },
	          br: { radius: 10 },
	      antiAlias: true,
	      autoPad: false
	    } 

	      /*
	      Usage:

	      newCornersObj = new curvyCorners(settingsObj, classNameStr);
	      newCornersObj = new curvyCorners(settingsObj, divObj1[, divObj2[, divObj3[, . . . [, divObjN]]]]);
	      */
	
	      var myBoxObject2 = new curvyCorners(settings, "xmain");
	   
	      myBoxObject2.applyCornersToAll();
	  }


 function getNewMessCount(){
	 var uid = '${sessionUser.id}';
	 if(uid!=''){
		 var url = '<%=request.getContextPath()%>/getMessageCount.do';
			new Ajax.Request(url, {
				method :'post',
				
				onComplete :showResult
			});
		 }
		
	 }
	  
 function showResult(originalRequest) {
		jsonRaw = originalRequest.responseText;
	$('me').innerHTML=jsonRaw;
		
	}
</script>





		<div id="header1">
<div style="height:70px;margin:0 auto;position:relative;width:1200px;">
<div style="float:left;height:60px;margin:20px 0 0 40px;width:210px;"><img height="50px"  src="<%=request.getContextPath()%>/images/logo.gif" /></div>



			
<div style="float:right;margin:20px 0 0;max-width:550px;overflow:hidden;padding:0 120px 0 0;text-align:right;white-space:nowrap;" class="topmenu">


			<c:if test="${sessionUser!=null}">
					欢迎你 <a href="<%=request.getContextPath()%>/home/${sessionUser.id }/">${sessionUser.realName }</a>&nbsp;|&nbsp;
				<a href="<%=request.getContextPath()%>/exit/">退出</a>&nbsp;|&nbsp;<a href="<%=request.getContextPath()%>/vblog/mybox/"><span id="me">0</span>条新短信</a>&nbsp;&nbsp;<br/>
				</c:if>
				<c:if test="${sessionUser==null}">
	
<form name="form1" action="<%=request.getContextPath()%>/login.do" onsubmit="password.value =hex_md5(password.value)" method="post" onsubmit="return checkit();">
<table>
<tr>
<td><label style="color: black;">登录ID:</label></td><td><input name="userName" id="userName" size="5" type="text"/></td>
<td><label style="color: black;">密码:</label></td><td><input size="5" name="password" id="password"  type="password"/></td>
<td><label style="color: black;">验证码:</label></td><td><input size="5" name="random"  type="text"/></td><td><img src="<%=request.getContextPath()%>/randomImage.do" /></td>
<td><input type="submit" style="border:0pt none;width:45px;height: 20px;background:transparent url(<%=request.getContextPath()%>/images/login.gif) no-repeat scroll 0% 0%;" value=" "/></td>
<td><a href="<%=request.getContextPath()%>/register/"><img src="<%=request.getContextPath()%>/images/reg.gif" /></a></td>
</tr>
</table>

</form>

						
</c:if>	





					<c:if test="${not empty sessionUser }">
<a href="<%=request.getContextPath()%>/" title="首页">我的首页</a>&nbsp;|&nbsp;
</c:if>
<c:if test="${empty sessionUser }">
<a href="<%=request.getContextPath()%>/" title="首页">首页</a>&nbsp;|&nbsp;
</c:if>
				
					<a href="<%=request.getContextPath()%>/video/index/" title="视频">视频</a>&nbsp;|&nbsp;
					<a href="<%=request.getContextPath()%>/vblog/index/" title="博客">博客</a>&nbsp;|&nbsp;				
					<a href="<%=request.getContextPath()%>/group/index/" title="小组">小组</a>&nbsp;|&nbsp;				
					<a href="<%=request.getContextPath()%>/playbill/index/" title="节目单">节目单</a>&nbsp;|&nbsp;				
					<a href="<%=request.getContextPath()%>/search/index/" title="搜索">搜索</a>&nbsp;|&nbsp;				
					<a href="<%=request.getContextPath()%>/tag/index/" title="标签">标签</a>&nbsp;|&nbsp;					
					<a href="<%=request.getContextPath()%>/notices/">帮助</a>&nbsp;|&nbsp;
				<a href="#">RSS</a>&nbsp;&nbsp;

<script type="text/javascript">
getNewMessCount();

</script>
</div>
</div>

		</div>


<div id="vdividermenu2" >
<div style="width: 980px;text-align: center">
<font size="6">${user.realName }</font>
</div>
<div >
<img src="<%=request.getContextPath()%>/images/house.gif"> <a href="<%=request.getContextPath()%>/home/${user.id }">个人首页</a>　　　　
<img src="<%=request.getContextPath()%>/images/ico_profile.gif"> <a href="<%=request.getContextPath()%>/home/${user.id }">档案</a>　　　
<img src="<%=request.getContextPath()%>/images/ico_entry.gif"> <a href="<%=request.getContextPath()%>/blogList/${user.id }">日志</a>　　　　
<img src="<%=request.getContextPath()%>/images/ico_video.gif"> <a href="<%=request.getContextPath()%>/user/${user.id }/videoes/1">视频</a>　　　　
<img src="<%=request.getContextPath()%>/images/ico_picture.gif"> <a href="<%=request.getContextPath()%>/user/${user.id }/playbills/1">节目单</a>　　　　
</div>
<div style="width: 980px;text-align: right;">
		
			<input type="radio" name="type" value="video" checked="checked" />
		<label style="color:000000;">视频</label> &nbsp;&nbsp;
		<input type="radio" name="type" value="vblog" />
		<label style="color:000000">播客</label>&nbsp;&nbsp;
		<input type="radio" name="type" value="playbill"/>
		<label style="color:000000;">节目单</label> &nbsp;&nbsp;
		<input type="text" name="key"  id="key" size="10" />&nbsp;
<button onclick="search('1')" style="border:0pt none;width:45px;height: 20px;background:transparent url(<%=request.getContextPath()%>/images/putin.gif) no-repeat scroll 0% 0%;">&nbsp;</button>
	</div>
		</div>