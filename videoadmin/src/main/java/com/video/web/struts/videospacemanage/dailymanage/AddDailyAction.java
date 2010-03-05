package com.video.web.struts.videospacemanage.dailymanage;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyTag;
import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.UserLevel;
import com.video.domain.connection.DailyAndTag;
import com.video.web.formbean.DailyFormBean;
import com.video.web.struts.BaseAction;

public class AddDailyAction extends BaseAction {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DailyFormBean dailyFormBean = (DailyFormBean) form;

		Daily daily = new Daily();

		BeanUtils.copyProperties(daily, dailyFormBean);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		StringBuffer sb = new StringBuffer();

		if (dailyFormBean.getAddDateString() != null
				&& !dailyFormBean.getAddDateString().trim().isEmpty()) {
			sb.append(dailyFormBean.getAddDateString());
			if (dailyFormBean.getAddDateHH() != null
					&& !dailyFormBean.getAddDateHH().trim().isEmpty()) {
				sb.append(" ");
				sb.append(dailyFormBean.getAddDateHH());
			}
			if (dailyFormBean.getAddDatemm() != null
					&& !dailyFormBean.getAddDatemm().trim().isEmpty()) {
				sb.append(":");
				sb.append(dailyFormBean.getAddDatemm());
			}
			if (dailyFormBean.getAddDatess() != null
					&& !dailyFormBean.getAddDatess().trim().isEmpty()) {
				sb.append(":");
				sb.append(dailyFormBean.getAddDatess());
			}
			daily.setAddDate(new Date(sdf.parse(sb.toString()).getTime()));
		}

		if (dailyFormBean.getRecommend() != null
				&& !dailyFormBean.getRecommend().trim().isEmpty()) {
			if (daily.getAddDate() != null) {
				daily.setRecommendDate(daily.getAddDate());
			} else {
				daily
						.setRecommendDate(new Date(new java.util.Date()
								.getTime()));
			}
		}

		if (dailyFormBean.getHot() != null
				&& !dailyFormBean.getHot().trim().isEmpty()) {
			if (daily.getAddDate() != null) {
				daily.setHotDate(daily.getAddDate());
			} else {
				daily
						.setRecommendDate(new Date(new java.util.Date()
								.getTime()));
			}
		}

		if (dailyFormBean.getTop() != null
				&& !dailyFormBean.getTop().trim().isEmpty()) {
			if (daily.getAddDate() != null) {
				daily.setTopDate(daily.getAddDate());
			} else {
				daily
						.setRecommendDate(new Date(new java.util.Date()
								.getTime()));
			}
		}

		User user = getAllDao().getUserById(
				Long.parseLong(dailyFormBean.getUserId()));
		daily.setUser(user);
		DailyChannel dailyChannel = getAllDao().getDailyChannelById(
				Long.parseLong(dailyFormBean.getChannelIdString()));
		daily.setChannel(dailyChannel);

		getAllDao().createDaily(daily);

		if (dailyFormBean.getTagsString() != null
				&& !dailyFormBean.getTagsString().trim().isEmpty()) {
			String[] tagsArray = dailyFormBean.getTagsString().split("\\|");
			List<DailyTag> tags = new ArrayList<DailyTag>();
			for (int i = 0; i < tagsArray.length; i++) {
				DailyTag tag = getAllDao().getDailyTagByName(tagsArray[i]);
				DailyAndTag dailyAndTag = new DailyAndTag();
				if (tag == null || tag.getId() == null) {
					tag = new DailyTag();
					tag.setBrowseCount(0);
					tag.setCreateDate(new java.util.Date());
					tag.setName(tagsArray[i]);
					tag.setUser(user);
					getAllDao().createDailyTag(tag);
					dailyAndTag.setDailyId(daily.getId());
					dailyAndTag.setTagId(tag.getId());
					getAllDao().createDailyAndTag(dailyAndTag);
				}
				tags.add(tag);
			}
		}

		return mapping.findForward("addSuccess");
	}

}
