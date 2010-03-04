package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetOtherVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userIdString = request.getParameter("userId");
		String pageNoString = request.getParameter("pageNo");
		String videoIdString = request.getParameter("videoId");
		Long userId = null;
		Long videoId = null;
		int pageNo = 1;

		if (userIdString != null && !userIdString.trim().isEmpty()) {
			userId = Long.parseLong(userIdString);
		}
		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
		}
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}
		Video video = new Video();
		video.setId(videoId);
		User user = new User();
		user.setId(userId);
		video.setUser(user);

		Pagination<Video> pagination = new Pagination<Video>();
		pagination.setNo(pageNo);
		pagination.setSize(SomeStatic.VIDEO_OTHER_PAGESIZE);
		pagination.setCondition(video);
		pagination.setOrderFieldName("v.add_date");
		getAllService().getVideoes(pagination);
		JSONObject object = JSONObject.fromObject(pagination);
		response.getWriter().print(object);

		return null;
	}
}
