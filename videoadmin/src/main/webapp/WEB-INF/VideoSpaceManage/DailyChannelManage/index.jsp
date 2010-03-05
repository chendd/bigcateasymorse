<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	function clean(cleanid,cleanname){
		if(confirm('该操作将会清空'+cleanname+'栏目下的所有日志!')){
			window.location.href='dailyChannelManage.do?method=clean&&id='+cleanid;
		}
	}
	
	function deleteChannel(cleanid,cleanname){
		if(confirm('该操作将会删除'+cleanname+'栏目及该栏目下的所有日志!')){
			window.location.href='dailyChannelManage.do?method=delete&&id='+cleanid;
		}
	}
</script>

<p style="color: red;">
	${error }
</p>
<table id="formattable" width="852" border="0" align="center">
	<tr>
		<th width="125">
			栏目名称		</th>
		<th width="175">
			管理员		</th>
		<th width="98">
			栏目属性		</th>
		<th width="87">
			浏览权限		</th>
		<th width="74">
			添加权限		</th>
		<th colspan="5">
			<div align="center">
				操作选项			</div>	  </th>
	</tr>
	<c:forEach items="${pagination.results}" var="dailyChnnel">
		<tr>

			<td>
			<div align="center">${dailyChnnel.name }		    </div></td>
			<td>
			<div align="center">${dailyChnnel.manage.name }		    </div></td>
			<td>
			 <div align="center">
				<c:if test="${dailyChnnel.recommend==1 }">
				 推荐
				</c:if>
				<c:if test="${dailyChnnel.beTop==1 }">
				 置顶
			</c:if>	</div>		</td>
			<td>
				<c:if test="${dailyChnnel.readGrade==0 }">
				  <div align="center">游客</div>
				</c:if>
				<c:if test="${dailyChnnel.readGrade==1 }">
				  <div align="center">注册用户</div>
			</c:if>			</td>
			<td>
				<c:if test="${dailyChnnel.publishGrade==0 }">
				  <div align="center">游客</div>
				</c:if>
				<c:if test="${dailyChnnel.publishGrade==1 }">
				  <div align="center">注册用户</div>
			</c:if>			</td>
			<td width="60">
				<div align="center"><a href="dailyChannelManage.do?method=add&&id=${dailyChnnel.id}">添加子栏目</a> </div></td>
			<td width="61">
				<div align="center"><a href="dailyChannelManage.do?method=update&&id=${dailyChnnel.id}">修改设置</a> </div></td>
			<td width="48">
				<div align="center"><a href="dailyChannelManage.do?method=move&&id=${dailyChnnel.id}">移动栏目</a> </div></td>
			<td width="42">
				<div align="center"><a
					href="javascript:clean('${dailyChnnel.id}','${dailyChnnel.name}')">清空</a> </div></td>
			<td width="40">
				<div align="center"><a
					href="javascript:deleteChannel('${dailyChnnel.id}','${dailyChnnel.name}')">删除</a> </div></td>
		</tr>
	</c:forEach>
</table>
