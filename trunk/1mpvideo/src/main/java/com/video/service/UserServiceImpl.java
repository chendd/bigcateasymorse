package com.video.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.BlogHistoryDao;
import com.video.dao.BlogWordDao;
import com.video.dao.DailyChannelDao;
import com.video.dao.DailyDao;
import com.video.dao.DailyHistoryDao;
import com.video.dao.DailyTagDao;
import com.video.dao.EventDao;
import com.video.dao.SafeCodeDao;
import com.video.dao.SystemNoticeDao;
import com.video.dao.UserDao;
import com.video.dao.UserRequestDao;
import com.video.dao.WhisperDao;
import com.video.domain.BlogHistory;
import com.video.domain.BlogWord;
import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyComment;
import com.video.domain.DailyHistory;
import com.video.domain.DailyTag;
import com.video.domain.Event;
import com.video.domain.Friend;
import com.video.domain.SafeCode;
import com.video.domain.SubscribeUser;
import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.domain.connection.DailyAndTag;
import com.video.util.Pagination;

public  class UserServiceImpl implements UserService {

	private UserDao userDao;
	private WhisperDao whisperDao;
	private BlogWordDao blogWordDao;
	private DailyDao dailyDao;
	private DailyChannelDao dailyChannelDao;
	private DailyTagDao dailyTagDao;
	private BlogHistoryDao blogHistoryDao;
	private UserRequestDao userRequestDao;
	private SystemNoticeDao systemNoticeDao;
	private DailyHistoryDao dailyHistoryDao;
	private SafeCodeDao safeCodeDao;
	private EventDao eventDao;

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public SafeCodeDao getSafeCodeDao() {
		return safeCodeDao;
	}

	public void setSafeCodeDao(SafeCodeDao safeCodeDao) {
		this.safeCodeDao = safeCodeDao;
	}

	public DailyHistoryDao getDailyHistoryDao() {
		return dailyHistoryDao;
	}

	public void setDailyHistoryDao(DailyHistoryDao dailyHistoryDao) {
		this.dailyHistoryDao = dailyHistoryDao;
	}

	public SystemNoticeDao getSystemNoticeDao() {
		return systemNoticeDao;
	}

	public void setSystemNoticeDao(SystemNoticeDao systemNoticeDao) {
		this.systemNoticeDao = systemNoticeDao;
	}

	public UserRequestDao getUserRequestDao() {
		
		return userRequestDao;
	}

	public void setUserRequestDao(UserRequestDao userRequestDao) {
		this.userRequestDao = userRequestDao;
	}

	public BlogHistoryDao getBlogHistoryDao() {
		return blogHistoryDao;
	}

	public void setBlogHistoryDao(BlogHistoryDao blogHistoryDao) {
		this.blogHistoryDao = blogHistoryDao;
	}

	public DailyTagDao getDailyTagDao() {
		return dailyTagDao;
	}

	public void setDailyTagDao(DailyTagDao dailyTagDao) {
		this.dailyTagDao = dailyTagDao;
	}

	public DailyChannelDao getDailyChannelDao() {
		return dailyChannelDao;
	}

	public void setDailyChannelDao(DailyChannelDao dailyChannelDao) {
		this.dailyChannelDao = dailyChannelDao;
	}

	public DailyDao getDailyDao() {
		return dailyDao;
	}

