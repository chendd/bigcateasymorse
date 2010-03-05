<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function tijiao(a) {
		var dd = window.document.getElementById('endId').selectedIndex;
	
		if(dd!=-1){
			if(confirm('确认移动栏目'+a+'？')){
				document.forms[0].submit();
			}
		}else{
			alert('请选择要移动到的栏目！');
		}
	}
</script>

<form action="moveVideoChannel.do" method="post">
	<table width="200" border="0" align="center">
		<tr>
			<td>
				栏目：${videoChannel.name }移动到
				<input type="hidden" name="moveId" value="${videoChannel.id }" />
				<input type="hidden" name="flag" value="1" />
			</td>
			<td>
				<select name="endId" size="10" id="endId">
					<c:forEach var="videoChannels" items="${videoChannelList}">
						<option value="${videoChannels.id }">
							${videoChannels.name }
						</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
			<td>
				<input type="button" name="Submit" value="提交"
					onclick="tijiao('${videoChannel.name }')" />
			</td>
		</tr>
	</table>
</form>