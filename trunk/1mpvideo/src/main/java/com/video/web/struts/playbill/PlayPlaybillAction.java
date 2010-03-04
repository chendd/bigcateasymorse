package com.video.web.struts.playbill;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class PlayPlaybillAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String noString = request.getParameter("pageNo");
		String idString = request.getParameter("id");
		String videoIdString = request.getParameter("videoId");
		int no = 1;
		Long id = null;
		Long videoId = null;
		if (noString != null && !noString.trim().isEmpty()) {
			no = Integer.parseInt(noString);
		}
		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
		}
		
		Playbill playbill = getAllService().getPlaybill(id);
		
//		Pagination<Video> pagination = new Pagination<Video>();
//		pagination.setNo(no);
//		pagination.setCondition(playbill);
//		pagination.setSize(SomeStatic.PLAYBILL_PARTICULAR_PAGESIZE);
//		pagination.setOrderFieldName("addDate");
//		getAllService().getVideoByPlaybill(pagination);
		List<Video> videoes = getAllService().getPlaybillVideoList(id);
		

		request.setAttribute("playbill", playbill);
		request.setAttribute("videoes", videoes);
		request.setAttribute("videoId", videoId);

		return mapping.findForward("success");
	}
}
