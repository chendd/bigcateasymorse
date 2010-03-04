package com.video.web.struts.video;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.domain.Video;
import com.video.web.struts.BaseAction;

public class DeleteMyVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] ids = request.getParameterValues("selectId");
		User user = (User) request.getSession().getAttribute("sessionUser");
		Long id = null;
		Video video = null;
		String url = mapping.findForward("error").getPath();
		if (user != null) {
			url = MessageFormat.format("{0}{1}/1/addDate/1", mapping
					.findForward("success").getPath(), user.getId());
			for (String idString : ids) {
				id = Long.parseLong(idString);
				video = getAllService().getVideo(id);
				if (video != null
						&& video.getUser().getId().equals(user.getId())) {
					video.setFlag(-1);
					getAllService().updateVideo(video);
				} else {
					break;
				}
			}
		}
		return new ActionForward(url, true);
	}
}
