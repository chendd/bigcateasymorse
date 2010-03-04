package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Notice;
import com.video.domain.Tag;
import com.video.domain.TagStrongUser;
import com.video.domain.Topic;
import com.video.domain.Video;
import com.video.util.Pagination;

public interface NoticeDao {



	public List<Notice> getNotices() throws DataAccessException;
	
	
}
