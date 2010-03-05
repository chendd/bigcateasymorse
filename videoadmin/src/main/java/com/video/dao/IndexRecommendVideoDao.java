package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.IndexRecommendVideo;

public interface IndexRecommendVideoDao {
	
	public void createIndexRecommendVideo(IndexRecommendVideo indexRecommendVideo) throws DataAccessException;
	
	public void updateIndexRecommendVideo(IndexRecommendVideo indexRecommendVideo) throws DataAccessException;
	
	public void deleteIndexRecommendVideo() throws DataAccessException;
	
	public IndexRecommendVideo getIndexRecommendVideoById(Long id) throws DataAccessException;
	
	public IndexRecommendVideo getFrontVideoById(Long id) throws DataAccessException;
	
	public IndexRecommendVideo getBackVideoById(Long id) throws DataAccessException;
	 
	public List<IndexRecommendVideo>  getIndexRecommendVideoes() throws DataAccessException;

}
