package com.video.domain.logic;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.video.domain.Administrator;
import com.video.domain.AuspiceAnnal;
import com.video.domain.BrowseVideoHistory;
import com.video.domain.CandidateVideo;
import com.video.domain.Challenge;
import com.video.domain.CollectionVideo;
import com.video.domain.Comment;
import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyReply;
import com.video.domain.DailyTag;
import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.IndexRecommendVideo;
import com.video.domain.KeywordChannel;
import com.video.domain.MayLikeVideo;
import com.video.domain.Notice;
import com.video.domain.Playbill;
import com.video.domain.SubscribeDaily;
import com.video.domain.SubscribeGroup;
import com.video.domain.SubscribePlaybill;
import com.video.domain.SubscribeVideo;
import com.video.domain.SystemKeyword;
import com.video.domain.SystemNotice;
import com.video.domain.Tag;
import com.video.domain.Topic;
import com.video.domain.TopicComment;
import com.video.domain.UploadVideo;
import com.video.domain.User;
import com.video.domain.UserKeyword;
import com.video.domain.UserLevel;
import com.video.domain.Video;
import com.video.domain.VideoAndPlayBill;
import com.video.domain.VideoChannel;
import com.video.domain.Whisper;
import com.video.domain.connection.DailyAndTag;
import com.video.domain.connection.Star;
import com.video.domain.connection.VideoAndTag;
import com.video.util.Pagination;

public class AllDaoImpl implements AllDaoFacade {
	private AdministratorDao administratorDao;
	private AuspiceAnnalDao auspiceAnnalDao;
	private BrowseVideoHistoryDao browseVideoHistoryDao;
	private CandidateVideoDao candidateVideoDao;
	private ChallengeDao challengeDao;
	private CollectionVideoDao collectionVideoDao;
	private CommentDao commentDao;
	private DailyChannelDao dailyChannelDao;
	private DailyDao dailyDao;
	private DailyReplyDao dailyReplyDao;
	private GroupAndUserDao groupAndUserDao;
	private GroupDao groupDao;
	private IndexRecommendVideoDao indexRecommendVideoDao;
	private KeywordChannelDao keywordChannelDao;
	private MayLikeVideoDao mayLikeVideoDao;
	private PlaybillDao playbillDao;
	private SubscribeDailyDao subscribeDailyDao;
	private SubscribeGroupDao subscribeGroupDao;
	private SubscribePlaybillDao subscribePlaybillDao;
	private SubscribeVideoDao subscribeVideoDao;
	private SystemKeywordDao systemKeywordDao;
	private TagDao tagDao;
	private TopicCommentDao topicCommentDao;
	private TopicDao topicDao;
	private UploadVideoDao uploadVideoDao;
	private UserDao userDao;
	private UserKeywordDao userKeywordDao;
	private Video3gpDao video3gpDao;
	private VideoChannelDao videoChannelDao;
	private VideoDao videoDao;
	private WhisperDao whisperDao;
	private DailyTagDao dailyTagDao;
	private DailyAndTagDao dailyAndTagDao;
	private SystemNoticeDao systemNoticeDao;
	private NoticeDao noticeDao;
	
	
	

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void setSystemNoticeDao(SystemNoticeDao systemNoticeDao) {
		this.systemNoticeDao = systemNoticeDao;
	}

	public void setDailyAndTagDao(DailyAndTagDao dailyAndTagDao) {
		this.dailyAndTagDao = dailyAndTagDao;
	}

	public void setDailyTagDao(DailyTagDao dailyTagDao) {
		this.dailyTagDao = dailyTagDao;
	}

	public void setAdministratorDao(AdministratorDao administratorDao) {
		this.administratorDao = administratorDao;
	}

	public void setAuspiceAnnalDao(AuspiceAnnalDao auspiceAnnalDao) {
		this.auspiceAnnalDao = auspiceAnnalDao;
	}

	public void setBrowseVideoHistoryDao(
			BrowseVideoHistoryDao browseVideoHistoryDao) {
		this.browseVideoHistoryDao = browseVideoHistoryDao;
	}

	public void setCandidateVideoDao(CandidateVideoDao candidateVideoDao) {
		this.candidateVideoDao = candidateVideoDao;
	}

	public void setChallengeDao(ChallengeDao challengeDao) {
		this.challengeDao = challengeDao;
	}

