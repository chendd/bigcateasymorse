<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- calendar  -->
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>

<script type="text/javascript" src="js/reguser.js"></script>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<div class="module">
<div class="title">
<span><a href="getUsers.do">会员管理</a></span>
<h2>每周明星</h2>
</div>
<div class="reDiv">
<form action="starUpdate.do" method="post" name="form">
 <table width="717" border="0">
<tr><td>男明星ID：</td><td><input type="text" name="male" value="${starIds[0] }"/></td></tr>
<tr><td>女明星ID：</td><td><input type="text" name="female" value="${starIds[1] }"/></td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="提交"/></td></tr>
</table>
	

  
  </form>
</div>
</div>










