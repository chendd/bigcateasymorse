package com.video.web.struts.playbill;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class ModifyPlaybillVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idString = request.getParameter("id");
		String noString = request.getParameter("no");
		User user = (User) request.getSession().getAttribute("sessionUser");
		Long id = null;
		int no = 1;

		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		if (noString != null && !noString.trim().isEmpty()) {
			no = Integer.parseInt(noString);
		}
		Playbill playbill = getAllService().getPlaybill(id);
		if (playbill == null || user == null
				|| !playbill.getUser().getId().equals(user.getId())) {
			return mapping.findForward("error");
		}
		Pagination<Video> pagination = new Pagination<Video>();
		pagination.setNo(no);
		pagination.setCondition(playbill);
		pagination.setSize(SomeStatic.PLAYBILL_VIDEO_PAGESIZE);
		getAllService().getVideoByPlaybill(pagination);
		request.setAttribute("pagination", pagination);
		return mapping.findForward("success");
	}
}
