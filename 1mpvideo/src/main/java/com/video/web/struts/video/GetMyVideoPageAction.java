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

public class GetMyVideoPageAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) request.getSession().getAttribute("sessionUser");
		String pageNoString = request.getParameter("pageNo");
		Integer pageNo = 1;
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			try {
				pageNo = Integer.parseInt(pageNoString);
			} catch (Exception e) {
				pageNo = 1;
			}
		}
		Video video = new Video();
		video.setUser(user);
		Pagination<Video> pagination = new Pagination<Video>();
		pagination.setCondition(video);
		pagination.setNo(pageNo);
		pagination.setSize(SomeStatic.VIDEO_MY_PAGE);
		getAllService().getVideoes(pagination);
		JSONObject object = JSONObject.fromObject(pagination);
		response.getWriter().print(object);
		return null;
	}
}
