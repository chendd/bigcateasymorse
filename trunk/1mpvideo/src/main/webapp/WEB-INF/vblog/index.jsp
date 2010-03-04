<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript">

function getStars(){
	var url = '<%=request.getContextPath()%>/getStars.do';
	new Ajax.Request(url, {
		method :'post',
		onComplete :showResponse3
	});

	function showResponse3(originalRequest){
		jsonRaw = originalRequest.responseText;
		users = eval("(" + jsonRaw + ")");
		if(users[0].gender=='m'){
			users[0].gender='男';
			}
		else if(users[0].gender=='f'){
			users[0].gender='女';
			}
		else{
			users[0].gender='保密';
			}
		if(users[1].gender=='m'){
			users[0].gender='男';
			}
		else if(users[1].gender=='f'){
			users[1].gender='女';
			}
		else{
			users[1].gender='保密';
			}
		var val = "<table  class='stars' width='95%' ><tr><td width='25%' rowspan='5'><img width='100'  src='${IMAGE_URL}"+users[0].face+"'></td><td width='25%'>会员:<a href='<%=request.getContextPath()%>/home/"+users[0].id+"'>"+users[0].realName+"</a></td><td rowspan='5' width='25%'><img width='100'  src='${IMAGE_URL}"+users[1].face+"'></td><td width='25%'>会员:<a href='<%=request.getContextPath()%>/home/"+users[1].id+"'>"+users[1].realName+"</a></td></tr>"+
		"<tr><td>性别:"+users[0].gender+"</td><td>性别:"+users[1].gender+"</td></tr>"+
		"<tr><td>积分:"+users[0].score+"</td><td>积分:"+users[1].score+"</td></tr>"+
		"<tr><td>视频:"+users[0].videoCount+"</td><td>视频:"+users[1].videoCount+"</td></tr>"+
		"<tr><td><a href='<%=request.getContextPath()%>/home/"+users[0].id+"'>查看所有作品</a></td><td><a href='<%=request.getContextPath()%>/home/"+users[1].id+"'>查看所有作品</a></td></tr></table>";


	  
	


		
	
		$('stars').innerHTML = val;
		}
	
}


function getModule1() {
	var url = '<%=request.getContextPath()%>/getTopUsersAjax.do';
	var pars = 'order=PNUM';
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse1
	});
}
function showResponse1(originalRequest){
	jsonRaw = originalRequest.responseText;
	videoes = eval("(" + jsonRaw + ")");
	var val = "<table width='90%' border='0' cellspacing='11'>";
	for (i = 0; i < 5; i++) {
		if(i<videoes.results.length){
			val = val+"<tr ><td width='240'><img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/t"+(i+1)+".jpg' width='20' height='11'>"+
			" <a href='<%=request.getContextPath()%>/home/"+videoes.results[i].id+"/'>"+
			videoes.results[i].realName+"</a></td>";
			}
		else{
			val = val+"<td width='240'>&nbsp;</td>";

			}
		
		if((i+5)<videoes.results.length){
			val = val +"<td width='240'><img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/t"+(i+6)+".jpg' width='20' height='11'> <a href='<%=request.getContextPath()%>/home/"+
			videoes.results[i+5].id+"/'>"+videoes.results[i+5].realName+"</a></td>";
			}
		else{
			val = val+"<td width='240'>&nbsp;</td>";
			}
		val=val+"</tr>";
		 }
	val= val +"</table>";
	
	document.getElementById("module1").innerHTML = val;
	
}


