package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.IsSubscribe;
import com.video.domain.Playbill;
import com.video.domain.Video;
import com.video.domain.VideoAndPlayBill;
import com.video.util.Pagination;

public interface PlaybillDao {

	public Playbill createPlaybill(Playbill playbill)
			throws DataAccessException;

	public void updatePlaybill(Playbill playbill) throws DataAccessException;

	public void deletePlaybill(Long id) throws DataAccessException;

	public Playbill getPlaybill(Long id) throws DataAccessException;

	public void getPlaybills(Pagination<Playbill> pagination)
			throws DataAccessException;

	// 对节目单和视频中间表的操作
	public void updateVideoAndPagination(Playbill playbill, List<Video> videoes)
			throws DataAccessException;

	public VideoAndPlayBill getVideoAndPlayBill(
			VideoAndPlayBill videoAndPlayBill) throws DataAccessException;

	public VideoAndPlayBill createVideoAndPlayBill(
			VideoAndPlayBill videoAndPlayBill) throws DataAccessException;

	public void deleteVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException;

	public void getMySubscribePlaybill(Pagination<Playbill> pagination)
			throws DataAccessException;

	public void getMyPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException;

	public void getPlayBillsByGroupId(Pagination<Playbill> pagination)
			throws DataAccessException;

	public boolean isSubscribe(IsSubscribe isSubscribe)
			throws DataAccessException;

	public void createSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException;

	public void deleteSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException;

	public void updatePlaybillWithBrowseCount(Playbill playbill)
			throws DataAccessException;

	public void getOtherPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException;

	public void deleteSubscribeWithPlaybillId(Long id)
			throws DataAccessException;

	public void deleteConnWithPlaybillId(Long id) throws DataAccessException;

	public void getPlaybillByKey(Pagination<Playbill> pagination)
			throws DataAccessException;
}
