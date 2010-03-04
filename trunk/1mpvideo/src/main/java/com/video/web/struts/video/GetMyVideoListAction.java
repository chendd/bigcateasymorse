package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetMyVideoListAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNoString = request.getParameter("pageNo");
		String order = request.getParameter("order");
		int pageNo = 1;
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			try {
				pageNo = Integer.parseInt(pageNoString);
			} catch (Exception e) {
				pageNo = 1;
			}
		}
		if ("browseCount".equals(order)) {
			order = "v.browse_count";
		} else if ("pushCount".equals(order)) {
			order = "v.phsh_count";
		} else {
			order = "v.add_date";
		}
		User user = (User) request.getSession().getAttribute("sessionUser");
		Video video = new Video();
		video.setUser(user);
		Pagination<Video> pagination = new Pagination<Video>();
		pagination.setCondition(video);
		pagination.setNo(pageNo);
		pagination.setSize(SomeStatic.VIDEO_MY_LIST);
		pagination.setOrderFieldName(order);
		getAllService().getVideoes(pagination);
		request.setAttribute("pagination", pagination);

		return mapping.findForward("success");
	}
}
