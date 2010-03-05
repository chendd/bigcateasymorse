package com.video.web.struts.videomanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.UploadVideo;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class PriviewVideoAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		String type = "";
		if(strId!=null && !strId.trim().isEmpty()){
			
			Long id = new Long(0);
			try{
			    id = Long.parseLong(strId);
			
				
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			UploadVideo uploadVideo = getAllDao().getUploadVideoById(id);
			if(uploadVideo.getVideoType().equals("wmv")||uploadVideo.getVideoType().equals("mpg")||uploadVideo.getVideoType().equals("mpeg")||uploadVideo.getVideoType().equals("avi")){
				type ="wmp";
			}
			else if(uploadVideo.getVideoType().equals("rm")||uploadVideo.getVideoType().equals("rmvb")||uploadVideo.getVideoType().equals("3gp")||uploadVideo.getVideoType().equals("mp4")){
				type ="real";
			}
			else if(uploadVideo.getVideoType().equals("flv")){
				type ="flv";
			}
			
			request.setAttribute("url", SomeStatic.PRIVIEW_URL+"/"+uploadVideo.getUrl());
			
		}
		return mapping.findForward(type);
	}

}
