package com.video.domain.logic;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.BlogHistory;
import com.video.domain.BlogWord;
import com.video.domain.BrowseHistoryVideo;
import com.video.domain.CollectionVideo;
import com.video.domain.CommendPlaybill;
import com.video.domain.Comment;
import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyComment;
import com.video.domain.DailyHistory;
import com.video.domain.DailyTag;
import com.video.domain.Event;
import com.video.domain.Friend;
import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.GroupHistory;
import com.video.domain.GroupRequest;
import com.video.domain.IndexRecommendVideo;
import com.video.domain.IsSubscribe;
import com.video.domain.KeywordChannel;
import com.video.domain.MayLikeVideo;
import com.video.domain.Notice;
import com.video.domain.Playbill;
import com.video.domain.PlaybillChannel;
import com.video.domain.PlaybillCommet;
import com.video.domain.PointHistory;
import com.video.domain.SafeCode;
import com.video.domain.SubscribeUser;
import com.video.domain.SystemKeyword;
import com.video.domain.SystemKeywordChange;
import com.video.domain.SystemKeywordTerm;
import com.video.domain.SystemNotice;
import com.video.domain.Tag;
import com.video.domain.TagStrongUser;
import com.video.domain.Topic;
import com.video.domain.TopicComment;
import com.video.domain.UploadVideo;
import com.video.domain.User;
import com.video.domain.UserKeyword;
import com.video.domain.Video;
import com.video.domain.VideoAndPlayBill;
import com.video.domain.VideoChannel;
import com.video.domain.Whisper;
import com.video.domain.connection.ChannelCount;
import com.video.domain.connection.Condition;
import com.video.service.EventService;
import com.video.service.GroupService;
import com.video.service.PlaybillService;
import com.video.service.SearchService;
import com.video.service.UserService;
import com.video.service.VideoCommentService;
import com.video.service.VideoService;
import com.video.service.VideoTagService;
import com.video.service.WhisperService;
import com.video.util.Pagination;

public class AllServiceImpl implements AllServiceFacade {

	private UserService userService;
	private GroupService groupService;
	private VideoService videoService;
	private VideoTagService videoTagService;
	private SearchService searchService;
	private PlaybillService playbillService;
	private VideoCommentService videoCommentService;
	private WhisperService whisperService;
	private EventService eventService;

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public WhisperService getWhisperService() {
		return whisperService;
	}

	public void setWhisperService(WhisperService whisperService) {
		this.whisperService = whisperService;
	}

	public VideoCommentService getVideoCommentService() {
		return videoCommentService;
	}

	public void setVideoCommentService(VideoCommentService videoCommentService) {
		this.videoCommentService = videoCommentService;
	}

	public PlaybillService getPlaybillService() {
		return playbillService;
	}

	public void setPlaybillService(PlaybillService playbillService) {
		this.playbillService = playbillService;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public VideoService getVideoService() {
		return videoService;
	}

	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}

	public User getUserById(Long id) throws DataAccessException {
		return this.userService.getUserById(id);
	}

	public void updateUser(User user) throws DataAccessException {
		this.userService.updateUser(user);

	}

	public List<IndexRecommendVideo> getIndexRecommendVideoes()
			throws DataAccessException {

		return this.videoService.getIndexRecommendVideoes();
	}

	public List<MayLikeVideo> getMayLikeVideoes() throws DataAccessException {
		return this.videoService.getMayLikeVideoes();
	}

