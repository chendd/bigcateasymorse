package com.video.web.struts.vblog;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Friend;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class DeleteFriendAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user!=null){
			String strId = request.getParameter("id");
			Long id = UtilMethod.longFormat(strId);
			Friend friend = new Friend();
			User fUser = new User();
			fUser.setId(id);
			friend.setUser(user);
			friend.setfUser(fUser);
			getAllService().deleteFriend(friend);
			
			response.getWriter().print("ok");
			
		}
		
	return null;
	}

}
