package com.video.web.struts.message;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class ToWirteGroupInviteAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		String strId = request.getParameter("id");
		if(strId!=null&&!strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			if(!id.equals(new Long(0))){
				User inviteUser = getAllService().getUserById(id);
				List<Group> groups =  getAllService().getMyGroups(user.getId());
				if(groups.size()!=0){
					request.setAttribute("groups", groups);
				}
				
			
				request.setAttribute("user", inviteUser);
			}
		}
		return mapping.findForward("success");
	}

}
