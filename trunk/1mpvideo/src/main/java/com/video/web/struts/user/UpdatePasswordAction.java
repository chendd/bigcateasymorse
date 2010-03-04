package com.video.web.struts.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdatePasswordAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		
		String message = null;
		String password_old = request.getParameter("password_old");
		String password_new = request.getParameter("password_new");
		String password_re = request.getParameter("password_re");
	
		if(password_old==null||password_old.trim().isEmpty()||password_new==null||password_new.trim().isEmpty()||password_re==null||password_re.trim().isEmpty()){
			message = "请完整填写信息";
		}
		else if(!password_new.equals(password_re)){
			
			message = "两次密码不匹配";
		}
		
		else if(!user.getPassword().equals(password_old)){
			message = "密码错误";
			
		}
		else{
			user.setPassword(password_new);
			getAllService().updateUser(user);
			message = "修改成功";
		}
		request.setAttribute("message", message);
		return mapping.findForward("success");
	}

}
