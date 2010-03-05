package com.video.web.struts.whisper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SystemNotice;
import com.video.web.struts.BaseAction;

public class GetSystemNoticeByIdAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = Long.parseLong(strId);
		SystemNotice systemNotice = getAllDao().getSystemNoticeById(id);
		request.setAttribute("systemNotice", systemNotice);
			
		}
		return mapping.findForward("success");
	}

}
