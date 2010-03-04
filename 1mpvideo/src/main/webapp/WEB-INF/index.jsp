<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>亿万视频</title>

<style type="text/css">
div.outer{background: #9BD1FA}
b.rtop, b.rbottom{display:block;background: #CCCCCC}
b.rtop b, b.rbottom b{display:block;height: 1px;overflow: hidden; background: #FFF}
b.r1{margin: 0 5px}
b.r2{margin: 0 3px}
b.r3{margin: 0 2px}
b.rtop b.r4, b.rbottom b.r4{margin: 0 1px;height: 2px}
</style>

		<link href="<%=request.getContextPath()%>/css/header.css"
			rel="stylesheet" type="text/css"></link>
		<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
			rel="stylesheet" type="text/css"></link>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/friend.js"></script>
		<link href="<%=request.getContextPath()%>/themes/default.css"
			rel="stylesheet" type="text/css"></link>
		
	
		<link href="<%=request.getContextPath()%>/themes/alphacube.css"
			rel="stylesheet" type="text/css"></link>
		
		<link id=stylecss
			href="<%=request.getContextPath()%>/css/drag/style.css" type=text/css
			rel=stylesheet />
		<link href="<%=request.getContextPath()%>/css/drag/memcp.css"
			type=text/css rel=stylesheet />

		<script src="<%=request.getContextPath()%>/js/drag/common.js"
			type=text/javascript></script>
		<script src="<%=request.getContextPath()%>/js/drag/bbcode.js"
			type=text/javascript></script>
		<script src="<%=request.getContextPath()%>/js/drag/menu.js"
			type=text/javascript></script>
		<script src="<%=request.getContextPath()%>/js/drag/drag.js"
			type=text/javascript></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/index_data.js"></script>
		<script src="<%=request.getContextPath()%>/js/drag/drag_space.js"
			type=text/javascript></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/win/effects.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/win/win.js"></script>
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/win/win_effects.js"></script>
	
<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/indexad/flashobj.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/md5/md5.js"></script>
<link href="<%=request.getContextPath()%>/js/tooltip/style.css"
			rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/tooltip/script.js"></script>

		<script type=text/javascript>
			var layout = ['${layout[0]}','${layout[1]}','${layout[2]}'];
			function bookmark(title, url) {
				  if (document.all)
				    window.external.AddFavorite(url, title);
				  else if (window.sidebar)
				    window.sidebar.addPanel(title, url, "")
			}


			function search(k){
				var types;
				var key='';
				var type;
				if(k=='1'){
					types = document.getElementsByName('type');
					 key = document.getElementById('key').value;
					}
				else{
					 types = document.getElementsByName('type2');
					 key = document.getElementById('key2').value;

					}
				
		
				
				
				
				for(var i=0;i<types.length;i++){
					
					if(types[i].checked==true){
						type=types[i].value;
					
						break;
					}
					
				}
				
				document.location.href='<%=request.getContextPath()%>/search/'+type+'/addDate/'+key+'/1/';
			}
			 function getNewMessCount(){
				
				 var uid = '${sessionUser.id}';
				 if(uid!=''){
					 var url = '<%=request.getContextPath()%>/getMessageCount.do';
						new Ajax.Request(url, {
							method :'post',
							
							onComplete :showResult
						});
					 }
					
				 }
				  
			 function showResult(originalRequest) {
					jsonRaw = originalRequest.responseText;
				$('me').innerHTML=jsonRaw;
					
				}

			
			

			
			
		</script>
	</head>
	<body>

		<div id="header1">
<div style="height:70px;margin:0 auto;position:relative;width:1200px;">
<div style="float:left;height:60px;margin:20px 0 0 40px;width:210px;"><img height="50px"  src="<%=request.getContextPath()%>/images/logo.gif" /></div>
<div style="float:right;margin:20px 0 0;max-width:550px;overflow:hidden;padding:0 120px 0 0;text-align:right;white-space:nowrap;">
			<c:if test="${sessionUser!=null}">
					欢迎你 <a href="<%=request.getContextPath()%>/home/${sessionUser.id }/">${sessionUser.realName }</a>&nbsp;|&nbsp;
				<a href="<%=request.getContextPath()%>/exit/">退出</a>&nbsp;|&nbsp;<a href="<%=request.getContextPath()%>/vblog/mybox/"><span id="me">0</span>条新短信</a>&nbsp;|&nbsp;
				<a href="<%=request.getContextPath()%>/notices/">帮助</a>&nbsp;|&nbsp;
				<a href="#">RSS</a>&nbsp;|&nbsp;<a href="<%=request.getContextPath()%>/invite/">邀请</a>&nbsp;&nbsp;<br />
				</c:if>
				<c:if test="${sessionUser==null}">
				<a href="<%=request.getContextPath()%>/register/">注册</a>&nbsp;|&nbsp;
				<a href="<%=request.getContextPath()%>/notices/">帮助</a>&nbsp;|&nbsp;
				<a href="#">RSS</a>&nbsp;&nbsp;&nbsp;&nbsp;<br />

<form name="form1" action="<%=request.getContextPath()%>/login.do" onsubmit="password.value =hex_md5(password.value)" method="post" onsubmit="return checkit();">
<table>
<tr>
<td><label style="color: black;">登录ID:</label></td><td><input name="userName" id="userName" size="5" type="text"/></td>
<td><label style="color: black;">密码:</label></td><td><input size="5" name="password" id="password"  type="password"/></td>
<td><label style="color: black;">验证码:</label></td><td><input size="5" name="random"  type="text"/></td><td><img src="<%=request.getContextPath()%>/randomImage.do" /></td>
<td>&nbsp;<input type="submit" style="border:0pt none;width:45px;height: 20px;background:transparent url(<%=request.getContextPath()%>/images/login.gif) no-repeat scroll 0% 0%;" value=" "/></td>
</tr>


</table>







</form>		
</c:if>	
<script type="text/javascript">
getNewMessCount();

</script>
</div>
</div>






		</div>
		<div id="vdividermenu" >
<div style="border-top: 10px #F46722 solid;text-align: left;width: 1200px">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<c:if test="${not empty sessionUser}">
<a href="<%=request.getContextPath()%>/" title="首页"><img src="<%=request.getContextPath()%>/images/nav_my_09.gif"/></a>
</c:if>
<c:if test="${empty sessionUser}">
<a href="<%=request.getContextPath()%>/" title="首页"><img src="<%=request.getContextPath()%>/images/nav_09.gif"/></a>
</c:if>
					
				
					<a href="<%=request.getContextPath()%>/video/index/" title="视频"><img src="<%=request.getContextPath()%>/images/nav_10.gif"/></a>
				
					<a href="<%=request.getContextPath()%>/vblog/index/" title="博客"><img src="<%=request.getContextPath()%>/images/nav_11.gif"/></a>
				
					<a href="<%=request.getContextPath()%>/group/index/" title="小组"><img src="<%=request.getContextPath()%>/images/nav_12.gif"/></a>
				
					<a href="<%=request.getContextPath()%>/playbill/index/" title="节目单"><img src="<%=request.getContextPath()%>/images/nav_13.gif"/></a>
				
					<a href="<%=request.getContextPath()%>/search/index/" title="搜索"><img src="<%=request.getContextPath()%>/images/nav_14.gif"/></a>
				
					<a href="<%=request.getContextPath()%>/tag/index/" title="标签"><img src="<%=request.getContextPath()%>/images/nav_15.gif"/></a>
				
					<a href="" title="论坛"><img src="<%=request.getContextPath()%>/images/nav_16.gif"/></a>
			</div>
<div style="width: 1200px;text-align: center;">
			<label style=" color: #B71200;">
				设置我的首页
			</label>
			<c:if test="${empty sessionUser}">
				<SPAN id=modulemenu><A
					style="text-decoration: none; color: white;"
					href="<%=request.getContextPath()%>/login/">∵模块选择∴</A> </SPAN>
				<SPAN id=basemenu><A
					style="text-decoration: none; color: white;"
					href="<%=request.getContextPath()%>/login/">∵保存布局∴</A> </SPAN>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<A style="text-decoration: none; color: white;"
					href="<%=request.getContextPath()%>/login/">上传视频</A>&nbsp;&nbsp;&nbsp;
				<A style="text-decoration: none; color: white;"
					href="<%=request.getContextPath()%>/login/">录制视频</A>&nbsp;&nbsp;&nbsp;
				<A style="text-decoration: none; color: white;"
					href="#" onclick="bookmark('1mp','http://www.1mp.net.cn');">收藏1MP</A>
			</c:if>
			<c:if test="${not empty sessionUser }">
				<SPAN id=modulemenu onmouseover=showMenu(this.id)><A
					style="text-decoration: none; color: white;" href="#">∵模块选择∴</A> </SPAN>
				<SPAN id=basemenu onclick="savedata();"><A
					style="text-decoration: none; color: white;" href="#">∵保存布局∴</A> </SPAN>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<A style="text-decoration: none; color: white;"
					href="<%=request.getContextPath()%>/video/upload">上传视频</A>&nbsp;&nbsp;&nbsp;
				<A style="text-decoration: none; color: white;" href="#">录制视频</A>&nbsp;&nbsp;&nbsp;
				<A style="text-decoration: none; color: white;" href="#" onclick="bookmark('1mp','http://www.1mp.net.cn');">收藏1MP</A>
			</c:if>


			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="type" value="video" checked="checked" />
		<label style="color: white;">视频</label> &nbsp;&nbsp;
		<input type="radio" name="type" value="vblog" />
		<label style="color: white;">播客</label>&nbsp;&nbsp;
		<input type="radio" name="type" value="playbill"/>
		<label style="color: white;">节目单</label> &nbsp;&nbsp;
		<input type="text" name="key" id="key" size="10" />&nbsp;
<button onclick="search('1')" style="border:0pt none;width:45px;height: 20px;background:transparent url(<%=request.getContextPath()%>/images/putin.gif) no-repeat scroll 0% 0%;">&nbsp;</button>
	</div>
		</div>


		<INPUT type=hidden value=c01b510b name=formhash />
		<INPUT id=spacelayout0 type=hidden name=spacelayout[0] />
		<INPUT id=spacelayout1 type=hidden name=spacelayout[1] />
		<INPUT id=spacelayout2 type=hidden name=spacelayout[2] />
		<INPUT type=hidden value=TRUE name=spacesubmit />
		<input id="side" name="side" type="hidden" value="${side }" />
		<DIV class=cp_menu id=basemenu_menu style="DISPLAY: none">
			<DIV class=title>
				<DIV style="FLOAT: right">
					<IMG class=dragdel onclick=hideMenu()
						src="<%=request.getContextPath()%>/images/close.gif" />
				</DIV>
				基本设置
			</DIV>
			<TABLE style="TABLE-LAYOUT: fixed" width="100%">
				<TBODY>
					<TR>
						<TD width="25%">
							空间名称
						</TD>
						<TD width="75%">
							<INPUT onkeyup="previewtext('pre_title', this.value)"
								style="WIDTH: 100%" maxLength=40 name=spacename />
						</TD>

					</TR>
					<tr>
						<TD width="25%">
							空间描述
						</TD>
						<td width="75%">
							<INPUT onkeyup="previewtext('pre_desc', this.value)"
								style="WIDTH: 100%" maxLength=100 name=spacedescription />
						</td>

					</tr>
				</TBODY>
			</TABLE>
		</DIV>

		<DIV class=cp_menu id=layoutmenu_menu style="DISPLAY: none">
			<DIV class=title>
				<DIV style="FLOAT: right">
					<IMG class=dragdel onclick=hideMenu()
						src="<%=request.getContextPath()%>/images/close.gif" />
				</DIV>
				布局选择
			</DIV>
			<TABLE width="100%">
				<TBODY>
					<TR>
						<TD align=middle>
							<A onclick=leftSide() href="#"><IMG
									src="<%=request.getContextPath()%>/images/layout1.gif" border=0 />
							</A>
							<BR />
							<INPUT class=radio id=side_1 onclick=leftSide() type=radio
								value=1 name=spaceside />
							左侧边栏
							<A onclick=rightSide() href="#"><IMG
									src="<%=request.getContextPath()%>/images/layout2.gif" border=0 />
							</A>
							<BR />
							<INPUT class=radio id=side_2 onclick=rightSide() type=radio
								value=2 name=spaceside />
							右侧边栏
							<A onclick=bothSide() href="#"><IMG
									src="<%=request.getContextPath()%>/images/layout3.gif" border=0 />
							</A>
							<BR />
							<INPUT class=radio id=side_0 onclick=bothSide() type=radio
								value=0 name=spaceside />
							双侧边栏
						</TD>
					</tr>
				</tbody>
			</table>
		</div>
		<div class=cp_menu id=modulemenu_menu style="DISPLAY: none">
			<div class=title>
				<div style="FLOAT: right">
					<img class="dragdel" onclick="hideMenu()"
						src="<%=request.getContextPath()%>/images/close.gif" />
				</div>
				模块选择
			</div>
			<c:forEach items="${allLayout}" var="layout">
<c:if test="${layout=='module1'||layout=='module5'||layout=='module8'||layout=='module10'}">
<c:set var="vside" value="1"></c:set>
</c:if>
<c:if test="${layout=='module2'||layout=='module7'||layout=='module4'||layout=='module6'||layout=='module11'||layout=='module9'||layout=='module3'}">
<c:set var="vside" value="0"></c:set>
</c:if>
				<div>
					<input class="checkbox" id="check_${layout }"
						onclick="Drag.handler.check('${vside }','${layout }','${nameMap[layout] }','')"
						type="checkbox" value="" />
					${nameMap[layout] }
				</div>
			</c:forEach>
		</div>
		<div class="outer" id="outer"  >
<b class="rtop"><b class="r1"></b><b class="r2"></b><b class="r3"></b><b class="r4"></b></b>
			<table class=main id=parentTable cellSpacing=0 border=0>
				<tbody>
					<tr>
						<td id="main_layout0"
							<c:if test="${side==2 }">style="DISPLAY: none"</c:if>>
							<c:forEach items="${layout1[0]}" var="layout">
								<div class="dragdiv" id="${layout }">
									<table class=module cellSpacing=0 cellPadding=0 width="100%"
										border=0>
										<tbody>

											<tr onmousedown="Drag.dragStart(event, '')">
												<td class=header
													style="background-image: url('<%=request.getContextPath()%>/images/bg.gif')">

													<div class=title>
														${nameMap[layout] }
													</div>
													<div  class=more>
														
														
														<img class=dragdel id="i_${layout }"
															onclick="dd(t_${layout },i_${layout });"
															src="<%=request.getContextPath()%>/images/d.gif" />
														<img class=dragdel onclick=Drag.handler.del(${layout
															}) src="<%=request.getContextPath()%>/images/close.gif" />
													</div>
												</td>
											</tr>
											<tr>
												<td class=dragtext>
													<div id="t_${layout }" class="result">
														<img
															src="<%=request.getContextPath()%>/images/loading.gif"
															width="20" />
													</div>

												</td>
											</tr>
										</tbody>
									</table>
									<script type=text/javascript>
										checkinit('${layout }');
										getdata('${layout }');
									</script>
								</div>
							</c:forEach>
						</td>
						<td id="main_layout1">








							<c:forEach items="${layout1[1]}" var="layout">
								<div class="dragdiv" id="${layout }">
									<table class="module" cellSpacing="0" cellPadding="0"
										width="100%" border="0">
										<tbody>

											<tr onmousedown="Drag.dragStart(event, '<c:if test="${layout=='module1'}">2</c:if>')">
												<td class=header
													style="background-image: url('<%=request.getContextPath()%>/images/bg.gif')">
													<div class=title>
														${nameMap[layout] }
													</div>
													<div class=more>
														
														<img class=dragdel id="i_${layout }"
															onclick="dd(t_${layout },i_${layout });"
															src="<%=request.getContextPath()%>/images/d.gif" />
														<IMG class=dragdel onclick=Drag.handler.del(${layout
															}) src="<%=request.getContextPath()%>/images/close.gif" />
													</div>

												</td>
											</tr>
											<tr>
												<td class=dragtext>
													<div id="t_${layout }" class="result">
														<img
															src="<%=request.getContextPath()%>/images/loading.gif"
															width="20" />
													</div>

												</td>
											</tr>
										</tbody>
									</table>
									<script type=text/javascript>
										checkinit('${layout }');
										getdata('${layout }');
									</script>
								</div>
							</c:forEach>
						</td>
						<td id="main_layout2"
							<c:if test="${side==1 }">style="DISPLAY: none"</c:if>
							align="right">
							<c:forEach items="${layout1[2]}" var="layout">
								<div class="dragdiv" id="${layout }">
									<table class=module cellSpacing=0 cellPadding=0 width="100%"
										border=0>
										<tbody>
											<tr onmousedown="Drag.dragStart(event, '')">
												<td class=header
													style="background-image: url('<%=request.getContextPath()%>/images/bg.gif')">
													<div class=title>
														${nameMap[layout] }
													</div>
													<div class=more>
														
														<img class=dragdel id="i_${layout }"
															onclick="dd(t_${layout },i_${layout });"
															src="<%=request.getContextPath()%>/images/d.gif" />
														<IMG class=dragdel onclick=Drag.handler.del(${layout
															}) src="<%=request.getContextPath()%>/images/close.gif" />
													</div>
												</td>
											</tr>
											<tr>
												<td class=dragtext>
													<div id="t_${layout }" class="result">
														<img
															src="<%=request.getContextPath()%>/images/loading.gif"
															width="20" />
													</div>

												</td>
											</tr>
										</tbody>
									</table>
									<script type="text/javascript">
										checkinit('${layout }');
										getdata('${layout }');
									</script>
								</div>
							</c:forEach>
						</td>
					</tr>
				</tbody>
			</table>
<b class="rbottom"><b class="r4"></b><b class="r3"></b><b class="r2"></b><b class="r1"></b></b>
		</div>
		<div id="footer">
<div style="float: left;width: 100px">&nbsp;</div>
			<div style="float: left;">
			<br />
				<img src="<%=request.getContextPath()%>/images/blogo.gif" />
			</div>
<div style="float: right;width: 100px">&nbsp;</div>
			<div style="float: right;">
		
		
			<input type="radio" name="type2" value="video" checked="checked" />
		<label style="color: white;">视频</label> &nbsp;&nbsp;
		<input type="radio" name="type2" value="vblog" />
		<label style="color: white;">播客</label>&nbsp;&nbsp;
		<input type="radio" name="type2" value="playbill"/>
		<label style="color: white;">节目单</label> &nbsp;&nbsp;
		<input type="text" name="key2" id="key2" size="10" />&nbsp;
<button onclick="search('2')" style="border:0pt none;width:45px;height: 20px;background:transparent url(<%=request.getContextPath()%>/images/putin.gif) no-repeat scroll 0% 0%;">&nbsp;</button>
&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/search/index/">看看别人在搜啥?</a>
<br /><br />
				<a href="#" >About
					Us</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" >关于1MP</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" >广告合作</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" >使用协议</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" >隐私和版权</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" >联系我们</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" >招贤纳士</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" >在线客服</a>
				<br />
				本站所有视频均由用户自主上传，如有版权异议，请和本站联系
				<br />
				Copyright 2008 1MP 京ICP证0111111号
			</div>

		</div>
		<div id=dragClone style="DISPLAY: none">
			<div class=dragDIV id=[id]>
				<table class=module cellSpacing=0 cellPadding=0 width="100%"
					border=0>
					<tbody>
						<tr onmousedown="Drag.dragStart(event,'[disable]');">
							<td class=header
								style="background-image: url('<%=request.getContextPath()%>/images/bg.gif')"
								s>
								<div class=title>
									[title]
								</div>
								<div class=more>
									
									<img class=dragdel id="i_[id]" onclick="dd(t_[id],i_[id]);"
										src="<%=request.getContextPath()%>/images/d.gif" />
									<img class=dragDel onclick=Drag.handler.del([id])
										src="<%=request.getContextPath()%>/images/close.gif" />
								</div>
						</tr>
						<tr>
							<td class=dragtext>
								<div id="t_[id]" class="result">
									<img src="<%=request.getContextPath()%>/images/loading.gif"
										width="20" />
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<SCRIPT type=text/javascript>
			Drag.init(Space_Memcp);
			$('side_${side}').checked = true;
			var tmp_spaceside = ${side};
			var tmp_styledir = 'default';

		
		</SCRIPT>
		<!--hide divs -->


	</body>

</html>