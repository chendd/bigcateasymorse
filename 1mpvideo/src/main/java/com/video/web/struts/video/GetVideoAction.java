package com.video.web.struts.video;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SubscribeUser;
import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idString = request.getParameter("id");
		Long id = null;
		String url = "success";
		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}

		User user = null;
		if (request.getSession().getAttribute("sessionUser") != null) {
			user = (User) request.getSession().getAttribute("sessionUser");
		}
		Video video = getAllService().getVideoById(id, user);
		if (video == null) {
			url = "notFind";
		} else {
			User videoUser = getAllService().getUserById(video.getUserId());
			Tag tag = new Tag();
			tag.setUser(user);
			Pagination<Tag> pagination = new Pagination<Tag>();
			pagination.setSize(SomeStatic.TAG_ABOUTUSER_PAGESIZE);
			pagination.setNo(1);
			pagination.setCondition(tag);
			List<Tag> tagList = getAllService().getMyVideoTag(pagination);
			request.setAttribute("tagList", tagList);
			request.setAttribute("videoUser", videoUser);
			SubscribeUser subscribeUser = new SubscribeUser();
			subscribeUser.setUser(user);
			subscribeUser.setPassiveUser(videoUser);
		
		}
	
		request.setAttribute("video", video);
		return mapping.findForward(url);
	}
}
