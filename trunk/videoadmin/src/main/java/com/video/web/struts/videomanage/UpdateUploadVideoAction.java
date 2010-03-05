package com.video.web.struts.videomanage;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.UploadVideo;
import com.video.domain.VideoChannel;
import com.video.web.struts.BaseAction;

public class UpdateUploadVideoAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = Long.parseLong(strId);
			UploadVideo uploadVideo = getAllDao().getUploadVideoById(id);
			if(uploadVideo!=null){
				
		
			String status = request.getParameter("stauts");
			
			if("-1".equals(status)){
				File file = new File("/usr/local/server/apache/htdocs/upload/uploadvideoes/"+uploadVideo.getUrl());
				if(file.isFile()){
					file.delete();
				}
				getAllDao().deleteUploadVideo(id);
			}
			else{
				String name = request.getParameter("name");
				String strChannelId = request.getParameter("channelId");
				Long channelId = Long.parseLong(strChannelId);
				VideoChannel channel = new VideoChannel();
				channel.setId(channelId);
				String description = request.getParameter("description");
				int statusInt = Integer.parseInt(status);
				
				String strNum3gp = request.getParameter("num3gp");
				int num3gp = Integer.parseInt(strNum3gp);
				String strVideoTime = request.getParameter("videoTime");
				int videoTime = Integer.parseInt(strVideoTime);
				String strVideoSize = request.getParameter("videoSize");
				int videoSize = Integer.parseInt(strVideoSize);
				uploadVideo.setStauts(statusInt);
				uploadVideo.setNum3gp(num3gp);
				uploadVideo.setVideoTime(videoTime);
				uploadVideo.getVideo().setName(name);
				uploadVideo.getVideo().setChannelId(channelId);
				uploadVideo.getVideo().setDescription(description);
				getAllDao().updateVideo(uploadVideo.getVideo());
				getAllDao().updateUploadVideo(uploadVideo);
		
				
			}
		}
		}
		return mapping.findForward("success");
	}

}
