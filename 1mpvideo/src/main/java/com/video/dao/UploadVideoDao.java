package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.UploadVideo;
import com.video.util.Pagination;

public interface UploadVideoDao {
	
	public void createUploadVideo(UploadVideo uploadVideo) throws DataAccessException;
	
	public void updateUploadVideo(UploadVideo uploadVideo) throws DataAccessException;
	
	public void deleteUploadVideo(Long id) throws DataAccessException;
	
	public UploadVideo getUploadVideoById(Long id) throws DataAccessException;
	
	public void getUploadVideoes(Pagination<UploadVideo> pagination) throws DataAccessException;
	
	public void updateUploadVideoStatus(UploadVideo uploadVideo) throws DataAccessException;
	public void updateUploadVideoLength(UploadVideo uploadVideo) throws DataAccessException;
	

}
