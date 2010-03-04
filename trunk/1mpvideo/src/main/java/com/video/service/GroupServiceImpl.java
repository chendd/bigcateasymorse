package com.video.service;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.DailyDao;
import com.video.dao.EventDao;
import com.video.dao.GroupAndUserDao;
import com.video.dao.GroupDao;
import com.video.dao.GroupHistoryDao;
import com.video.dao.GroupRequestDao;
import com.video.dao.PlaybillDao;
import com.video.dao.SystemNoticeDao;
import com.video.dao.TopicCommentDao;
import com.video.dao.TopicDao;
import com.video.dao.UserDao;
import com.video.dao.VideoDao;
import com.video.domain.Daily;
import com.video.domain.Event;
import com.video.domain.Friend;
import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.GroupHistory;
import com.video.domain.GroupRequest;
import com.video.domain.Playbill;
import com.video.domain.SystemNotice;
import com.video.domain.Topic;
import com.video.domain.TopicComment;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.util.Pagination;

public class GroupServiceImpl implements GroupService {
	
	private GroupDao groupDao;
	private UserDao userDao;
	private GroupAndUserDao groupAndUserDao;
	private TopicDao topicDao;
	private TopicCommentDao topicCommentDao;
	private VideoDao videoDao;
	private PlaybillDao playbillDao;
	private GroupHistoryDao groupHistoryDao;
	private GroupRequestDao groupRequestDao;
	private SystemNoticeDao systemNoticeDao;
	private EventDao eventDao;
	private DailyDao dailyDao;
	
	
	
