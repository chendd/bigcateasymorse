<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form action="updateNotice.do" method="post">
<table>

<tr><td>名称：</td><td><input name="name" type="text"/></td></tr>
<tr><td>内容：</td><td>
<textarea rows="5" cols="30" name="notice"></textarea>

</td></tr>
<tr><td></td><td><input type="submit" value="添加" /></td></tr>
</table>

</form>
