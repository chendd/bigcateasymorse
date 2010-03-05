<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	FCKeditor fckEditor = new FCKeditor(request, "text");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="net.fckeditor.FCKeditor"%>
<%@page import="com.video.domain.Topic"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>	
<div align="center">
<form action="updateTopic.do?type=one" method="post" name="form">

<table width="797" border="0">
  <tr>
    <td width="83" height="19">ID：</td>
    <td width="616"><input type="text" name="id" readonly="readonly" value="${topic.id }"/></td>
  </tr>
  <tr>
    <td >标题：</td>
    <td width="616"><input type="text" name="title" value="${topic.title }"/></td>
  </tr>
  <tr>
    <td></td>
    <td>
<%
					fckEditor.setValue("");
					fckEditor.setToolbarSet("Topic");
					Topic topic = (Topic)request.getAttribute("topic");
					if (topic != null) {
						fckEditor.setValue(topic.getText());
					}
					out.println(fckEditor);
				%>
</td>
  </tr>
  <tr>
    <td>是否推荐：</td>
    <td>

<input type="radio" name="recommend" value="y" />是 <input type="radio" <c:if test="${not empty topic.recommendDate }">checked="checked"</c:if> name="recommend" <c:if test="${empty topic.recommendDate}">checked="checked"</c:if> value="n"/>否
</td>
  </tr>
  <tr>
    <td>状态：</td>
    <td>
<input type="radio" name="flag" value="1" />正常 <input type="radio" <c:if test="${topic.flag==1}">checked="checked"</c:if> name="flag" <c:if test="${topic.flag==2}">checked="checked"</c:if> value="2"/>锁定
</td>
  </tr>
  <tr>
    <td>发表时间：</td>
    <td><fmt:formatDate
				value="${topic.addDate }" type="both" /></td>
  </tr>
  <tr>
    <td>发表用户：</td>
    <td>${topic.user.userName }</td>
  </tr>
  <tr>
    <td>所属圈子：</td>
    <td>${topic.group.name }</td>
  </tr>
  <tr>
    <td>回复数量：</td>
    <td>${fn:length(topic.comments)}</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>
<input type="submit" value="修改"/>
</td>
  </tr>
</table>
	</form>
</div>		
</body>
</html>