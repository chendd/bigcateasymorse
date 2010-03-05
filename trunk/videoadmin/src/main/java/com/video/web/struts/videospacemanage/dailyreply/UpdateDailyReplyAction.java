package com.video.web.struts.videospacemanage.dailyreply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.DailyReply;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class UpdateDailyReplyAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ids = request.getParameter("id");
		Long id = null;
		String flag = request.getParameter("flag");
		String url = "init";
		boolean error = false;
		int point = 0;
		DailyReply dailyReply = null;
		if (ids != null && !ids.trim().isEmpty()) {
			id = Long.parseLong(ids);
		}
		if (id != null) {
			dailyReply = getAllDao().getDailyReplyById(id);
			request.setAttribute("dailyReply", dailyReply);
			User user = getAllDao().getUserById(dailyReply.getUserId());
			dailyReply.setUser(user);
			Daily daily = getAllDao().getDailyById(dailyReply.getDailyId());
			dailyReply.setDaily(daily);
		}
		if (flag != null && !flag.trim().isEmpty()) {
			String comment = request.getParameter("comment");
			String points = request.getParameter("point");
			if (comment == null || comment.trim().isEmpty()) {
				error = true;
				request.setAttribute("commenterror", "回复内容不能为空");
			}
			if (points != null && !points.trim().isEmpty()) {
				try {
					point = Integer.parseInt(points);
					if (point < 0) {
						error = true;
						request.setAttribute("pointerror", "评分必须大于零");
					}
				} catch (Exception e) {
					error = true;
					request.setAttribute("pointerror", "评分格式错误");
				}

			}
			if (!error && dailyReply != null) {
				dailyReply.setPoint(point);
				dailyReply.setComment(comment);
				getAllDao().updateDailyReplyById(dailyReply);
				url = "success";
			}
		}

		return mapping.findForward(url);
	}
}
