package com.video.web.struts.playbill;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.domain.VideoAndPlayBill;
import com.video.web.struts.BaseAction;

public class ModifyPlaybillDeleteVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) request.getSession().getAttribute("sessionUser");
		String idString = request.getParameter("id");
		String videoIdString = request.getParameter("videoId");
		Long id = null;
		Long videoId = null;
		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
		}
		Playbill playbill = getAllService().getPlaybill(id);
		if (playbill == null || user == null
				|| !playbill.getUser().getId().equals(user.getId())) {
			return mapping.findForward("error");
		}
		VideoAndPlayBill videoAndPlayBill = new VideoAndPlayBill();
		videoAndPlayBill.setPlayBillId(id);
		videoAndPlayBill.setVideoId(videoId);

		getAllService().deleteVideoAndPlayBill(videoAndPlayBill);

		String url = MessageFormat.format("{0}{1}/1/", mapping
				.findForward("success").getPath(), id);
		return new ActionForward(url, true);
	}
}