	public DailyDao getDailyDao() {
		return dailyDao;
	}
	public void setDailyDao(DailyDao dailyDao) {
		this.dailyDao = dailyDao;
	}
	public EventDao getEventDao() {
		return eventDao;
	}
	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	public SystemNoticeDao getSystemNoticeDao() {
		return systemNoticeDao;
	}
	public void setSystemNoticeDao(SystemNoticeDao systemNoticeDao) {
		this.systemNoticeDao = systemNoticeDao;
	}
	public GroupRequestDao getGroupRequestDao() {
		return groupRequestDao;
	}
	public void setGroupRequestDao(GroupRequestDao groupRequestDao) {
		this.groupRequestDao = groupRequestDao;
	}
	public GroupHistoryDao getGroupHistoryDao() {
		return groupHistoryDao;
	}
	public void setGroupHistoryDao(GroupHistoryDao groupHistoryDao) {
		this.groupHistoryDao = groupHistoryDao;
	}
	public PlaybillDao getPlaybillDao() {
		return playbillDao;
	}
	public void setPlaybillDao(PlaybillDao playbillDao) {
		this.playbillDao = playbillDao;
	}
	public VideoDao getVideoDao() {
		return videoDao;
	}
	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	public TopicCommentDao getTopicCommentDao() {
		return topicCommentDao;
	}
	public void setTopicCommentDao(TopicCommentDao topicCommentDao) {
		this.topicCommentDao = topicCommentDao;
	}
	public TopicDao getTopicDao() {
		return topicDao;
	}
	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}
	public GroupDao getGroupDao() {
		return groupDao;
	}
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public GroupAndUserDao getGroupAndUserDao() {
		return groupAndUserDao;
	}
	public void setGroupAndUserDao(GroupAndUserDao groupAndUserDao) {
		this.groupAndUserDao = groupAndUserDao;
	}

	public void getMyJoinGroups(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		this.groupAndUserDao.getMyJoinGroups(pagination);
		
	}

	public void getTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		this.topicDao.getTopices(pagination);
		
	}

	public void getMyGroupTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		this.topicDao.getMyGroupTopices(pagination);
		
	}

	public Topic getTopicById(Long id) throws DataAccessException {
		return  this.topicDao.getTopicById(id);
	}

	public Group getGroupSimpleById(Long id) throws DataAccessException {
		
		return this.groupDao.getGroupSimpleById(id);
	}

	public void getTopicesByGroupId(Pagination<Topic> pagination)
			throws DataAccessException {
		this.topicDao.getTopicesByGroupId(pagination);
		
	}
	
	public void getTopicComments(Pagination<TopicComment> pagination)
			throws DataAccessException {
		this.topicCommentDao.getTopicComments(pagination);
		
	}

	public void createTopicComment(TopicComment topicComment)
			throws DataAccessException {
		Topic topic = this.topicDao.getTopicById(topicComment.getTopic().getId());
		Group group = this.groupDao.getGroupById(topic.getGroup().getId());
		group.setActivity(group.getActivity()+1);
		this.groupDao.updateGroup(group);
		this.topicCommentDao.createTopicComment(topicComment);
		
	}

	public void getVideoesByGroupId(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getVideoesByGroupId(pagination);
		
	}

	public void getPlayBillsByGroupId(Pagination<Playbill> pagination)
			throws DataAccessException {
		this.playbillDao.getPlayBillsByGroupId(pagination);
		
	}
	
	public Group getGroupById(Long id) throws DataAccessException {
		
		return (Group)this.groupDao.getGroupById(id);
		
	}

	public void getMyGroupMembers(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		this.groupAndUserDao.getMyGroupMembers(pagination);
		
	}

	public void getGroupHistories(Pagination<GroupHistory> pagination)
			throws DataAccessException {
		this.groupHistoryDao.getGroupHistories(pagination);
		
	}

	public void createORupdateGroupRequest(GroupRequest groupRequest)
			throws DataAccessException {
		GroupRequest groupRequest2 = this.groupRequestDao.getGroupRequest(groupRequest);
		if(groupRequest2==null){
			this.groupRequestDao.createGroupRequest(groupRequest);
		}
		else{
			groupRequest.setId(groupRequest2.getId());
			this.groupRequestDao.updateGroupRequest(groupRequest);
		}
		
	}

	public void deleteGroupRequestById(long id) throws DataAccessException {
		this.groupRequestDao.deleteGroupRequestById(id);
		
	}
	
	public List<GroupRequest> getGroupRequestsByGroupId(Long id)
			throws DataAccessException {
	
		return this.groupRequestDao.getGroupRequestsByGroupId(id);
	}

	public void createGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
	 this.groupAndUserDao.createGroupAndUser(groupAndUser);
		
	}

	public void deleteGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		this.groupAndUserDao.deleteGroupAndUser(groupAndUser);
		
	}

	public void createTopic(Topic topic) throws DataAccessException {
		Group group = this.groupDao.getGroupById(topic.getGroup().getId());
		group.setActivity(group.getActivity()+10);
		this.groupDao.updateGroup(group);
		this.topicDao.createTopic(topic);
		
		String description = "发表了新话题：《"+topic.getTitle()+"》";
		String url = "group/topic/"+topic.getId()+"/";
		Event event = new Event();
		event.setAddDate(topic.getAddDate());
		event.setDescription(description);
		event.setUrl(url);
		event.setUser(topic.getUser());
		this.eventDao.createEvent(event);

		
	}

	public void createOrUpdateGroupHistory(GroupHistory groupHistory)
			throws DataAccessException {
		groupHistory.setVisitDate(new Date());
		if(this.groupHistoryDao.getGroupHistory(groupHistory)==null){
			this.groupHistoryDao.createGroupHistory(groupHistory);
		}
		else{
			
			this.groupHistoryDao.updateGroupHistory(groupHistory);
		}
		
	}

	public void deleteTopicById(Long id) throws DataAccessException {
		Pagination<TopicComment> pagination = new Pagination<TopicComment>();
		Topic topic = this.topicDao.getTopicById(id);
		if(topic!=null){
			pagination.setCondition(topic);
			int num = this.topicCommentDao.getTopicCommentCount(pagination);
			this.topicCommentDao.deleteTopicCommentByTopicId(id);
			this.topicDao.deleteTopic(id);
			Group group = this.groupDao.getGroupById(topic.getGroup().getId());
			group.setActivity(group.getActivity()-num*1-10);
			this.groupDao.updateGroup(group);
			
		}
		
		
	}

	public List<Group> getMyGroups(Long userId) throws DataAccessException {
		return this.groupAndUserDao.getMyGroups(userId);
	}
	public void agreeGroupInvite(SystemNotice systemNotice)
			throws DataAccessException {
	
		Group group = new Group();
		group.setId(systemNotice.getModule().getId());
		systemNotice.setStatus(2);
		this.systemNoticeDao.updateSystemNotice(systemNotice);
		GroupAndUser groupAndUser = new GroupAndUser();
		groupAndUser.setAddDate(new Date());
		groupAndUser.setGroup(group);
		groupAndUser.setUser(systemNotice.getUser());
		groupAndUser.setRate(1);
		if(this.groupAndUserDao.getGroupAndUser(groupAndUser)==null){
			this.groupAndUserDao.createGroupAndUser(groupAndUser);
		}
		

		
	}
	public Group createGroup(Group group) throws DataAccessException {
		group = this.groupDao.createGroup(group);
		GroupAndUser groupAndUser = new GroupAndUser();
		groupAndUser.setGroup(group);
		groupAndUser.setUser(group.getOwner());
		groupAndUser.setAddDate(new Date());
		groupAndUser.setRate(3);
		this.groupAndUserDao.createGroupAndUser(groupAndUser);
		
		
		String description = "创建了小组 ：" + group.getName();
		String url = "group/" + group.getId() + "/";
		Event event = new Event();
		event.setAddDate(group.getAddDate());
		event.setDescription(description);
		event.setUrl(url);
		event.setUser(group.getOwner());
		this.eventDao.createEvent(event);
		
		return group;
	}
	public void deleteGroup(Long id,Long userId) throws DataAccessException {
		Group group = this.groupDao.getGroupById(id);
		if(group.getOwner().getId().equals(userId)){
			this.topicDao.deleteTopicByGroupId(id);
			this.groupAndUserDao.deleteGroupAndUserByGoupId(id);
			this.groupHistoryDao.deleteGroupHistoryByGoupId(id);
			this.groupDao.deleteGroup(id);
		}
		
		
	}
	public void updateTopic(Topic topic) throws DataAccessException {
		Topic oldTopic = this.topicDao.getTopicById(topic.getId());
		if(oldTopic.getDailyId()!=null){
			Daily daily = this.dailyDao.getDailyById(oldTopic.getDailyId());
			daily.setTitle(topic.getTitle());
			daily.setLog(topic.getText());
			daily.setLog2(topic.getText2());
			this.dailyDao.updateDaily(daily);
			
			List<Topic> topices = this.topicDao.getTopicesByDaily(daily.getId());
			for(Topic topic2:topices){
				topic2.setTitle(topic.getTitle());
				topic2.setText(topic.getText());
				topic2.setText2(topic.getText2());
				this.topicDao.updateTopic(topic2);
			}
		
			
		}
		
		
	
		
	}
	public void deleteTopic(Long id) throws DataAccessException {
		this.topicDao.deleteTopic(id);
		
		
	}
	public void getGroups(Pagination<Group> pagination)
			throws DataAccessException {
		this.groupDao.getGroups(pagination);
		
	}
	public void updateGroup(Group group) throws DataAccessException {
		this.groupDao.updateGroup(group);
		
	}
	public void getGroupAdmins(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		this.groupAndUserDao.getGroupAdmins(pagination);
		
	}
	public void deleteTopicComment(Long id) throws DataAccessException {
	this.topicCommentDao.deleteTopicComment(id);
	TopicComment topicComment = this.topicCommentDao.getTopicCommentById(id);

	Topic topic = this.topicDao.getTopicById(topicComment.getTopic().getId());
	Group group = this.groupDao.getGroupById(topic.getGroup().getId());
	group.setActivity(group.getActivity()-1);
	this.groupDao.updateGroup(group);
	
	}
	public List<Group> getMyGroupList(Long id) throws DataAccessException {
		
		return this.groupDao.getMyGroupList(id);
	}
	public List<Topic> getTopicesByDaily(Long id) throws DataAccessException {
		
		return this.topicDao.getTopicesByDaily(id);
	}

	
	

}