	public void setCollectionVideoDao(CollectionVideoDao collectionVideoDao) {
		this.collectionVideoDao = collectionVideoDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public void setDailyChannelDao(DailyChannelDao dailyChannelDao) {
		this.dailyChannelDao = dailyChannelDao;
	}

	public void setDailyDao(DailyDao dailyDao) {
		this.dailyDao = dailyDao;
	}

	public void setDailyReplyDao(DailyReplyDao dailyReplyDao) {
		this.dailyReplyDao = dailyReplyDao;
	}

	public void setGroupAndUserDao(GroupAndUserDao groupAndUserDao) {
		this.groupAndUserDao = groupAndUserDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public void setIndexRecommendVideoDao(
			IndexRecommendVideoDao indexRecommendVideoDao) {
		this.indexRecommendVideoDao = indexRecommendVideoDao;
	}

	public void setKeywordChannelDao(KeywordChannelDao keywordChannelDao) {
		this.keywordChannelDao = keywordChannelDao;
	}

	public void setMayLikeVideoDao(MayLikeVideoDao mayLikeVideoDao) {
		this.mayLikeVideoDao = mayLikeVideoDao;
	}

	public void setPlaybillDao(PlaybillDao playbillDao) {
		this.playbillDao = playbillDao;
	}

	public void setSubscribeDailyDao(SubscribeDailyDao subscribeDailyDao) {
		this.subscribeDailyDao = subscribeDailyDao;
	}

	public void setSubscribeGroupDao(SubscribeGroupDao subscribeGroupDao) {
		this.subscribeGroupDao = subscribeGroupDao;
	}

	public void setSubscribePlaybillDao(
			SubscribePlaybillDao subscribePlaybillDao) {
		this.subscribePlaybillDao = subscribePlaybillDao;
	}

	public void setSubscribeVideoDao(SubscribeVideoDao subscribeVideoDao) {
		this.subscribeVideoDao = subscribeVideoDao;
	}

	public void setSystemKeywordDao(SystemKeywordDao systemKeywordDao) {
		this.systemKeywordDao = systemKeywordDao;
	}

	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	public void setTopicCommentDao(TopicCommentDao topicCommentDao) {
		this.topicCommentDao = topicCommentDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public void setUploadVideoDao(UploadVideoDao uploadVideoDao) {
		this.uploadVideoDao = uploadVideoDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUserKeywordDao(UserKeywordDao userKeywordDao) {
		this.userKeywordDao = userKeywordDao;
	}

	public void setVideo3gpDao(Video3gpDao video3gpDao) {
		this.video3gpDao = video3gpDao;
	}

	public void setVideoChannelDao(VideoChannelDao videoChannelDao) {
		this.videoChannelDao = videoChannelDao;
	}

	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	public void setWhisperDao(WhisperDao whisperDao) {
		this.whisperDao = whisperDao;
	}

	public Administrator createAdministrator(Administrator administrator)
			throws DataAccessException {
		administrator = administratorDao.createAdministrator(administrator);
		return administrator;
	}

	public void deleteAdministrator(Long Id) throws DataAccessException {
		administratorDao.deleteAdministrator(Id);
	}

	public Administrator getAdministratorById(Long Id)
			throws DataAccessException {
		Administrator administrator = administratorDao.getAdministratorById(Id);
		return administrator;
	}

	public Administrator getAdministratorByName(String AdminName)
			throws DataAccessException {
		Administrator administrator = administratorDao
				.getAdministratorByName(AdminName);
		return administrator;
	}

	public void getAdministrators(Pagination<Administrator> pagination)
			throws DataAccessException {
		administratorDao.getAdministrators(pagination);
	}

	public void updateAdministrator(Administrator administrator)
			throws DataAccessException {
		administratorDao.updateAdministrator(administrator);
	}

	public void createAuspiceAnnal(AuspiceAnnal auspiceAnnal)
			throws DataAccessException {
		auspiceAnnalDao.createAuspiceAnnal(auspiceAnnal);
	}

	public void getAuspiceAnnals(Pagination<AuspiceAnnal> pagination)
			throws DataAccessException {
		auspiceAnnalDao.getAuspiceAnnals(pagination);
	}

	public BrowseVideoHistory createBrowseVideoHistory(
			BrowseVideoHistory history) throws DataAccessException {
		history = browseVideoHistoryDao.createBrowseVideoHistory(history);
		return history;
	}

	public void getBrowseVideoHistories(
			Pagination<BrowseVideoHistory> pagination)
			throws DataAccessException {
		browseVideoHistoryDao.getBrowseVideoHistories(pagination);
	}

	public CandidateVideo createCandidateVideo(CandidateVideo candidateVideo)
			throws DataAccessException {
		CandidateVideo video = candidateVideoDao.getCandidateVideoByVideoId(candidateVideo.getVideo().getId());
		if(video == null){
			candidateVideoDao.createCandidateVideo(candidateVideo);
		}
		else {
			video.setSake(candidateVideo.getSake());
			video.setRecommender(candidateVideo.getRecommender());
			video.setRecommendDate(candidateVideo.getRecommendDate());
			video.setVideo(candidateVideo.getVideo());
			candidateVideoDao.updateCandidateVideo(video);
		}
		return null;
	}

	public void getCandidateVideoes(Pagination<CandidateVideo> pagination)
			throws DataAccessException {
		candidateVideoDao.getCandidateVideoes(pagination);
	}

	public void updateCandidateVideo(CandidateVideo candidateVideo)
			throws DataAccessException {
		candidateVideoDao.updateCandidateVideo(candidateVideo);
	}

	public Challenge createChallenge(Challenge challenge)
			throws DataAccessException {
		challenge = challengeDao.createChallenge(challenge);
		return challenge;
	}

	public void deleteChallenge(Long id) throws DataAccessException {
		challengeDao.deleteChallenge(id);
	}

	public void getChallenges(Pagination<Challenge> pagination)
			throws DataAccessException {
		challengeDao.getChallenges(pagination);
	}

	public void updateChallenge(Challenge challenge) throws DataAccessException {
		challengeDao.updateChallenge(challenge);
	}

	public void createCollectionVideo(CollectionVideo collectionVideo)
			throws DataAccessException {
		collectionVideoDao.createCollectionVideo(collectionVideo);
	}

	public void deleteCollectionVideo(Long id) throws DataAccessException {
		collectionVideoDao.deleteCollectionVideo(id);
	}

	public void getCollectionVideoes(Pagination<CollectionVideo> pagination)
			throws DataAccessException {
		collectionVideoDao.getCollectionVideoes(pagination);

	}

	public void createComment(Comment comment) throws DataAccessException {
		commentDao.createComment(comment);
	}

	public void deleteComment(Long id) throws DataAccessException {
		commentDao.deleteComment(id);
	}

	public void getComments(Pagination<Comment> pagination)
			throws DataAccessException {
		commentDao.getComments(pagination);
	}

	public void updateComment(Comment comment) throws DataAccessException {
		commentDao.updateComment(comment);
	}

	public void createDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		dailyChannelDao.createDailyChannel(dailyChannel);
	}

	public void deleteDailyChannel(Long id) throws DataAccessException {
		dailyChannelDao.deleteDailyChannel(id);
	}

	public DailyChannel getDailyChannelById(Long id) throws DataAccessException {
		DailyChannel dailyChannel = dailyChannelDao.getDailyChannelById(id);
		return dailyChannel;
	}

	public List<DailyChannel> getDailyChannels() throws DataAccessException {
		List<DailyChannel> dailyChannelList = dailyChannelDao
				.getDailyChannels();
		return dailyChannelList;
	}

	public void updateDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		dailyChannelDao.updateDailyChannel(dailyChannel);
	}

	public Daily createDaily(Daily daily) throws DataAccessException {
		daily = dailyDao.createDaily(daily);
		return daily;
	}

	public void deleteDaily(Long id) throws DataAccessException {
		dailyDao.deleteDaily(id);
	}

	public void getDailies(Pagination<Daily> pagination)
			throws DataAccessException {
		dailyDao.getDailies(pagination);
	}

	public Daily getDailyById(Long id) throws DataAccessException {
		Daily daily = dailyDao.getDailyById(id);
		return daily;
	}

	public void updateDaily(Daily daily) throws DataAccessException {
		dailyDao.updateDaily(daily);
	}

	public void createDailyReply(DailyReply dailyReply)
			throws DataAccessException {
		dailyReplyDao.createDailyReply(dailyReply);
	}

	public void getDailyReplies(Pagination<DailyReply> pagination)
			throws DataAccessException {
		dailyReplyDao.getDailyReplies(pagination);
	}

	public DailyReply getDailyReplyById(long id) throws DataAccessException {
		DailyReply dailyReply = dailyReplyDao.getDailyReplyById(id);
		return dailyReply;
	}

	public void createGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		groupAndUserDao.createGroupAndUser(groupAndUser);
	}

	public void deleteGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException {
		groupAndUserDao.deleteGroupAndUser(groupAndUser);
	}

	public void getGroupAndUsers(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		groupAndUserDao.getGroupAndUsers(pagination);
	}

	public void updateGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		groupAndUserDao.updateGroupAndUser(groupAndUser);
	}

