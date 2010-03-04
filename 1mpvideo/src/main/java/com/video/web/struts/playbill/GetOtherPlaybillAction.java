package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetOtherPlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idString = request.getParameter("id");
		String noExistIdString = request.getParameter("noExistId");
		String pageNoString = request.getParameter("pageNo");
		Long userId = null;
		Long noExistId = null;
		int pageNo = 1;
		Pagination<Playbill> pagination = new Pagination<Playbill>();

		if (idString != null && !idString.trim().isEmpty()) {
			userId = Long.parseLong(idString);
		}
		if (noExistIdString != null && !noExistIdString.trim().isEmpty()) {
			noExistId = Long.parseLong(noExistIdString);
		}
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}

		Playbill playbill = new Playbill();
		playbill.setId(noExistId);
				
		User user = new User();
		user.setId(userId);
		playbill.setUser(user);

		pagination.setCondition(playbill);
		pagination.setNo(pageNo);
		pagination.setSize(SomeStatic.PLAYBILL_OTHER_PAGESIZE);
		pagination.setOrderFieldName("addDate");

		getAllService().getOtherPlaybill(pagination);

		JSONObject object = JSONObject.fromObject(pagination);
		response.getWriter().print(object);
		return null;
	}
}
