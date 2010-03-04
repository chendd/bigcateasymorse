package com.video.web.struts.video;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.CollectionVideo;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.web.struts.BaseAction;

public class UpdateVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String videoIdString = request.getParameter("videoId");
		String action = request.getParameter("action");
		Long videoId = null;

		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
		}
		Video video = getAllService().getInitVideo(videoId);
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		if (action.equals("top")) {
			video.setPushCount(video.getPushCount() + 1);
			getAllService().updateVideo(video);
		} else if (action.equals("collection")) {
			CollectionVideo collectionVideo = new CollectionVideo();
			collectionVideo.setVideo(video);
			collectionVideo.setUser(user);
			collectionVideo.setCollectionDate(new Date());
			getAllService().createCollection(collectionVideo);
		} else if (action.equals("notify")) {
			video.setNotify(video.getNotify() + 1);
			getAllService().updateVideo(video);
		}

		return null;
	}
}


