<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function tijiao(dailyname){
		if(confirm('确认移动日志'+dailyname+'?')){
			document.forms[0].submit();
		}
	}
</script>
<div align="center">
	<form action="moveDaily.do" method="post">
		<input type="hidden" name="flag" value="1" />
		<input type="hidden" name="id" value="${daily.id }" />
		日志${daily.title }移动到：
		<select name="moveChannelIdString">
			<c:forEach items="${dailyChannelList}" var="dailyChannels">
				<option value="${dailyChannels.id }">
					${dailyChannels.name }
				</option>
			</c:forEach>
		</select>
		<input type="button" value="移动" onclick="tijiao('${daily.title }')" />
	</form>
</div>