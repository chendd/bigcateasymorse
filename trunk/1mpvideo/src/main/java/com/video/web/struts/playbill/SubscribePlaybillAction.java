package com.video.web.struts.playbill;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.IsSubscribe;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class SubscribePlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String playbillIdString = request.getParameter("playbillId");
		String actionString = request.getParameter("action");
		User user = (User) request.getSession().getAttribute("sessionUser");
		Long playbillId = null;
		boolean action = false;
		if (actionString != null && !actionString.trim().isEmpty()) {
			action = Boolean.parseBoolean(actionString);
		}
		if (playbillIdString != null && !playbillIdString.trim().isEmpty()) {
			playbillId = Long.parseLong(playbillIdString);
		}
		IsSubscribe isSubscribe = new IsSubscribe();
		isSubscribe.setUserId(user.getId());
		isSubscribe.setPlaybillId(playbillId);
		isSubscribe.setAddDate(new Date());
		if (action) {
			getAllService().createSubscribePlaybill(isSubscribe);
		} else {
			getAllService().deleteSubscribePlaybill(isSubscribe);
		}
		response.getWriter().print(action);
		return null;
	}
}
