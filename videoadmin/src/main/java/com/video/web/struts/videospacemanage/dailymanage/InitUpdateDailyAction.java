package com.video.web.struts.videospacemanage.dailymanage;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyTag;
import com.video.domain.UserLevel;
import com.video.domain.connection.DailyAndTag;
import com.video.web.formbean.DailyFormBean;
import com.video.web.struts.BaseAction;

public class InitUpdateDailyAction extends BaseAction {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idString = request.getParameter("id");
		Long id = null;
		id = Long.parseLong(idString);
		Daily daily = getAllDao().getDailyById(id);
		DailyFormBean dailyFormBean = new DailyFormBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		BeanUtils.copyProperties(dailyFormBean, daily);
		if (daily.getTopDate() != null) {
			BeanUtils.copyProperty(dailyFormBean, "top", "1");
		}
		if (daily.getHotDate() != null) {
			BeanUtils.copyProperty(dailyFormBean, "hot", "1");
		}
		if (daily.getRecommendDate() != null) {
			BeanUtils.copyProperty(dailyFormBean, "recommend", "1");
		}
		if (daily.getAddDate() != null) {
			String date = sdf.format(daily.getAddDate());
			String[] dates = date.split(" ");
			String[] times = dates[1].split(":");

			BeanUtils.copyProperty(dailyFormBean, "addDateString", dates[0]);
			BeanUtils.copyProperty(dailyFormBean, "addDateHH", times[0]);
			BeanUtils.copyProperty(dailyFormBean, "addDatemm", times[1]);
			BeanUtils.copyProperty(dailyFormBean, "addDatess", times[2]);
		}
		List<DailyAndTag> dailyAndTagList = getAllDao()
				.getDailyAndTagByDailyId(id);

		if (dailyAndTagList != null && dailyAndTagList.size() > 0) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < dailyAndTagList.size(); i++) {
				Long tagId = dailyAndTagList.get(i).getTagId();
				sb.append(((DailyTag) getAllDao().getDailyTagById(tagId))
						.getName()
						+ "|");
			}
			BeanUtils.copyProperty(dailyFormBean, "tagsString", sb.toString());
		}
		List<DailyChannel> dailyChannelList = getAllDao().getDailyChannels();
		List<UserLevel> readGradeList = getAllDao().getUserLevels();
		request.setAttribute("readGradeList", readGradeList);
		request.setAttribute("dailyChannelList", dailyChannelList);
		request.setAttribute("dailyForm", dailyFormBean);

		return mapping.findForward("init");
	}

}
