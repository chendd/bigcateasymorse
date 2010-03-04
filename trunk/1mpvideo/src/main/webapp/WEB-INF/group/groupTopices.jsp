<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="h" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<link href="<%=request.getContextPath()%>/js/dialog/dialog.css"
	rel="stylesheet" type="text/css"></link>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/dialog/dialog.js"></script>
<c:set var="condition" value=""></c:set>

<c:if test="${not empty order }">
	<c:set var="condition" value="${condition}&order=${order }"></c:set>
</c:if>
<c:if test="${not empty pageSize }">
	<c:set var="condition" value="${condition}&pageSize=${pageSize }"></c:set>
</c:if>

<script type="text/javascript">

function deleteTopic(id)
{
	var i = confirm("确定删除？");
	if(i){

		var showResponse = function(originalRequest){
			var strValue = originalRequest.responseText;
			
			if(strValue=='ok'){
				window.history.go(0);
		}
		}
		var url ="<%=request.getContextPath()%>/deleteTopic.do";
		pars = "id="+id;

		
		new Ajax.Request(url, {
			method :'post',
			parameters :pars,
			onComplete :showResponse
		});
	}
		
		}

function nextPage(){
	var url = "<%=request.getContextPath()%>/group/${group.id}/topiclist/${pageSize}/${order}/${pagination.no+1}/";
	
	window.location.href=url; 
}
function prePage(){
	var url = "<%=request.getContextPath()%>/group/${group.id}/topiclist/${pageSize}/${order}/${pagination.no-1}/";
	window.location.href=url; 
}
function toPage(){
	var obj=document.getElementById('pages');

	var index=obj.selectedIndex; 

	var val = obj.options[index].value;
	var url = "<%=request.getContextPath()%>/group/${group.id}/topiclist/${pageSize}/${order}/"+val+"/";
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
    var url = "<%=request.getContextPath()%>/group/${group.id}/topiclist/"+pageSize+"/"+order+"/1/";
    window.location.href=url; 
	
}
</script>
<div id="msgDiv">
	<div id="msgShut">
		关闭
	</div>
	<div id="msgDetail">
		<p></p>
		<div align="center">
			<form action="" id="form1" name="form1">
				<table width="90%">
					<tr>
						<td width="40%">
							每页条数：
						</td>
						<td width="60%">
							<input type="radio" name="pageSize" value="1"
								<c:if test="${pageSize==1 }">checked="checked"</c:if> />
							1
							<input type="radio" name="pageSize" value="2"
								<c:if test="${pageSize==2 }">checked="checked"</c:if> />
							2
						</td>
					</tr>
					<tr>
						<td width="40%">
							排列顺序：
						</td>
						<td width="60%">
							<input type="radio" name="order" value="T.ADD_DATE"
								<c:if test="${order=='T.ADD_DATE' }">checked="checked"</c:if> />
							上传时间
							<br />
							<input type="radio" name="order" value="T.BROWSE_TIMES"
								<c:if test="${order=='T.BROWSE_TIMES' }">checked="checked"</c:if> />
							播放次数
							<br />
							<input type="radio" name="order" value="COMMENTCOUNT"
								<c:if test="${order=='COMMENTCOUNT' }">checked="checked"</c:if> />
							评论条数

						</td>
					</tr>
				</table>
			</form>

		</div>
		<div align="center">
			<button onclick="getTopices()">
				确定
			</button>
		</div>
	</div>
</div>
<div id="bgDiv">
</div>


<div id="center">
<div class="side">

<div class="module">

<div class="reDiv">
<p class="sideButton"><a href="<%=request.getContextPath()%>/group/${group.id }/memberlist/">小组成员</a></p>
<p class="sideButton"><a href="<%=request.getContextPath()%>/group/${group.id }/videolist/">小组视频</a></p>
<p class="sideButton"><a >小组话题</a></p>
</div>
</div>


</div>
<div class="main">
<DIV class="module">

	<DIV class=title>
		<span><a href="#" onClick="showDiv()">编辑</a>
		</span>
		<h2>
			<a href="<%=request.getContextPath()%>/group/${group.id }/">${group.name
				}</a>的话题
		</h2>
	</DIV>


	<DIV class="reDiv">
		<table width="90%">
			<tr>
				<td>
					<div align="center">
						话题
					</div>
				</td>
				<td>
					<div align="center">
						回复
					</div>
				</td>
				<td>
					<div align="center">
						点击
					</div>
				</td>
				<td>
					<div align="center">
						组名称
					</div>
				</td>
				<td>
					<div align="center">
						发布人
					</div>
				</td>
				<td>
					<div align="center">
						时间
					</div>
				</td>
				<td>
					<div align="center"></div>
				</td>
			</tr>
			<c:forEach items="${pagination.results}" var="topic">
				<tr>
					<td>
						<div align="center">
							<a href="<%=request.getContextPath()%>/group/topic/${topic.id}/">${topic.title
								}</a>
						</div>
					</td>
					<td>
						<div align="center">
							${topic.commentCount }
						</div>
					</td>
					<td>
						<div align="center">
							${topic.browseCount }
						</div>
					</td>
					<td>
						<div align="center">
							${group.name }
						</div>
					</td>
					<td>
						<div align="center">
							<a href="<%=request.getContextPath()%>/home/${topic.user.id }/">${topic.user.realName }</a>
						</div>
					</td>

					<td>
						<div align="center">
							<fmt:formatDate value="${topic.addDate}" type="both" />
						</div>
					</td>
					<c:if test="${group.owner.id==sessionUser.id}">
						<td>
							<div align="center">
								<a href="#" onclick="deleteTopic('${topic.id}');">删除</a>
							</div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>

		<h:pagination next="${pagination.next}" pre="${pagination.previous}" no="${pagination.no}" pageSum="${pagination.pageSum}" url="${pageContext.request.contextPath}/group/${group.id}/topiclist/${pageSize}/${order}"></h:pagination>
	</DIV>
</DIV>
</div>
</div>
