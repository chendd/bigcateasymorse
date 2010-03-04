<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script type="text/javascript">
function selectIt(){
	var keyword = document.getElementById('condition').value;
    var selectFrom = document.getElementById("selectFrom");
    var i = 0;
    for (i=0; i<selectFrom.selectType.length; i++)
    {
        if (selectFrom.selectType[i].checked)
        {
           if(selectFrom.selectType[i].value=='group'){
               if(keyword==''){
            	   self.location = "<%=request.getContextPath()%>/groups/1";
                   }
               else{
            	   self.location = "<%=request.getContextPath()%>/groups/"+keyword+"/1";

                   }
               }
           else{
        	   if(keyword==''){
            	   self.location = "<%=request.getContextPath()%>/groups/topices/1";
                   }
               else{
            	   self.location = "<%=request.getContextPath()%>/groups/topices/"+keyword+"/1";

                   }
               }
        }
    }
}
</script>
<div class="side"><c:if test="${not empty sessionUser }">
	<DIV class="module">
	<DIV class=title>
	<h2>我的小组</h2>
	</DIV>
	<DIV class="reDiv">
	<div><a href="<%=request.getContextPath()%>/group/create/">建个小组</a>
	| <a href="">关于小组</a></div>
	<table width="90%" border="0">
		<tr>
			<td width="40%">我建的小组</td>
			<td width="60%">
			<ul>
				<c:forEach items="${myGroups}" var="myGroup">
					<li><a
						href="<%=request.getContextPath()%>/group/${myGroup.group.id }/">${myGroup.group.name}</a>
					</li>
				</c:forEach>
			</ul>
			</td>
		</tr>
		<tr>
			<td width="30%">我加入的小组</td>
			<td width="70%">
			<ul>
				<c:forEach items="${myJoinGroups}" var="myJoinGroup">
					<li><a
						href="<%=request.getContextPath()%>/group/${myJoinGroup.group.id }/">${myJoinGroup.group.name}</a>
					</li>
				</c:forEach>
			</ul>
			</td>
		</tr>
	</table>
	</DIV>
	</DIV>
</c:if>



<div class="module">

<div class="title">
<h2>搜索</h2>
</div>
<div class="reDiv">
<form action="" name="selectFrom" id="selectFrom" method="post">
	<input class="color" type="text" id="condition" name="condition" size="10"/>&nbsp;  
<button class="sou" onclick="selectIt();">&nbsp;</button>
<br />
<input type="radio" name="selectType" value="group" checked="checked" />
小组 <input type="radio" name="selectType" value="topic" /> 话题 

</form>
</div>
</div>






<DIV class="module">
<DIV class=title>
<h2>过去一分钟里</h2>
</DIV>

<DIV style="margin: 15px; text-align: left;">
<table width="90%">
	<c:forEach items="${events}" var="event">
		<tr>
			<td><a
				href="<%=request.getContextPath()%>/home/${event.userId }/">${event.realName
			}</a></td>
			<td><a href="<%=request.getContextPath()%>/${event.url }">${event.description
			}</a></td>
		</tr>
	</c:forEach>
</table>
</DIV>
</DIV>
<DIV class="module">
<DIV class=title>
<h2>最活跃小组</h2>
</DIV>
<DIV class='reDiv2'>
<table width="95%">
		<c:forEach items="${hotGroups.results}" var="group">
 <tr>
    <td rowspan="4"><img width=100px src="<%= application.getAttribute("IMAGE_URL")%>${group.image}"/></td>
    <td><a href="<%=request.getContextPath()%>/group/${group.id }/" style="color: #C92103">${group.name}</a></td>
  </tr>
  <tr>
    <td>圈主:<a href="<%=request.getContextPath()%>/home/${group.owner.id }/">${group.owner.realName}</a>&nbsp;成员:${group.memberCount }</td>
  </tr>
  <tr>
    <td>小组类型:<c:if test="${group.auditType==0}">公开</c:if><c:if test="${group.auditType==1}">私有</c:if></td>
  </tr>
  <tr>
    <td>创建时间:<fmt:formatDate value="${group.addDate}" type="date"/></td>
  </tr>



		</c:forEach>
		
		</table>
</DIV>
</DIV>
</div>
<div class="main">
<DIV class="module">
<DIV class=title>
<h2>精品小组</h2>
</DIV>
<DIV class="reDiv" id='modeul2'>
<table width="95%">
	<tr>
		<c:forEach var="i" begin="0" end="4" step="1">
			<td width="25%"><c:if
				test="${not empty recommendGroups.results[i] }">
				<img width="100" src="<%= application.getAttribute("IMAGE_URL")%>${recommendGroups.results[i].image }" />
				<br />
				<a
					href="<%=request.getContextPath()%>/group/${recommendGroups.results[i].id }/">${recommendGroups.results[i].name
				}</a>
				<br />组员:${recommendGroups.results[i].memberCount }
