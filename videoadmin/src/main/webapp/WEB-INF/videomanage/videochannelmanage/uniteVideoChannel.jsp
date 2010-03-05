<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.video.domain.VideoChannel"%>
<SCRIPT language=javascript src="/js/dtree/dtree.js" />
<link rel="stylesheet" href="/js/dtree/dtree.css" type="text/css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	
	
</script>
<form action="uniteVideoChannel.do" method="post">
	<table width="600" border="0" align="center">
		<tr>
			<td>
				<SCRIPT LANGUAGE="JavaScript">
	    channeltree = new dTree('channeltree');
	    channeltree.config.imageDir = 'js/dtree/img';
	    channeltree.reSetImagePath();
	    channeltree.config.folderLinks = true;
	    channeltree.config.closeSameLevel = false;
	       //根节点
	    
        channeltree.add(0, -1, '栏目合并','');
	    <%
	    List<VideoChannel> videoChannelTree= (List<VideoChannel>)request.getAttribute("videoChannelTree");
	    	for(int i = 0;i<videoChannelTree.size();i++){
	    		%>
	    			channeltree.add(<%=videoChannelTree.get(i).getId()%>,<%=videoChannelTree.get(i).getParentId() == null ? 0
								: videoChannelTree.get(i).getParentId()%>,
	    			 '<%=videoChannelTree.get(i).getName()%>','javascript:setthis(\'<%=videoChannelTree.get(i).getId()%>\',\'<%=videoChannelTree.get(i).getName()%>\')','','','');
	    		<%
	    	}
	    %>
	    document.write(channeltree);
	    
	function tijiao(){
		var source= document.getElementById('sourceVideoChannelId');
		var destination = document.getElementById('destinationVideoChannelId');
		var sourcename= document.getElementById('sourceVideoChannelName');
		var destinationname = document.getElementById('destinationVideoChannelName');
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
		if(thistext.name=='sourceVideoChannelName'){
			document.getElementById('actionid').value='sourceVideoChannelId';
		}
		if(thistext.name=='destinationVideoChannelName'){
		
			document.getElementById('actionid').value='destinationVideoChannelId';
		}
	}
	function setthis(ids,names){
		
			if(document.getElementById('sourceVideoChannelId').value==''){
				document.getElementById('actionid').value='sourceVideoChannelId';
				document.getElementById('actionname').value='sourceVideoChannelName';
			}else if(document.getElementById('destinationVideoChannelId').value==''){
				document.getElementById('actionid').value='destinationVideoChannelId';
				document.getElementById('actionname').value='destinationVideoChannelName';
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
				<input type="hidden" id="sourceVideoChannelId"
					name='sourceVideoChannelId' />
				<input type="hidden" id="destinationVideoChannelId"
					name='destinationVideoChannelId' />
				<input type="hidden" name="method" value="unite" />
				<input type="hidden" name="flag" value="unite" />
				合并栏目：
				<input type="text" name="sourceVideoChannelName"
					id='sourceVideoChannelName' onclick="setactionid(this)" />
				到：
				<input type="text" name="destinationVideoChannelName"
					id='destinationVideoChannelName' onclick="setactionid(this)" />
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