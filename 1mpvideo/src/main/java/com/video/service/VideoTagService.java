package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.BrowseHistoryVideo;
import com.video.domain.Tag;
import com.video.domain.TagStrongUser;
import com.video.domain.Video;
import com.video.util.Pagination;

public interface VideoTagService {

	public List<Tag> getNewVideoTag();

	public List<Tag> getHotVideoTag();

	public List<Tag> getMyVideoTag(Pagination<Tag> pagination);

	public List<Tag> getLikeVideoTag();

	public List<TagStrongUser> getTagStrongUser(int size);
	
	public void deleteVideoAndTagByVideoId(Long id) throws DataAccessException;

	public void createVideoAndTag(Video video, String tagName)
			throws DataAccessException;

	public void getTags(Pagination<Tag> pagination) throws DataAccessException;
	
	public List<Tag> getTagsByVideo(Long id) throws DataAccessException;
	
	
}
