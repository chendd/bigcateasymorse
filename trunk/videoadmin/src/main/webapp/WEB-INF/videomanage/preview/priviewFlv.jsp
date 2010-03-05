<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- prototype -->
<script type="text/javascript" src="js/window/prototype.js"></script>
<script type="text/javascript" src="js/player/swfobject.js"></script>
</head>
<body>
<p id="player1"> </p>
<script type="text/javascript">
var s1 = new SWFObject("js/player/player.swf","single","320","240","7");
s1.addParam("allowfullscreen","true");


s1.addParam('flashvars','&file=${url}&autostart=true');
s1.write("player1");
</script>
</body>
</html>