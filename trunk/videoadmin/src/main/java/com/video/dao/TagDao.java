package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Tag;
import com.video.domain.Video;
import com.video.domain.connection.VideoAndTag;
import com.video.util.Pagination;

public interface TagDao {
	
	public Tag createTag(Tag tag) throws DataAccessException;
	
	public void updateTag(Tag tag) throws DataAccessException;
	
	public void deleteTag(Long id) throws DataAccessException;
	
	public Tag getTagById(Long id) throws DataAccessException;
	
	public Tag getTagByName(String name) throws DataAccessException;
	
	public void getTags(Pagination<Tag> pagination) throws DataAccessException;
	
	public List<Video> getVideoesByTagId(Long id) throws DataAccessException;
	
	public List<Tag> getTagsByVideo(Long id) throws DataAccessException;
	
	
	public void deleteVideoAndTagsByVideoId(Long id) throws DataAccessException;
	
	public void creatVideoAndTag(VideoAndTag videoAndTag) throws DataAccessException;

}
