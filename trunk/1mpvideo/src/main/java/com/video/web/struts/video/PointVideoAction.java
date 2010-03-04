package com.video.web.struts.video;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.PointHistory;
import com.video.domain.User;
import com.video.web.struts.BaseAction;

public class PointVideoAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String videoIdString = request.getParameter("videoId");
		String pointString = request.getParameter("point");
		Long videoId = null;
		int point = 0;
		User user = (User) request.getSession().getAttribute("sessionUser");
		PointHistory pointHistory = new PointHistory();
		pointHistory.setUserId(user.getId());
		pointHistory.setAddDate(new Date());
		if (videoIdString != null && !videoIdString.trim().isEmpty()) {
			videoId = Long.parseLong(videoIdString);
			pointHistory.setVideoId(videoId);
		}
		if (pointString != null && !pointString.trim().isEmpty()) {
			point = Integer.parseInt(pointString);
			pointHistory.setPoint(point);
		}
		boolean flag = getAllService().pointVideo(pointHistory);
		String result = "";
		if (flag) {
			result = "评分成功";
		} else {
			result = "今天您已评过分";
		}
		response.getWriter().println(result);
		return null;
	}
}
