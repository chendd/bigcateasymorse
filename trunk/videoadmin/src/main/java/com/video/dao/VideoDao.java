package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.Video;
import com.video.util.Pagination;

public interface VideoDao {

	public Video createVideo(Video video) throws DataAccessException;

	public void updateVideo(Video video) throws DataAccessException;

	public void deleteVideo(Long id) throws DataAccessException;

	public Video getVideoById(Long id) throws DataAccessException;

	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException;

	public void updateVideoByVideoChannelId(Video video)
			throws DataAccessException;

	public void deleteVideoByChannelId(Long id) throws DataAccessException;

	public void updateVideoWithChannelByVideoChannelId(Video video)
			throws DataAccessException;
}
