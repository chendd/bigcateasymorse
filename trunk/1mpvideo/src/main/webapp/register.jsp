<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/json/json.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/json/formatdate.js"></script>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5/md5.js"></script>
<script type="text/javascript">
var submitFlag = 0;
	//切换行背景以及输入框样式
function change_style(inputObj, actionType, trId){
	if (inputObj.type=='text' || inputObj.type=='textarea' || inputObj.type=='password'){
		switch (actionType){
			case 'onfocus':
				inputObj.style.backgroundColor = '#fff9f8';
				inputObj.style.border = '1px inset #999';
				break;
			case 'onblur':
				inputObj.style.backgroundColor = '#fff';
				inputObj.style.border = '1px solid #ccc';
				break;
		}
	}
	
	for (var i=1; i<=9; i++){
		$("tr_"+i).style.backgroundColor = "";
	}
	if (trId!=''){
		$(trId).style.backgroundColor = "#EEF5FD";
	}
}
//得到提示信息
function get_msg(infoType, divId, msg){
	//infoType: 'ok', 'err', ''
	var htmlCode;
	switch (infoType){
		case "ok":
			htmlCode = ''+
			'<table width="100%" border="0" cellspacing="0" cellpadding="0">'+
			'	<tr>'+
			'		<td style="padding-left:5px; border:0px;">'+
			'			<img src="<%=request.getContextPath()%>/images/right.gif" width="12" height="12">'+msg+
			'		</td>'+
			'	</tr>'+
			'</table>'+
			'<input type="hidden" name="check_flag[]" value="ok">';
			break;
		case "err":
			htmlCode = ''+
			'<table width="100%" border="0" cellspacing="0" cellpadding="0">'+
			'  <tr>'+
			'	<td width="7%" valign="middle" style="padding-left:5px; border:0px;">'+
			'		<font color="#FF0099"><img src="<%=request.getContextPath()%>/images/wrong.gif" width="12" height="12"></font>'+
			'	</td>'+
			'	<td align="left" style="border:0px;">'+
			'		<span class="textCol2">'+msg+'</span>'+
			'	</td>'+
			'  </tr>'+
			'</table>'+
			'<input type="hidden" name="check_flag[]" value="err">';
			break;
		default:
			htmlCode = ''+
			'<table width="100%" border="0" cellspacing="0" cellpadding="0">'+
			'	<tr>'+
			'		<td style="padding-left:5px; border:0px;">'+
			'			<span class="textCol4">'+msg+'</span>'+
			'		</td>'+
			'	</tr>'+
			'</table>'+
			'<input type="hidden" name="check_flag[]" value="">';
	}
	$(divId).innerHTML = htmlCode;
}
//得到密码安全级别
function get_pwd_safe_level(pwd, divId){
	var strong = 0;
	var L = 0;
	var C = 0;
	var S = 0;
	for(var i=0; i<pwd.length; i++)	{
		if(pwd.charAt(i)>='a' && pwd.charAt(i)<='z'){
			L = 1;
		}
		if(pwd.charAt(i)>='A' && pwd.charAt(i)<='Z'){
			C = 1;
		}
		if(pwd.charAt(i)>='0' && pwd.charAt(i)<='9'){
			S = 1;
		}
	}
	strong = L + C + S;

	var lowBg = '#fff';
	var middleBg = '#fff';
	var heightBg = '#fff';

	switch (strong){
		case 3: heightBg='#ffcccc'; break;
		case 2: middleBg='#ffcccc'; break;
		default: lowBg='#ffcccc'; break;
	}

	var htmlCode = ''+
		'<table width="100%" border="0" cellpadding="0" cellspacing="0">'+
		'	<tr>'+
		'		<td width="7%" valign="middle" style="padding-left:5px; border:0px;">'+
		'			<font color="#FF0099"><img src="<%=request.getContextPath()%>/images/right.gif" width="12" height="12"></font>'+
		'		</td>'+
		'		<td width="20%" align="left" valign="baseline" style="border:0px;">'+
		'			<span class="textCol4">密码安全级别</span>'+
		'		</td>'+
		'		<td align="left" valign="middle" style="border:0px;">'+
		'			<div style="border:1px solid #ccc; width:152px;">'+
		'				<div style="width:50px; height:20px; float:left; background:'+lowBg+'; text-align:center; line-height:20px; color:#cc0000;">低</div>'+
		'				<div style="width:50px; height:20px; float:left; background:'+middleBg+'; text-align:center; line-height:20px; color:#cc0000;">中</div>'+
		'				<div style="width:50px; height:20px; float:left; background:'+heightBg+'; text-align:center; line-height:20px; color:#cc0000;">高</div>'+
		'				<div class="clear"></div>'+
		'			</div>'+
		'		</td>'+
		'	</tr>'+
		'</table>'+
		'<input type="hidden" name="check_flag[]" value="ok">';

	$(divId).innerHTML = htmlCode;
}
//后台检查用户名
function check_user_id_ajax(){
	if (!check_user_id_js()){
		return false;
	}
	var userName=$('loginName').value;
	
	var pars='userName='+userName;
	var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			if (jsonResult.id==''){
				get_msg('ok', 'userName_msg', '');
				return true;
			}else{
				get_msg('err', 'userName_msg', '此用户名已有人注册');
				return false;
			}
		}
		var getAjax = new Ajax.Request('<%=request.getContextPath()%>/getUser.do',{
			method:'post',parameters:pars,onComplete:showResult
		});
}
//前台检查用户名
function check_user_id_js(){
	var userIdObj = $("loginName");
	if (userIdObj.value.length==0 
		|| userIdObj.value.length<3 
		|| userIdObj.value.length>16
		|| /[^0-9a-z]/.test(userIdObj.value)){
		get_msg('err', 'userName_msg', '格式不正确，由3-16个小写英文字母或数字组成');
		return false;
	}
	get_msg('ok', 'userName_msg', '(由3-16个小写英文字母或数字组成，用于登录1MP)');
	return true;
}
//检查密码
function check_password(){
	var pwdObj = $("password1");
	
	var pwdReObj = $("againPassword");
	if (pwdReObj.value.length!=0){
		check_password_re();
	}
	if (pwdObj.value.length==0 
		|| pwdObj.value.length<6
		|| pwdObj.value.length>16
		|| pwdObj.value.match('"') 
		|| pwdObj.value.match("'") 
		|| pwdObj.value.match(" ")){
		get_msg('err', 'password_msg', '格式不正确，6-16个字符，不能含空格、「"」及「\'」');
		return false;
	}
	get_pwd_safe_level(pwdObj.value, 'password_msg');
	return true;
}
//realName
function check_realName(){
	var rnObj = $("realName");
	if (rnObj.value.length==0 
		|| rnObj.value.length<2 
		|| rnObj.value.length>12
		|| rnObj.value.match('"') 
		|| rnObj.value.match("'") 
		|| rnObj.value.match(" ")){
		get_msg('err', 'realName_msg', '格式不正确，2-12个字符，不能含空格、「"」及「\'」');
		return false;
	}
	get_msg('ok', 'realName_msg', '(由2-12个小写英文字母或数字或汉字组成，用于1MP显示)');
	return true;
}

