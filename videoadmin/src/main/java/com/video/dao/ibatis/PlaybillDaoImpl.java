package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.PlaybillDao;
import com.video.domain.Playbill;
import com.video.domain.Topic;
import com.video.domain.Video;
import com.video.domain.VideoAndPlayBill;
import com.video.util.Pagination;

public class PlaybillDaoImpl extends SqlMapClientDaoSupport implements
		PlaybillDao {

	public Playbill createPlaybill(Playbill playbill)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createPlayBill", playbill);
		return null;
	}

	public void deletePlaybill(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public Playbill getPlaybill(Long id) throws DataAccessException {
		return (Playbill)getSqlMapClientTemplate().queryForObject("getPlayBill", id);
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


	public void createVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
	
		getSqlMapClientTemplate().insert("createVideoAndPlayBill", videoAndPlayBill);
	}


	public VideoAndPlayBill getVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
		
	return	(VideoAndPlayBill)getSqlMapClientTemplate().queryForObject("getVideoAndPlayBill", videoAndPlayBill);
	}

	@Override
	public void deleteVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
		
		getSqlMapClientTemplate().delete("deleteVideoAndPlayBill", videoAndPlayBill);
	}
	


}
