<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form action="updateNotice.do" method="post">
<table>
<tr><td>ID：</td><td><input type="text" name="id" value="${notice.id }" readonly="readonly"/></td></tr>
<tr><td>名称：</td><td><input type="text" name="name" value="${notice.name }" /></td></tr>
<tr><td>内容：</td><td>
<textarea rows="5" cols="30" name="notice">${notice.notice }</textarea>

</td></tr>
<tr><td></td><td><input type="submit" value="修改" /></td></tr>
</table>

</form>