</c:if></td>
		</c:forEach>
	</tr>
</table>
</DIV>
</DIV>
<DIV class="module">
<DIV class=title><span><a
	href="<%=request.getContextPath()%>/groups/topices/1">更多</a></span>
<h2>最新话题</h2>
</DIV>
<DIV id='' style="margin: 15px; text-align: left;">
<table width="580px" class="itable">
	<tr>
		<th width="350px">
		<div>话题</div>
		</th>
		<th width="50px">
		<div>回复</div>
		</th>
		<th width="50px">
		<div>点击</div>
		</th>
		<th width="80px">
		<div>组名称</div>
		</th>
		<th width="80px">
		<div>发布人</div>
		</th>
		<th width="80px">
		<div>时间</div>
		</th>
</tr>
		<c:forEach items="${newTopices}" var="newTopic">
			<tr>
				<td>
				<div><a
					href="<%=request.getContextPath()%>/group/topic/${newTopic.id}/">${newTopic.title}</a>
				</div>
				</td>
				<td>
				<div>${newTopic.commentCount }</div>
				</td>
				<td>
				<div>${newTopic.browseCount }</div>
				</td>
				<td>
				<div><a
					href="<%=request.getContextPath()%>/group/${newTopic.group.id }/">${newTopic.group.name}</a>
				</div>
				</td>
				<td>
				<div><a
					href="<%=request.getContextPath()%>/home/${newTopic.user.id }/">${newTopic.user.realName}</a>
				</div>
				</td>
				<td>
				<div><fmt:formatDate value="${newTopic.addDate}" type="date" />
				</div>
				</td>
				<td></td>
			</tr>
		</c:forEach>
	
</table>
</DIV>
</DIV>
<DIV class="module">
<DIV class=title>
<h2>热门话题</h2>
</DIV>
<DIV id='' style="margin: 15px; text-align: left;">
<table width="580px" class="itable">
	<tr>
		<th width="350px">
		<div>话题</div>
		</th>
		<th width="50px">
		<div>回复</div>
		</th>
		<th width="50px">
		<div>点击</div>
		</th>
		<th width="80px">
		<div>组名称</div>
		</th>
		<th width="80px">
		<div>发布人</div>
		</th>
		<th width="80px">
		<div>时间</div>
		</th>
</tr>
		<c:forEach items="${hotTopices}" var="hotTopic">
			<tr>
				<td>
				<div><a
					href="<%=request.getContextPath()%>/group/topic/${hotTopic.id }/">${hotTopic.title}</a>
				</div>
				</td>
				<td>
				<div>${hotTopic.commentCount }</div>
				</td>
				<td>
				<div>${hotTopic.browseCount }</div>
				</td>
				<td>
				<div><a
					href="<%=request.getContextPath()%>/group/${hotTopic.group.id }/">${hotTopic.group.name}</a>
				</div>
				</td>
				<td>
				<div><a
					href="<%=request.getContextPath()%>/home/${hotTopic.user.id }/">${hotTopic.user.realName}</a>
				</div>
				</td>
				<td>
				<div><fmt:formatDate value="${hotTopic.addDate}" type="date" />
				</div>
				</td>
				<td></td>
			</tr>
		</c:forEach>
	
</table>
</DIV>
</DIV>
<c:if test="${not  empty sessionUser }">
	<DIV class="module">
	<DIV class=title>
	<h2>我圈子里的新话题</h2>
	</DIV>
	<DIV id='' style="margin: 15px; text-align: left;">
	<table width="580px" class="itable">
			<tr>
		<th width="350px">
		<div>话题</div>
		</th>
		<th width="50px">
		<div>回复</div>
		</th>
		<th width="50px">
		<div>点击</div>
		</th>
		<th width="80px">
		<div>组名称</div>
		</th>
		<th width="80px">
		<div>发布人</div>
		</th>
		<th width="80px">
		<div>时间</div>
		</th>
</tr>
			<c:forEach items="${myGroupTopices}" var="myGroupTopic">
				<tr>
					<td>
					<div><a
						href="<%=request.getContextPath()%>/group/topic/${myGroupTopic.id }/">${myGroupTopic.title}</a>
					</div>
					</td>
					<td>
					<div>${myGroupTopic.commentCount }</div>
					</td>
					<td>
					<div>${myGroupTopic.browseCount }</div>
					</td>
					<td>
					<div><a
						href="<%=request.getContextPath()%>/group/${myGroupTopic.group.id }/">${myGroupTopic.group.name}</a>
					</div>
					</td>
					<td>
					<div><a
						href="<%=request.getContextPath()%>/home/${myGroupTopic.user.id }/">${myGroupTopic.user.realName}</a>
					</div>
					</td>
					<td>
					<div><fmt:formatDate value="${myGroupTopic.addDate}"
						type="date" /></div>
					</td>
					<td></td>
			
			</c:forEach>
	
	</table>
	</DIV>
	</DIV>
</c:if></div>
