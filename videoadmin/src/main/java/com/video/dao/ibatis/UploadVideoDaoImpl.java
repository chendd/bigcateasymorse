package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.UploadVideoDao;
import com.video.domain.Topic;
import com.video.domain.UploadVideo;
import com.video.domain.Video;
import com.video.util.Pagination;

public class UploadVideoDaoImpl extends SqlMapClientDaoSupport implements
		UploadVideoDao {

	public void createUploadVideo(UploadVideo uploadVideo)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createUploadVideo", uploadVideo);

	}

	public void deleteUploadVideo(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteUploadVideo", id);

	}

	public UploadVideo getUploadVideoById(Long id) throws DataAccessException {
		return (UploadVideo) getSqlMapClientTemplate().queryForObject(
				"getUploadVideoById", id);
	}

	public void getUploadVideoes(Pagination<UploadVideo> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUploadVideoes",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<UploadVideo> list;

			list = this.getSqlMapClientTemplate().queryForList("getUploadVideoes",pagination);
			for(UploadVideo uploadVideo:list){
				Video video = (Video)getSqlMapClientTemplate().queryForObject("getVideoById",uploadVideo.getVideo().getId());
				uploadVideo.setVideo(video);
				
			}
			pagination.setResults(list);

		}
	}

	public void updateUploadVideo(UploadVideo uploadVideo)
			throws DataAccessException {
		
		getSqlMapClientTemplate().update("updateUploadVideo", uploadVideo);

	}

}
