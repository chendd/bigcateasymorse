package com.video.web.struts.playbill;

import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.PlaybillCommet;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class AddCommentWithPlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String comment = new URLDecoder().decode(request
				.getParameter("comment"), "utf-8");
		String playbillIdString = request.getParameter("playbillId");
		Long playbillId = null;
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		PlaybillCommet playbillCommet = new PlaybillCommet();
		if (playbillIdString != null && !playbillIdString.trim().isEmpty()) {
			playbillId = Long.parseLong(playbillIdString);
		}
		Playbill playbill = new Playbill();
		playbill.setId(playbillId);

		playbillCommet.setUser(user);
		playbillCommet.setPlaybill(playbill);
		playbillCommet.setCommentDate(new Date());
		playbillCommet.setComment(comment);

		getAllService().createCommentPlaybill(playbillCommet);

		response.getWriter().print("");

		return null;
	}
}
