package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class DeleteGroupAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String strId = request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			getAllService().deleteGroup(id,user.getId());
		}
		
		return mapping.findForward("success");
	}

}
