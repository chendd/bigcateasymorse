package com.video.web.struts.vblog;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.DailyChannel;
import com.video.domain.Group;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class ToCreateDailyAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		List<DailyChannel> channels = getAllService().getDailyChannels();
		List<Group> groups = getAllService().getMyGroupList(user.getId());
		
		request.setAttribute("channels", channels);
		request.setAttribute("groups", groups);

		return mapping.findForward("success");
	}

}
