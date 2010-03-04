<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>密他</title>
		<base target="_self">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>
	<body>
		<form action="<%=request.getContextPath()%>/sendMessage.do">
			<input  id="toUserId" name="toUserId"
				value="${param.toUserId }" />
			密语：
			<textarea rows="8" cols="60" name="message"></textarea>
			<br>
			<input type="submit" value="发送" />
			<input type="button" value="返回" onclick="self.close();" />
		</form>
	</body>
</html>
