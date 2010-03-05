package com.video.web.struts.videospacemanage.dailymanage;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.util.Pagination;
import com.video.util.SomeStatic;
import com.video.web.struts.BaseAction;

public class DailyListAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String channelIdString = request.getParameter("channelId");
		String method = request.getParameter("method");
		String moveChannelIdString = request.getParameter("moveChannelId");
		Daily dailyTerm = new Daily();
		Long channelId = null;
		Long moveChannelId = null;
		request.setAttribute("method", method);
		if (method != null && !method.trim().isEmpty()) {
			if (method.trim().equals("move") && moveChannelIdString != null
					&& !moveChannelIdString.trim().isEmpty()) {
				moveChannelId = Long.parseLong(moveChannelIdString);
				String[] dailyIds = request.getParameterValues("dailyId");
				Daily daily = null;
				for (int i = 0; i < dailyIds.length; i++) {
					daily = new Daily();
					daily.setId(Long.parseLong(dailyIds[i]));
					daily.setChannelId(moveChannelId);
					getAllDao().updateDailyWithChannelIdById(daily);
				}
			}
			if (method.trim().equals("find")) {
				String findDailyTitle = request.getParameter("findDailyTitle");
				String keyWord = request.getParameter("keyWord");
				dailyTerm.setTitle(findDailyTitle);
				dailyTerm.setLog(keyWord);
				request.setAttribute("findDailyTitle", findDailyTitle);
				request.setAttribute("keyWord", keyWord);
			}
			if (method.trim().equals("deleteDaily")) {
				String idString = request.getParameter("id");
				Long id = null;
				if (idString != null && !idString.trim().isEmpty()) {
					id = Long.parseLong(idString);
					getAllDao().deleteDaily(id);
					getAllDao().deleteDailyAndTagByDailyId(id);
				}
			}
			if (method.trim().equals("topDaily")) {
				String idString = request.getParameter("id");
				Long id = null;
				if (idString != null && !idString.trim().isEmpty()) {
					id = Long.parseLong(idString);
					Daily daily = new Daily();
					daily.setId(id);
					daily.setTopDate(new Date(new java.util.Date().getTime()));
					getAllDao().updateDailyTopById(daily);
				}
			}
			if (method.trim().equals("recommend")) {
				String idString = request.getParameter("id");
				Long id = null;
				if (idString != null && !idString.trim().isEmpty()) {
					id = Long.parseLong(idString);
					Daily daily = new Daily();
					daily.setId(id);
					daily.setRecommendDate(new Date(new java.util.Date()
							.getTime()));
					getAllDao().updateDailyRecommendById(daily);
				}
			}
			if (method.trim().equals("deleteDailys")) {
				String[] dailyIds = request.getParameterValues("dailyId");
				Long id = null;
				for (int i = 0; i < dailyIds.length; i++) {
					id = Long.parseLong(dailyIds[i]);
					getAllDao().deleteDaily(id);
					getAllDao().deleteDailyAndTagByDailyId(id);
				}
			}

		}

		if (channelIdString != null && !channelIdString.trim().isEmpty()
				&& !channelIdString.trim().equals("all")) {
			channelId = Long.parseLong(channelIdString);
			request.setAttribute("channelId", channelId);
		}

		List<DailyChannel> dailyChannelList = getAllDao().getDailyChannels();
		Pagination<Daily> dailyPage = new Pagination<Daily>();

		int pageSize = 10;
		int pageNo = 1;
		String pageNoString = request.getParameter("pageNo");

		if (pageNoString != null && !pageNoString.trim().isEmpty()) {
			pageNo = Integer.parseInt(pageNoString);
		}

		dailyPage.setNo(pageNo);
		dailyPage.setSize(pageSize);

		dailyTerm.setChannelId(channelId);

		dailyPage.setCondition(dailyTerm);

		getAllDao().getDailies(dailyPage);

		List<Daily> dailyList = dailyPage.getResults();
		if (dailyList != null && dailyList.size() > 0) {
			for (int i = 0; i < dailyList.size(); i++) {
				Daily daily = dailyList.get(i);
				Long userId = daily.getUserId();
				if (userId != null) {
					daily.setUser(getAllDao().getUserById(userId));
				}
			}
		}

		request.setAttribute("dailyPage", dailyPage);
		request.setAttribute("dailyChannelList", dailyChannelList);

		return mapping.findForward("success");
	}
}
