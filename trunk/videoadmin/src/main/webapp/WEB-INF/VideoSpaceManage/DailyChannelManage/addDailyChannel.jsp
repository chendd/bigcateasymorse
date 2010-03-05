<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	function tijiao(actionname) {
		if(confirm('确认'+actionname+'该栏目？')){
			document.forms[0].submit();
		}
	}
</script>
<form action="dailyChannelManage.do" method="post">
	<table width="303" border="0" align="center">
		<input type="hidden" name="flag" value="1" />
		<input type="hidden" name="method" value="add" />
		<input type="hidden" name="id" value="${dailyChannel.id }" />
		<tr>
			<td width="127">
				<div align="right">
					所属栏目:
				</div>
			</td>
			<td width="166">
				<label>
					<select name="parentId">
						<option value="0">
							无（作为一级栏目）
						</option>
						<c:forEach items="${dailyChannelList}" var="dailyChannels">
							<c:choose>
								<c:when
									test="${dailyChannel!=null&&dailyChannels.id==dailyChannel.parent.id}">
									<c:set value="selected=&quot;seleced&quot;" var="parent" />
								</c:when>
								<c:otherwise>
									<c:set value="" var="parent" />
								</c:otherwise>
							</c:choose>
							<option value="${dailyChannels.id }" ${parent }>
								${dailyChannels.name }
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
					<input type="text" name="name" value="${dailyChannel.name }" />
				</label>
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
					<textarea name="description">${dailyChannel.description }</textarea>
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					推荐栏目:
				</div>
			</td>
			<td>
				<label>
					<c:set var="recommend" value="checked=&quot;checked&quot;" />
					<c:if test="${dailyChannel.recommend==1 }">
						<c:set var="recommend" value="checked=&quot;checked&quot;" />
					</c:if>
					<c:if test="${dailyChannel.recommend==0 }">
						<c:set var="norecommend" value="checked=&quot;checked&quot;" />
					</c:if>
					<input type="radio" name="recommend" value="1" ${recommend } />
				</label>
				是
				<label>
					<input type="radio" name="recommend" value="0" ${norecommend } />
				</label>
				否
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					顶部导航栏显示:
				</div>
			</td>
			<td>
				<label>
					<c:set var="beTop" value="checked=&quot;checked&quot;" />
					<c:if test="${dailyChannel.beTop==1 }">
						<c:set var="beTop" value="checked=&quot;checked&quot;" />
					</c:if>
					<c:if test="${dailyChannel.beTop==0 }">
						<c:set var="nobeTop" value="checked=&quot;checked&quot;" />
					</c:if>
					<input type="radio" name="beTop" value="1" ${beTop } />
				</label>
				是
				<label>
					<input type="radio" name="beTop" value="0" ${nobeTop } />
				</label>
				否
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					栏目配色模板:
				</div>
			</td>
			<td>
				<label>
					<input type="text" name="textfield2" />
				</label>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					版面设计模板:
				</div>
			</td>
			<td>
				<label>
					<input type="text" name="textfield3" />
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
				<a href="${dailyChannel.image }" target="_bank">${dailyChannel.image
					}</a>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					管理员:
				</div>
			</td>
			<td>
				<select name="manageId">
					<option value="-1">
						无
					</option>

					<c:forEach items="${manageList}" var="manage">
						<c:choose>
							<c:when test="${manage.id==dailyChannel.manageId}">
								<c:set value="selected=&quot;seleced&quot;" var="manages" />
							</c:when>
							<c:otherwise>
								<c:set value="" var="manages" />
							</c:otherwise>
						</c:choose>
						<option value="${manage.id } "${manages }>
							${manage.name }
						</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					栏目浏览权限:
				</div>
			</td>
			<td>
				<select name="readGrade">
					<c:forEach items="${userLevelList}" var="userLevel">
						<c:choose>
							<c:when
								test="${dailyChannel!=null&&userLevel.id==dailyChannel.readGrade}">
								<c:set value="selected=&quot;seleced&quot;" var="readGrades" />
							</c:when>
							<c:otherwise>
								<c:set value="" var="readGrades" />
							</c:otherwise>
						</c:choose>
						<option value="${userLevel.id }"${readGrades }>
							${userLevel.name}
						</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>
				<div align="right">
					栏目发表日志权限:
				</div>
			</td>
			<td>
				<select name="publishGrade">
					<c:forEach items="${userLevelList}" var="userLevel">
						<c:choose>
							<c:when
								test="${dailyChannel!=null&&userLevel.id==dailyChannel.publishGrade}">
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
				<c:set var="submitName" value="添加" />
				<c:if test="${dailyChannel.id!=null}">
					<c:set var="submitName" value="修改" />
				</c:if>
					<input type="button" name="Submit" value="${submitName }" onclick="tijiao('${submitName }')" />
				</div>
			</td>
			<td>
				<label>
					<input type="button" name="cancel" value="取消" onclick="javascript:history.go(-1);" />
				</label>
			</td>
		</tr>
	</table>
</form>