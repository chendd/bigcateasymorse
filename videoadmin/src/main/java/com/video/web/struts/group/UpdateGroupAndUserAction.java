package com.video.web.struts.group;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdateGroupAndUserAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String type = request.getParameter("type");
		String uids = request.getParameter("uids");
		String id = request.getParameter("id");
		
		Long groupId = Long.parseLong(id);
		Group group = new Group();
		group.setId(groupId);
		
		List<User> users = new ArrayList<User>();
		String[] sids = uids.split(",");
		for(String sid:sids){
			Long userId = Long.parseLong(sid);
			User user = new User();
			user.setId(userId);
			users.add(user);
			
		}
		
		if("add".equals(type)){
			
			getAllDao().createGroupAndUsers(users, group);
			response.getWriter().print("ok");
		}
if("remove".equals(type)){
			getAllDao().deleteGroupAndUsers(users, group);
			response.getWriter().print("ok");
		}
		return null;
	}

}
