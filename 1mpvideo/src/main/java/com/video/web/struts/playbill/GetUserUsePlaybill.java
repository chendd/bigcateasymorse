package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class GetUserUsePlaybill extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userIdString = request.getParameter("userId");
		Long userId = null;
		if (userIdString != null && !userIdString.trim().isEmpty()) {
			userId = Long.parseLong(userIdString);
		}
		User user = new User();
		user.setId(userId);
		user = getAllService().getUserUsePlaybillById(user);
		JSONObject object = JSONObject.fromObject(user);
		response.getWriter().print(object);
		return null;
	}
}
