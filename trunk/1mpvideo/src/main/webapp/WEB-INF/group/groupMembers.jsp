<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link href="<%=request.getContextPath()%>/js/dialog/dialog.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dialog/dialog.js"></script>
<c:set var="condition" value=""></c:set>

<c:if test="${not empty order}"><c:set var="condition" value="${condition}&order=${order }"></c:set></c:if>
<c:if test="${not empty pageSize}"><c:set var="condition" value="${condition}&pageSize=${pageSize }"></c:set></c:if>

<script type="text/javascript">
function deleteGroupAndUser(uid){
if(uid=='${group.owner.id}'){
	alert('你不能踢自己');
}
else{
var i = confirm("你确定踢了TA？");
if(i){
	

	var showResponse = function(originalRequest){
		var strValue = originalRequest.responseText;
		
		if(strValue=='ok'){
			window.history.go(0);
			}
	}
	
	var gid = '${group.id}';
	var url ="<%=request.getContextPath()%>/weedGroupMember.do";
	pars = "gid="+gid+"&uid="+uid;

	
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse
	});
}}
}

function nextPage(){
	var url = "<%=request.getContextPath()%>/group/${group.id}/memberlist/${pageSize}/${order}/${pagination.no+1}/";
	window.location.href=url; 
}
function prePage(){
	var url = "<%=request.getContextPath()%>/group/${group.id}/memberlist/${pageSize}/${order}/${pagination.no-1}/";
	window.location.href=url; 
}
function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	var url = "<%=request.getContextPath()%>/group/${group.id}/memberlist/${pageSize}/${order}/"+val+"/";
	window.location.href=url; 
}
function showDiv(){
	 showDetail('');
		
	}

function getTopices(){
	var selectedIndex = -1;
    var form1 = document.getElementById("form1");
    var i = 0;
    var pageSize;
    var order;
    for (i=0; i<form1.pageSize.length; i++)
    {
        if (form1.pageSize[i].checked)
        {
            selectedIndex = i;
            pageSize =  form1.pageSize[i].value;
            break;
        }
    }
    for (i=0; i<form1.order.length; i++)
    {
        if (form1.order[i].checked)
        {
            selectedIndex = i;
            order =  form1.order[i].value;
            break;
        }
    }
    var url = "<%=request.getContextPath()%>/group/${group.id}/memberlist/"+pageSize+"/"+order+"/1/";
    
    window.location.href=url; 
	
}
</script>
<div id="msgDiv">
 <div id="msgShut">
  关闭</div>
 <div id="msgDetail">
<p></p>
<div >
<form action="" id="form1" name="form1">
<table width="90%">
<tr><td width="40%">每页条数：</td><td width="60%"><input type="radio" name="pageSize" value="5" <c:if test="${pageSize==5 }">checked="checked"</c:if> />5 <input type="radio" name="pageSize" value="10" <c:if test="${pageSize==10 }">checked="checked"</c:if>   />10</td></tr>
<tr><td width="40%">排列顺序：</td><td width="60%">
<input type="radio" name="order" value="X.ADD_DATE" <c:if test="${order=='X.ADD_DATE' }">checked="checked"</c:if> />加入时间 <br />
<input type="radio" name="order" value="X.RATE" <c:if test="${order=='X.RATE' }">checked="checked"</c:if> />权限<br />
<input type="radio" name="order" value="U.ID" <c:if test="${order=='U.ID' }">checked="checked"</c:if> />用户ID

</td></tr>
</table>
</form>

</div>
<div ><button onclick="getTopices()">确定</button></div>
 </div>
</div>
<div id="bgDiv">
</div>
<div id="center">
<div class="side">

<div class="module">

<div class="reDiv">
<p class="sideButton"><a>小组成员</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/group/${group.id }/videolist/">小组视频</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/group/${group.id }/topiclist/">小组话题</a></p>
</div>
</div>

</div>


<div class="main">
<div class="module">

			<div class=title ><span><a href="<%=request.getContextPath()%>/group/${group.id }/">返回该小组</a></span><h2>${group.name } 的管理员</h2></div>
			
			
			<div class="reDiv">
				<table width="90%">
				<tr>
				<c:forEach var="i"  begin="0" end="4" step="1">
				<td width="20%">
					<c:if test="${not empty admins.results[i] }">
					<img src="<%= application.getAttribute("IMAGE_URL")%>${admins.results[i].user.face }" width="100" /><br />
							<a href="<%=request.getContextPath()%>/home/${admins.results[i].user.id }">${admins.results[i].user.realName }</a><br />
							加入时间:<fmt:formatDate value="${admins.results[i].addDate }" type="date"/><br />
							权限:<c:if test="${admins.results[i].rate==3 }">圈主</c:if><c:if test="${admins.results[i].rate==2 }">管理员</c:if>
					</c:if>
				</td>
				
				</c:forEach>
				</tr>
				</table>
			</div>
</div>



<DIV class="module">

			<DIV class=title ><span><a href="#" onClick="showDiv()">编辑</a></span><h2>${group.name } 成员列表</h2></DIV>
			
			
			<DIV class="reDiv">
			<table width="90%">
				<c:if test="${fn:length(pagination.results)%5==0}">
					<c:set var="row" value="${fn:length(pagination.results)/5}" />
				</c:if>
				<c:if test="${fn:length(pagination.results)%5!=0}">
					<c:set var="row" value="${fn:length(pagination.results)/5+1}" />
				</c:if>

				<c:forEach var="i" begin="1" end="${row}" step="1">
					<c:forEach var="j" begin="${(i-1)*5+1}" end="${(i-1)*5+5}" step="1">
						<c:if test="${fn:length(pagination.results)>=j}">
							<td width="20%">
							<div ><img src="<%= application.getAttribute("IMAGE_URL")%>${pagination.results[j-1].user.face }" width="100" /><br />
							<a href="<%=request.getContextPath()%>/home/${pagination.results[j-1].user.id }">${pagination.results[j-1].user.realName }</a><br />
							加入时间:<fmt:formatDate value="${pagination.results[j-1].addDate }" type="date"/><br />
							权限:<c:if test="${pagination.results[j-1].rate==3 }">圈主</c:if><c:if test="${pagination.results[j-1].rate==2 }">管理员</c:if><c:if test="${pagination.results[j-1].rate==1 }">组员</c:if>
							<c:if test="${group.owner.id==sessionUser.id}"><br /><a href="#" onclick="deleteGroupAndUser('${pagination.results[j-1].user.id }')">踢了TA</a></c:if>
							</div>
							</td>
						</c:if>
						<c:if test="${fn:length(pagination.results)<j}">
							<td width="20%">
							<div >&nbsp;</div>
							</td>
						</c:if>

					</c:forEach>
					<tr></tr>
					<br>
				</c:forEach>

			</table>
			<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${pageContext.request.contextPath}/group/${group.id}/memberlist/${pageSize}/${order}"></h:pagination>
			</DIV>

</DIV>
</div>
</div>