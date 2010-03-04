package com.video.web.struts.group;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.GroupRequest;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class CreateGroupRequestAction extends BaseAction{
	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		String word = request.getParameter("word");
		if(word!=null&&!word.trim().isEmpty()){
			

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user != null){
			String strId = request.getParameter("id");
			Long groupId = UtilMethod.longFormat(strId);
			Group group = getAllService().getGroupById(groupId);
			if(group!=null){
				GroupRequest groupRequest = new GroupRequest();
				
				groupRequest.setUser(user);
				groupRequest.setGroup(group);
				groupRequest.setWord(word);
				groupRequest.setAddDate(new Date());
				getAllService().createORupdateGroupRequest(groupRequest);
				response.getWriter().print("ok");
				
			}
			
		}
		}
		return null;
	}

}