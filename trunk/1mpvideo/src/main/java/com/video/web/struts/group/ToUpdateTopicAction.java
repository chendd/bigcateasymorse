package com.video.web.struts.group;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.Topic;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class ToUpdateTopicAction extends BaseAction{
	

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String strId=request.getParameter("id");
		if(strId!=null && !strId.trim().isEmpty()){
			Long id = UtilMethod.longFormat(strId);
			Topic topic = getAllService().getTopicById(id);
			request.setAttribute("topic", topic);
			
		}
	return mapping.findForward("success");
			
		
		
	}

}
