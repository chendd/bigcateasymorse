<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
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
		if(confirm('确认分类顺序？')){
			var keywordChanneljs = document.getElementById('keywordChannelId');
			for(var i =0;i<keywordChanneljs.length;i++){
				keywordChanneljs.options[i].selected=true;
			}
			document.forms[0].submit();
		}
	}
	
</script>
<form action="keywordChannelOrder.do" method="post">
	<input type="hidden" name="flag" value="rootOrder" />
	<table width="200" border="0" align="center">
		<tr>
			<td>
				<div align="center">
					<select id="keywordChannelId" name="keywordChannels" size="15"
						multiple="multiple">
						<c:forEach var="keywordChannel" items="${keywordChannelList}">
							<option value="${ keywordChannel.id}">
								${ keywordChannel.name}
							</option>
						</c:forEach>
					</select>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div align="center">
					<input name="button" type="button"
						onClick="UpDownMove('keywordChannelId',true)" value="向上" />
					<input name="button2" type="button"
						onClick="UpDownMove('keywordChannelId',false)" value="向下" />
					<input type="button" name="button3" value="提交" onclick="tijiao()" />
				</div>
			</td>
		</tr>
	</table>
</form>