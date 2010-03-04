package com.video.web.struts.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class IndexLayoutSaveAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user!= null){
			
			String spacelayout0 = request.getParameter("spacelayout[0]");
			String spacelayout1 = request.getParameter("spacelayout[1]");
			String spacelayout2 = request.getParameter("spacelayout[2]");
			if(spacelayout0.equals(null)||spacelayout0.equals("")){
				spacelayout0="*";
			}
			if(spacelayout1.equals(null)||spacelayout1.equals("")){
				spacelayout1="*";
			}
			if(spacelayout2.equals(null)||spacelayout2.equals("")){
				spacelayout2="*";
			}
			String str_side = request.getParameter("side");
			
			
			int side = Integer.parseInt(str_side);
			
			String layout = spacelayout0+","+spacelayout1+","+spacelayout2;
		
		user.setSide(side);
		user.setLayout(layout);
		getAllService().updateUser(user);
		
		response.getWriter().write("ok");
		
		}
		return null;
	}

}