	public Group createGroup(Group group) throws DataAccessException {
		group = groupDao.createGroup(group);
		return group;
	}

	public void deleteGroup(Long id) throws DataAccessException {
		groupDao.deleteGroup(id);
	}

	public Group getGroupById(Long id) throws DataAccessException {
		Group group = groupDao.getGroupById(id);
		return group;
	}

	public void getGroups(Pagination<Group> pagination)
			throws DataAccessException {
		groupDao.getGroups(pagination);
	}

	public void updateGroup(Group group) throws DataAccessException {
		groupDao.updateGroup(group);
	}

	public void createIndexRecommendVideo(
			IndexRecommendVideo indexRecommendVideo) throws DataAccessException {
		indexRecommendVideoDao.createIndexRecommendVideo(indexRecommendVideo);
	}

	public void deleteIndexRecommendVideo() throws DataAccessException {
		indexRecommendVideoDao.deleteIndexRecommendVideo();
	}

	public IndexRecommendVideo getBackVideoById(Long id)
			throws DataAccessException {
		IndexRecommendVideo indexRecommendVideo = indexRecommendVideoDao
				.getBackVideoById(id);
		return indexRecommendVideo;
	}

	public IndexRecommendVideo getFrontVideoById(Long id)
			throws DataAccessException {
		IndexRecommendVideo indexRecommendVideo = indexRecommendVideoDao
				.getFrontVideoById(id);
		return indexRecommendVideo;
	}

	public IndexRecommendVideo getIndexRecommendVideoById(Long id)
			throws DataAccessException {
		IndexRecommendVideo indexRecommendVideo = indexRecommendVideoDao
				.getIndexRecommendVideoById(id);
		return indexRecommendVideo;
	}

	public List<IndexRecommendVideo> getIndexRecommendVideoes()
			throws DataAccessException {
		List<IndexRecommendVideo> indexRecommendVideoList = indexRecommendVideoDao
				.getIndexRecommendVideoes();
		return indexRecommendVideoList;
	}

	public void updateIndexRecommendVideo(
			IndexRecommendVideo indexRecommendVideo) throws DataAccessException {
		indexRecommendVideoDao.updateIndexRecommendVideo(indexRecommendVideo);
	}

	public void createKeywordChannel(KeywordChannel keywordChannel)
			throws DataAccessException {
		keywordChannelDao.createKeywordChannel(keywordChannel);
	}

	public void deleteKeywordChannel(Long id) throws DataAccessException {
		keywordChannelDao.deleteKeywordChannel(id);
	}

