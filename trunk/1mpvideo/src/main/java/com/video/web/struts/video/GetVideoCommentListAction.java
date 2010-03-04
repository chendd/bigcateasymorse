package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Comment;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetVideoCommentListAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String videoIdString = request.getParameter("videoId");
		String pageNoString = request.getParameter("pageNo");
		
		int pageNo = 1;
		Long videoId = null;
		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
		}
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}

		Pagination<Comment> pagination = new Pagination<Comment>();
		Comment comment = new Comment();
		Video video = new Video();
		video.setId(videoId);
		comment.setVideo(video);
		pagination.setCondition(comment);
		pagination.setNo(pageNo);
		pagination.setSize(SomeStatic.VIDEO_COMMENT_PAGESIZE);

		getAllService().getCommentByVideoId(pagination);
		JSONObject array = JSONObject.fromObject(pagination);
		response.getWriter().print(array);
		
		return null;
	}
}
