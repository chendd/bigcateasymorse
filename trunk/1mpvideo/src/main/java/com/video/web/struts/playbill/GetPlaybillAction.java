package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.CommendPlaybill;
import com.video.domain.IsSubscribe;
import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetPlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String noString = request.getParameter("pageNo");
		String idString = request.getParameter("id");
		String order = request.getParameter("order");
		String nonsuchIdString = request.getParameter("nonsuchId");
		int no = 1;
		Long id = null;
		Integer nonsuchId = null;
		if (noString != null && !noString.trim().isEmpty()) {
			no = Integer.parseInt(noString);
		}
		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		if (order == null || order.trim().isEmpty()) {
			order = "addDate";
		}else{
			order = order.replaceAll("[/]*", "");
		}
		if (nonsuchIdString != null && !nonsuchIdString.trim().isEmpty()) {
			nonsuchId = Integer.parseInt(nonsuchIdString);
		}

		Playbill playbill = getAllService().getPlaybill(id);
		getAllService().updatePlaybillWithBrowseCount(playbill);
		if (nonsuchId != null) {
			CommendPlaybill commendPlaybill = new CommendPlaybill();
			commendPlaybill.setId(nonsuchId);
			getAllService().updateCommendPlaybillWithBrowseCount(
					commendPlaybill);
		}

		Pagination<Video> pagination = new Pagination<Video>();
		pagination.setNo(no);
		pagination.setCondition(playbill);
		pagination.setSize(SomeStatic.PLAYBILL_PARTICULAR_PAGESIZE);
		pagination.setOrderFieldName(order.trim());
		getAllService().getVideoByPlaybill(pagination);

		boolean action = false;
		if (request.getSession().getAttribute("sessionUser") != null) {
			User user = (User) request.getSession().getAttribute("sessionUser");
			IsSubscribe isSubscribe = new IsSubscribe();
			isSubscribe.setPlaybillId(id);
			isSubscribe.setUserId(user.getId());
			action = getAllService().isSubscribe(isSubscribe);
		}
		User videoUser = getAllService().getUserById(playbill.getUser().getId());
		
		request.setAttribute("subscribeFlag", action);
		request.setAttribute("playbillId", id);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);
		request.setAttribute("videoUser", videoUser);
		request.setAttribute("playbill", playbill);

		return mapping.findForward("success");
	}
}
