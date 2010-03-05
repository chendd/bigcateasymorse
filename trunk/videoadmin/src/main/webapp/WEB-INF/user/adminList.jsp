<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- prototype -->
<script type="text/javascript" src="js/window/prototype.js"></script>

<!--prototype window -->
<script type="text/javascript" src="js/window/effects.js"></script>
<script type="text/javascript" src="js/window/window.js"></script>
<script type="text/javascript" src="js/window/window_effects.js"></script>
<link href="themes/default.css" rel="stylesheet" type="text/css"></link>
<link href="themes/spread.css" rel="stylesheet" type="text/css"></link>
<link href="themes/lighting.css" rel="stylesheet" type="text/css"></link>
<link href="themes/alphacube.css" rel="stylesheet" type="text/css"></link>
<link href="themes/alert.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="js/jarry.util.js"></script>
<link href="css/table.css" rel="stylesheet" type="text/css"></link>

<script type="text/JavaScript" src="js/crosshairs0.3.js"></script>
<script type="text/javascript">
	function selectAll(){
			var aa = document.getElementsByName("ids");
			  for (var i=0; i<aa.length; i++)
			   aa[i].checked = document.getElementById('all').checked;
		
		}

	
	function deleteAdmins(){
		
		var status = false;
		var aa = document.getElementsByName("ids");
		for (var i=0; i<aa.length; i++){
			if(aa[i].checked){
				status = true;
				}

			}
		if(status == false){
			
			walert("<img src='http://wap.1mp.net.cn/images/o2.gif'>大哥，没事别乱点啊");
			
			return false;
			}
		
		}

	function changePassword(id){
		
			Dialog.confirm($('info').innerHTML, {className:"alphacube", width:300, 
                okLabel: "修改", cancelLabel: "取消",
                onOk:function(win){
                if($('passwordO').value==''||$('passwordN').value==''){
                	$('login_error_msg').innerHTML='密码不能为空';
                    $('login_error_msg').show();
                    Windows.focusedWindow.updateHeight();
                    return false;
                    }
        		sendMess(id);
                  
                 
                 }});

		}
	 function sendMess(id)	{

     	
   	  var url = 'updateAdmin.do';
         var passwordO = document.getElementById('passwordO').value;
         var passwordN = document.getElementById('passwordN').value;
   	  var pars = 'passwordO=' + passwordO + '&passwordN=' + passwordN+'&id=' + id+'&type=ajax';

   	 	
   	  new Ajax.Request( url, { method: 'post', parameters: pars, onComplete: showResponse });
   	}

	 function showResponse(originalRequest){
 		var result = originalRequest.responseText;
 		if(result=='ok'){
 			Dialog.cancelCallback();
     		}
 	
 		else{
 			$('login_error_msg').innerHTML='密码错误';
             $('login_error_msg').show(); 
             Windows.focusedWindow.updateHeight();

     		}
 		
 		
 		
 		}


	
	          

</script>
<div id="info" style="display:none">
  <p><span id='login_error_msg' class="login_error" style="display:none;color: red;">&nbsp;</span></p>
  <div style="clear:both"></div>
  <p><span class="login_label">旧密码:</span> <span class="login_input"><input id="passwordO" size="12" name="password" type="password"/></span></p>
  <div style="clear:both"></div>
  <p><span class="login_label">新密码:</span> <span class="login_input"><input id="passwordN" size="12" name="password" type="password"/></span></p>

  <div style="clear:both"></div>
</div>
<div style="text-align: left;">管理导航：管理员设置|<a
	href="toAdminCreate.do">新增管理员</a></div>

<div><br />
<br />
<div align="center">
<form action="deleteAdmin.do" method="post">
<table width="772" border="0" id="mytable">
	<tr >
		<td colspan="7">
		<div align="left">第${pagination.no}页 <c:if test="${pagination.next}">
			<a href="getAdmins.do?pageNo=${pagination.no+1} ">下一页</a>
		</c:if> <c:if test="${pagination.previous}">
			<a href="getAdmins.do?pageNo=${pagination.no-1} ">上一页</a>
		</c:if> 共${pagination.pageSum}页</div>
		</td>
	</tr>
	<tr>
		<td width="43">
		<div align="center">选中</div>
		</td>
		<td width="57">
		<div align="center">序号</div>
		</td>
		<td width="111">
		<div align="center">用户名</div>
		</td>
		<td width="157">
		<div align="center">最后登录IP</div>
		</td>
		<td width="147">
		<div align="center">最后登录时间</div>
		</td>
		<td width="76">
		<div align="center">登录次数</div>
		</td>
		<td width="151">
		<div align="center">操作</div>
		</td>
	</tr>


	<c:forEach items="${pagination.results}" var="result" varStatus="stat">

		<tr ${stat.count%2==0? "bgcolor='#F5FFD9'":"" }>
			<td>
			<div align="center"><input type="checkbox" value="${result.id}"
				name="ids" /></div>
			</td>
			<td>
			<div align="center">${result.id}</div>
			</td>
			<td>
			<div align="center">${result.name}</div>
			</td>
			<td>
			<div align="center">${result.lastLoginIp}</div>
			</td>
			<td>
			<div align="center"><fmt:formatDate
				value="${result.lastLoginDate}" type="both" /></div>
			</td>
			<td>
			<div align="center">${result.loginCount}</div>
			</td>
			<td>
			<div align="center"><a href="#" onclick="changePassword('${result.id}')">修改密码</a></div>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3"><input type="checkbox" id="all"
			onclick="selectAll();" />选中本页显示的所有管理员</td>
		<td>&nbsp;</td>
		<td colspan="2">
		<input type="submit" value="删除选中的管理员" onclick="return deleteAdmins();"/>

	
		</td>
		<td>&nbsp;</td>
	</tr>
</table>
</form>
</div>
</div>

<script type="text/javascript">
tableHelper('mytable');
	
</script>