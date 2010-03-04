package com.video.web.struts.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class GetUserAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user = getAllService().getUser(user);
		JSONObject object = JSONObject.fromObject(user);
		response.getWriter().print(object);
		return null;
	}
}
