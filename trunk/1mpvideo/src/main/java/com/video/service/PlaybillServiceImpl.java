package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.CommendPlaybillDao;
import com.video.dao.PlaybillChannelDao;
import com.video.dao.PlaybillDao;
import com.video.dao.VideoDao;
import com.video.domain.CommendPlaybill;
import com.video.domain.IsSubscribe;
import com.video.domain.Playbill;
import com.video.domain.PlaybillChannel;
import com.video.domain.PlaybillCommet;
import com.video.domain.VideoAndPlayBill;
import com.video.util.Pagination;

public class PlaybillServiceImpl implements PlaybillService {
	private CommendPlaybillDao commendPlaybillDao;
	private PlaybillDao playbillDao;
	private PlaybillChannelDao playbillChannelDao;
	private VideoDao videoDao;

	public PlaybillChannelDao getPlaybillChannelDao() {
		return playbillChannelDao;
	}

	public void setPlaybillChannelDao(PlaybillChannelDao playbillChannelDao) {
		this.playbillChannelDao = playbillChannelDao;
	}

	public PlaybillDao getPlaybillDao() {
		return playbillDao;
	}

	public void setPlaybillDao(PlaybillDao playbillDao) {
		this.playbillDao = playbillDao;
	}

	public CommendPlaybillDao getCommendPlaybillDao() {
		return commendPlaybillDao;
	}

	public void setCommendPlaybillDao(CommendPlaybillDao commendPlaybillDao) {
		this.commendPlaybillDao = commendPlaybillDao;
	}

	public List<CommendPlaybill> getCommendPlaybill()
			throws DataAccessException {
		return this.commendPlaybillDao.getCommendPlaybill();
	}

	public void getMySubscribePlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillDao.getMySubscribePlaybill(pagination);
	}

	public void getMyPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillDao.getMyPlaybill(pagination);
	}

	public Playbill getPlaybill(Long id) throws DataAccessException {

		return this.playbillDao.getPlaybill(id);
	}

	public boolean isSubscribe(IsSubscribe isSubscribe)
			throws DataAccessException {
		return this.playbillDao.isSubscribe(isSubscribe);
	}

	public void createSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException {
		this.playbillDao.createSubscribePlaybill(isSubscribe);
	}

	public void deleteSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException {
		this.playbillDao.deleteSubscribePlaybill(isSubscribe);
	}

	public void createCommentPlaybill(PlaybillCommet commet)
			throws DataAccessException {
		this.commendPlaybillDao.createCommentPlaybill(commet);
	}

	public void getCommentPlaybillByPlaybillId(
			Pagination<PlaybillCommet> pagination) throws DataAccessException {
		this.commendPlaybillDao.getCommentPlaybillByPlaybillId(pagination);
	}

	public void updateCommendPlaybillWithBrowseCount(
			CommendPlaybill commendPlaybill) throws DataAccessException {
		this.commendPlaybillDao
				.updateCommendPlaybillWithBrowseCount(commendPlaybill);
	}

	public void updatePlaybillWithBrowseCount(Playbill playbill)
			throws DataAccessException {
		this.playbillDao.updatePlaybillWithBrowseCount(playbill);
	}

	public void getOtherPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillDao.getOtherPlaybill(pagination);
	}

	public VideoAndPlayBill createVideoAndPlayBill(
			VideoAndPlayBill videoAndPlayBill) throws DataAccessException {
		VideoAndPlayBill vPlayBill = this.playbillDao
				.getVideoAndPlayBill(videoAndPlayBill);
		if (vPlayBill == null) {
			this.playbillDao.createVideoAndPlayBill(videoAndPlayBill);
		}
		return videoAndPlayBill;
	}

	public void createPlaybill(Playbill playbill) throws DataAccessException {
		this.playbillDao.createPlaybill(playbill);
	}

	public List<PlaybillChannel> getPlaybillChannels()
			throws DataAccessException {
		return this.playbillChannelDao.getPlaybillChannels();
	}

	public void updatePlaybill(Playbill playbill) throws DataAccessException {
		this.playbillDao.updatePlaybill(playbill);
	}

	public void deletePlaybill(Long id) throws DataAccessException {
		this.playbillDao.deletePlaybill(id);
		this.playbillDao.deleteConnWithPlaybillId(id);
		this.playbillDao.deleteSubscribeWithPlaybillId(id);
	}

	public void deleteVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
		this.playbillDao.deleteVideoAndPlayBill(videoAndPlayBill);
	}

	public void getPlaybillByKey(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillDao.getPlaybillByKey(pagination);
	}
}
