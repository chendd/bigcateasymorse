<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/prototype/prototype-1.6.0.2.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/pagination.js"></script>
<script type="text/javascript">
function initData(){
	getDailies('${user.id}','${channelId}','','1');
	getChannels('${user.id}');
	getTags('${user.id}');
}
function getDailies(id,channelId,tagId,pageNo) {
	var url = '<%=request.getContextPath()%>/getMyDailies.do';
	var pars = 'pageNo='+pageNo+'&id='+id;
	if(channelId!=''){
		pars = pars+"&channelId="+channelId;
		}
	if(tagId!=''){
		pars = pars+"&tagId="+tagId;
		}
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse1
	});
	function showResponse1(originalRequest){
		
		jsonRaw = originalRequest.responseText;
		if(jsonRaw){
			dailies = eval("(" + jsonRaw + ")");
			var val = "<table width='98%' border='0' cellspacing='11'>";
			for(i =0;i<dailies.results.length;i++){
				val = val+"<tr><td width='100%'><div>"+dailies.results[i].addDate+" | "+dailies.results[i].title+"</div>"+
				"<div>评论 ("+dailies.results[i].commentCount+") | 阅读 ("+dailies.results[i].browseTimes+
				") | <a href='<%=request.getContextPath()%>/blog/"+dailies.results[i].id+"/'>固定链接</a> | 类别 ("+
				dailies.results[i].channelName+") | 发表于 "+dailies.results[i].addTime+" </div></td></tr>";
				}
			val += "</table>";
			var click = 'getDailies(\'${user.id}\',\''+dailies.channelId+'\',\''+dailies.tagId+'\',\'[no]\')';
			
			var pa = pagination(dailies.pageSum,dailies.no,dailies.next,dailies.pre,click);
			val +=pa;
			$('module1').innerHTML = val;
			}
		else{
			$('module1').innerHTML = "查不相关记录";
			}
		}
}
function getChannels(id) {
	var url = '<%=request.getContextPath()%>/getDailyChannels.do';
	var pars = 'id='+id;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse2
	});
	function showResponse2(originalRequest){
		jsonRaw = originalRequest.responseText;
		channels = eval("(" + jsonRaw + ")");
		var val = "<table width='98%' border='0' cellspacing='11'><tr><td width='100%'><a href="+'"javascript:getDailies('+"'${user.id}','','','1'"+')"'+">全部分类</a></td></tr>";
		for(i=0;i<channels.results.length;i++){
			val = val+"<tr><td><a href="+'"javascript:getDailies('+"'${user.id}','"+channels.results[i].id+"','','1'"+')"'+">"+channels.results[i].name+"</a>("+channels.results[i].dailyCount+")</td></tr>";
			}
		val = val+"</table>";
		$('module2').innerHTML = val;
		}
}
function getTags(id) {
	var url = '<%=request.getContextPath()%>/getDailyTags.do';
	var pars = 'id='+id;
	new Ajax.Request(url, {
		method :'post',
		parameters :pars,
		onComplete :showResponse3
	});
	function showResponse3(originalRequest){
		jsonRaw = originalRequest.responseText;
		tags = eval("(" + jsonRaw + ")");
		var val = '';
		for(var i=0;i<tags.results.length;i++){
			val = val+"<a href="+'"javascript:getDailies('+"'${user.id}','','"+tags.results[i].id+"','1'"+')"'+">"+tags.results[i].name+"</a>&nbsp;&nbsp;";
			if(i%5==4){
				val =val+'<br />';
				}
			}
		$('module3').innerHTML = val;
		}
}
initData();
</script>
<div class="side">

	<DIV class="module">
		<DIV class=title>
			<h2>
				日志分类
			</h2>
		</DIV>
		<DIV id='module2' class="reDiv">
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
		</DIV>
	</DIV>
	<DIV class="module">
		<DIV class=title>
			<h2>
				日志标签
			</h2>
		</DIV>
		<DIV id='module3'>
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
		</DIV>
	</DIV>
</div>
<div class="main">
	<DIV class="module">
		<DIV class=title>
			<h2>
				<a href='<%=request.getContextPath()%>/vblog/index/'>播客</a>-
				<a href='<%=request.getContextPath()%>/home/${user.id }/'>${user.realName
					}</a>
			</h2>
		</DIV>
		<DIV id='module1'>
			<img src="<%= application.getAttribute("IMAGE_URL")%>/1mpweb/images/loading.gif"
				width="20" />
		</DIV>
	</DIV>
</div>