function getModule2(order,pageNo) {
	document.getElementById('new').style.color='#0071BC';
	document.getElementById('browse').style.color='#0071BC';
	document.getElementById('comment').style.color='#0071BC';
	document.getElementById('pnum').style.color='#0071BC';
	document.getElementById('score').style.color='#0071BC';
	if(order=='PNUM'){
		document.getElementById('pnum').style.color='#C92103';
		}
	if(order=='SCORE'){
		
		document.getElementById('score').style.color='#C92103';
	}
	
	document.getElementById("module2").innerHTML ="<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif' width='20' />";
	var url = '<%=request.getContextPath()%>/getTopUsersAjax.do';
	var pars = 'order='+order+"&pageNo="+pageNo;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse2
	});

}
function getModule22(type,pageNo) {
	document.getElementById('new').style.color='#0071BC';
	document.getElementById('browse').style.color='#0071BC';
	document.getElementById('comment').style.color='#0071BC';
	document.getElementById('pnum').style.color='#0071BC';
	document.getElementById('score').style.color='#0071BC';
	
	if(type=='new'){
		document.getElementById('new').style.color='#C92103';
		}
	if(type=='browse'){
		document.getElementById('browse').style.color='#C92103';
	}
	if(type=='comment'){
		document.getElementById('comment').style.color='#C92103';
	}
	document.getElementById("module2").innerHTML ="<img src='<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif' width='20' />";
	
	var url = '';
	if(type=='new'){
		url = '<%=request.getContextPath()%>/getUsersOrderByNewVideo.do';
		}
	if(type=='browse'){
		url = '<%=request.getContextPath()%>/getUsersOrderByBrowseTimes.do';
		}
	if(type=='comment'){
		url = '<%=request.getContextPath()%>/getUsersOrderByCommentCount.do';
		}
	var pars = "pageNo="+pageNo;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse2
	});
}

function showResponse2(originalRequest){
	jsonRaw = originalRequest.responseText;
	videoes = eval("(" + jsonRaw + ")");
	var val = "<table width='95%' >";
	var length = videoes.results.length;
	var row = Math.ceil(length/5);
	var ccount = '';
	for(j =0;j<row;j++){
		val = val+"<tr>";
		for (i = 0; i < 5; i++) {
			if((5*j+i)<length){
				if(videoes.results[5*j+i].commentCount){
					ccount = "<br />评论数:"+videoes.results[5*j+i].commentCount;
					}
				val = val+"<td width='20%'><img src='<%= application.getAttribute("IMAGE_URL")%>"+videoes.results[5*j+i].image+
				"' width='80'><br /><a href='<%=request.getContextPath()%>/home/"+videoes.results[5*j+i].id+"/'>"+
				videoes.results[5*j+i].realName+"的主页</a><br />性别:"+videoes.results[5*j+i].gender+"<br />年龄:"+
				videoes.results[5*j+i].age+" <br />节目:"+videoes.results[5*j+i].videoCount+"&nbsp;&nbsp;被关注:"+
				videoes.results[5*j+i].beSubscribeCount+"<br />好友:"+videoes.results[5*j+i].friendCount+"&nbsp;&nbsp;积分:"+
				videoes.results[5*j+i].score+ccount+"</td>";
				}
			else{
				val = val+"<td width='20%'>&nbsp;</td>";
				}
		}
		val = val+"</tr>";
		 }
	val= val +"</table>";
	var click='';
	if(videoes.order=='new'||videoes.order=='browse'||videoes.order=='comment'){
		 click = 'getModule22(\''+videoes.order+'\',\'[no]\')';
		}
	else if(videoes.order=='PNUM'||videoes.order=='SCORE'){
		 click = 'getModule2(\''+videoes.order+'\',\'[no]\')';
		}
	
	var pa = pagination(videoes.pageSum,videoes.no,videoes.next,videoes.previous,click);
	val +=pa;
	document.getElementById("module2").innerHTML = val;
}

function getModule4(pageNo) {
	var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
	if(flag!='ok'){
		document.getElementById("module4").innerHTML = flag;
		return ;
	}
	var url = '<%=request.getContextPath()%>/getMySubscribeUsers.do';
	var pars = 'pageNo='+pageNo;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse4
	});

}
function showResponse4(originalRequest){
	jsonRaw = originalRequest.responseText;
	videoes = eval("(" + jsonRaw + ")");
	var val = "<table width='95%' ><tr >";
	for (i = 0; i < 5; i++) {
		if(i<videoes.results.length){
			val = val+"<td width='20%'><img src='<%= application.getAttribute("IMAGE_URL")%>"+videoes.results[i].image+"' width='80'><br /><a href=''>"+videoes.results[i].realName+"的主页</a><br />性别:"+videoes.results[i].gender+"<br />年龄:"+videoes.results[i].age+" <br />节目:"+videoes.results[i].videoCount+"&nbsp;&nbsp;被关注:"+videoes.results[i].beSubscribeCount+"<br />好友:"+videoes.results[i].friendCount+"&nbsp;&nbsp;积分:"+videoes.results[i].score+"</td>";
			}
		else{
			val = val+"<td width='20%'>&nbsp;</td>";
			}
		 }
	val= val +"</tr><tr><td></td></tr></table>";
		var click = 'getModule4(\'[no]\')';
	
	var pa = pagination(videoes.pageSum,videoes.no,videoes.next,videoes.previous,click);
	val +=pa;
	document.getElementById("module4").innerHTML = val;
}

