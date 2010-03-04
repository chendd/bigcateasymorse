package com.video.web.struts.vblog;

import java.util.Date;

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

public class CreateFriendAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("sessionUser");
		if(user!=null){
			
			String strFid = request.getParameter("fid");
			if(strFid!=null&& !strFid.trim().isEmpty()){
				Long fid = UtilMethod.longFormat(strFid);
				User fUser = new User();
				fUser.setId(fid);
				Friend friend = new Friend();
				friend.setfUser(fUser);
				friend.setUser(user);
				friend.setRegdate(new Date());
				response.getWriter().print("ok");
			}
			
		}
		return null;
	}

}
