package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.CandidateVideoDao;
import com.video.domain.CandidateVideo;
import com.video.domain.Topic;
import com.video.util.Pagination;

public class CandidateVideoDaoImpl extends SqlMapClientDaoSupport implements
		CandidateVideoDao {

	public CandidateVideo createCandidateVideo(CandidateVideo candidateVideo)
			throws DataAccessException {
		getSqlMapClientTemplate()
				.insert("createCandidateVideo", candidateVideo);
		return null;
	}

	public void getCandidateVideoes(Pagination<CandidateVideo> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countCandidateVideo");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<CandidateVideo> list;

			list = this.getSqlMapClientTemplate().queryForList("getCandidateVideoes",
					pagination);

			pagination.setResults(list);

		}
	}

	public void updateCandidateVideo(CandidateVideo candidateVideo)
			throws DataAccessException {
		getSqlMapClientTemplate()
				.update("updateCandidateVideo", candidateVideo);

	}

	@Override
	public List<CandidateVideo> getCandidateVideoeList()
			throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getCandidateVideoeList");
	}

	@Override
	public CandidateVideo getCandidateVideoByVideoId(Long vid)
			throws DataAccessException {

		return (CandidateVideo) getSqlMapClientTemplate().queryForObject(
				"getCandidateVideoByVideoId", vid);
	}

	@Override
	public void deleteCandidateVideo(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCandidateVideo", id);
		
	}

}
