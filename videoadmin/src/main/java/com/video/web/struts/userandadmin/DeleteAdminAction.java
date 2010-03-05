package com.video.web.struts.userandadmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.web.struts.BaseAction;

public class DeleteAdminAction extends BaseAction{
	
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String[] ids = request.getParameterValues("ids");
	
		for(String sid:ids){
			
			Long id = Long.parseLong(sid);
			getAllDao().deleteAdministrator(id);
		
		}
		return mapping.findForward("success");
	}

}
