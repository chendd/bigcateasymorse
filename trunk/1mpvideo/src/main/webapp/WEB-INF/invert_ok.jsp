<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div 
 	style="border: 1px solid rgb(204, 204, 204); margin: 10px 0pt; padding: 5px; background: rgb(255, 255, 204) none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
成功发出邀请邮件！对方应邀加入了时，将自动加为你的好友 </div>

<a href="<%=request.getContextPath()%>/invite/"><button>邀请更多人</button></a>  <a href="<%=request.getContextPath()%>/home/${sessionUser.id }"><button>返回我的首页</button></a>
