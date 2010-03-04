package com.video.web.struts.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdateEmailAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String email = request.getParameter("email");
		String message = null;
		if(email==null||email.trim().isEmpty()){
			message = "邮箱不能为空";
		}
		else{
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("sessionUser");
			user.setEmail(email);
			getAllService().updateUser(user);
			message = "更新成功";
		}
		request.setAttribute("message", message);
		return mapping.findForward("success");
	}

}
