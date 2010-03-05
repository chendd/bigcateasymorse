package com.video.web.struts.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Notice;
import com.video.web.struts.BaseAction;

public class ToUpdateNoticeAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId!=null&&!strId.trim().isEmpty()){
		 try{
			 id = Long.parseLong(strId);
		 }
		 catch (Exception e) {
			
		}
		}
		Notice notice = getAllDao().getNoticeById(id);
		request.setAttribute("notice", notice);
		return mapping.findForward("success");
	}

}
