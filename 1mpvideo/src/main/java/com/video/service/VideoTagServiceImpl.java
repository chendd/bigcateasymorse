package com.video.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.TagDao;
import com.video.dao.VideoDao;
import com.video.domain.BrowseHistoryVideo;
import com.video.domain.Tag;
import com.video.domain.TagStrongUser;
import com.video.domain.Video;
import com.video.domain.connection.VideoAndTag;
import com.video.util.Pagination;
import com.video.util.SomeStatic;

public class VideoTagServiceImpl implements VideoTagService {
	private TagDao tagDao;
	private VideoDao videoDao;

	public VideoDao getVideoDao() {
		return videoDao;
	}

	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	public TagDao getTagDao() {
		return tagDao;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public List<Tag> getHotVideoTag() {
		Pagination<Tag> pagination = new Pagination<Tag>();
		pagination.setSize(SomeStatic.VIDEOTAG_HOT_PAGESIZE);
		pagination.setOrderFieldName("browsecount");
		pagination.setNo(1);
		pagination.setDesc(true);

		tagDao.getTags(pagination);

		return pagination.getResults();
	}

	public List<Tag> getMyVideoTag(Pagination<Tag> pagination) {
		tagDao.getTags(pagination);
		return pagination.getResults();
	}

	public List<Tag> getNewVideoTag() {

		Pagination<Tag> pagination = new Pagination<Tag>();
		pagination.setSize(SomeStatic.VIDEOTAG_NEW_PAGESIZE);
		pagination.setOrderFieldName("createdate");
		pagination.setNo(1);
		pagination.setDesc(true);

		tagDao.getTags(pagination);

		return pagination.getResults();
	}

	public List<Tag> getLikeVideoTag() {
		List<Tag> list = tagDao
				.getLikeVideoTag(SomeStatic.VIDEOTAG_LIKE_PAGESIZE);
		return list;
	}

	public List<TagStrongUser> getTagStrongUser(int size) {
		return tagDao.getTagStrongUser(size);
	}

	public void createVideoAndTag(Video video, String tagName)
			throws DataAccessException {
		Tag tag = this.tagDao.getTagByName(tagName);
		if (tag == null) {
			tag = new Tag();
			tag.setName(tagName);
			tag.setStatus(1);
			tag.setBrowseCount(0);
			tag.setUser(video.getUser());
			tag.setCreateDate(new Date());
			this.tagDao.createTag(tag);
			VideoAndTag videoAndTag = new VideoAndTag();
			videoAndTag.setTagId(tag.getId());
			videoAndTag.setVideoId(video.getId());
			this.videoDao.createVideoAndTag(videoAndTag);
		} else {
			VideoAndTag videoAndTag = new VideoAndTag();
			videoAndTag.setTagId(tag.getId());
			videoAndTag.setVideoId(video.getId());
			VideoAndTag videoAndTag2 = this.videoDao
					.getVideoAndTag(videoAndTag);
			if (videoAndTag2 == null) {
				this.videoDao.createVideoAndTag(videoAndTag);
			}
		}
	}


	public void getTags(Pagination<Tag> pagination) throws DataAccessException {
		this.tagDao.getTags(pagination);
	}
	public void deleteVideoAndTagByVideoId(Long id) throws DataAccessException {
		this.videoDao.deleteVideoAndTagByVideoId(id);
	}

	public List<Tag> getTagsByVideo(Long id) throws DataAccessException {
		
		return this.tagDao.getTagsByVideo(id);
	}

	
}
