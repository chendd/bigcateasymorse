package com.video.web.struts.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.SubscribeUser;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class SubscribeUserAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idString = request.getParameter("id");
		Long id = null;

		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		User passiveUser = new User();
		passiveUser.setId(id);

		SubscribeUser subscribeUser = new SubscribeUser();
		subscribeUser.setUser(user);
		subscribeUser.setPassiveUser(passiveUser);
		subscribeUser.setAddDate(new Date());

		getAllService().createSubscribe(subscribeUser);

		return null;
	}
}
