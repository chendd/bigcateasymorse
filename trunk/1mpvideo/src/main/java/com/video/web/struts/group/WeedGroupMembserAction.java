package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class WeedGroupMembserAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("sessionUser");
	
			String strUid = request.getParameter("uid");
			String strGid = request.getParameter("gid");
			Long uid =UtilMethod.longFormat(strUid);
			Long gid = UtilMethod.longFormat(strGid);
			if(!uid.equals(new Long(0))&&!gid.equals(new Long(0))){
				
				Group group = new Group();
				group.setId(gid);
				GroupAndUser groupAndUser = new GroupAndUser();
				groupAndUser.setUser(user);
				groupAndUser.setGroup(group);
				getAllService().deleteGroupAndUser(groupAndUser);
				
			}
			
			
		
		response.getWriter().print("ok");
		return null;
	}

}
