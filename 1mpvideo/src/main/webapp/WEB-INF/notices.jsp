<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
function showNotice(index){
var length = '${length}';
var arr=new Array(length);
<c:forEach items="${notices}" var="notice" varStatus="statu">
arr[${statu.index}] = '${notice.notice}';
</c:forEach>

document.getElementById('val').innerHTML=arr[index];
}


</script>
	

<div class="side">
		<div class="module">
			<div class="title">
				<h2>
			
				</h2>
			</div>
			<div class="reDiv">
           <table width="90%">
			<c:forEach items="${notices}" var="notice" varStatus="statu">
			<tr><td><a href="javascript:showNotice('${ statu.index}')">${notice.name}</a></td></tr>
			</c:forEach>	
</table>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="module">
			<div class="title">
				<h2>
				
				</h2>
			</div>
<div id="val" class="reDiv">
${notices[0].notice }
			
</div>
		
		
			
		</div>
	</div>

    