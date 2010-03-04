package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetMyPlaybillListAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		User user = (User) request.getSession().getAttribute("sessionUser");
		String pageNoString = request.getParameter("pageNo");
		String order = request.getParameter("order").replaceAll("/", "");
		int pageNo = 1;
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}
		if (!"addDate".equals(order) && !"playbillsize".equals(order)
				&& !"browseCount".equals(order)
				&& !"subscribecount".equals(order)
				&& !"commentCount".equals(order)) {
			order = "addDate";
		}

		Pagination<Playbill> pagination = new Pagination<Playbill>();
		pagination.setCondition(user);
		pagination.setSize(SomeStatic.PLAYBILLLIST_MY_PAGESIZE);
		pagination.setNo(pageNo);
		pagination.setOrderFieldName(order);

		getAllService().getMyPlaybill(pagination);
		request.setAttribute("pagination", pagination);
		return mapping.findForward("success");
	}
}
