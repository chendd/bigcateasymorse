<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- calendar  -->
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<style type="text/css">
<!--
.s1{
	
	border:1pt double #BDD6E8  ;
	
	height:16pt;
	padding: 2pt inherit;
	text-align:center;
	color: #0099CC;
	background-color: #E5EAFE;
}


.s2{
	
		border:1pt double #FF0000  ;
	
	height:16pt;
	padding: 2pt inherit;
	text-align:center;
	color: #e50000;
	background-color: #fff2f2;
	
}

.s3{
	
		border:1pt double #00dd00  ;
	
	height:16pt;
	padding: 2pt inherit;
	text-align:center;
	color: #009900;
	background-color: #f2fdf2;
	
}
-->
</style>
<script type="text/javascript" src="js/reguser.js"></script>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>
<div class="module">
<div class="title">
<span><a href="getUsers.do">会员管理</a></span>
<h2>新增会员</h2>
</div>
<div class="reDiv">
<form action="userCreate.do" method="post" name="form">



 <table width="717" border="0">

  <tr>
    <td>必填：</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="139">Email：</td>
    <td width="302"><input type="text" name="email" id="email" onblur="check_email_input(this)" onfocus="click_email_input(this)"/></td>
    <td width="254"><span id="regemailinfo" class=""></span></td>
  </tr>
  <tr>
    <td>用户名：</td>
    <td><input type="text" name="userName" id="userName" onblur="check_userName_input(this)" onfocus="click_userName_input(this);"/></td>
    <td><span id="regeuserNameinfo" class=""></span></td>
  </tr>
  <tr>
    <td>密码：</td>
    <td><input type="text" name="password" id="password" onblur="check_password_input(this)" onfocus="click_password_input(this);"/></td>
    <td><span id="regpassinfo" class=""></span></td>
  </tr>
  <tr>
    <td>重复密码：</td>
    <td><input type="text" name="passwordAgain" id="passwordAgain" onblur="check_chkpass_input(this)" onfocus="click_chkpass_input(this)"/></td>
    <td><span id="regpass2info" class=""></span></td>
  </tr>

  <tr>
    <td>昵称：</td>
    <td><input type="text" name="fullName" onblur="check_fullName_input(this)" onfocus="click_fullName_input(this)"/></td>
    <td><span id="regefullNameinfo" class=""></span></td>
  </tr>
  <tr>
    <td>性别：</td>
    <td>
		<input type="radio" value="m" name="gender"/>男 <input type="radio" value="f" name="gender" checked='checked'/>女 <input type="radio" value="s" name="gender" />保密
	</td>
    <td></td>
  </tr>


  
  <tr>
    <td>&nbsp;</td>
    <td>
		<button onclick="submitForm()">添加</button>
</td>
    <td>&nbsp;</td>
  </tr>
</table>
 

  
  </form>
</div>
</div>










