package com.video.web.struts.videomanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.IndexRecommendVideo;
import com.video.web.struts.BaseAction;

public class GetIndexRecommendVideoAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId != null && !strId.trim().isEmpty()){
			id = Long.parseLong(strId);
		}
		IndexRecommendVideo indexRecommendVideo = getAllDao().getIndexRecommendVideoById(id);
		request.setAttribute("video",indexRecommendVideo );
		
		return mapping.findForward("success");
	}

}
