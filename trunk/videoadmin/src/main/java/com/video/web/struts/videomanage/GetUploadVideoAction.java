package com.video.web.struts.videomanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.UploadVideo;
import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class GetUploadVideoAction extends BaseAction{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		
		if(strId!=null&&!strId.trim().isEmpty()){
			Long id = Long.parseLong(strId);
			UploadVideo video = getAllDao().getUploadVideoById(id);
			request.setAttribute("video", video);
			List<VideoChannel> channels = getAllDao().getVideoChannelList();
			request.setAttribute("channels", channels);
		}
		return mapping.findForward("success");
	}
	
	

}
