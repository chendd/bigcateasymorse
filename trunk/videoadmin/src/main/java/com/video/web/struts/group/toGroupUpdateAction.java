package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.web.struts.BaseAction;

public class toGroupUpdateAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		Long id  = new Long(0);
		if(strId != null&& !strId.trim().isEmpty()){
			id = Long.parseLong(strId);
		}
		Group group = getAllDao().getGroupById(id);
		request.setAttribute("group", group);
		return mapping.findForward("success");
	}

}