	public KeywordChannel getKeywordChannel(Long id) throws DataAccessException {
		KeywordChannel keywordChannel = keywordChannelDao.getKeywordChannel(id);
		return keywordChannel;
	}

	public List<KeywordChannel> getKeywordChannels() throws DataAccessException {
		List<KeywordChannel> keywordChannelList = keywordChannelDao
				.getKeywordChannels();
		return keywordChannelList;
	}

	public void updateKeywordChannel(KeywordChannel keywordChannel)
			throws DataAccessException {
		keywordChannelDao.updateKeywordChannel(keywordChannel);
	}

	public void createMayLikeVideo(MayLikeVideo mayLikeVideo)
			throws DataAccessException {
		mayLikeVideoDao.createMayLikeVideo(mayLikeVideo);
	}

	public void deleteMayLikeVideo() throws DataAccessException {
		mayLikeVideoDao.deleteMayLikeVideo();
	}

	public MayLikeVideo getBackVideoeById(Long id) throws DataAccessException {
		MayLikeVideo mayLikeVideo = mayLikeVideoDao.getBackVideoeById(id);
		return mayLikeVideo;
	}

	public MayLikeVideo getFrontVideoeById(Long id) throws DataAccessException {
		MayLikeVideo mayLikeVideo = mayLikeVideoDao.getFrontVideoeById(id);
		return mayLikeVideo;
	}

	public MayLikeVideo getMayLikeVideoById(Long id) throws DataAccessException {
		MayLikeVideo mayLikeVideo = mayLikeVideoDao.getMayLikeVideoById(id);
		return mayLikeVideo;
	}

	public List<MayLikeVideo> getMayLikeVideoes() throws DataAccessException {
		List<MayLikeVideo> mayLikeVideoList = mayLikeVideoDao
				.getMayLikeVideoes();
		return mayLikeVideoList;
	}

	public void updateMayLikeVideo(MayLikeVideo mayLikeVideo)
			throws DataAccessException {
		mayLikeVideoDao.updateMayLikeVideo(mayLikeVideo);
	}

	public Playbill createPlaybill(Playbill playbill)
			throws DataAccessException {
		playbill = playbillDao.createPlaybill(playbill);
		return playbill;
	}

	public void deletePlaybill(Long id) throws DataAccessException {
		playbillDao.deletePlaybill(id);
	}

	public Playbill getPlaybill(Long id) throws DataAccessException {
		Playbill playbill = playbillDao.getPlaybill(id);
		return playbill;
	}

	public void getPlaybills(Pagination<Playbill> pagination)
			throws DataAccessException {
		playbillDao.getPlaybills(pagination);
	}

	public void updatePlaybill(Playbill playbill) throws DataAccessException {
		playbillDao.updatePlaybill(playbill);
	}

	public void updateVideoAndPagination(Playbill playbill, List<Video> videoes)
			throws DataAccessException {
		playbillDao.updateVideoAndPagination(playbill, videoes);
	}

	public void createSubscribeDaily(SubscribeDaily subscribeDaily)
			throws DataAccessException {
		subscribeDailyDao.createSubscribeDaily(subscribeDaily);
	}

	public void deleteSubscribeDaily(Long id) throws DataAccessException {
		subscribeDailyDao.deleteSubscribeDaily(id);
	}

	public void getDailySubscribeDailies(Pagination<SubscribeDaily> pagination)
			throws DataAccessException {
		subscribeDailyDao.getDailySubscribeDailies(pagination);
	}

	public void createSubscribeGroup(SubscribeGroup subscribeGroup)
			throws DataAccessException {
		subscribeGroupDao.createSubscribeGroup(subscribeGroup);
	}

	public void deleteSubscribeGroup(Long id) throws DataAccessException {
		subscribeGroupDao.deleteSubscribeGroup(id);
	}

	public void getDailySubscribeGroups(Pagination<SubscribeGroup> pagination)
			throws DataAccessException {
		subscribeGroupDao.getDailySubscribeGroups(pagination);
	}

	public void createSubscribePlaybill(SubscribePlaybill subscribePlaybill)
			throws DataAccessException {
		subscribePlaybillDao.createSubscribePlaybill(subscribePlaybill);
	}

	public void deleteSubscribePlaybill(Long id) throws DataAccessException {
		subscribePlaybillDao.deleteSubscribePlaybill(id);
	}

	public void getSubscribePlaybills(Pagination<SubscribePlaybill> pagination)
			throws DataAccessException {
		subscribePlaybillDao.getSubscribePlaybills(pagination);
	}

	public void createSubscribeVideo(SubscribeVideo subscribeVideo)
			throws DataAccessException {
		subscribeVideoDao.createSubscribeVideo(subscribeVideo);
	}

	public void deleteSubscribeVideo(Long id) throws DataAccessException {
		subscribeVideoDao.deleteSubscribeVideo(id);
	}

	public void getSubscribeVideoes(Pagination<SubscribeVideo> pagination)
			throws DataAccessException {
		subscribeVideoDao.getSubscribeVideoes(pagination);
	}

	public void createSystemKeyword(SystemKeyword systemKeyword)
			throws DataAccessException {
		systemKeywordDao.createSystemKeyword(systemKeyword);
	}

	public void deleteSystemKeyword(Long id) throws DataAccessException {
		systemKeywordDao.deleteSystemKeyword(id);
	}

