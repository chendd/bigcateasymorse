package com.video.web.struts.video;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.domain.connection.VideoAndTag;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetMyVideoByIdAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		String idString = request.getParameter("id");
		String path = "success";
		Long id = null;
		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		Video video = null;
		if (id != null) {
			video = getAllService().getVideo(id);
		}

		if (user != null && video != null) {
			
			
			List<Tag> list = getAllService().getTagsByVideo(video.getId());
			request.setAttribute("tags", list);
			request.setAttribute("video", video);
		} else {
			path = "error";
		}
		return mapping.findForward(path);
	}
}