	public void setDailyDao(DailyDao dailyDao) {
		this.dailyDao = dailyDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public WhisperDao getWhisperDao() {
		return whisperDao;
	}

	public void setWhisperDao(WhisperDao whisperDao) {
		this.whisperDao = whisperDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserById(Long id) throws DataAccessException {

		return this.userDao.getUserById(id);
	}

	public void updateUser(User user) throws DataAccessException {
		this.userDao.updateUser(user);

	}

	public void getFriends(Pagination<User> pagination)
			throws DataAccessException {
		this.userDao.getFriends(pagination);

	}

	public void getWhispers(Pagination<Whisper> pagination)
			throws DataAccessException {
		this.whisperDao.getWhispers(pagination);

	}

	public void getTopUsers(Pagination<User> pagination)
			throws DataAccessException {
		this.userDao.getUsers2(pagination);

	}

	public void getSubscibeUsers(Pagination<SubscribeUser> pagination)
			throws DataAccessException {
		this.userDao.getSubscribeUser(pagination);
		if(pagination.getRecordSum()>0){
			for (SubscribeUser subscribeUser : pagination.getResults()) {

				User user1 = userDao.getUser2ById(subscribeUser.getPassiveUser()
						.getId());

				subscribeUser.setPassiveUser(user1);
				User user2 = userDao.getUser2ById(subscribeUser.getUser().getId());

				subscribeUser.setUser(user2);
			}
		}
		

	}

	public void getUsersOrderByBrowseTimes(Pagination<User> pagination)
			throws DataAccessException {
		this.userDao.getUsersOrderByBrowseTimes(pagination);
		this.userDao.getUsersOrderByBrowseTimes(pagination);
		List<User> list = new ArrayList<User>();
		for (User user : pagination.getResults()) {

			user = this.userDao.getUser2ById(user.getId());
			list.add(user);
		}
		pagination.setResults(list);
	}

	public void getUsersOrderByNewVideo(Pagination<User> pagination)
			throws DataAccessException {

		this.userDao.getUsersOrderByNewVideo(pagination);
		List<User> list = new ArrayList<User>();
		for (User user : pagination.getResults()) {

			user = this.userDao.getUser2ById(user.getId());
			list.add(user);
		}
		pagination.setResults(list);
	}

	public void getUsersOrderByCommentCount(Pagination<User> pagination)
			throws DataAccessException {

		this.userDao.getUsersOrderByCommentCount(pagination);
		List<User> list = new ArrayList<User>();
		for (User user : pagination.getResults()) {
			User user2 = this.userDao.getUser2ById(user.getId());
			user2.setCommentCount(user.getCommentCount());
			list.add(user2);
		}
		pagination.setResults(list);

	}

	public User getUser2ById(Long id) throws DataAccessException {
		return this.userDao.getUser2ById(id);
	}

	public void createBlogWord(BlogWord blogWord) throws DataAccessException {
		this.blogWordDao.createBlogWord(blogWord);

	}

	public void deleteBlogWordById(Long id) throws DataAccessException {
		this.blogWordDao.deleteBlogWordById(id);

	}

	public void getBlogWords(Pagination<BlogWord> pagination)
			throws DataAccessException {
		this.blogWordDao.getBlogWords(pagination);

	}

	public BlogWordDao getBlogWordDao() {
		return blogWordDao;
	}

	public void setBlogWordDao(BlogWordDao blogWordDao) {
		this.blogWordDao = blogWordDao;
	}

	public void getMyDailies(Pagination<Daily> pagination)
			throws DataAccessException {
		this.dailyDao.getMyDailies(pagination);

	}

	public User getUserUsePlaybillById(User user) throws DataAccessException {
		return this.userDao.getUserUsePlaybillById(user);
	}

	public List<DailyChannel> getSimpleDailyChannels(Long userId)
			throws DataAccessException {

		return this.dailyChannelDao.getSimpleDailyChannels(userId);
	}

	public void getDailyTags(Pagination<DailyTag> pagination)
			throws DataAccessException {
		this.dailyTagDao.getDailyTags(pagination);

	}

	public Daily getDailyById(Long id) throws DataAccessException {

		return this.dailyDao.getDailyById(id);
	}

	public void createDailyComment(DailyComment dailyComment)
			throws DataAccessException {
		this.dailyDao.createDailyComment(dailyComment);

	}

	public void deleteDailyCommentById(Long id) throws DataAccessException {
		this.dailyDao.deleteDailyCommentById(id);

	}

	public void getDailyComment(Pagination<DailyComment> pagination)
			throws DataAccessException {
		this.dailyDao.getDailyComment(pagination);

	}

	public void getBlogHistories(Pagination<BlogHistory> pagination)
			throws DataAccessException {
		this.blogHistoryDao.getBlogHistories(pagination);

	}

	public Long getFriendId(Friend friend) throws DataAccessException {
		return this.userDao.getFriendId(friend);
	}

	public void createFriend(Friend friend) throws DataAccessException {
		this.userDao.createFriend(friend);
		Friend friend2 = new Friend();
		friend2.setUser(friend.getfUser());
		friend2.setfUser(friend.getUser());
		friend2.setRegdate(friend.getRegdate());
		this.userDao.createFriend(friend2);
	}

	public void createUserRequest(SystemNotice systemNotice)
			throws DataAccessException {
		this.systemNoticeDao.createSystemNotice(systemNotice);

	}

	public void getOtherUserByVideoId(Pagination<User> pagination)
			throws DataAccessException {
		this.userDao.getOtherUserByVideoId(pagination);
	}

	public void createSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException {
		if (this.userDao.getSubscribe(subscribeUser) == null) {
			this.userDao.createSubscribe(subscribeUser);
		}
	}

	public User getUser(User user) throws DataAccessException {
		return this.userDao.getUser(user);
	}

	public void createUser(User user) throws DataAccessException {
		this.userDao.createUser(user);
	}

	public List<DailyChannel> getDailyChannels() throws DataAccessException {

		return this.dailyChannelDao.getDailyChannels();
	}



	public void agreeUserRequest(SystemNotice systemNotice)
			throws DataAccessException {
		SystemNotice systemNotice1 = new SystemNotice();
		systemNotice1.setSendDate(new Date());
		systemNotice1.setTitle("好友请求回应");
		systemNotice1.setStatus(0);
		systemNotice1.setType(1);
		systemNotice1.setMessage(systemNotice.getUser().getRealName()+"同意了你的好友请求,Ta已经和你成为好友");
		User user = new User();
		user.setId(systemNotice.getModule().getId());
		systemNotice1.setUser(user);
		this.systemNoticeDao.createSystemNotice(systemNotice1);
		systemNotice.setStatus(2);
		this.systemNoticeDao.updateSystemNotice(systemNotice);
		Friend friend1 = new Friend();
		friend1.setUser(user);
		friend1.setfUser(systemNotice.getUser());
		friend1.setRegdate(new Date());
		Friend friend2 = new Friend();
		friend2.setUser(systemNotice.getUser());
		friend2.setfUser(user);
		friend2.setRegdate(new Date());
		this.userDao.createFriend(friend1);
		this.userDao.createFriend(friend2);
	}

	
	public void createDaily(Daily daily) throws DataAccessException {
		this.dailyDao.createDaily(daily);
		String description = "发表了新日志：《"+daily.getTitle()+"》";
		String url = "blog/"+daily.getId()+"/";
		Event event = new Event();
		event.setUser(daily.getUser());
		event.setAddDate(daily.getAddDate());
		event.setDescription(description);
		event.setUrl(url);
		this.eventDao.createEvent(event);
		
		
		
	}

	public void updateDaily(Daily daily) throws DataAccessException {
		Long id = daily.getId();
		Daily oldDaily = dailyDao.getDailyById(id);
		if(oldDaily!=null){
			oldDaily.setChannel(daily.getChannel());
			oldDaily.setLog(daily.getLog());
			oldDaily.setTitle(daily.getTitle());
			dailyDao.updateDaily(oldDaily);
		}
		
	}

	
	public void deleteDailyHistoryByDailyId(Long id) throws DataAccessException {
		this.dailyHistoryDao.deleteDailyHistoryByDailyId(id);
		
	}

	public void getDailyHistories(Pagination<DailyHistory> pagination)
			throws DataAccessException {
		this.dailyHistoryDao.getDailyHistories(pagination);
		
	}


	public void createOrUpdateDailyHistory(DailyHistory dailyHistory)
			throws DataAccessException {
		dailyHistory.setVisitDate(new Date());
		if(this.dailyHistoryDao.getDailyHistory(dailyHistory)==null){
			this.dailyHistoryDao.createDailyHistory(dailyHistory);
		}
		else{
			
			this.dailyHistoryDao.updateDailyHistory(dailyHistory);
		}
		
	}

	public void deleteDaily(Long id) throws DataAccessException {
		this.dailyDao.deleteDailyCommentByDailyId(id);
		this.dailyTagDao.deleteDailyTagByDailyId(id);
		this.dailyHistoryDao.deleteDailyHistoryByDailyId(id);
		this.dailyDao.deleteDaily(id);
		
	}

	public void createOrUpdateBlogHistory(BlogHistory blogHistory)
			throws DataAccessException {
		blogHistory.setVisitDate(new Date());
		if(this.blogHistoryDao.getBlogHistory(blogHistory)==null){
		
			this.blogHistoryDao.createBlogHistory(blogHistory);
			
		}
		else{
			
			this.blogHistoryDao.updateBlogHistory(blogHistory);
		}
		
	}

	public void createSafeCode(SafeCode safeCode) throws DataAccessException {
		this.safeCodeDao.createSafeCode(safeCode);
		
	}

	public void deleteSafeCodeByCode(String code) throws DataAccessException {
		this.safeCodeDao.deleteSafeCodeByCode(code);
	}

	public SafeCode getSafeCodeByCode(String code) throws DataAccessException {
		
		return this.safeCodeDao.getSafeCodeByCode(code);
	}

	public List<User> getStars() throws DataAccessException {
		List<Long> userIds = this.userDao.getStars();
		List<User> users = new ArrayList<User>();
		if(userIds !=null){
			for(Long userId:userIds){
				User user = this.userDao.getUser2ById(userId);
				users.add(user);
			}
		}
		return users;
	}


	
	public void createDailyAndTag(Daily daily, String tagName)
	throws DataAccessException {
DailyTag tag = this.dailyTagDao.getDailyTagByName(tagName);
if (tag == null) {
	tag = new DailyTag();
	tag.setName(tagName);
	tag.setStatus(1);
	tag.setBrowseCount(0);
	tag.setUser(daily.getUser());
	tag.setCreateDate(new Date());
	this.dailyTagDao.createDailyTag(tag);
	DailyAndTag dailyAndTag = new DailyAndTag();
	dailyAndTag.setTagId(tag.getId());
	dailyAndTag.setDailyId(daily.getId());
	this.dailyDao.createDailyAndTag(dailyAndTag);
} else {
	DailyAndTag dailyAndTag = new DailyAndTag();
	dailyAndTag.setTagId(tag.getId());
	dailyAndTag.setDailyId(daily.getId());
	DailyAndTag dailyAndTag2 = this.dailyDao
			.getDailyAndTag(dailyAndTag);
	if (dailyAndTag2 == null) {
		this.dailyDao.createDailyAndTag(dailyAndTag);
	}
}
}

	public List<DailyTag> getDailyTagsByUser(Long id)
			throws DataAccessException {
	
		return this.dailyTagDao.getDailyTagsByUser(id);
	}

	public void deleteSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException {
	this.userDao.deleteSubscribe(subscribeUser);
		
	}

	

	public SubscribeUser getSubscribe(SubscribeUser subscribeUser)
	throws DataAccessException{
		
		return this.userDao.getSubscribe(subscribeUser);
	}

	public void deleteFriend(Friend friend) throws DataAccessException {
		this.userDao.deleteFriend(friend);
		
	}

	public int countMyFans(Long id) throws DataAccessException {
		
		return this.userDao.countMyFans(id);
	}

	public int countMySubscibeUsers(Long id) throws DataAccessException {
		return this.userDao.countMySubscibeUsers(id);
	}

	public void getSimilars(Pagination<User> pagination)
			throws DataAccessException {
		this.userDao.getSimilars(pagination);
		
	}
	



}
