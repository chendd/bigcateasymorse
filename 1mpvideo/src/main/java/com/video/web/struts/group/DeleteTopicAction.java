package com.video.web.struts.group;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Group;
import com.video.domain.Topic;
import com.video.domain.User;
import com.video.util.UtilMethod;
import com.video.web.struts.BaseAction;

public class DeleteTopicAction extends BaseAction{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		
		String strId = request.getParameter("id");
		String groupId = request.getParameter("groupId");
		Long id = UtilMethod.longFormat(strId);
		getAllService().deleteTopic(id);
	
		return new ActionForward(MessageFormat.format("{0}{1}/", mapping
				.findForward("success").getPath(), groupId), true);
	}

}
