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

<form action="dailyChannelManage.do" method="post">
	<table width="200" border="0" align="center">
		<tr>
			<td>
				栏目：${moveDailyChannel.name }移动到
				<input type="hidden" name="moveId" value="${moveDailyChannel.id }" />
				<input type="hidden" name="method" value="move" />
				<input type="hidden" name="flag" value="1" />
			</td>
			<td>
				<select name="endId" size="10" id="endId">
					<c:forEach var="dailyChannel" items="${moveDailyChannelList}">
						<option value="${dailyChannel.id }">
							${dailyChannel.name }
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
				<input type="button" name="Submit" value="提交" onclick="tijiao('${moveDailyChannel.name }')"/>
			</td>
		</tr>
	</table>
</form>