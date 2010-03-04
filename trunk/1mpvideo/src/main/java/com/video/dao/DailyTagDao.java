package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Daily;
import com.video.domain.DailyTag;
import com.video.domain.Tag;
import com.video.domain.Video;
import com.video.util.Pagination;

public interface DailyTagDao {
	
	public void createDailyTag(DailyTag tag) throws DataAccessException;
	
	public void updateDailyTag(DailyTag tag) throws DataAccessException;
	
	public void deleteDailyTag(Long id) throws DataAccessException;
	
	public DailyTag getDailyTagById(Long id) throws DataAccessException;
	
	public DailyTag getDailyTagByName(String name) throws DataAccessException;
	
	public void getDailyTags(Pagination<DailyTag> pagination) throws DataAccessException;
	
	public List<Daily> getDailysByTagId(Long id) throws DataAccessException;
	
	public void deleteDailyTagByDailyId(Long id) throws DataAccessException;
	
	public List<DailyTag> getDailyTagsByUser(Long id) throws DataAccessException;

}
