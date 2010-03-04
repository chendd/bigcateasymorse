<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
function checkit(){
	var text = $('text').value;
	if(text==''){
		alert("信息不能为空");
		}
	else{
		document.form1.submit();
		}
}
</script>
<div align="center">
	<form action="<%=request.getContextPath()%>/createWhisper.do" method="post" name="form1" id="form1">
		<table width="50%">
			<tr>
				<td width="10%">
					收件人
				</td>
				<td width="90%">
					<a href="<%=request.getContextPath()%>/home/${user.id }/">${user.realName }</a>
					<input type="hidden" name="id" value="${user.id }" />
				</td>
			</tr>
			<tr>
				<td>
					内容
				</td>
				<td>
					<textarea rows="5" cols="30" id="text" name="text"></textarea>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button onclick="checkit();">
						提交
					</button>
				</td>
			</tr>
		</table>
	</form>
</div>
