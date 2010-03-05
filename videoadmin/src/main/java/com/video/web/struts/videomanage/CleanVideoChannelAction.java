package com.video.web.struts.videomanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Video;
import com.video.web.struts.BaseAction;

public class CleanVideoChannelAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("id");
		if (ids != null && !ids.trim().isEmpty()) {
			Video video = new Video();
			video.setChannelId(Long.parseLong(ids));
			video.setFlag(-1);
			getAllDao().updateVideoByVideoChannelId(video);
		}
		return mapping.findForward("success");
	}
}