//检查密码确认
function check_password_re(){
	var pwdObj = $("password1");
	
	var pwdReObj = $("againPassword");
	if (pwdReObj.value.length==0){
		get_msg('err', 'againPassword_msg', '确认密码不能为空');
		return false;
	}
	if (pwdReObj.value.length != pwdObj.value.length||pwdReObj.value!=pwdObj.value){
		get_msg('err', 'againPassword_msg', '两次密码输入不一致');
		return false;
	}
	get_msg('ok', 'againPassword_msg', '');
	return true;
}

//前台检查邮箱
function check_email_js(){
	var mailObj = $("email");
	var regMail = /^(([A-Za-z0-9\-]+_+)|([A-Za-z0-9\-]+\-+)|([A-Za-z0-9\-]+\.+)|([A-Za-z0-9\-]+\++))*[A-Za-z0-9_\-]+@((\w+\-+)|(\w+\.))*\w{1,63}\.[a-zA-Z]{2,6}$/;
	if (!regMail.test(mailObj.value)){
		get_msg('err', 'email_msg', '邮箱格式不正确');
		return false;
	}
	get_msg('ok', 'email_msg', '(不公开，用于取回密码)');
	return true;
}
//后台检查邮箱
function check_email(){
	if (!check_email_js()){
		return false;
	}
	var email=$('email').value;
	var pars='email='+email;
	var showResult = function (originalRequest){
			var jsonResult = JSON.parse(originalRequest.responseText);
			if (jsonResult.id==''){
				get_msg('ok', 'email_msg', '');
				return true;
			}else{
				get_msg('err', 'email_msg', '此邮箱已有人注册');
				return false;
			}
		}
		var getAjax = new Ajax.Request('<%=request.getContextPath()%>/getUser.do',{
			method:'post',parameters:pars,onComplete:showResult
		});
}
//密码问题
function check_passwordHint(){
	var passwordHint=$('passwordHint');
	if (passwordHint.value.length<6||passwordHint.value.length>16){
			get_msg('err', 'passwordHint_msg', '问题格式错误，6-16个字符！');
			return false;
		}
		get_msg('', 'passwordHint_msg', '(用于取回密码的问题)');
		return true;
}
//密码答案
function check_hintAns(){
	var hintAns=$('hintAns');
		if (hintAns.value.length<6||hintAns.value.length>16){
				get_msg('err', 'hintAns_msg', '答案格式错误，6-16个字符！');
				return false;
			}
			get_msg('', 'hintAns_msg', '(用于取回密码的答案)');
			return true;
}
//手机
function check_mobilePhone(){
	var mobilePhone = $('mobilePhone');
	if (mobilePhone.value.length==0){
		get_msg('', 'mobilePhone_msg', '(不公开，用于密码保护和选用增值服务，可随时取消或修改)');
		return true;
	}
	if (!/1[3|5][\d]{9}/.test(mobilePhone.value)){
		get_msg('err', 'mobilePhone_msg', '手机格式不正确');
		return false;
	}
	get_msg('ok', 'mobilePhone_msg', '');
	return true;
}




