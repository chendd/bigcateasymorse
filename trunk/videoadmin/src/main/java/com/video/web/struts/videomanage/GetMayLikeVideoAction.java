package com.video.web.struts.videomanage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.MayLikeVideo;
import com.video.web.struts.BaseAction;

public class GetMayLikeVideoAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId != null && !strId.trim().isEmpty()){
			id = Long.parseLong(strId);
		}
		System.out.println(id);
		MayLikeVideo mayLikeVideo = getAllDao().getMayLikeVideoById(id);
		
		request.setAttribute("video",mayLikeVideo );
		
		return mapping.findForward("success");
	}

}
