package com.video.web.struts.playbill;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.jspsmart.upload.SmartUpload;
import com.video.domain.Playbill;
import com.video.domain.PlaybillChannel;
import com.video.domain.User;
import com.video.util.SomeStatic;
import com.video.util.ZoomImage;
import com.video.web.struts.BaseAction;

public class AddPlaybillAction extends BaseAction {
	public void initValue(HttpServletRequest request,
			HttpServletResponse response) {
		List<PlaybillChannel> playbillChannels = getAllService()
				.getPlaybillChannels();
		request.setAttribute("playbillChannels", playbillChannels);
		request.setAttribute("action", "new");
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		String action = request.getParameter("action");
		if (action == null) {
			
			String name = request.getParameter("name");
			
			String channelIdString = request.getParameter(
					"channelId");
			String description = request.getParameter(
					"description");
			
			if (name == null || name.trim().isEmpty()) {
				request.setAttribute("nameError", "标题不能为空");
				initValue(request, response);
				return mapping.findForward("error");
			} else {

			
			
				
					
					Long channelId = null;
					PlaybillChannel playbillChannel = new PlaybillChannel();
					if (channelIdString != null
							&& !channelIdString.trim().isEmpty()) {
						channelId = Long.parseLong(channelIdString);
					}
					playbillChannel.setId(channelId);
					Playbill playbill = new Playbill();
					playbill.setName(name);
					playbill.setAddDate(new Date());
					playbill.setBrowseCount(0);
					playbill.setChannel(playbillChannel);
					playbill.setCommentCount(0);
					playbill.setDescription(description);
					playbill.setFlag(1);
					String imagesUrl = "\\upload\\videoImg\\special.jpg";
							
					
				
					playbill.setImagesUrl(imagesUrl);
					playbill.setUser(user);
					getAllService().createPlaybill(playbill);
				
			}
		} else {
			initValue(request, response);
			return mapping.findForward("error");
		}
		String url = MessageFormat.format("{0}{1}/addDate/1", mapping
				.findForward("success").getPath(), user.getId());
		return new ActionForward(url, true);
	}
}
