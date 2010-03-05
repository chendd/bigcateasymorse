<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function tijiao() {
		if(confirm('确认添加该栏目？')){
			document.forms[0].submit();
		}
	}
</script>
<form action="addVideoChannel.do" method="post" name="videoChannelForm">
	<input type="hidden" name="flag" value="1" />
	<table width="353" border="0" align="center">
		<tr>
			<td width="139">
				<div align="right">
					父栏目:
				</div>
			</td>
			<td width="204">
				<label>
					<select name="parentId">
						<option value="0">
							无（作为一级栏目）
						</option>
						<c:forEach items="${videoChannelList}" var="videoChannels">
							<c:choose>
								<c:when
									test="${videoChannels.id==videoChannel.parent.id}">
									<c:set value="selected"
										var="selectVideoChannel" />
								</c:when>
								<c:otherwise>
									<c:set value="" var="selectVideoChannel" />
								</c:otherwise>
							</c:choose>
							<option value="${videoChannels.id }"${selectVideoChannel }>
								${videoChannels.name }
							</option>
						</c:forEach>
					</select>
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					栏目名称:
				</div>
			</td>
			<td>
				<label>
					<input type="text" name="name" value="${videoChannel.name }" />
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					WAP名称:
				</div>
			</td>
			<td>
				<input type="text" name="wapName" value="${videoChannel.wapName }" />
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					栏目说明:
				</div>
			</td>
			<td>
				<label>
					<textarea name="description">${videoChannel.description }</textarea>
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					栏目图片地址:
				</div>
			</td>
			<td>
				<input type="text" name="imageUrl" value="${videoChannel.imageUrl }" />
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					活跃按钮图片:
				</div>
			</td>
			<td>
				<input type="text" name="activeImageUrl"
					value="${videoChannel.activeImageUrl }" />
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					无效按钮图片:
				</div>
			</td>
			<td>
				<input type="text" name="deactivateImageUrl"
					value="${videoChannel.deactivateImageUrl }" />
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					栏目等级:
				</div>
			</td>
			<td>
				<select name="grade">
					<c:forEach items="${userLevelList}" var="userLevel">
						<c:choose>
							<c:when
								test="${videoChannel!=null&&userLevel.id==videoChannel.grade}">
								<c:set value="selected=&quot;seleced&quot;" var="publishGrades" />
							</c:when>
							<c:otherwise>
								<c:set value="" var="publishGrades" />
							</c:otherwise>
						</c:choose>
						<option value="${userLevel.id }"${publishGrades }>
							${userLevel.name}
						</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td height="29">

				<div align="right">
					<input type="button" name="Submit" value="添加" onclick="tijiao()" />
				</div>
			</td>
			<td>
				<label>
					<input type="button" name="cancel" value="取消"
						onclick="javascript:history.go(-1);" />
				</label>
			</td>
		</tr>
	</table>
</form>