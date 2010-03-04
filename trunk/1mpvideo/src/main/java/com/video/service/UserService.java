package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.BlogHistory;
import com.video.domain.BlogWord;
import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyComment;
import com.video.domain.DailyHistory;
import com.video.domain.DailyTag;
import com.video.domain.Friend;
import com.video.domain.SafeCode;
import com.video.domain.SubscribeUser;
import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.util.Pagination;

public interface UserService {
	public User getUserById(Long id) throws DataAccessException;

	public User getUser2ById(Long id) throws DataAccessException;

	public void updateUser(User user) throws DataAccessException;

	public void getFriends(Pagination<User> pagination)
			throws DataAccessException;

	public void getWhispers(Pagination<Whisper> pagination)
			throws DataAccessException;

	public void getTopUsers(Pagination<User> pagination)
			throws DataAccessException;

	public void getSubscibeUsers(Pagination<SubscribeUser> pagination)
			throws DataAccessException;

	public void getUsersOrderByNewVideo(Pagination<User> pagination)
			throws DataAccessException;

	public void getUsersOrderByBrowseTimes(Pagination<User> pagination)
			throws DataAccessException;

	public void getUsersOrderByCommentCount(Pagination<User> pagination)
			throws DataAccessException;

	public void createBlogWord(BlogWord blogWord) throws DataAccessException;

	public void deleteBlogWordById(Long id) throws DataAccessException;

	public void getBlogWords(Pagination<BlogWord> pagination)
			throws DataAccessException;

	public void getMyDailies(Pagination<Daily> pagination)
			throws DataAccessException;

	public List<DailyChannel> getSimpleDailyChannels(Long userId)
			throws DataAccessException;

	public void getDailyTags(Pagination<DailyTag> pagination)
			throws DataAccessException;

	public Daily getDailyById(Long id) throws DataAccessException;

	public void getDailyComment(Pagination<DailyComment> pagination)
			throws DataAccessException;

	public void createDailyComment(DailyComment dailyComment)
			throws DataAccessException;

	public void deleteDailyCommentById(Long id) throws DataAccessException;

	public void getBlogHistories(Pagination<BlogHistory> pagination)
			throws DataAccessException;

	public User getUserUsePlaybillById(User user) throws DataAccessException;

	public void getOtherUserByVideoId(Pagination<User> pagination)
			throws DataAccessException;

	public void createSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException;

	public User getUser(User user) throws DataAccessException;

	public void createUser(User user) throws DataAccessException;

	public Long getFriendId(Friend friend) throws DataAccessException;

	public void createFriend(Friend friend) throws DataAccessException;

	public void createUserRequest(SystemNotice systemNotice)
			throws DataAccessException;

	public List<DailyChannel> getDailyChannels() throws DataAccessException;

	public void agreeUserRequest(SystemNotice systemNotice)
			throws DataAccessException;

	public void createDaily(Daily daily) throws DataAccessException;

	public void updateDaily(Daily daily) throws DataAccessException;

	public void createOrUpdateDailyHistory(DailyHistory dailyHistory)
			throws DataAccessException;

	public void createOrUpdateBlogHistory(BlogHistory blogHistory)
			throws DataAccessException;

	public void getDailyHistories(Pagination<DailyHistory> pagination)
			throws DataAccessException;

	public void deleteDailyHistoryByDailyId(Long id) throws DataAccessException;

	public void deleteDaily(Long id) throws DataAccessException;

	public void createSafeCode(SafeCode safeCode) throws DataAccessException;

	public void deleteSafeCodeByCode(String code) throws DataAccessException;

	public SafeCode getSafeCodeByCode(String code) throws DataAccessException;

	public List<User> getStars() throws DataAccessException;

	public void createDailyAndTag(Daily daily, String tagName)
			throws DataAccessException;

	public List<DailyTag> getDailyTagsByUser(Long id)
			throws DataAccessException;

	public void deleteSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException;

	public SubscribeUser getSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException;
	
	public void deleteFriend(Friend friend) throws DataAccessException ;
	
public int countMySubscibeUsers(Long id) throws DataAccessException;
	
	public int countMyFans(Long id) throws DataAccessException;
	
	public void getSimilars(Pagination<User> pagination)
	throws DataAccessException;

}
