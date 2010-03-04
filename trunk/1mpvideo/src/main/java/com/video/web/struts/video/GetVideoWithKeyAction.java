package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetVideoWithKeyAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String noString = request.getParameter("pageNo");
		String key = request.getParameter("key");
		// String key = new String(request.getParameter("key").getBytes(
		// "iso-8859-1"), "utf-8");
		String orderBy = request.getParameter("orderBy");
		int no = 1;
		if (noString != null && !noString.trim().isEmpty()) {
			no = Integer.parseInt(noString);
		}
		if (orderBy != null && !orderBy.trim().isEmpty()) {
			orderBy = orderBy.replaceAll("[/]*", "");
		}
		if (!"add_date".equals(orderBy) && !"browse_count".equals(orderBy)
				&& !"commentcount".equals(orderBy)
				&& !"collectionCount".equals(orderBy)) {
			orderBy = "add_date";
		}
		Video video = new Video();
		video.setDescription(key);
		video.setName(key);
		Pagination<Video> pagination = new Pagination<Video>();

		pagination.setCondition(video);
		pagination.setNo(no);
		pagination.setSize(SomeStatic.VIDEO_KEY_PAGESIZE);
		pagination.setOrderFieldName(orderBy);

		getAllService().getVideoBykey(pagination);

		request.setAttribute("pagination", pagination);
		request.setAttribute("key", key);
		request.setAttribute("orderBy", orderBy);

		return mapping.findForward("success");
	}
}
