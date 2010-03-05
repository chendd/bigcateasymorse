package com.video.web.struts.userandadmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Administrator;
import com.video.web.struts.BaseAction;

public class UpdateAdminAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId!= null){
			id = Long.parseLong(strId);
		}
		if("ajax".equals(type)){
			String passwordO = request.getParameter("passwordO");
			String passwordN = request.getParameter("passwordN");
			
			Administrator administrator = getAllDao().getAdministratorById(id);
		
			if(administrator.getPassword().equals(passwordO)){
				administrator.setPassword(passwordN);
				getAllDao().updateAdministrator(administrator);
				response.getWriter().print("ok");
			}
			else{
				response.getWriter().print("error");
			}
			
			return null;
			
		}
		else{
			return mapping.findForward("success");
		}
		
	}

}