//提交
function check_form(){
	if (!$('accede').checked){
		alert('请仔细阅读并同意1MP服务条款');
		return false;
	}
	var submitFlag = true;
	if(check_user_id_ajax()== false){submitFlag=false;}
	if(!check_password()){submitFlag=false;}
	if(!check_password_re()){submitFlag=false;}
	if(check_email()== false){submitFlag=false;}
	if(!check_passwordHint()){submitFlag=false;}
	if(!check_hintAns()){submitFlag=false;}
	if(!check_realName()){submitFlag=false;}
	
	if(!submitFlag){
		$('err_msg').innerHTML='您还有些信息不完整，请看红叉后的提示！';
		return;
	}
	var againPassword = $('againPassword').value;
	$('againPassword').value=hex_md5(againPassword);
	$('password1').value=$('againPassword').value;
	$(form_reg_user).submit();
}
</script>
<div class="module">
<div class="title">
<span><a href="<%=request.getContextPath()%>/login/">已经注册了?</a></span>
<h2>用户注册信息</h2></div>
<div class="">
<form action="<%=request.getContextPath()%>/register.do" method="post" id="form_reg_user"
	name="userForm">
	<table width="872" border="0" align="center">
		<input type="hidden" name="send" value="${send }" />
		<tr id="tr_h">
			<td>
				
			</td>
			<td colspan="2">
				<div id='err_msg' style="color: red;">
				</div>
			</td>
		</tr>
		
		<tr id="tr_1">
			<td width="161">
				<div align="right">
					登录ID:
				</div>
			</td>
			<td width="202">
				<input type="text" name="userName" id="loginName" maxlength="16"
					value="${userForm.userName }"
					style="border: solid 1px #ccc; background-color: #fff; width: 200px"
					onblur="change_style(this, 'onblur', '');check_user_id_ajax(); "
					onfocus="change_style(this, 'onfocus', 'tr_1');">
			</td>
			<td width="495">
				<div id="userName_msg">
					*
					<html:errors property="userName" />
				</div>
			</td>
		</tr>
		<tr id="tr_7">
			<td>
				<div align="right">
					昵称:
				</div>
			</td>
			<td>
				<input type="text" name="realName" id="realName" maxlength="10"
					value="${userForm.realName }"
					style="border: solid 1px #ccc; background-color: #fff; width: 200px"
					onblur="change_style(this, 'onblur', '');check_realName();"
					onfocus="change_style(this, 'onfocus', 'tr_7');">
			</td>
			<td>
				<div id="realName_msg">
					*<html:errors property="realName" />
				</div>
			</td>
		</tr>

		<tr id="tr_2">
			<td>
				<div align="right">
					密码:
				</div>
			</td>
			<td>
				<input type="password" name="password" id="password1" maxlength="16"
					style="border: solid 1px #ccc; background-color: #fff; width: 200px"
					onblur="change_style(this, 'onblur', ''); check_password();"
					onfocus="change_style(this, 'onfocus', 'tr_2');">
			</td>
			<td>
				<div id="password_msg">
					*
					<html:errors property="password" />
				</div>
			</td>
		</tr>
		<tr id="tr_3">
			<td>
				<div align="right">
					重复密码:
				</div>
			</td>
			<td>
				<input type="password" name="againPassword" id="againPassword"
					maxlength="16"
					style="border: solid 1px #ccc; background-color: #fff; width: 200px"
					onblur="change_style(this, 'onblur', ''); check_password_re();"
					onfocus="change_style(this, 'onfocus', 'tr_3');">
			</td>
			<td>
				<div id="againPassword_msg">
					*
					<html:errors property="againPassword" />
				</div>
			</td>
		</tr>
	<tr id="tr_8">
			<td>
				<div align="right">
					性别:
				</div>
			</td>
			<td>
				<input type="radio" name="gender" value="m"
					style="border: solid 1px #ccc; background-color: #fff"
					onblur="change_style(this, 'onblur', ''); "
					onfocus="change_style(this, 'onfocus', 'tr_8');">
				男
				<input type="radio" name="gender" value="f"
					style="border: solid 1px #ccc; background-color: #fff"
					onblur="change_style(this, 'onblur', ''); "
					onfocus="change_style(this, 'onfocus', 'tr_8');">
				女
				<input type="radio" name="gender" value="s" checked="checked"
					style="border: solid 1px #ccc; background-color: #fff"
					onblur="change_style(this, 'onblur', ''); "
					onfocus="change_style(this, 'onfocus', 'tr_8');">
				保密
			</td>
			<td>
				<div id="gender_msg"></div>
			</td>
		</tr>
		<tr id="tr_4">
			<td>
				<div align="right">
					邮箱:
				</div>
			</td>
			<td>
				<input type="text" name="email" id="email"
					value="${userForm.email }"
					style="border: solid 1px #ccc; background-color: #fff; width: 200px"
					onblur="change_style(this, 'onblur', ''); check_email();"
					onfocus="change_style(this, 'onfocus', 'tr_4');">
			</td>
			<td>
				<div id="email_msg">
					*
					<html:errors property="email" />
				</div>
			</td>
		</tr>
		<tr id="tr_5">
			<td>
				<div align="right">
					找回密码问题:
				</div>
			</td>
			<td>
				<input type="text" name="passwordHint" id="passwordHint"
					maxlength="16" value="${userForm.passwordHint }"
					style="border: solid 1px #ccc; background-color: #fff; width: 200px"
					onblur="change_style(this, 'onblur', ''); check_passwordHint();"
					onfocus="change_style(this, 'onfocus', 'tr_5');">
			</td>
			<td>
				<div id="passwordHint_msg">
					*
				</div>
			</td>
		</tr>
		<tr id="tr_6">
			<td>
				<div align="right">
					找回密码答案:
				</div>
			</td>
			<td>
				<input type="text" name="hintAns" id="hintAns" maxlength="16"
					value="${userForm.hintAns }"
					style="border: solid 1px #ccc; background-color: #fff; width: 200px"
					onblur="change_style(this, 'onblur', ''); check_hintAns();"
					onfocus="change_style(this, 'onfocus', 'tr_6');">
			</td>
			<td>
				<div id="hintAns_msg">
					*
					<html:errors property="hintAns" />
				</div>
			</td>
		</tr>

	
	
		<tr id="tr_9">
			<td>
				<div align="right">
					<input type="checkbox" name="accede" id="accede" value="y"
						checked="checked"
						style="border: solid 1px #ccc; background-color: #fff"
						onblur="change_style(this, 'onblur', ''); "
						onfocus="change_style(this, 'onfocus', 'tr_19');">
				</div>
			</td>
			<td>
				同意
				<a href="">1MP协议</a>
			</td>
			<td>
				<div id="accede_msg"></div>
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<input type="button" name="Submit" value="注册" onclick="check_form()">
			</td>
			<td>
			</td>
		</tr>
	</table>
</form>

</div>

</div>