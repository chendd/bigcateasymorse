package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.CommendPlaybill;
import com.video.domain.IsSubscribe;
import com.video.domain.Playbill;
import com.video.domain.PlaybillChannel;
import com.video.domain.PlaybillCommet;
import com.video.domain.VideoAndPlayBill;
import com.video.util.Pagination;

public interface PlaybillService {

	public List<CommendPlaybill> getCommendPlaybill()
			throws DataAccessException;

	public void getMySubscribePlaybill(Pagination<Playbill> pagination)
			throws DataAccessException;

	public void getMyPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException;

	public Playbill getPlaybill(Long id) throws DataAccessException;

	public boolean isSubscribe(IsSubscribe isSubscribe)
			throws DataAccessException;

	public void createSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException;

	public void deleteSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException;

	public void createCommentPlaybill(PlaybillCommet commet)
			throws DataAccessException;

	public void getCommentPlaybillByPlaybillId(
			Pagination<PlaybillCommet> pagination) throws DataAccessException;

	public void updateCommendPlaybillWithBrowseCount(
			CommendPlaybill commendPlaybill) throws DataAccessException;

	public void updatePlaybillWithBrowseCount(Playbill playbill)
			throws DataAccessException;

	public void getOtherPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException;

	public VideoAndPlayBill createVideoAndPlayBill(
			VideoAndPlayBill videoAndPlayBill) throws DataAccessException;

	public void createPlaybill(Playbill playbill) throws DataAccessException;

	public List<PlaybillChannel> getPlaybillChannels()
			throws DataAccessException;

	public void updatePlaybill(Playbill playbill) throws DataAccessException;

	public void deletePlaybill(Long id) throws DataAccessException;

	public void deleteVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException;
	public void getPlaybillByKey(Pagination<Playbill> pagination)
	throws DataAccessException;
}
