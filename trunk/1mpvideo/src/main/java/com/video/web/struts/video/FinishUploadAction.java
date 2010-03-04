package com.video.web.struts.video;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.domain.Video;
import com.video.domain.VideoChannel;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class FinishUploadAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		String videoId =request.getParameter("videoId");
		Long id = UtilMethod.longFormat(videoId);
		System.out.println("+++++++++++"+id);
		User user = (User) session.getAttribute("sessionUser");
		if(id!=null){
			Video video = getAllService().getVideo(id);
			if(video!=null){
				String name = request.getParameter("name");
				String channelId = request.getParameter("channel"); 
				String description = request.getParameter("description");
				String tag1 = request.getParameter("tag1");
				String tag2 = request.getParameter("tag2");
				String tag3 = request.getParameter("tag3");
				String tag4 = request.getParameter("tag4");
				String tag5 = request.getParameter("tag5");
				if(name!=null&&!name.trim().isEmpty()){
					video.setName(name);
				}
				if(description!=null&&!description.trim().isEmpty()){
					video.setDescription(description);
				}
				if(channelId!=null&&!channelId.trim().isEmpty()){
					Long cId = UtilMethod.longFormat(channelId);
					if(!cId.equals(new Long(0))){
					VideoChannel channel = new VideoChannel();
					channel.setId(cId);
					video.setChannel(channel);
					}
				}
				getAllService().updateVideo(video);
				if(tag1!=null&&!tag1.trim().isEmpty()){
					getAllService().createVideoAndTag(video, tag1);
					
				}
				if(tag2!=null&&!tag2.trim().isEmpty()){
					getAllService().createVideoAndTag(video, tag2);
					
				}
				if(tag3!=null&&!tag3.trim().isEmpty()){
					getAllService().createVideoAndTag(video, tag3);
					
				}
				if(tag4!=null&&!tag4.trim().isEmpty()){
					getAllService().createVideoAndTag(video, tag4);
					
				}
				if(tag5!=null&&!tag5.trim().isEmpty()){
					getAllService().createVideoAndTag(video, tag5);
					
				}
				
			}
		}
		
		
		return new ActionForward(MessageFormat.format("{0}{1}/", mapping
				.findForward("success").getPath(), user.getId()),true);
	}

}
