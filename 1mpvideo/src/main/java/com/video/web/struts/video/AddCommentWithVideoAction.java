package com.video.web.struts.video;

import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Comment;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.web.struts.BaseAction;

public class AddCommentWithVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String comment = new URLDecoder().decode(request
				.getParameter("comment"), "utf-8");
		String videoIdString = request.getParameter("videoId");
		Long videoId = null;
		
		User user = (User) request.getSession().getAttribute("sessionUser");

		Comment videoComment = new Comment();

		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
		}

		Video video = new Video();
		video.setId(videoId);

		videoComment.setUser(user);
		videoComment.setVideo(video);
		videoComment.setCommentDate(new Date());
		videoComment.setComment(comment);

		getAllService().createComment(videoComment);

		response.getWriter().print("");
		return null;
	}
}
