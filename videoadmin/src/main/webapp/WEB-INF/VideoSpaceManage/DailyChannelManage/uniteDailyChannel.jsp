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
	    
        childtree.add(0, -1, '栏目合并','');
	    <%
	    List<DailyChannel> dailyChannelTree= (List<DailyChannel>)request.getAttribute("dailyChannelTree");
	    	for(int i = 0;i<dailyChannelTree.size();i++){
	    		%>
	    			childtree.add(<%=dailyChannelTree.get(i).getId()%>,<%=dailyChannelTree.get(i).getParentId() == null ? 0
								: dailyChannelTree.get(i).getParentId()%>,
	    			 '<%=dailyChannelTree.get(i).getName()%>','javascript:setthis(\'<%=dailyChannelTree.get(i).getId()%>\',\'<%=dailyChannelTree.get(i).getName()%>\')','','','');
	    		<%
	    	}
	    %>
	    document.write(childtree);
	    
	function tijiao(){
		var source= document.getElementById('sourceDailyChannelId');
		var destination = document.getElementById('destinationDailyChannelId');
		var sourcename= document.getElementById('sourceDailyChannelName');
		var destinationname = document.getElementById('destinationDailyChannelName');
		if(source.value==''){
			alert('要合并栏目为空！');
			return;
		}
		if(destination.value==''){
			alert('合并到栏目为空！');
			return;
		}
		if(source.value==destination.value){
			alert('源栏目和目的栏目不能相同！');
			return;
		}
		if(confirm('确认将'+sourcename.value+'栏目合并到'+destinationname.value+'？')){
			document.forms[0].submit();
		}
	}
	function setactionid(thistext){
		document.getElementById('actionname').value=thistext.name;
		if(thistext.name=='sourceDailyChannelName'){
			document.getElementById('actionid').value='sourceDailyChannelId';
		}
		if(thistext.name=='destinationDailyChannelName'){
		
			document.getElementById('actionid').value='destinationDailyChannelId';
		}
	}
	function setthis(ids,names){
		
			if(document.getElementById('sourceDailyChannelId').value==''){
				document.getElementById('actionid').value='sourceDailyChannelId';
				document.getElementById('actionname').value='sourceDailyChannelName';
			}else if(document.getElementById('destinationDailyChannelId').value==''){
				document.getElementById('actionid').value='destinationDailyChannelId';
				document.getElementById('actionname').value='destinationDailyChannelName';
			}
		
		var actionid = document.getElementById('actionid').value;
		var actionname = document.getElementById('actionname').value;
		document.getElementById(actionid).value=ids;
		document.getElementById(actionname).value=names;
	}
 	</script>
			</td>
			<td>
				<p style="color: red;">
					${error }
				</p>
				<input type="hidden" id="actionid" name='actionid' />
				<input type="hidden" id="actionname" name='actionname' />
				<input type="hidden" id="sourceDailyChannelId"
					name='sourceDailyChannelId' />
				<input type="hidden" id="destinationDailyChannelId"
					name='destinationDailyChannelId' />
				<input type="hidden" name="method" value="unite" />
				<input type="hidden" name="flag" value="unite" />
				合并栏目：
				<input type="text" name="sourceDailyChannelName"
					id='sourceDailyChannelName' onclick="setactionid(this)" />
				到：
				<input type="text" name="destinationDailyChannelName"
					id='destinationDailyChannelName' onclick="setactionid(this)" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<input type="button" onclick="tijiao();" value="合并" />
			</td>
		</tr>
	</table>
</form>