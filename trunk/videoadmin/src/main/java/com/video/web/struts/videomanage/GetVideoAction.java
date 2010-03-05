package com.video.web.struts.videomanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Tag;
import com.video.domain.Video;
import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class GetVideoAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if (strId != null && !strId.trim().isEmpty()) {
			try {
				id = Long.parseLong(strId);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		Video video = getAllDao().getVideoById(id);
		List<VideoChannel> channels = getAllDao().getVideoChannelList();
		List<Tag> tags = getAllDao().getTagsByVideo(id);
		request.setAttribute("channels", channels);
		request.setAttribute("video", video);
		request.setAttribute("tags", tags);
		
	
		return mapping.findForward("success");
	}

}
