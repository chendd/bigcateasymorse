package com.video.web.struts.playbill;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.PlaybillChannel;
import com.video.domain.User;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetMyPlaybillsAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String pageNoString = request.getParameter("pageNo");
		String videoId = request.getParameter("videoId");
		int pageNo = 1;
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}

		Pagination<Playbill> pagination = new Pagination<Playbill>();
		List<PlaybillChannel> playbillChannels = getAllService()
				.getPlaybillChannels();
		User user = (User) request.getSession().getAttribute("sessionUser");
		pagination.setCondition(user);
		pagination.setSize(SomeStatic.PLAYBILL_ADDVIDEO_PAGESIZE);
		pagination.setNo(pageNo);

		getAllService().getMyPlaybill(pagination);
		request.setAttribute("pagination", pagination);
		request.setAttribute("videoId", videoId);
		request.setAttribute("playbillChannels", playbillChannels);
		return mapping.findForward("success");
	}
}
