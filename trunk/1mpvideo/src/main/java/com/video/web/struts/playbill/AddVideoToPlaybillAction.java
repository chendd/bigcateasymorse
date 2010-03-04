package com.video.web.struts.playbill;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.PlaybillChannel;
import com.video.domain.User;
import com.video.domain.VideoAndPlayBill;
import com.video.web.struts.BaseAction;

public class AddVideoToPlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String videoIdString = request.getParameter("videoId");
		String playbillIdString = request.getParameter("playbillId");
		String action = request.getParameter("action");
		String playbillName = request.getParameter("playbillName");
		String playbillChannelIdString = request.getParameter("channelId");
		Long videoId = null;
		Long playbillId = null;
		Long playbillChannelId = null;
		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
		}
		if (playbillIdString != null && !playbillIdString.trim().isEmpty()) {
			playbillId = Long.parseLong(playbillIdString);
		}
		if (playbillChannelIdString != null
				&& !playbillChannelIdString.trim().isEmpty()) {
			playbillChannelId = Long.parseLong(playbillChannelIdString);
		}
		if (action.equals("new")) {
			Playbill playbill = new Playbill();
			playbill.setName(playbillName);
			playbill.setAddDate(new Date());
			User user = (User) request.getSession().getAttribute("sessionUser");
			playbill.setUser(user);
			PlaybillChannel playbillChannel = new PlaybillChannel();
			playbillChannel.setId(playbillChannelId);
			playbill.setChannel(playbillChannel);
			getAllService().createPlaybill(playbill);
			playbillId = playbill.getId();
		}

		VideoAndPlayBill videoAndPlayBill = new VideoAndPlayBill();
		videoAndPlayBill.setPlayBillId(playbillId);
		videoAndPlayBill.setVideoId(videoId);
		getAllService().createVideoAndPlayBill(videoAndPlayBill);

		response.getWriter().print("已添加<br>");
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
