package com.video.domain.logic;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.AdministratorDao;
import com.video.dao.AuspiceAnnalDao;
import com.video.dao.BrowseVideoHistoryDao;
import com.video.dao.CandidateVideoDao;
import com.video.dao.ChallengeDao;
import com.video.dao.CollectionVideoDao;
import com.video.dao.CommentDao;
import com.video.dao.DailyAndTagDao;
import com.video.dao.DailyChannelDao;
import com.video.dao.DailyDao;
import com.video.dao.DailyReplyDao;
import com.video.dao.DailyTagDao;
import com.video.dao.GroupAndUserDao;
import com.video.dao.GroupDao;
import com.video.dao.IndexRecommendVideoDao;
import com.video.dao.KeywordChannelDao;
import com.video.dao.MayLikeVideoDao;
import com.video.dao.NoticeDao;
import com.video.dao.PlaybillDao;
import com.video.dao.SubscribeDailyDao;
import com.video.dao.SubscribeGroupDao;
import com.video.dao.SubscribePlaybillDao;
import com.video.dao.SubscribeVideoDao;
import com.video.dao.SystemKeywordDao;
import com.video.dao.SystemNoticeDao;
import com.video.dao.TagDao;
import com.video.dao.TopicCommentDao;
import com.video.dao.TopicDao;
import com.video.dao.UploadVideoDao;
import com.video.dao.UserDao;
import com.video.dao.UserKeywordDao;
import com.video.dao.Video3gpDao;
import com.video.dao.VideoChannelDao;
import com.video.dao.VideoDao;
import com.video.dao.WhisperDao;
import com.video.domain.Group;
import com.video.domain.SystemNotice;
import com.video.domain.Tag;
import com.video.domain.User;

public interface AllDaoFacade extends AdministratorDao, AuspiceAnnalDao,
		BrowseVideoHistoryDao, CandidateVideoDao, ChallengeDao,
		CollectionVideoDao, CommentDao, DailyChannelDao, DailyDao,
		DailyReplyDao, GroupAndUserDao, GroupDao, IndexRecommendVideoDao,
		KeywordChannelDao, MayLikeVideoDao, PlaybillDao, SubscribeDailyDao,
		SubscribeGroupDao, SubscribePlaybillDao, SubscribeVideoDao,
		SystemKeywordDao, TagDao, TopicDao, TopicCommentDao, UploadVideoDao,
		UserDao, UserKeywordDao, Video3gpDao, VideoChannelDao, VideoDao,
		WhisperDao, DailyTagDao, DailyAndTagDao,SystemNoticeDao,NoticeDao {

	public void createSystemNotice(Integer grade,SystemNotice systemNotice)
	throws DataAccessException;
		
	public void createGroupAndUsers(List<User> users,Group group) throws DataAccessException;
	public void deleteGroupAndUsers(List<User> users,Group group) throws DataAccessException;
	
	public void updateRecommendGroups(List<Group> gruops) throws DataAccessException;
	
	public void updateVideoAndTag(List<Tag> tags,Long videoId) throws DataAccessException;
}
