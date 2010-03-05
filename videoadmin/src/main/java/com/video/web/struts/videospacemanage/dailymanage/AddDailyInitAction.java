package com.video.web.struts.videospacemanage.dailymanage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.DailyChannel;
import com.video.domain.UserLevel;
import com.video.web.struts.BaseAction;

public class AddDailyInitAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<DailyChannel> dailyChannelList = getAllDao().getDailyChannels();
		List<UserLevel> readGradeList = getAllDao().getUserLevels();
		request.setAttribute("readGradeList", readGradeList);
		request.setAttribute("dailyChannelList", dailyChannelList);
		return mapping.findForward("addDaily");
	}
}
