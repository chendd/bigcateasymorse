<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
response.setHeader("pragma","no-cache"); 
response.setHeader("cache-control","no-cache"); 
response.setDateHeader("expires", -10); 
%> 

<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5/md5.js"></script>
<div class="main2">
<div class="module">
<div class="title"><h2>用户登陆</h2></div>
<div >
<form action="<%=request.getContextPath()%>/login.do" onsubmit="password.value =hex_md5(password.value)" method="post"
			id="form_login">
			<table width="419" border="0" align="center">
				<tr>
					<td width="62">
						<input type="hidden" name="send" value="${send }" />
					</td>
					<td width="168">
						
					</td>
					<td width="203" style="color: red;">
						${error }
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							登录ID:
						</div>
					</td>
					<td>
						<input type="text" name="userName" value="${userName }" />
					</td>
					<td style="color: red;">
						${userNameError }
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							密码:
						</div>
					</td>
					<td>
						<input type="password" id="password" name="password" />
					</td>
					<td style="color: red;">
						${passwordError }
					</td>
				</tr>
				<tr>
					<td>
						<div align="right">
							验证码:
						</div>
					</td>
					<td>
						<input name="random" type="text" size="4" maxlength="4" />
						<img src="<%=request.getContextPath()%>/randomImage.do" />
					</td>
					<td style="color: red;">
						${randomError }
					</td>
				</tr>
				<tr>
					<td>
						<div align="right"></div>
					</td>
					<td>
						<input type="submit" name="Submit" value="登陆" />
						<input type="button" name="button" value="注册"
							onclick="javascript:window.location.href='<%=request.getContextPath()%>/register/${send }/'" />
					</td>
					<td>
					</td>
				</tr>
			</table>
		</form>
	
</div>
</div>
</div>

<div class="side2">
<div class="module">
<div class="title"><h2>如果您 ...</h2></div>
<div class="reDiv">
<ul>
<li>不是会员，现在就免费<a href="<%=request.getContextPath()%>/register/${send }/">注册</a></li>
<li>不想进去了，回到<a href="<%=request.getContextPath()%>/">首页</a>去 </li>
<li><a href="<%=request.getContextPath()%>/forgot_password">忘记密码</a></li>
</ul>

</div>
</div>

</div>

		