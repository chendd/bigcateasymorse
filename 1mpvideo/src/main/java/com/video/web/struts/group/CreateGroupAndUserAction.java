package com.video.web.struts.group;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.GroupRequest;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class CreateGroupAndUserAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		if(type!=null&&!type.trim().isEmpty()){
			
	
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user != null){
			String strId = request.getParameter("id");
			Long groupId = UtilMethod.longFormat(strId);
			Group group = getAllService().getGroupById(groupId);
			if(group!=null){
				
				GroupAndUser groupAndUser = new GroupAndUser();
				
				groupAndUser.setUser(user);
				groupAndUser.setGroup(group);
				groupAndUser.setAddDate(new Date());
				groupAndUser.setRate(1);
				if(type.equals("add")){
				getAllService().createGroupAndUser(groupAndUser);
				response.getWriter().print("ok");
				}
				if(type.equals("del")){
					getAllService().deleteGroupAndUser(groupAndUser);
					response.getWriter().print("ok");
					}
			}
		}
		}
		return null;
	}

}