	public void getPlayBills(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.videoService.getPlayBills(pagination);

	}

	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getVideoes(pagination);

	}

	public void getFriends(Pagination<User> pagination)
			throws DataAccessException {
		this.userService.getFriends(pagination);

	}

	public void getWhispers(Pagination<Whisper> pagination)
			throws DataAccessException {
		this.whisperService.getWhispers(pagination);

	}

	public List<Tag> getHotVideoTag() {
		return this.videoTagService.getHotVideoTag();
	}

	public List<Tag> getMyVideoTag(Pagination<Tag> pagination) {
		return this.videoTagService.getMyVideoTag(pagination);
	}

	public List<Tag> getNewVideoTag() {
		return this.videoTagService.getNewVideoTag();
	}

	public VideoTagService getVideoTagService() {
		return videoTagService;
	}

	public void setVideoTagService(VideoTagService videoTagService) {
		this.videoTagService = videoTagService;
	}

	public List<Tag> getLikeVideoTag() {
		return this.videoTagService.getLikeVideoTag();
	}

	public List<TagStrongUser> getTagStrongUser(int size) {
		return this.videoTagService.getTagStrongUser(size);
	}

	public void getTopUsers(Pagination<User> pagination)
			throws DataAccessException {
		this.userService.getTopUsers(pagination);

	}

	public void getSubscibeUsers(Pagination<SubscribeUser> pagination)
			throws DataAccessException {
		this.userService.getSubscibeUsers(pagination);

	}

	public List<KeywordChannel> getKeywordChannelOrder() {
		return this.searchService.getKeywordChannelOrder();
	}

	public List<SystemKeyword> getSystemKeywordByChannelId(Long id) {
		return this.searchService.getSystemKeywordByChannelId(id);
	}

	public List<SystemKeywordChange> getSystemKeywordWithForeFront(
			SystemKeywordTerm term) {
		return this.searchService.getSystemKeywordWithForeFront(term);
	}

	public List<UserKeyword> getUserSearchWithForeFront(int size) {
		return this.searchService.getUserSearchWithForeFront(size);
	}

	public void getVideoByTagId(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getVideoByTagId(pagination);
	}

	public void getUsersOrderByBrowseTimes(Pagination<User> pagination)
			throws DataAccessException {
		this.userService.getUsersOrderByBrowseTimes(pagination);

	}

	public void getUsersOrderByNewVideo(Pagination<User> pagination)
			throws DataAccessException {
		this.userService.getUsersOrderByNewVideo(pagination);

	}

	public void getUsersOrderByCommentCount(Pagination<User> pagination)
			throws DataAccessException {
		this.userService.getUsersOrderByCommentCount(pagination);

	}

	public User getUser2ById(Long id) throws DataAccessException {

		return this.userService.getUser2ById(id);
	}

	public void createBlogWord(BlogWord blogWord) throws DataAccessException {
		this.userService.createBlogWord(blogWord);

	}

	public void deleteBlogWordById(Long id) throws DataAccessException {
		this.userService.deleteBlogWordById(id);

	}

	public void getBlogWords(Pagination<BlogWord> pagination)
			throws DataAccessException {
		this.userService.getBlogWords(pagination);

	}

	public void getVideoBykey(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getVideoBykey(pagination);
	}

	public List<CommendPlaybill> getCommendPlaybill()
			throws DataAccessException {
		return this.playbillService.getCommendPlaybill();
	}

	public void getMySubscribePlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillService.getMySubscribePlaybill(pagination);
	}

	public void getMyPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillService.getMyPlaybill(pagination);
	}

	public void getMyDailies(Pagination<Daily> pagination)
			throws DataAccessException {
		this.userService.getMyDailies(pagination);

	}

	public List<DailyChannel> getSimpleDailyChannels(Long userId)
			throws DataAccessException {

		return this.userService.getSimpleDailyChannels(userId);
	}

	public void getDailyTags(Pagination<DailyTag> pagination)
			throws DataAccessException {
		this.userService.getDailyTags(pagination);

	}

	public Daily getDailyById(Long id) throws DataAccessException {

		return this.userService.getDailyById(id);
	}

	public void createDailyComment(DailyComment dailyComment)
			throws DataAccessException {
		this.userService.createDailyComment(dailyComment);

	}

	public void deleteDailyCommentById(Long id) throws DataAccessException {
		this.userService.deleteDailyCommentById(id);

	}

	public void getDailyComment(Pagination<DailyComment> pagination)
			throws DataAccessException {
		this.userService.getDailyComment(pagination);

	}

	public void getBlogHistories(Pagination<BlogHistory> pagination)
			throws DataAccessException {
		this.userService.getBlogHistories(pagination);
	}

	public void getMyJoinGroups(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		this.groupService.getMyJoinGroups(pagination);

	}

	public void getTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		this.groupService.getTopices(pagination);

	}

	public void getMyGroupTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		this.groupService.getMyGroupTopices(pagination);

	}

	public Topic getTopicById(Long id) throws DataAccessException {
		return this.groupService.getTopicById(id);
	}

	public Group getGroupSimpleById(Long id) throws DataAccessException {
		return this.groupService.getGroupSimpleById(id);
	}

	public void getTopicesByGroupId(Pagination<Topic> pagination)
			throws DataAccessException {
		this.groupService.getTopicesByGroupId(pagination);

	}

	public void getTopicComments(Pagination<TopicComment> pagination)
			throws DataAccessException {
		this.groupService.getTopicComments(pagination);

	}

	public void createTopicComment(TopicComment topicComment)
			throws DataAccessException {
		this.groupService.createTopicComment(topicComment);

	}

	public void getVideoesByGroupId(Pagination<Video> pagination)
			throws DataAccessException {
		this.groupService.getVideoesByGroupId(pagination);

	}

	public void getPlayBillsByGroupId(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.groupService.getPlayBillsByGroupId(pagination);

	}

	public Group getGroupById(Long id) throws DataAccessException {

		return this.groupService.getGroupById(id);
	}

	public void getMyGroupMembers(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		this.groupService.getMyGroupMembers(pagination);
	}

	public void getVideoByPlaybill(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getVideoByPlaybill(pagination);
	}

	public Playbill getPlaybill(Long id) throws DataAccessException {
		return this.playbillService.getPlaybill(id);
	}

	public boolean isSubscribe(IsSubscribe isSubscribe)
			throws DataAccessException {
		return this.playbillService.isSubscribe(isSubscribe);
	}

	public void createSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException {
		this.playbillService.createSubscribePlaybill(isSubscribe);
	}

	public void deleteSubscribePlaybill(IsSubscribe isSubscribe)
			throws DataAccessException {
		this.playbillService.deleteSubscribePlaybill(isSubscribe);
	}

	public void createCommentPlaybill(PlaybillCommet commet)
			throws DataAccessException {
		this.playbillService.createCommentPlaybill(commet);
	}

	public void getCommentPlaybillByPlaybillId(
			Pagination<PlaybillCommet> pagination) throws DataAccessException {
		this.playbillService.getCommentPlaybillByPlaybillId(pagination);
	}

	public void updateCommendPlaybillWithBrowseCount(
			CommendPlaybill commendPlaybill) throws DataAccessException {
		this.playbillService
				.updateCommendPlaybillWithBrowseCount(commendPlaybill);
	}

	public void updatePlaybillWithBrowseCount(Playbill playbill)
			throws DataAccessException {
		this.playbillService.updatePlaybillWithBrowseCount(playbill);
	}

	public User getUserUsePlaybillById(User user) throws DataAccessException {
		return this.userService.getUserUsePlaybillById(user);
	}

	public void getOtherPlaybill(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillService.getOtherPlaybill(pagination);
	}

	public void getVideo(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getVideo(pagination);
	}

	public void getVideoByCommend(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getVideoByCommend(pagination);
	}

	public void getBrowseHistoryByUserId(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getBrowseHistoryByUserId(pagination);
	}

	public void getMyCommentVideo(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getMyCommentVideo(pagination);
	}

	public void getCommentByVideoId(Pagination<Comment> pagination)
			throws DataAccessException {
		this.videoCommentService.getCommentByVideoId(pagination);
	}

	public void getGroupHistories(Pagination<GroupHistory> pagination)
			throws DataAccessException {
		this.groupService.getGroupHistories(pagination);

	}

	public void createORupdateGroupRequest(GroupRequest groupRequest)
			throws DataAccessException {
		this.groupService.createORupdateGroupRequest(groupRequest);

	}

	public void deleteGroupRequestById(long id) throws DataAccessException {
		this.groupService.deleteGroupRequestById(id);

	}

	public List<GroupRequest> getGroupRequestsByGroupId(Long id)
			throws DataAccessException {

		return this.groupService.getGroupRequestsByGroupId(id);
	}

	public void createGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		this.groupService.createGroupAndUser(groupAndUser);

	}

	public void deleteGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		this.groupService.deleteGroupAndUser(groupAndUser);

	}

	public void createTopic(Topic topic) throws DataAccessException {
		this.groupService.createTopic(topic);
	}

	public void createOrUpdateGroupHistory(GroupHistory groupHistory)
			throws DataAccessException {
		this.groupService.createOrUpdateGroupHistory(groupHistory);

	}

	public void deleteTopicById(Long id) throws DataAccessException {
		this.groupService.deleteTopicById(id);

	}

	public Long getFriendId(Friend friend) throws DataAccessException {
		return this.userService.getFriendId(friend);
	}

	public void createFriend(Friend friend) throws DataAccessException {
		this.userService.createFriend(friend);

	}

	public void createUserRequest(SystemNotice systemNotice)
			throws DataAccessException {
		this.userService.createUserRequest(systemNotice);

	}

	public Video getVideoById(Long id, User user) throws DataAccessException {
		return this.videoService.getVideoById(id, user);
	}

	public void createComment(Comment comment) throws DataAccessException {
		this.videoCommentService.createComment(comment);
	}

	public void createWhisper(Whisper whisper) throws DataAccessException {
		this.whisperService.createWhisper(whisper);
	}

	public void getOtherUserByVideoId(Pagination<User> pagination)
			throws DataAccessException {
		this.userService.getOtherUserByVideoId(pagination);
	}

	public Video getInitVideo(Long id) throws DataAccessException {
		return this.videoService.getInitVideo(id);
	}

	public void createCollection(CollectionVideo collectionVideo)
			throws DataAccessException {
		this.videoService.createCollection(collectionVideo);
	}

	public void updateVideo(Video video) throws DataAccessException {
		this.videoService.updateVideo(video);
	}

	public void createPlaybill(Playbill playbill) throws DataAccessException {
		this.playbillService.createPlaybill(playbill);
	}

	public VideoAndPlayBill createVideoAndPlayBill(
			VideoAndPlayBill videoAndPlayBill) throws DataAccessException {
		this.playbillService.createVideoAndPlayBill(videoAndPlayBill);
		return videoAndPlayBill;
	}

	public void createSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException {
		this.userService.createSubscribe(subscribeUser);
	}

	public User getUser(User user) throws DataAccessException {
		return this.userService.getUser(user);
	}

	public void createUser(User user) throws DataAccessException {
		this.userService.createUser(user);
	}

	public Whisper getWhisperById(Long id) throws DataAccessException {

		return this.whisperService.getWhisperById(id);
	}

	public List<DailyChannel> getDailyChannels() throws DataAccessException {

		return this.userService.getDailyChannels();
	}

	public void agreeUserRequest(SystemNotice systemNotice)
			throws DataAccessException {
		this.userService.agreeUserRequest(systemNotice);

	}

	public SystemNotice getSystemNoticeById(Long id) throws DataAccessException {
		return this.whisperService.getSystemNoticeById(id);
	}

	public void getSystemNoticesByUserId(Pagination<SystemNotice> pagination)
			throws DataAccessException {
		this.whisperService.getSystemNoticesByUserId(pagination);

	}

	public List<Group> getMyGroups(Long userId) throws DataAccessException {
		return this.groupService.getMyGroups(userId);
	}

	public void createSystemNotice(SystemNotice systemNotice)
			throws DataAccessException {
		this.whisperService.createSystemNotice(systemNotice);

	}

	public void agreeGroupInvite(SystemNotice systemNotice)
			throws DataAccessException {
		this.groupService.agreeGroupInvite(systemNotice);

	}

	public void createDaily(Daily daily) throws DataAccessException {
		this.userService.createDaily(daily);

	}

	public Group createGroup(Group group) throws DataAccessException {
		return this.groupService.createGroup(group);
	}

	public void updateDaily(Daily daily) throws DataAccessException {
		this.userService.updateDaily(daily);

	}

	public void deleteGroup(Long id, Long userId) throws DataAccessException {
		this.groupService.deleteGroup(id, userId);
	}

	public void deleteTopic(Long id) throws DataAccessException {
		this.groupService.deleteTopic(id);

	}

	public void updateTopic(Topic topic) throws DataAccessException {
		this.groupService.updateTopic(topic);

	}

	public void getGroups(Pagination<Group> pagination)
			throws DataAccessException {
		this.groupService.getGroups(pagination);

	}

	public void updateGroup(Group group) throws DataAccessException {
		this.groupService.updateGroup(group);

	}

	public void getGroupAdmins(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		this.groupService.getGroupAdmins(pagination);

	}

	public void deleteTopicComment(Long id) throws DataAccessException {
		this.groupService.deleteTopicComment(id);

	}

	public List<PlaybillChannel> getPlaybillChannels()
			throws DataAccessException {
		return this.playbillService.getPlaybillChannels();
	}

	public void updatePlaybill(Playbill playbill) throws DataAccessException {
		this.playbillService.updatePlaybill(playbill);
	}

	public void deletePlaybill(Long id) throws DataAccessException {
		this.playbillService.deletePlaybill(id);
	}

	public void deleteVideoAndPlayBill(VideoAndPlayBill videoAndPlayBill)
			throws DataAccessException {
		this.playbillService.deleteVideoAndPlayBill(videoAndPlayBill);
	}

	public List<VideoChannel> getVideoChannelList() throws DataAccessException {
		return this.videoService.getVideoChannelList();
	}

	public void createOrUpdateDailyHistory(DailyHistory dailyHistory)
			throws DataAccessException {
		this.userService.createOrUpdateDailyHistory(dailyHistory);

	}

	public void deleteDailyHistoryByDailyId(Long id) throws DataAccessException {
		this.userService.deleteDailyHistoryByDailyId(id);

	}

	public void getDailyHistories(Pagination<DailyHistory> pagination)
			throws DataAccessException {
		this.userService.getDailyHistories(pagination);
	}

	public void deleteDaily(Long id) throws DataAccessException {
		this.userService.deleteDaily(id);
	}

	public void getPlaybillByKey(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillService.getPlaybillByKey(pagination);
	}

	public void createUserKeyword(UserKeyword userKeyword)
			throws DataAccessException {
		this.searchService.createUserKeyword(userKeyword);
	}

	public void createVideo(Video video) throws DataAccessException {
		this.videoService.createVideo(video);
	}

	public void createUploadVideo(UploadVideo uploadVideo)
			throws DataAccessException {
		this.videoService.createUploadVideo(uploadVideo);

	}

	public void updateUploadVideoStatus(UploadVideo uploadVideo)
			throws DataAccessException {
		this.videoService.updateUploadVideoStatus(uploadVideo);

	}

	public void createOrUpdateBlogHistory(BlogHistory blogHistory)
			throws DataAccessException {

		this.userService.createOrUpdateBlogHistory(blogHistory);

	}

	public Video getVideo(Long id) throws DataAccessException {
		return this.videoService.getVideo(id);
	}

	public void createVideoAndTag(Video video, String tagName)
			throws DataAccessException {
		this.videoTagService.createVideoAndTag(video, tagName);
	}

	public void getTags(Pagination<Tag> pagination) throws DataAccessException {
		this.videoTagService.getTags(pagination);
	}

	public void deleteVideoAndTagByVideoId(Long id) throws DataAccessException {
		this.videoTagService.deleteVideoAndTagByVideoId(id);
	}

	public boolean pointVideo(PointHistory pointHistory)
			throws DataAccessException {
		return this.videoService.pointVideo(pointHistory);
	}

	public void getBrowseHistoryByGroupId(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoService.getBrowseHistoryByGroupId(pagination);

	}

	public void createSafeCode(SafeCode safeCode) throws DataAccessException {
		this.userService.createSafeCode(safeCode);
	}

	public void deleteSafeCodeByCode(String code) throws DataAccessException {
		this.userService.deleteSafeCodeByCode(code);

	}

	public SafeCode getSafeCodeByCode(String code) throws DataAccessException {
		return this.userService.getSafeCodeByCode(code);
	}

	public List<User> getStars() throws DataAccessException {

		return this.userService.getStars();
	}

	public void updateUploadVideoLength(UploadVideo uploadVideo)
			throws DataAccessException {
		this.videoService.updateUploadVideoLength(uploadVideo);
		
	}

	public List<Video> getPlaybillVideoList(Long id) throws DataAccessException {
		return this.videoService.getPlaybillVideoList(id);
	}

	public void createDailyAndTag(Daily daily, String tagName)
			throws DataAccessException {
		this.userService.createDailyAndTag(daily, tagName);
		
	}

	public List<DailyTag> getDailyTagsByUser(Long id)
			throws DataAccessException {
		
		return this.userService.getDailyTagsByUser(id);
	}

	public void deleteSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException {
		this.userService.deleteSubscribe(subscribeUser);
	}

	public SubscribeUser getSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException {
		
		return this.userService.getSubscribe(subscribeUser);
	}

	public void createEvent(Event event) throws DataAccessException {
		this.eventService.createEvent(event);
		
	}

	public void deleteEvent(Long id) throws DataAccessException {
		this.eventService.deleteEvent(id);
		
	}

	public void getEvents(Pagination<Event> pagination)
			throws DataAccessException {
		this.eventService.getEvents(pagination);
		
	}

	public List<Event> getLastEvents() throws DataAccessException {
		
		return this.eventService.getLastEvents();
	}

	public int getNewMessageCount(Long id) throws DataAccessException {
		
		return this.whisperService.getNewMessageCount(id);
	}

	public ChannelCount getChannelTop(Long id)
	throws DataAccessException{
		return this.videoService.getChannelTop(id);
	}

	public List<Video> getVideoRand(Condition condition) throws DataAccessException {
	
		return this.videoService.getVideoRand(condition);
	}

	public List<Long> getPlayHistoryVideoIds(Long id)
			throws DataAccessException {
	
		return this.videoService.getPlayHistoryVideoIds(id);
	}

	public void deleteFriend(Friend friend) throws DataAccessException {
	this.userService.deleteFriend(friend);
		
	}

	public int countMyFans(Long id) throws DataAccessException {
		
		return this.userService.countMyFans(id);
	}

	public int countMySubscibeUsers(Long id) throws DataAccessException {
		
		return this.userService.countMySubscibeUsers(id);
	}

	public void getSimilars(Pagination<User> pagination)
			throws DataAccessException {
		this.userService.getSimilars(pagination);
		
	}

	public List<Group> getMyGroupList(Long id) throws DataAccessException {
		return this.groupService.getMyGroupList(id);
	}

	public List<Topic> getTopicesByDaily(Long id) throws DataAccessException {
	
		return this.groupService.getTopicesByDaily(id);
	}

	public List<Notice> getNotices() throws DataAccessException {
		return this.eventService.getNotices();
	}

	public List<Tag> getTagsByVideo(Long id) throws DataAccessException {
		
		return this.videoTagService.getTagsByVideo(id);
	}


}
