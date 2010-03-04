package com.video.web.struts.video;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class GetVideoListAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String noString = request.getParameter("pageNo");
		String order = request.getParameter("order");
		int pageNo = 1;
		if (noString != null && !noString.trim().isEmpty()) {
			pageNo = Integer.parseInt(noString);
		}
		if (order != null && !order.trim().isEmpty()) {
			order = order.replaceAll("[/]*", "");
		}
		Pagination<Video> pagination = new Pagination<Video>();
		pagination.setNo(pageNo);
		pagination.setOrderFieldName(order);
		pagination.setSize(SomeStatic.VIDEO_INDEX_PAGESIZE);
		if (!"addDate".equals(order) && !"browseCount".equals(order)
				&& !"commentcount".equals(order)
				&& !"collectionCount".equals(order) && !"point".equals(order)) {
			order = "commend";
		}
		if (order.equals("commend")) {
			getAllService().getVideoByCommend(pagination);
		} else {
			getAllService().getVideo(pagination);
		}
		JSONObject object = JSONObject.fromObject(pagination);
		response.getWriter().print(object);
		return null;
	}
}
