package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.VideoDao;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;

public class VideoDaoImpl extends SqlMapClientDaoSupport implements VideoDao {

	public Video createVideo(Video video) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteVideo(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public Video getVideoById(Long id) throws DataAccessException {
	return (Video)getSqlMapClientTemplate().queryForObject("getVideoById", id);

	}

	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException {
	
		
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoes",pagination);
		
		pagination.setRecordSum(count);
		if (count > 0) {
		
			List<Video> list;
			
			
			
			

			list = getSqlMapClientTemplate().queryForList("getVideoes",
					pagination);

			pagination.setResults(list);
		}
	}

	public void updateVideo(Video video) throws DataAccessException {
		getSqlMapClientTemplate().update("updateVideo", video);

	}

	public void updateVideoByVideoChannelId(Video video)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateVideoByVideoChannelId", video);

	}

	public void deleteVideoByChannelId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteVideoByChannelId", id);

	}

	public void updateVideoWithChannelByVideoChannelId(Video video)
			throws DataAccessException {
		getSqlMapClientTemplate().update(
				"updateVideoWithChannelByVideoChannelId", video);
	}

}