	public SystemKeyword getSystemKeywordById(Long id)
			throws DataAccessException {
		SystemKeyword systemKeyword = systemKeywordDao.getSystemKeywordById(id);
		return systemKeyword;
	}

	public void getSystemKeywords(Pagination<SystemKeyword> pagination)
			throws DataAccessException {
		systemKeywordDao.getSystemKeywords(pagination);
	}

	public void updateSystemKeyword(SystemKeyword systemKeyword)
			throws DataAccessException {
		systemKeywordDao.updateSystemKeyword(systemKeyword);
	}

	public Tag createTag(Tag tag) throws DataAccessException {
		if (tagDao.getTagByName(tag.getName()) == null) {
			tagDao.createTag(tag);
		}
		
		return tag;

	}

	public void deleteTag(Long id) throws DataAccessException {
		tagDao.deleteTag(id);
	}

	public Tag getTagById(Long id) throws DataAccessException {
		Tag tag = tagDao.getTagById(id);
		return tag;
	}

	public void getTags(Pagination<Tag> pagination) throws DataAccessException {
		tagDao.getTags(pagination);
		if (pagination.getResults() != null) {

			for (Tag tag : pagination.getResults()) {

				List<Video> list = tagDao.getVideoesByTagId(tag.getId());
				Set<Video> set = new HashSet<Video>();
				for (Video video : list) {
					set.add(video);
				}
				tag.setVideoes(set);
			}
		}
	}

	public void updateTag(Tag tag) throws DataAccessException {
		tagDao.updateTag(tag);
	}

	public void createTopic(Topic topic) throws DataAccessException {
		topicDao.createTopic(topic);
	}

	public void deleteTopic(Long id) throws DataAccessException {
		topicDao.deleteTopic(id);
	}

	public Topic getTopicById(Long id) throws DataAccessException {
		Topic topic = topicDao.getTopicById(id);
		return topic;
	}

