package com.video.web.struts.videomanage;

import java.text.MessageFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.CandidateVideo;
import com.video.domain.Video;
import com.video.web.struts.BaseAction;

public class CreateCandidateVideoAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String method = request.getParameter("method");
		if("create".equals(method)){
			String strVideoId = request.getParameter("videoId");
			//System.out.println(strVideoId);
			Long videoId = new Long(0);
			
			if(strVideoId != null && !strVideoId.trim().isEmpty()){
				videoId = Long.parseLong(strVideoId);
				
			}
			String sake = request.getParameter("sake");
			CandidateVideo candidateVideo = new CandidateVideo();
			Video video = new Video();
			video.setId(videoId);
			candidateVideo.setVideo(video);
			candidateVideo.setSake(sake);
			candidateVideo.setRecommendDate(new Date());
			getAllDao().createCandidateVideo(candidateVideo);
			return new ActionForward(MessageFormat.format("{0}?id={1}", mapping
					.findForward("createOk").getPath(), videoId), true);
		
		}
		
		
		return mapping.findForward("createOk");
	}

}
