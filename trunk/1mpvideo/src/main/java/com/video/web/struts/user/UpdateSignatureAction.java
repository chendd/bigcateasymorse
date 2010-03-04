package com.video.web.struts.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdateSignatureAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String signature = request.getParameter("signature");
		String message = null;
		if(signature==null||signature.trim().isEmpty()){
			message = "你还没有填写个人简介";
		}
		else{
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("sessionUser");
			user.setSignature(signature);
			getAllService().updateUser(user);
			message = "更新成功";
		}
		request.setAttribute("message", message);
		return mapping.findForward("success");
	}

}
