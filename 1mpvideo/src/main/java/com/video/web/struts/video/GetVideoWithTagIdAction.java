package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Video;
import com.video.domain.connection.VideoAndTag;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetVideoWithTagIdAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String tagIdString = request.getParameter("id");
		String noString = request.getParameter("pageNo");
		String name = request.getParameter("name");
		String orderBy = request.getParameter("orderBy");
		int no = 1;
		Long tagId = null;
		if (noString != null && !noString.trim().isEmpty()) {
			no = Integer.parseInt(noString);
		}
		if (tagIdString != null && !tagIdString.trim().isEmpty()) {
			tagId = Long.parseLong(tagIdString);
		}
		if (orderBy != null && !orderBy.trim().isEmpty()) {
			orderBy = orderBy.replaceAll("[/]*", "");
		}
		VideoAndTag videoAndTag = new VideoAndTag();
		videoAndTag.setTagId(tagId);

		Pagination<Video> pagination = new Pagination<Video>();

		pagination.setCondition(videoAndTag);
		pagination.setNo(no);
		pagination.setSize(SomeStatic.VIDEO_TAG_PAGESIZE);
		pagination.setOrderFieldName(orderBy);

		getAllService().getVideoByTagId(pagination);

		request.setAttribute("pagination", pagination);
		request.setAttribute("name", name);
		request.setAttribute("id", tagId);
		request.setAttribute("orderBy", orderBy);

		return mapping.findForward("success");
	}
}
