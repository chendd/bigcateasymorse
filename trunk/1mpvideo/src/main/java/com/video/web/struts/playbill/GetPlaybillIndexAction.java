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

public class GetPlaybillIndexAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String orderFieldName = request.getParameter("orderBy");
		String pageNoString = request.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}
		if (orderFieldName == null || orderFieldName.trim().isEmpty()) {
			orderFieldName = "addDate";
		}else{
			orderFieldName = orderFieldName.replaceAll("[/]*", "");
		}
		Pagination<Playbill> pagination = new Pagination<Playbill>();
		pagination.setSize(SomeStatic.PLAYBILL_MY_PAGESIZE);
		pagination.setNo(pageNo);
		pagination.setOrderFieldName(orderFieldName);
		
		getAllService().getPlayBills(pagination);
		request.setAttribute("orderBy", orderFieldName);
		request.setAttribute("pagination", pagination);
		return mapping.findForward("success");
	}
}
