package com.video.web.formbean;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.video.domain.DailyChannel;
import com.video.domain.User;
import com.video.domain.UserLevel;
import com.video.web.struts.BaseActionForm;

public class DailyFormBean extends BaseActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -472306865003798605L;
	private String id;
	private String title;
	private String log;
	private String addDateString;
	private String addDateHH;
	private String addDatemm;
	private String addDatess;
	private String browseTimes;
	private String top;
	private String expense;
	private String grade;
	private String channelIdString;
	private String recommend;
	private String point;
	private String tagsString;
	private String hot;
	private String userId;

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (userId != null && !userId.trim().isEmpty()) {
			Long uId = null;
			try {
				uId = Long.parseLong(userId);
			} catch (Exception e) {
				errors
						.add("userId", new ActionMessage(
								"errors.User.id.format"));
			}
			User user = getAllDao().getUserById(uId);
			if (user == null || !user.getId().equals(uId)) {
				errors.add("userId", new ActionMessage(
						"errors.User.id.notexist"));
			}
		} else {
			errors.add("userId", new ActionMessage("errors.User.id.empty"));
		}

		if (title == null || title.trim().isEmpty()) {
			errors.add("title", new ActionMessage("errors.Daily.title.empty"));
		}

		if (log == null || log.trim().isEmpty()) {
			errors.add("log", new ActionMessage("errors.Daily.log.empty"));
		}

		if (tagsString != null && !tagsString.trim().isEmpty()) {
			String key = "\\p{Punct}";
			Pattern pattern = Pattern.compile(key);
			Matcher matcher = pattern
					.matcher(tagsString.replaceAll("\\|", " "));
			boolean b = matcher.find();
			if (b) {
				errors.add("tagsString", new ActionMessage(
						"errors.Daily.tags.format"));
			}
		}

		if (channelIdString != null && !channelIdString.trim().isEmpty()) {
			Long channelId = null;
			try {
				channelId = Long.parseLong(channelIdString);
			} catch (Exception e) {
				errors.add("channelIdString", new ActionMessage(
						"errors.DailyChannel.id.format"));
			}
			DailyChannel channel = getAllDao().getDailyChannelById(channelId);
			if (channel == null
					|| channel.getId() != Long.parseLong(channelIdString)) {
				errors.add("channelIdString", new ActionMessage(
						"errors.DailyChannel.id.notexist"));
			}
		} else {
			errors.add("channelIdString", new ActionMessage(
					"errors.DailyChannel.id.empty"));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (addDateString != null && !addDateString.trim().isEmpty()) {
			StringBuffer sb = new StringBuffer();

			sb.append(addDateString);
			if (addDateHH != null && !addDateHH.trim().isEmpty()) {
				sb.append(" ");
				sb.append(addDateHH);
			}
			if (addDatemm != null && !addDatemm.trim().isEmpty()) {
				sb.append(":");
				sb.append(addDatemm);
			}
			if (addDatess != null && !addDatess.trim().isEmpty()) {
				sb.append(":");
				sb.append(addDatess);
			}
			try {
				sdf.parse(sb.toString());
			} catch (Exception e) {
				errors.add("addDateString", new ActionMessage(
						"errors.Daily.addDate.format"));
			}

		}

		if (browseTimes != null && !browseTimes.trim().isEmpty()) {
			try {
				Integer.parseInt(browseTimes);
			} catch (Exception e) {
				errors.add("browseTimes", new ActionMessage(
						"errors.Daily.browseTimes.format"));
			}
		}
		if (expense != null && !expense.trim().isEmpty()) {
			try {
				Integer.parseInt(expense);
			} catch (Exception e) {
				errors.add("expense", new ActionMessage(
						"errors.Daily.expense.format"));
			}
		}

		if (grade != null && !grade.trim().isEmpty()) {
			try {
				Integer.parseInt(grade);
			} catch (Exception e) {
				errors.add("grade", new ActionMessage(
						"errors.Daily.grade.format"));
			}
		}

		if (point != null && !point.trim().isEmpty()) {
			try {
				Integer.parseInt(point);
			} catch (Exception e) {
				errors.add("point", new ActionMessage(
						"errors.Daily.point.format"));
			}
		}

		if (errors.size() > 0) {
			List<DailyChannel> dailyChannelList = getAllDao()
					.getDailyChannels();
			List<UserLevel> readGradeList = getAllDao().getUserLevels();
			request.setAttribute("readGradeList", readGradeList);
			request.setAttribute("dailyChannelList", dailyChannelList);
		}
		return errors;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public String getAddDateString() {
		return addDateString;
	}

	public void setAddDateString(String addDateString) {
		this.addDateString = addDateString;
	}

	public String getAddDateHH() {
		return addDateHH;
	}

	public void setAddDateHH(String addDateHH) {
		this.addDateHH = addDateHH;
	}

	public String getAddDatemm() {
		return addDatemm;
	}

	public void setAddDatemm(String addDatemm) {
		this.addDatemm = addDatemm;
	}

	public String getAddDatess() {
		return addDatess;
	}

	public void setAddDatess(String addDatess) {
		this.addDatess = addDatess;
	}

	public String getChannelIdString() {
		return channelIdString;
	}

	public void setChannelIdString(String channelIdString) {
		this.channelIdString = channelIdString;
	}

	public String getBrowseTimes() {
		return browseTimes;
	}

	public void setBrowseTimes(String browseTimes) {
		this.browseTimes = browseTimes;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getTagsString() {
		return tagsString;
	}

	public void setTagsString(String tagsString) {
		this.tagsString = tagsString;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getHot() {
		return hot;
	}

	public void setHot(String hot) {
		this.hot = hot;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
