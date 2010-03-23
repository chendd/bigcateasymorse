<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML xmlns="http://www.w3.org/1999/xhtml"><HEAD><META http-equiv="Content-Type" content="text/html; charset=GBK">



<TITLE>会员注册</TITLE>
<LINK href="<%=request.getContextPath() %>/css/div_css.css" rel="stylesheet" type="text/css">
<LINK href="<%=request.getContextPath() %>/css/css_new.css" rel="stylesheet" type="text/css">
<!--<SCRIPT language="javascript" src="<%=request.getContextPath() %>/css/changecity.js"></SCRIPT>-->
<SCRIPT language="javascript" src="<%=request.getContextPath() %>/css/chkfunc.js"></SCRIPT>
<SCRIPT language="javascript">
function check(frm)
{
if (frm.member_user.value==""){
			alert("用户名不能为空！");
			frm.member_user.focus();
			return false;
	}

	if (frm.member_pass.value!=frm.member_pass1.value){
		alert("两次输入的密码不相同!");
		frm.member_pass.focus();
		return false;
	}
	if (frm.member_pass.value.length < 6){
			alert("密码不能小于6位！");
			frm.member_name.focus();
			return false;
	}
		if (frm.member_name.value==""){
			alert("姓名不能为空！");
			frm.member_name.focus();
			return false;
	}

	if (frm.member_tel.value!=""){
		if (!CheckInput(frm.member_tel.value,"0123456789０１２３４５６７８９-+ ()（）转分机")){
			alert("请输入正确的手机号码！");
			frm.member_tel.focus();
			return false;
		}
	}
	else
	{
	   alert("手机号码不能为空！");
			frm.member_tel.focus();
			return false;
	}
		if (frm.member_tel.value.length < 11||frm.member_tel.value.length > 19){
			alert("请输入正确的手机号码！");
			frm.member_tel.focus();
			return false;
	}
}
</SCRIPT>
<STYLE type="text/css">
<!--
.style1 {color: #FF6600}
.hui {color:#7B7B7B;}
.STYLE4 {color: #FF6500}
.title{ font-size:14px; font-weight:bold;color:#006699; border-right:1px dashed #BAD9F1}
.contentbox{width:700px; padding:10px; margin:20px 30px 20px 95px; /*background:#fff;*/ border:1px solid #F1FAFE;}
.contentbox2{width:700px; padding:10px; margin:20px 30px 20px 95px; background:#F7FDFF; border:1px dashed #BAD9F1;}

.reg_inputxt{

	height:17px;
	line-height:17px;
	width:167px;
	margin:0 5px 0 10px;
}
-->
</STYLE>
</HEAD><BODY>
<jsp:include page="/header.jsp"></jsp:include>
<DIV id="head">


<DIV class="Container" style="border:1px solid #9FD1F7; background:#F1FAFE;">
<DIV style=" height:75px;margin:1px;border-bottom:1px solid #BAD9F1; background:#D3ECFA;">
  <TABLE width="100%" height="75" border="0" cellspacing="0" cellpadding="0">
    <TBODY><TR>
      <TD width="10%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<IMG src="css/icon52.gif" style="margin-bottom:-8px;"></TD>
      <TD width="23%"><SPAN style="font-size:20px; font-weight:bold;">新用户注册</SPAN></TD>
      <TD width="67%" class="cheng" style="font-size:14px">现在注册，您将立即获得<SPAN class="red14">
            1000
            点</SPAN>会员积分，积分可以换取各种精彩大奖！赶快行动吧。</TD>
    </TR>
  </TBODY></TABLE>
</DIV>
<FORM name="formreg" method="post" action="register_submit.do" onsubmit="return check(this);">
<DIV class="contentbox"><!--经过效果：onmouseover="this.className='contentbox2'" onmouseout="this.className='contentbox'"-->
<TABLE width="100%" border="0" cellspacing="0" cellpadding="0">
  <TBODY><TR>
<TD width="52" rowspan="5" align="center" class="title">&nbsp;</TD>
          <TD width="100" height="38" align="right">用户名：</TD>
          <TD width="548"><INPUT name="alias" type="text" id="member_user" maxlength="25" class="reg_inputxt">
        <SPAN class="STYLE4">*&nbsp;</SPAN><SPAN class="hui">由英文字母或数字组成（不超过12个字符）</SPAN></TD>
      </TR>
        
        <TR>
          <TD height="38" align="right">密&nbsp;&nbsp;码：</TD>
          <TD><INPUT name="member_pass1" type="password" id="member_pass1" maxlength="25" class="reg_inputxt">
            <SPAN class="STYLE4">*<SPAN class="hui" id="chk_signup_pwd"> 建议设置6位字符以上的安全密码。</SPAN></SPAN></TD>
        </TR>
        
        <TR>
          <TD height="38" align="right">确认密码：</TD>
          <TD><INPUT name="password" type="password" id="member_pass" maxlength="25" class="reg_inputxt">
            <SPAN class="STYLE4">*&nbsp;<SPAN class="hui">再次确认密码</SPAN></SPAN></TD>
  </TR>
  
          <TR>
          <TD height="38" align="right">姓&nbsp;&nbsp;名：</TD>
          <TD><INPUT name="userName" type="text" id="member_name" maxlength="20" class="reg_inputxt">
            <SPAN class="STYLE4">*&nbsp;<SPAN class="hui">请填写真实姓名，以便提高我们的服务质量</SPAN></SPAN></TD>
  </TR>
            <TR>
          <TD height="38" align="right">手机号码：</TD>
          <TD><INPUT name="phone" type="text" id="member_tel" maxlength="35" class="reg_inputxt">
            <SPAN class="STYLE4">* </SPAN><SPAN class="hui666">请正确填写您的手机号码，以便我们确认您的预订服务。</SPAN></TD>
  </TR>
</TBODY></TABLE></DIV>
<TABLE width="90%" height="46" border="0" cellpadding="0" cellspacing="0">
  <TBODY><TR>
    <TD width="271" rowspan="2">&nbsp;</TD>
    <TD width="584"><INPUT type="submit" name="Submit3" value="  提交  ">&nbsp;
      <INPUT type="reset" name="Submit22" value="重置"></TD>
  </TR>
  <TR>
    <TD>&nbsp;</TD>
  </TR>
</TBODY></TABLE>
</FORM>
</DIV>
</DIV></DIV></BODY></HTML>