function getModule5(pageNo) {
	var flag = sessionUser('<%=session.getAttribute("sessionUser")%>');
	if(flag!='ok'){
		document.getElementById("module5").innerHTML = flag;
		return ;
	}
	
	var url = '<%=request.getContextPath()%>/getMyFans.do';
	var pars = 'pageNo='+pageNo;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse5
	});
}
function showResponse5(originalRequest){
	jsonRaw = originalRequest.responseText;
	videoes = eval("(" + jsonRaw + ")");
	var val = "<table width='95%' ><tr >";
	for (i = 0; i < 5; i++) {
		if(i<videoes.results.length){
			val = val+"<td width='20%'><img src='<%= application.getAttribute("IMAGE_URL")%>"+videoes.results[i].image+"' width='80'><br /><a href=''>"+videoes.results[i].realName+"的主页</a><br />性别:"+videoes.results[i].gender+"<br />年龄:"+videoes.results[i].age+" <br />节目:"+videoes.results[i].videoCount+"&nbsp;&nbsp;被关注:"+videoes.results[i].beSubscribeCount+"<br />好友:"+videoes.results[i].friendCount+"&nbsp;&nbsp;积分:"+videoes.results[i].score+"</td>";
			}
		else{
			val = val+"<td width='20%'>&nbsp;</td>";
			}
		 }
	val= val +"</tr><tr><td></td></tr></table>";
	var click = 'getModule5(\'[no]\')';
	
	var pa = pagination(videoes.pageSum,videoes.no,videoes.next,videoes.previous,click);
	val +=pa;
	document.getElementById("module5").innerHTML = val;
}



</script>
<div class="center">
	<div class="six">
		<DIV class="module">
			<DIV class=title>
				<h2>
					每周明星
				</h2>
			</DIV>
			<DIV id="stars" class="reDiv">
			
			</DIV>
		</div>
<script type="text/javascript">getStars();</script>
	</div>
	<div class="four">
		<DIV class="module">
			<DIV class=title>
				<h2>
					明星TOP10
				</h2>
			</DIV>
			<DIV class="reDiv2" id=module1>
				<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif" width="20" />
				<script type="text/javascript">	getModule1();</script>
			</DIV>
		</DIV>
	</div>
</div>

<DIV class="module">
	<DIV class=title>
		<h2>
			<a style="TEXT-DECORATION: none" id="new" href="#" onclick="getModule22('new','1')">最新发布</a> |
			<a style="TEXT-DECORATION: none" id="browse" href="#" onclick="getModule22('browse','1')">人气最旺的</a> |
			<a style="TEXT-DECORATION: none" id="pnum" href="#" onclick="getModule2('PNUM','1')">订阅最多的</a> |
			<a style="TEXT-DECORATION: none" id="score" href="#" onclick="getModule2('SCORE','1')">打分最高的</a> |
			<a style="TEXT-DECORATION: none" id="comment" href="#" onclick="getModule22('comment','1')">评论最多的</a>
		</h2>
	</DIV>
	<DIV id="module2" class="reDiv">
		<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif" width="20" />
		<script type="text/javascript">	getModule22('new','1');</script>
	</DIV>
</DIV>


<c:if test="${sessionUser==null}"></c:if><c:if test="${sessionUser!=null}">

<DIV class="module">
	<DIV class=title>
		<h2>
			我关注的
		</h2>
	</DIV>
	<DIV class="reDiv" id=module4>
		<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif" width="20" />
		<script type="text/javascript">	getModule4('1');</script>
	</DIV>	</DIV>


<DIV class="module">
	<DIV class=title>
		<h2>
			谁在关注我
		</h2>
	</DIV>
	<DIV class="reDiv" id="module5">
		<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif" width="20" />
		<script type="text/javascript">	getModule5('1');</script>
	</DIV>
</DIV>
</c:if>

