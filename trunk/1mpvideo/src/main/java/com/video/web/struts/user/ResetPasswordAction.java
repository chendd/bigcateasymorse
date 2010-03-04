package com.video.web.struts.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SafeCode;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class ResetPasswordAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String message = null;
		String	 code = request.getParameter("c");
		System.out.println(code);
		SafeCode safeCode = null;
		if(code!=null){
			safeCode = getAllService().getSafeCodeByCode(code);
			
		}
	if(safeCode==null){
		message = "这URL已经失效";
		
	}
	else{
		String password = request.getParameter("password");
		String passwordAgain = request.getParameter("passwordAgain");
		if(password==null||password.trim().isEmpty()||passwordAgain==null||passwordAgain.trim().isEmpty()){
			
		
		}
		else if(!password.equals(passwordAgain)){
			message = "两次密码必须一样";
		}
		else{
			User user = getAllService().getUserById(safeCode.getUser().getId());
			user.setPassword(password);
			getAllService().updateUser(user);
			getAllService().deleteSafeCodeByCode(code);
			request.setAttribute("success", true);
		}
		
	}
		
		if(message!=null){
			request.setAttribute("message", message);
		}
		return mapping.findForward("success");
	}

}
