<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>公司简介</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="wrap">
<div id="content">
<!--_____________________________________________________left_content_____________________________________________________-->
<jsp:include page="/left.jsp"></jsp:include>
<!--_____________________________________________________end_left_content_____________________________________________________-->

<!--_____________________________________________________right_content_____________________________________________________-->
<div id="right_content1">
<div class="inner_right1">

<jsp:include page="/menu.jsp"></jsp:include>



<div style="float:left; width:273px ">
<div style="margin-right:13px ">
<img alt="" src="images/4im1.jpg" align="left" class="img" width="85" height="88">
The Company Namer Inc.<br>
9870 St Vincent Place,<br>
Glasgow, DC 45 Fr 45.<br>
<br>
Freephone:<img alt="" src="images/spacer.gif" width="8" height="1">+44 800 559 6580<br>
Telephone:<img alt="" src="images/spacer.gif" width="11" height="1">+44 959 603 6035<br>
FAX:<img alt="" src="images/spacer.gif" width="42" height="1">+44 101 889 9898 <br>
</div>
<br>
</div>
</div>


<br>
<br>
<br>
<div class="clear">
<strong class="bold t">contact form</strong><br>
<img alt="" src="images/spacer.gif" width="1" height="5"><br>
<div class="line"><img alt="" src="images/spacer.gif" width="1" height="1"></div>
<img alt="" src="images/spacer.gif" width="1" height="26"><br>
<div style="margin-left:35px ">
<form action="" style="margin:0; padding:0 ">
<input type="text" class="form" value="Your name:"><img alt="" src="images/spacer.gif" width="19" height="1"><input type="text" class="form" value="Company name:"><br>
<img alt="" src="images/spacer.gif" width="1" height="5"><br>
<input type="text" class="form" value="Phone:"><img alt="" src="images/spacer.gif" width="19" height="1"><input type="text" class="form" value="E-mail:"><br>
<img alt="" src="images/spacer.gif" width="1" height="5"><br>
<textarea cols="5" rows="5" class="textarea">Message:</textarea><br>
<br>
<div align="right"><input name="" type="image" src="images/reset.jpg" width="29" height="10"><img alt="" src="images/spacer.gif" width="44" height="1"><input name="" type="image" src="images/submit.jpg" width="33" height="10"><img alt="" src="images/spacer.gif" width="50" height="1"></div>
</form>
</div>
</div>









<br>
<jsp:include page="/footer.jsp" />
</div>

</div>
</div>
<!--_____________________________________________________________end_right_content_____________________________________________________-->
</div>

</body>
</html>