<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<SCRIPT LANGUAGE="JavaScript">
function tijiao(){
		if(confirm('确认恢复所有栏目顺序初始值？')){
			window.location.href="dailyChannelManage.do?method=reposition&flag=true";
		}
	}
</SCRIPT>

<h1>
	注意!此操作将恢复所有栏目的顺序为初始值！
</h1>

<input type="button" name="button" value="复位" onclick="tijiao()" />