package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.PlaybillDao;
import com.video.domain.IsSubscribe;
import com.video.domain.Playbill;
import com.video.domain.Video;
import com.video.domain.VideoAndPlayBill;
import com.video.util.Pagination;

public class PlaybillDaoImpl extends SqlMapClientDaoSupport implements
		PlaybillDao {

	public Playbill createPlaybill(Playbill playbill)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createPlayBill", playbill);
		return playbill;
	}

	public void deletePlaybill(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deletePlaybill", id);
	}

	public Playbill getPlaybill(Long id) throws DataAccessException {
		return (Playbill) getSqlMapClientTemplate().queryForObject(
				"getPlayBill", id);
	}

	public void getPlaybills(Pagination<Playbill> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countPlayBill");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Playbill> list;

			list = this.getSqlMapClientTemplate().queryForList("getPlayBills",
					pagination);

			pagination.setResults(list);

		}
	}

	public void updatePlaybill(Playbill playbill) throws DataAccessException {
		getSqlMapClientTemplate().update("updatePlayBill", playbill);

	}

	public void updateVideoAndPagination(Playbill playbill, List<Video> videoes)
			throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public VideoAndPlayBill createVideoAndPlayBill(
			VideoAndPlayBill videoAndPlayBill) throws DataAccessException {

		getSqlMapClientTemplate().insert("createVideoAndPlayBill",
				videoAndPlayBill);
		return videoAndPlayBill;
	}

	public VideoAndPlayBill getVideoAndPlayBill(
			VideoAndPlayBill videoAndPlayBill) throws DataAccessException {

		return (VideoAndPlayBill) getSqlMapClientTemplate().queryForObject(
				"getVideoAndPlayBill", videoAndPlayBill);
	}

	public void deleteVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {

		getSqlMapClientTemplate().delete("deleteVideoAndPlayBill",
				videoAndPlayBill);
	}

	public void getMySubscribePlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countMySubscribePlaybill",pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Playbill> list;
			list = this.getSqlMapClientTemplate().queryForList(
					"getMySubscribePlaybill", pagination);
			pagination.setResults(list);
		}
	}

	public void getMyPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countMyPlaybill", pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Playbill> list;
			list = this.getSqlMapClientTemplate().queryForList("getMyPlaybill",
					pagination);
			pagination.setResults(list);
		}
	}

	public void getPlayBillsByGroupId(Pagination<Playbill> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countPlayBillsByGroupId");
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Playbill> list;
			list = this.getSqlMapClientTemplate().queryForList(
					"getPlayBillsByGroupId", pagination);
			pagination.setResults(list);
		}

	}

	public boolean isSubscribe(IsSubscribe isSubscribe)
			throws DataAccessException {
		int count = (Integer) this.getSqlMapClientTemplate().queryForObject(
				"isSubscribe", isSubscribe);
		boolean flag = false;
		if (count > 0) {
			flag = true;
		}
		return flag;
	}

	public void createSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException {
		this.getSqlMapClientTemplate().insert("createSubscribePlaybill",
				isSubscribe);
	}

	public void deleteSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException {
		this.getSqlMapClientTemplate().delete("deleteSubscribePlaybill",
				isSubscribe);
	}

	public void updatePlaybillWithBrowseCount(Playbill playbill)
			throws DataAccessException {
		this.getSqlMapClientTemplate().update("updatePlaybillWithBrowseCount",
				playbill);

	}

	public void getOtherPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countOtherPlaybill", pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Playbill> list;
			list = this.getSqlMapClientTemplate().queryForList(
					"getOtherPlaybill", pagination);
			pagination.setResults(list);
		}
	}

	public void deleteSubscribeWithPlaybillId(Long id)
			throws DataAccessException {
		this.getSqlMapClientTemplate().delete("deleteSubscribeWithPlaybillId",
				id);
	}

	public void deleteConnWithPlaybillId(Long id) throws DataAccessException {
		this.getSqlMapClientTemplate().delete("deleteConnWithPlaybillId", id);
	}

	public void getPlaybillByKey(Pagination<Playbill> pagination)
			throws DataAccessException {
		if (pagination.getCondition() != null) {
			Playbill playbill = (Playbill) pagination.getCondition();
			if (playbill.getDescription() != null
					&& !playbill.getDescription().isEmpty()) {
				playbill.setDescription(MessageFormat.format("%{0}%", playbill
						.getDescription().replaceAll("%", "!%").replaceAll("!",
								"!!")));
			}
			if (playbill.getName() != null && !playbill.getName().isEmpty()) {
				playbill.setName(MessageFormat.format("%{0}%", playbill.getName()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
		}

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countPlaybillByKey", pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Playbill> list;
			list = getSqlMapClientTemplate().queryForList("getPlaybillByKey",
					pagination);
			pagination.setResults(list);
		}
	}

}
