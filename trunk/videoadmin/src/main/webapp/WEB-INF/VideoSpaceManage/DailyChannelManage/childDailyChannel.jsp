<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.video.domain.DailyChannel"%>
<SCRIPT language=javascript src="/js/dtree/dtree.js" />
<link rel="stylesheet" href="/js/dtree/dtree.css" type="text/css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	
	
</script>
<form name="rootManageForm" action="dailyChannelManage.do" method="post">
	<input type="hidden" name="flag" value="childOrder" />
	<input type="hidden" name="method" value="child" />
	<input type="hidden" name="parentid" value="${parentid }" />
	<table width="200" border="0" align="center">
		<tr>
			<td>
				<SCRIPT LANGUAGE="JavaScript">
	    childtree = new dTree('childtree');
	    childtree.config.imageDir = 'js/dtree/img';
	    childtree.reSetImagePath();
	    childtree.config.folderLinks = true;
	    childtree.config.closeSameLevel = false;
	    var isOpen ;
	       //根节点
	    
        childtree.add(0, -1, '栏目分类顺序管理','');
	    <%
	    List<DailyChannel> dailyChannelTree= (List<DailyChannel>)request.getAttribute("dailyChannelTree");
	    	for(int i = 0;i<dailyChannelTree.size();i++){
	    		%>
	    			childtree.add(<%=dailyChannelTree.get(i).getId()%>,<%=dailyChannelTree.get(i).getParentId() == null ? 0
								: dailyChannelTree.get(i).getParentId()%>,
	    			 '<%=dailyChannelTree.get(i).getName()%>','dailyChannelManage.do?method=child&action=getchild&parentid=<%=dailyChannelTree.get(i).getId()%>','','','');
	    		<%
	    	}
	    %>
	    document.write(childtree);
	    var o;
	var op;
	var source;
	var distinct;
	var tempo1;
	var tempo2;
	var flg;
	function UpDownMove(sourceid, asc) {
		var targetIndex;
		var startIndex;
		var endIndex;
		source = document.getElementById(sourceid);
		if (asc) {
			startIndex = 1;
			endIndex = source.options.length - 1;
		} else {
			startIndex = source.options.length - 2;
			endIndex = 0;
		}
		for (i = startIndex;;) {
			if (asc) {
				if (i > endIndex)
					return;
				targetIndex = i - 1;
			} else {
				if (i < endIndex)
					return;
				targetIndex = i + 1;
			}
			if (source.options[i].selected
					&& !source.options[targetIndex].selected) {
				
					o = source.options[i];
					op = source.options[targetIndex];
					tempo1 = new Option(o.text, o.value);
					tempo2 = new Option(op.text, op.value);
					tempo1.selected = true;
					source.options[i] = tempo2;
					source.options[targetIndex] = tempo1;
				
			}
			if (asc) {
				i++;
			} else
				i--;
		}
	}
	function tijiao(){
		if(confirm('确认一级栏目顺序？')){
			var rootDailyChanneljs = document.getElementById('childDailyChannelsId');
			for(var i =0;i<rootDailyChanneljs.length;i++){
				rootDailyChanneljs.options[i].selected=true;
			}
			document.forms[0].submit();
		}
	}
 	</script>
			</td>
			<td>
				<div align="center">
					<p>
						<select id="childDailyChannelsId" name="childDailyChannels" style="width:300px"
							size="15" multiple="multiple">
							<c:forEach var="dailyChannelop" items="${childDailyChannelsList}">
								<option value="${ dailyChannelop.id}">
									${ dailyChannelop.name}
								</option>
							</c:forEach>
						</select>
					</p>
					<input name="button" type="button"
						onClick="UpDownMove('childDailyChannelsId',true)" value="向上" />
					<input name="button2" type="button"
						onClick="UpDownMove('childDailyChannelsId',false)" value="向下" />
					<input type="button" name="button3" value="提交" onclick="tijiao()" />
				</div>
			</td>
		</tr>
	</table>
</form>