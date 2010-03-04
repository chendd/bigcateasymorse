package com.video.domain;

import java.io.Serializable;
import java.util.*;

/** @pdOid 9ba9fa32-b84e-4610-89a2-921ff04b2ae2 */
public class Challenge implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private User attackUser;// 挑战用户
	private User receiveUser;// 应战用户
	private Video attackVideo;// 挑战视频
	private Video receiveVideo;// 应战视频
	private int attackVideoAuspiceCount;// 挑战者得分
	private int receiveVideoAuspiceCount;// 应战者得分
	private Date startTime;// 开始时间
	private Date endTime;// 结束时间
	private int status;// 比赛状态
	private User winner;// 胜利者

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAttackUser() {
		return attackUser;
	}

	public void setAttackUser(User attackUser) {
		this.attackUser = attackUser;
	}

	public User getReceiveUser() {
		return receiveUser;
	}

	public void setReceiveUser(User receiveUser) {
		this.receiveUser = receiveUser;
	}

	public Video getAttackVideo() {
		return attackVideo;
	}

	public void setAttackVideo(Video attackVideo) {
		this.attackVideo = attackVideo;
	}

	public Video getReceiveVideo() {
		return receiveVideo;
	}

	public void setReceiveVideo(Video receiveVideo) {
		this.receiveVideo = receiveVideo;
	}

	public int getAttackVideoAuspiceCount() {
		return attackVideoAuspiceCount;
	}

	public void setAttackVideoAuspiceCount(int attackVideoAuspiceCount) {
		this.attackVideoAuspiceCount = attackVideoAuspiceCount;
	}

	public int getReceiveVideoAuspiceCount() {
		return receiveVideoAuspiceCount;
	}

	public void setReceiveVideoAuspiceCount(int receiveVideoAuspiceCount) {
		this.receiveVideoAuspiceCount = receiveVideoAuspiceCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getWinner() {
		return winner;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}

	public Challenge() {
	}

}