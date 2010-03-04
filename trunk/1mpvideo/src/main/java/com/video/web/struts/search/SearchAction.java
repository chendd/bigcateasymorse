package com.video.web.struts.search;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Playbill;
import com.video.domain.User;
import com.video.domain.UserKeyword;
import com.video.domain.Video;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class SearchAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String key = request.getParameter("key");
		
		String type = request.getParameter("type");
		String pageNoString = request.getParameter("pageNo");
		String order = request.getParameter("orders");
		String path = "error";
		Integer pageNo = 1;
		if (key == null || key.trim().isEmpty()) {
			request.setAttribute("message", "关键字不能为空或空格！");
			return mapping.findForward(path);
		}
		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			try {
				pageNo = Integer.parseInt(pageNoString);
			} catch (Exception e) {
				pageNo = 1;
			}
		}
	key = new String(key.getBytes("ISO-8859-1"), "UTF-8");
		Pagination pagination = new Pagination();
		pagination.setNo(pageNo);
		UserKeyword keyword = new UserKeyword();
		keyword.setName(key);
		keyword.setAddDate(new Date());
		getAllService().createUserKeyword(keyword);
		if ("playbill".equals(type)) {
			if (!"addDate".equals(order) && !"browseCount".equals(order)
					&& !"commentCount".equals(order)
					&& !"subscribecount".equals(order)) {
				order = "addDate";
			}
			Playbill playbill = new Playbill();
			playbill.setName(key);
			playbill.setDescription(key);
			pagination.setCondition(playbill);
			pagination.setSize(SomeStatic.SEARCH_PLAYBILL_PAGESIZE);
			pagination.setOrderFieldName(order);
			getAllService().getPlaybillByKey(pagination);
			path="playbill";
		} else if ("vblog".equals(type)) {
			path="vblog";
			pagination.setSize(SomeStatic.SEARCH_VBLOG_PAGESIZE);
			
				User user = new User();
				user.setRealName(key);
				pagination.setCondition(user);
		
			getAllService().getTopUsers(pagination);
		} else {
			if (!"add_date".equals(order) && !"browse_count".equals(order)
					&& !"commentcount".equals(order)
					&& !"collectionCount".equals(order)) {
				order = "add_date";
			}
			Video video = new Video();
			video.setName(key);
			video.setDescription(key);
			pagination.setCondition(video);
			pagination.setSize(SomeStatic.SEARCH_VIDEO_PAGESIZE);
			pagination.setOrderFieldName(order);
			getAllService().getVideoBykey(pagination);
			path="video";
		}

		request.setAttribute("pagination", pagination);
		request.setAttribute("key", key);
		request.setAttribute("type", type);
		return mapping.findForward(path);
	}
}
