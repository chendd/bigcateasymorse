package com.video.web.struts.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.web.struts.BaseAction;

public class SendMessageAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String sendUserIdString = request.getParameter("toUserId");
		
		String message = request.getParameter("message");
		Long sendUserId = null;

		if (sendUserIdString != null && !sendUserIdString.trim().isEmpty()) {
			sendUserId = Long.parseLong(sendUserIdString);
		}

		User toUser = (User) request.getSession().getAttribute("sessionUser");
		User sendUser = new User();
		sendUser.setId(sendUserId);

		Whisper whisper = new Whisper();
		whisper.setToUser(sendUser);
		whisper.setFromUser(toUser);
		whisper.setMessage(message);
		whisper.setSendDate(new Date());
		getAllService().createWhisper(whisper);
		response.getWriter().print("已发送<br>");
		response
				.getWriter()
				.print(
						"<input type=\"button\" value=\"关闭\" onclick=\"self.close();\" />");
		response.getWriter().print("<div id='showtime'></div>秒后关闭");
		response.getWriter().print("<script type=\"text/javascript\">");
		response.getWriter().print("function count(time){");
		response.getWriter().print(
				"document.getElementById('showtime').innerHTML=time;  ");
		response.getWriter().print(
				"if(time==0){setTimeout(\"self.close()\",100);}");
		response.getWriter().print("setTimeout('count('+(--time)+')',1000);");
		response.getWriter().print("}");
		response.getWriter().print("window.onload = function(){count(3);}");

		response.getWriter().print("</script>");

		return null;
	}
}
