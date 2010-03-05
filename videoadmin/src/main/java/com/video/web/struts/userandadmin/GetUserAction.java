package com.video.web.struts.userandadmin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class GetUserAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id = new Long(0);
		if(strId!=null){
			try{
			id = Long.parseLong(strId);	
			}
			catch(Exception e){
				
			}
			User user = getAllDao().getUserById(id);
			request.setAttribute("user", user);
		}
		return mapping.findForward("success");
	}

}
