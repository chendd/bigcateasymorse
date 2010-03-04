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
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class ToCreateTopicAction extends BaseAction{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
	
		
		String strId = request.getParameter("id");
		Long groupId = UtilMethod.longFormat(strId);
		Group group = getAllService().getGroupById(groupId);
		if(group==null){
			return mapping.findForward("groupError");
		}
		else{
			Pagination<GroupAndUser> pagination = new Pagination<GroupAndUser>();
			pagination.setNo(1);
			pagination.setSize(1);
			
			GroupAndUser groupAndUser = new GroupAndUser();
			groupAndUser.setUser(user);
			groupAndUser.setGroup(group);
			pagination.setCondition(groupAndUser);
			getAllService().getMyJoinGroups(pagination);
			
			if(pagination.getResults()==null){
				return mapping.findForward("join");
			}
			else{
				request.setAttribute("group", group);
				return mapping.findForward("success");
			}
		}
	
			
		
		
	}

}
