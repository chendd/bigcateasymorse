package com.video.web.struts.videospacemanage.dailymanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.web.struts.BaseAction;

public class MoveDailyAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idString = request.getParameter("id");
		Long id = null;
		String url = "move";
		String flag = request.getParameter("flag");

		if (idString != null && !idString.trim().isEmpty()) {
			id = Long.parseLong(idString);
		}
		Daily daily = getAllDao().getDailyById(id);
		if (flag == null) {
			List<DailyChannel> dailyChannelList = getAllDao()
					.getOtherDailyChannelByDailyId(daily.getChannelId());
			request.setAttribute("daily", daily);
			request.setAttribute("dailyChannelList", dailyChannelList);
		} else {
			String dailyChannelIdString = request
					.getParameter("moveChannelIdString");
			Long dailyChannelId = null;
			if (dailyChannelIdString != null
					&& !dailyChannelIdString.trim().isEmpty()) {
				dailyChannelId = Long.parseLong(dailyChannelIdString);
			}
			daily.setChannelId(dailyChannelId);

			getAllDao().updateDaily(daily);
			url = "success";
		}
		return mapping.findForward(url);
	}
}
