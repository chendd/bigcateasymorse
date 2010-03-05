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



<div align="center">

<fieldset style="width: 50%">

<legend>节目单添加</legend>

<div>
<c:forEach items="${messages}" var="message">
${message}

</c:forEach>

</div>

<form action="createPlayBill.do" method="post" name="form">
<table width="603" border="0">
<tr>
   <td width="97">节目单名称：</td>
     <td width="368"><input type="text" name="name" value="${playbill.name }"/></td>
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
    <td>添加用户ID：</td>
    <td><input type="text" name="userId" /></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><input type="submit" value="保存"/> </td>
  </tr>
</table>

</form>

</fieldset>

</div>

</body>
</html>