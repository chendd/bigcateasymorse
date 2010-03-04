package com.video.web.struts.playbill;

import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.PlaybillChannel;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class ModifyPlaybillAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) request.getSession().getAttribute("sessionUser");
		String idString = request.getParameter("id");
		String action = request.getParameter("action");
		Long id = null;
		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		Playbill playbill = getAllService().getPlaybill(id);
		if (playbill != null && user != null) {
			if (!playbill.getUser().getId().equals(user.getId())) {
				return mapping.findForward("error");
			}
		}
		if ("modify".equals(action)) {
			String name = request.getParameter("name");
			String channelIdString = request.getParameter("channelId");
			String description = request.getParameter("description");
			Long channelId = null;
			if (channelIdString != null && !channelIdString.trim().isEmpty()) {
				channelId = Long.parseLong(channelIdString);
			}
			playbill.setName(name);
			playbill.getChannel().setId(channelId);
			playbill.setDescription(description);
			getAllService().updatePlaybill(playbill);
		} else {
			List<PlaybillChannel> playbillChannels = getAllService()
					.getPlaybillChannels();
			request.setAttribute("playbillChannels", playbillChannels);
			request.setAttribute("playbill", playbill);
			request.setAttribute("action", "modify");
			return mapping.findForward("modify");
		}

		String url = MessageFormat.format("{0}{1}/addDate/1", mapping
				.findForward("success").getPath(), user.getId());
		return new ActionForward(url, true);
	}
}
