package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetNewPlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Pagination<Playbill> pagination = new Pagination<Playbill>();
		pagination.setSize(SomeStatic.PLAYBILL_NEW_PAGESIZE);
		pagination.setNo(1);
		pagination.setOrderFieldName("addDate");
		getAllService().getPlayBills(pagination);
		JSONObject object = JSONObject.fromObject(pagination);
		response.getWriter().print(object);
		return null;
	}
}
