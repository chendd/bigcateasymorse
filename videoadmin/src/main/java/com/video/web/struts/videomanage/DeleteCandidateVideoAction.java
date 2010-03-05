package com.video.web.struts.videomanage;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.web.struts.BaseAction;

public class DeleteCandidateVideoAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String pageNo = request.getParameter("pageNo") == null ? "1" : request
				.getParameter("pageNo");
		if("all".equals(type)){
			String[] ids = request.getParameterValues("ids");
			for(String strId : ids){
				Long id = Long.parseLong(strId);
				getAllDao().deleteCandidateVideo(id);
			}
		}
		else{
			String strId = request.getParameter("id");
			if(strId != null && !strId.trim().isEmpty()){
				Long id = Long.parseLong(strId);
				getAllDao().deleteCandidateVideo(id);
			}
		}
		
		
		return new ActionForward(MessageFormat.format("{0}?pageNo={1}", mapping
				.findForward("success").getPath(), pageNo), true);
	}

}
