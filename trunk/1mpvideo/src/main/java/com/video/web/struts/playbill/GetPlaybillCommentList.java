package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.PlaybillCommet;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetPlaybillCommentList extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String playbillIdString = request.getParameter("playbillId");
		String pageNoString = request.getParameter("pageNo");
		int pageNo = 1;
		Long playbillId = null;
		if (playbillIdString != null && !playbillIdString.trim().isEmpty()) {
			playbillId = Long.parseLong(playbillIdString);
		}
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}

		Pagination<PlaybillCommet> pagination = new Pagination<PlaybillCommet>();
		PlaybillCommet playbillCommet = new PlaybillCommet();
		Playbill playbill = new Playbill();
		playbill.setId(playbillId);
		playbillCommet.setPlaybill(playbill);
		pagination.setCondition(playbillCommet);
		pagination.setNo(pageNo);
		pagination.setSize(SomeStatic.PLAYBILL_COMMENT_PAGESIZE);

		getAllService().getCommentPlaybillByPlaybillId(pagination);
		JSONObject array = JSONObject.fromObject(pagination);
		response.getWriter().print(array);

		return null;
	}
}
