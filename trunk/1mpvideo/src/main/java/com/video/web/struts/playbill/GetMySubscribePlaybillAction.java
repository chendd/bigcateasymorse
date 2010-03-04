package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetMySubscribePlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Pagination<Playbill> pagination = new Pagination<Playbill>();

		User user = (User) request.getSession().getAttribute("sessionUser");
		pagination.setCondition(user);
		pagination.setSize(SomeStatic.PLAYBILL_MYSUBSCRIBE_PAGESIZE);
		pagination.setNo(1);

		getAllService().getMySubscribePlaybill(pagination);
//		List<Playbill> list = pagination.getResults();

		JSONObject object = JSONObject.fromObject(pagination);
		response.getWriter().print(object);

		return null;
	}
}
