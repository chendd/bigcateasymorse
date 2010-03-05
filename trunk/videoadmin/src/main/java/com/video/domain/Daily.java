package com.video.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/** @pdOid 1713d384-7377-4d90-98dc-57994531a53b */
public class Daily implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// 日志ID
	private String title;// 日志标题
	private String log;// 日志内容
	private Date addDate;// 发表时间
	private Date updateDate;// 更新时间
	private User user;// 发表用户
	private int browseTimes;// 浏览次数
	private Date topDate;// 置顶时间
	private int expense;// 阅读花费
	private int grade;// 等级
	private DailyChannel channel;// 日志分类
	private Date recommendDate;// 推荐时间
	private int point;// 日志得分
	private String flag;// 是否删除
	private List<DailyTag> tags;// 标签
	private Date hotDate;// 热点文章

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Long getChannelId() {
		if (this.channel == null) {
			this.channel = new DailyChannel();
		}
		return this.channel.getId();
	}

	public void setChannelId(Long id) {
		if (this.channel == null) {
			this.channel = new DailyChannel();
		}
		this.channel.setId(id);
	}

	public Long getUserId() {
		if (this.user == null) {
			this.user = new User();
		}
		return this.user.getId();
	}

	public void setUserId(Long id) {
		if (this.user == null) {
			this.user = new User();
		}
		this.user.setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getBrowseTimes() {
		return browseTimes;
	}

	public void setBrowseTimes(int browseTimes) {
		this.browseTimes = browseTimes;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public DailyChannel getChannel() {
		return channel;
	}

	public void setChannel(DailyChannel channel) {
		this.channel = channel;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Daily() {
	}

	public List<DailyTag> getTags() {
		return tags;
	}

	public void setTags(List<DailyTag> tags) {
		this.tags = tags;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getTopDate() {
		return topDate;
	}

	public void setTopDate(Date topDate) {
		this.topDate = topDate;
	}

	public Date getRecommendDate() {
		return recommendDate;
	}

	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}

	public Date getHotDate() {
		return hotDate;
	}

	public void setHotDate(Date hotDate) {
		this.hotDate = hotDate;
	}

}