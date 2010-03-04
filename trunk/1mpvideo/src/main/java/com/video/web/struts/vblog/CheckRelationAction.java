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

public class CheckRelationAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user !=null){
			
			String strFid = request.getParameter("fid");
		
			if(strFid!=null&&!strFid.trim().isEmpty()){
				Long fid = UtilMethod.longFormat(strFid);
				
				if(!fid.equals(new Long(0))){
					
					User fUser = new User();
					fUser.setId(fid);
					Friend friend = new Friend();
					friend.setfUser(fUser);
					friend.setUser(user);
					
					if(getAllService().getFriendId(friend)!=null){
						
						response.getWriter().print("yes");
					}
					else{
						response.getWriter().print("no");
					}
					
				}
			}
		}
		return null;
	}

}
