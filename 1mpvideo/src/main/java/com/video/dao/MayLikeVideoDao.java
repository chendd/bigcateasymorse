package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.IndexRecommendVideo;
import com.video.domain.MayLikeVideo;

public interface MayLikeVideoDao {
	
	public void createMayLikeVideo(MayLikeVideo  mayLikeVideo) throws DataAccessException;
	
	public void updateMayLikeVideo(MayLikeVideo mayLikeVideo) throws DataAccessException;
	
	public void deleteMayLikeVideo() throws DataAccessException;
	
	public MayLikeVideo getMayLikeVideoById(Long id) throws DataAccessException;
	
	public MayLikeVideo getFrontVideoeById(Long id) throws DataAccessException;
	
	public MayLikeVideo getBackVideoeById(Long id) throws DataAccessException;
	 
	public List<MayLikeVideo>  getMayLikeVideoes() throws DataAccessException;

}
