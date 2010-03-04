package com.video.web.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Notice;

public class getNoticesAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
	
		List<Notice> notices = getAllService().getNotices();
		request.setAttribute("notices", notices);
		request.setAttribute("length", notices.size());
		return mapping.findForward("success");
	
	}

}
