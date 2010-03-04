package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class ToWriteMessageAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId = request.getParameter("id");
		if(strId!=null&&!strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			if(!id.equals(new Long(0))){
				
			
			HttpSession  session = request.getSession();
			User user = (User)session.getAttribute("sessionUser");
		
				User user2 = getAllService().getUserById(id);
				request.setAttribute("user", user2);
				return mapping.findForward("success");
				
		
			}
			else{
				return mapping.findForward("error");
			}
		}
		else{
			return mapping.findForward("error");
			
		}
		
	}

}
