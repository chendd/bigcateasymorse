package com.video.web.struts.videomanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.UploadVideo;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetUploadVideoesAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int pageSize = 10;
		int pageNo = 1;
		String str_pageNo = request.getParameter("pageNo");
		if(str_pageNo!=null){
			pageNo = Integer.parseInt(str_pageNo);
		}
		String strStatus = request.getParameter("status");
		
		Pagination<UploadVideo> pagination = new Pagination<UploadVideo>();
		pagination.setNo(pageNo);
		pagination.setSize(pageSize);
		if(strStatus!=null && !strStatus.trim().isEmpty()){
			int status = Integer.parseInt(strStatus);
			UploadVideo uploadVideo = new UploadVideo();
			uploadVideo.setStauts(status);
			pagination.setCondition(uploadVideo);
			request.setAttribute("status", status);
			
		}
		getAllDao().getUploadVideoes(pagination);
		request.setAttribute("pagination", pagination);
		return mapping.findForward("success");
	}

}