	public void getTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		topicDao.getTopices(pagination);
	}

	public void updateTopic(Topic topic) throws DataAccessException {
		topicDao.updateTopic(topic);
	}

	public void createTopicComment(TopicComment topicComment)
			throws DataAccessException {
		topicCommentDao.createTopicComment(topicComment);
	}

	public void deleteTopicComment(Long id) throws DataAccessException {
		topicCommentDao.deleteTopicComment(id);
	}

	public TopicComment getTopicCommentById(Long id) throws DataAccessException {
		TopicComment topicComment = topicCommentDao.getTopicCommentById(id);
		return topicComment;
	}

	public void getTopicComments(Pagination<TopicComment> pagination)
			throws DataAccessException {
		topicCommentDao.getTopicComments(pagination);
	}

	public void updateTopicComment(TopicComment topicComment)
			throws DataAccessException {
		topicCommentDao.updateTopicComment(topicComment);
	}

	public void createUploadVideo(UploadVideo uploadVideo)
			throws DataAccessException {
		uploadVideoDao.createUploadVideo(uploadVideo);
	}

	public void deleteUploadVideo(Long id) throws DataAccessException {
		uploadVideoDao.deleteUploadVideo(id);
	}

	public UploadVideo getUploadVideoById(Long id) throws DataAccessException {
		UploadVideo uploadVideo = uploadVideoDao.getUploadVideoById(id);
		Video video = this.videoDao.getVideoById(uploadVideo.getVideo().getId());
		uploadVideo.setVideo(video);
		return uploadVideo;
	}

	public void getUploadVideoes(Pagination<UploadVideo> pagination)
			throws DataAccessException {
		uploadVideoDao.getUploadVideoes(pagination);
	}

	public void updateUploadVideo(UploadVideo uploadVideo)
			throws DataAccessException {
		uploadVideoDao.updateUploadVideo(uploadVideo);
	}

	public User createUser(User user) throws DataAccessException {
		userDao.createUser(user);
		return user;
	}

	public void deleteUser(Long id) throws DataAccessException {
		userDao.deleteUser(id);
	}

	public User getUserById(Long id) throws DataAccessException {
		User user = userDao.getUserById(id);
		return user;
	}

	public void getUsers(Pagination<User> pagination)
			throws DataAccessException {
		userDao.getUsers(pagination);
	}

	public void updateUser(User user) throws DataAccessException {
		userDao.updateUser(user);
	}

	public void createUserKeyword(UserKeyword userKeyword)
			throws DataAccessException {
		userKeywordDao.createUserKeyword(userKeyword);
	}

	public void deleteUserKeywordByName(String name) throws DataAccessException {
		userKeywordDao.deleteUserKeywordByName(name);
	}

	public List<UserKeyword> getUserKeywords() throws DataAccessException {
		List<UserKeyword> userKeywordList = userKeywordDao.getUserKeywords();
		return userKeywordList;
	}

	public void createVideoChannel(VideoChannel videoChannel)
			throws DataAccessException {
		videoChannelDao.createVideoChannel(videoChannel);
	}

	public void deleteVideoChannel(Long id) throws DataAccessException {
		videoChannelDao.deleteVideoChannel(id);
	}

	public VideoChannel getVideoChannelById(Long id) throws DataAccessException {
		VideoChannel videoChannel = videoChannelDao.getVideoChannelById(id);
		return videoChannel;
	}

	public List<VideoChannel> getVideoChannels(VideoChannel videoChannel)
			throws DataAccessException {
		List<VideoChannel> videoChannelList = videoChannelDao
				.getVideoChannels(videoChannel);
		return videoChannelList;
	}

	public void updateVideoChannel(VideoChannel videoChannel)
			throws DataAccessException {
		videoChannelDao.updateVideoChannel(videoChannel);
	}

	public Video createVideo(Video video) throws DataAccessException {
		video = videoDao.createVideo(video);
		return video;
	}

	public void deleteVideo(Long id) throws DataAccessException {
		videoDao.deleteVideo(id);
	}

	public Video getVideoById(Long id) throws DataAccessException {
		return  videoDao.getVideoById(id);
	}

	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException {
		videoDao.getVideoes(pagination);
	}

	public void updateVideo(Video video) throws DataAccessException {
		videoDao.updateVideo(video);
	}

	public void createWhisper(Whisper whisper) throws DataAccessException {
		whisperDao.createWhisper(whisper);
	}

	public void deleteWhisper(Long id) throws DataAccessException {
		whisperDao.deleteWhisper(id);
	}

	public void getWhispers(Pagination<Whisper> pagination)
			throws DataAccessException {
		whisperDao.getWhispers(pagination);
	}

	public User getUserByEmail(String email) throws DataAccessException {
		User user = userDao.getUserByEmail(email);
		return user;
	}

	public User getUserByName(String userName) throws DataAccessException {
		User user = userDao.getUserByName(userName);
		return user;
	}

	public User getUserByRealName(String realName) throws DataAccessException {
		User user = userDao.getUserByRealName(realName);
		return user;
	}

	public void getDailyChannelPage(Pagination<DailyChannel> pagination)
			throws DataAccessException {
		dailyChannelDao.getDailyChannelPage(pagination);
	}

	public List<UserLevel> getUserLevels() throws DataAccessException {
		return userDao.getUserLevels();
	}

	public List<Video> getVideoesByTagId(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void listUsers(Pagination<User> pagination)
			throws DataAccessException {
		userDao.listUsers(pagination);

	}

	public void createMessages(Integer grade, String message)
			throws DataAccessException {
		User user1 = new User();
		user1.setGrade(grade);
		Pagination<User> pagination = new Pagination<User>();

		if (grade != null) {
			pagination.setCondition(user1);
		}

		userDao.listUsers(pagination);
		System.out.println(pagination.getResults().size());
		User fromUser = new User();
		fromUser.setId(new Long(0));
		for (User user : pagination.getResults()) {
			Whisper whisper = new Whisper();

			whisper.setFromUser(fromUser);
			whisper.setSendDate(new Date());
			whisper.setStatus(0);
			whisper.setToUser(user);
			whisper.setMessage(message);
			whisperDao.createWhisper(whisper);
		}

	}

	public void deleteWhisperByGrade(User user) throws DataAccessException {
		whisperDao.deleteWhisperByGrade(user);

	}

	public void deleteWhisperByDate(int dayNum) throws DataAccessException {
		whisperDao.deleteWhisperByDate(dayNum);

	}

	public Tag getTagByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Administrator> getAdministratorList()
			throws DataAccessException {
		return administratorDao.getAdministratorList();
	}

	public List<DailyChannel> getRootDailyChannels() throws DataAccessException {
		return dailyChannelDao.getRootDailyChannels();
	}

	public void updateDailyChannelOrders(DailyChannel dailyChannel)
			throws DataAccessException {
		dailyChannelDao.updateDailyChannelOrders(dailyChannel);
	}

	public List<DailyChannel> getDailyChannelsByParentId(Long parentId)
			throws DataAccessException {
		return dailyChannelDao.getDailyChannelsByParentId(parentId);
	}

	public void updateRepositionDailyChannelOrders() throws DataAccessException {
		dailyChannelDao.updateRepositionDailyChannelOrders();

	}

	public DailyChannel getParentDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		return dailyChannelDao.getParentDailyChannel(dailyChannel);
	}

	public void updateUniteDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		dailyChannelDao.updateUniteDailyChannel(dailyChannel);
	}

	public void updateDailyByChannelId(Daily daily) throws DataAccessException {
		dailyDao.updateDailyByChannelId(daily);

	}

	public List<Daily> getDailysByChannelId(Long id) throws DataAccessException {

		return dailyDao.getDailysByChannelId(id);
	}

	public void updateDailyCleanByChannelId(Long id) throws DataAccessException {
		dailyDao.updateDailyCleanByChannelId(id);
	}

	public void deleteDailyByChannelId(Long id) throws DataAccessException {
		dailyDao.deleteDailyByChannelId(id);
	}

	public void createDailyTag(DailyTag tag) throws DataAccessException {
		dailyTagDao.createDailyTag(tag);

	}

	public void deleteDailyTag(Long id) throws DataAccessException {
		dailyTagDao.deleteDailyTag(id);

	}

	public DailyTag getDailyTagById(Long id) throws DataAccessException {

		return dailyTagDao.getDailyTagById(id);
	}

	public DailyTag getDailyTagByName(String name) throws DataAccessException {

		return dailyTagDao.getDailyTagByName(name);
	}

	public void getDailyTags(Pagination<DailyTag> pagination)
			throws DataAccessException {
		dailyTagDao.getDailyTags(pagination);
		if (pagination.getResults() != null) {
			for (DailyTag tag : pagination.getResults()) {

				List<Daily> list = dailyTagDao.getDailysByTagId(tag.getId());
				Set<Daily> set = new HashSet<Daily>();
				for (Daily daily : list) {
					set.add(daily);
				}
				tag.setDailies(set);
			}
		}

	}

	public List<Daily> getDailysByTagId(Long id) throws DataAccessException {
		return null;
	}

	public void updateDailyTag(DailyTag tag) throws DataAccessException {
		dailyTagDao.updateDailyTag(tag);

	}

	public void createDailyAndTag(DailyAndTag dailyAndTag) {
		dailyAndTagDao.createDailyAndTag(dailyAndTag);

	}

	public void deleteDailyAndTagByDailyId(Long id) {
		dailyAndTagDao.deleteDailyAndTagByDailyId(id);
	}

	public void deleteDailyAndTagByDailyIdAndTagId(DailyAndTag dailyAndTag) {
		dailyAndTagDao.deleteDailyAndTagByDailyIdAndTagId(dailyAndTag);
	}

	public void deleteDailyAndTagByTagId(Long id) {
		dailyAndTagDao.deleteDailyAndTagByTagId(id);
	}

	public List<DailyAndTag> getDailyAndTagByDailyId(Long id) {
		return dailyAndTagDao.getDailyAndTagByDailyId(id);
	}

	public List<DailyAndTag> getDailyAndTagByTagId(Long id) {
		return dailyAndTagDao.getDailyAndTagByTagId(id);
	}

	public void updateDailyWithChannelIdById(Daily daily)
			throws DataAccessException {
		dailyDao.updateDailyWithChannelIdById(daily);

	}

	public void updateDailyHotById(Daily daily) throws DataAccessException {
		dailyDao.updateDailyHotById(daily);
	}

	public void updateDailyRecommendById(Daily daily)
			throws DataAccessException {
		dailyDao.updateDailyRecommendById(daily);

	}

	public void updateDailyTopById(Daily daily) throws DataAccessException {
		dailyDao.updateDailyTopById(daily);
	}

	public List<DailyChannel> getOtherDailyChannelByDailyId(Long id)
			throws DataAccessException {
		return dailyDao.getOtherDailyChannelByDailyId(id);
	}

	public void deleteDailyReplyById(long id) throws DataAccessException {
		dailyReplyDao.deleteDailyReplyById(id);
	}

	public void updateDailyReplyById(DailyReply dailyReply)
			throws DataAccessException {
		dailyReplyDao.updateDailyReplyById(dailyReply);
	}

	public Whisper getWhisperById(Long id) throws DataAccessException {

		return whisperDao.getWhisperById(id);
	}

	public List<VideoChannel> getVideoChannelList() throws DataAccessException {

		return videoChannelDao.getVideoChannelList();
	}

	public List<VideoChannel> getChildVideoChannelList(Long parentId)
			throws DataAccessException {
		return videoChannelDao.getChildVideoChannelList(parentId);
	}

	public void updateVideoByVideoChannelId(Video video)
			throws DataAccessException {
		videoDao.updateVideoByVideoChannelId(video);
	}

	public void deleteVideoByChannelId(Long id) throws DataAccessException {
		videoDao.deleteVideoByChannelId(id);
	}

	public void updateVideoChannelWithParent(VideoChannel videoChannel)
			throws DataAccessException {
		videoChannelDao.updateVideoChannelWithParent(videoChannel);
	}

	public void updateVideoChannelWithParentByParent(VideoChannel videoChannel)
			throws DataAccessException {
		videoChannelDao.updateVideoChannelWithParentByParent(videoChannel);
	}

	public void updateVideoWithChannelByVideoChannelId(Video video)
			throws DataAccessException {
		videoDao.updateVideoWithChannelByVideoChannelId(video);
	}

	
	public void getOhterUsersByGroupId(Pagination<User> pagination)
			throws DataAccessException {
		System.out.println("--1--");
		  groupDao.getOhterUsersByGroupId(pagination);
	}

	
	public void getUsersByGroupId(Pagination<User> pagination) throws DataAccessException {
		  groupDao.getUsersByGroupId(pagination);
	}



	public void createGroupAndUsers(List<User> users, Group group)
			throws DataAccessException {
		for(User user:users){
		
			GroupAndUser groupAndUser = new GroupAndUser();
			groupAndUser.setUser(user);
			groupAndUser.setGroup(group);
			groupAndUser.setAddDate(new Date());
			groupAndUserDao.createGroupAndUser(groupAndUser);
			
			
		}
		
	}


	public void deleteGroupAndUsers(List<User> users, Group group)
			throws DataAccessException {
		for(User user:users){
			GroupAndUser groupAndUser = new GroupAndUser();
			groupAndUser.setUser(user);
			groupAndUser.setGroup(group);
			groupAndUserDao.deleteGroupAndUser(groupAndUser);
			
			
		}
		
	}

	public KeywordChannel getKeywordChannelByName(String name)
			throws DataAccessException {
		return keywordChannelDao.getKeywordChannelByName(name);
	}


	public List<CandidateVideo> getCandidateVideoeList()
			throws DataAccessException {
		
		return candidateVideoDao.getCandidateVideoeList();
	}


	public CandidateVideo getCandidateVideoByVideoId(Long vid)
			throws DataAccessException {
		return candidateVideoDao.getCandidateVideoByVideoId(vid);
	}


	public List<Comment> getCommentsByVideoId(Long id)
			throws DataAccessException {
		
		return commentDao.getCommentsByVideoId(id);
	}

	
	public void createVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
	if(playbillDao.getVideoAndPlayBill(videoAndPlayBill)==null){
		playbillDao.createVideoAndPlayBill(videoAndPlayBill);
	}
		
	}


	public VideoAndPlayBill getVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
		return null;
		
	}


	public void deleteVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
		playbillDao.deleteVideoAndPlayBill(videoAndPlayBill);
		
	}


	public void deleteCandidateVideo(Long id) throws DataAccessException {
		candidateVideoDao.deleteCandidateVideo(id);
		
	}



	public void updateKeywordChannelWithOrder(KeywordChannel keywordChannel)
			throws DataAccessException {
		keywordChannelDao.updateKeywordChannelWithOrder(keywordChannel);
	}

	public void deleteSystemKeywordByChannelId(Long id)
			throws DataAccessException {
		systemKeywordDao.deleteSystemKeywordByChannelId(id);
	}

	public List<SystemKeyword> getSystemKeywordByChannelId(Long id)
			throws DataAccessException {
		return systemKeywordDao.getSystemKeywordByChannelId(id);
	}

	public void createSystemNotice(Integer grade,SystemNotice systemNotice)
			throws DataAccessException {
		User user1 = new User();
		user1.setGrade(grade);
		Pagination<User> pagination = new Pagination<User>();

		if (grade != null) {
			pagination.setCondition(user1);
		}

		userDao.listUsers(pagination);
		System.out.println(pagination.getResults().size());
		User fromUser = new User();
		fromUser.setId(new Long(0));
		for (User user : pagination.getResults()) {
			
			systemNotice.setUser(user);
			this.systemNoticeDao.createSystemNotice(systemNotice);
		}
		
	}

	public void deleteSystemNoticeByDate(int dayNum) throws DataAccessException {
		this.systemNoticeDao.deleteSystemNoticeByDate(dayNum);
		
	}

	public void deleteSystemNoticeByGrade(User user) throws DataAccessException {
		this.systemNoticeDao.deleteSystemNoticeByGrade(user);
		
	}

	public void getSystemNotices(Pagination<SystemNotice> pagination)
			throws DataAccessException {
		this.systemNoticeDao.getSystemNotices(pagination);
		
	}

	public void createSystemNotice(SystemNotice systemNotice)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public SystemNotice getSystemNoticeById(Long id) throws DataAccessException {
		return this.systemNoticeDao.getSystemNoticeById(id);
	}

	public void deleteSystemNoticeBySendDate(SystemNotice systemNotice)
			throws DataAccessException {
		this.systemNoticeDao.deleteSystemNoticeBySendDate(systemNotice);
		
	}

	public List<Long> getStarIds() throws DataAccessException {
	
		return this.userDao.getStarIds();
	}

	public void updateStar(Star star) throws DataAccessException {
		this.userDao.updateStar(star);
		
	}

	public List<Group> getRecommendGroups() throws DataAccessException {
		
		return this.groupDao.getRecommendGroups();
	}

	public void deleteRecommendGroups() throws DataAccessException {
		
		this.groupDao.deleteRecommendGroups();
		
	}

	public void creatRecommendGroup(Group group) throws DataAccessException {
	   
		this.groupDao.creatRecommendGroup(group);
		
	}

	public void updateRecommendGroups(List<Group> gruops)
			throws DataAccessException {
		this.groupDao.deleteRecommendGroups();
		for(Group group:gruops){
			this.groupDao.creatRecommendGroup(group);
			
		}
		
	}

	public List<Tag> getTagsByVideo(Long id) throws DataAccessException {
	
		return this.tagDao.getTagsByVideo(id);
	}

	public void updateVideoAndTag(List<Tag> tags,Long videoId) throws DataAccessException {
		this.tagDao.deleteVideoAndTagsByVideoId(videoId);
		for(Tag tag:tags){
			Tag tag1 = this.tagDao.getTagByName(tag.getName());
			if(tag1==null){
				tag.setBrowseCount(0);
				tag.setCreateDate(new Date());
				User user = new User();
				user.setId(new Long(1));
				tag.setUser(user);
				tag.setStatus(1);
				tag1 = this.tagDao.createTag(tag);
			}
			
			VideoAndTag videoAndTag = new VideoAndTag();
			videoAndTag.setVideoId(videoId);
			videoAndTag.setTagId(tag1.getId());
			this.tagDao.creatVideoAndTag(videoAndTag);
			
		}
		
	}


	public void deleteVideoAndTagsByVideoId(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void creatVideoAndTag(VideoAndTag videoAndTag)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void createNotice(Notice notice) throws DataAccessException {
	this.noticeDao.createNotice(notice);
		
	}

	public void deleteNoticeById(Long id) throws DataAccessException {
		this.noticeDao.deleteNoticeById(id);
		
	}

	public List<Notice> getNotices() throws DataAccessException {
		
		return this.noticeDao.getNotices();
	}

	public void updateNotice(Notice notice) throws DataAccessException {
		this.noticeDao.updateNotice(notice);
		
	}

	public Notice getNoticeById(Long id) throws DataAccessException {
		
		return this.noticeDao.getNoticeById(id);
	}

	
	
	


	

	
}
