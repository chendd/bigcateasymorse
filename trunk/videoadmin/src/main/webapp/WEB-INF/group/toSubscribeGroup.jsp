<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- calendar  -->
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>

<script type="text/javascript" src="js/reguser.js"></script>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<div class="module">
<div class="title">
<span><a href="getUsers.do">小组管理</a></span>
<h2>精品小组</h2>
</div>
<div class="reDiv">
<form action="updateRecommendGroups.do" method="post" name="form">
 <table width="717" border="0">

<tr><td>序号1：</td><td><input type="text" name="group1" value="${groups[0].id }"/></td></tr>

<tr><td>序号2：</td><td><input type="text" name="group2" value="${groups[1].id }"/></td></tr>

<tr><td>序号3：</td><td><input type="text" name="group3" value="${groups[2].id }"/></td></tr>

<tr><td>序号4：</td><td><input type="text" name="group4" value="${groups[3].id }"/></td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="提交"/></td></tr>
</table>
	

  
  </form>
</div>
</div>










