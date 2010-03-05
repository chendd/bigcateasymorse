<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="text-align: left;">管理导航：<a
	href="getAdmins.do">管理员设置</a>|新增管理员</div>


<br />
<br />
<br />
<br />
<script type="text/javascript">
function checkName(){
	var name = document.getElementById('name').value;
	if(!/\W/.test(name)&&name!='')
	
	var url = 'adminCreate.do';
	var pars = 'name='+name+"&type=ajax";
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :checkOk
	});


}

function checkOk(originalRequest){
	
	jsonRaw = originalRequest.responseText;
	if(jsonRaw=='exist'){
		mss.style.display='';
	}
	
}
function msgreset(){

	mss.style.display='none';
}
</script>
<div style="text-align: center;">
<form action="adminCreate.do" method="post" name="form">

<fieldset style="width: 50%">
<legend>管理员添加</legend>
<br/>

  <div>
    <div >帐号：<span id="mss" style=" display: none;color: red;">(该帐号已存在)</span></div>
  </div>
  <div>
    <div>
      <input class="validate-alphanum" onblur="checkName();" onfocus="msgreset();"  title="帐号由字符或数字组成" name="name" id="name"   size="25"/>
      </div>
  </div>
  <div>
    <div >密码：</div>
  </div>
  <div>
    <div >
      <input  class="required "  title="请输入密码." name="password" id="password" type="password" size="25"/>
      </div>
  </div>
  
    <div>
      <div >
      <br />
        
        <input  type="submit"  value="添加"/>
        </div>
    </div>
    </fieldset>

  
  </form>
</div>

<script type="text/javascript">
    new Validation('form',{useTitles : true,immediate : true});

  
    
</script>
