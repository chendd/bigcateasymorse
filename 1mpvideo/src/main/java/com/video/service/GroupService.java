package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.GroupHistory;
import com.video.domain.GroupRequest;
import com.video.domain.Playbill;
import com.video.domain.SystemNotice;
import com.video.domain.Topic;
import com.video.domain.TopicComment;
import com.video.domain.Video;
import com.video.util.Pagination;

public interface GroupService {
	
	public void getMyJoinGroups(Pagination<GroupAndUser> pagination) throws DataAccessException;
	
	public void getTopices(Pagination<Topic> pagination) throws DataAccessException;
	
	public void getMyGroupTopices(Pagination<Topic> pagination) throws DataAccessException;
	
	public Topic getTopicById(Long id) throws DataAccessException;
	
	public Group getGroupSimpleById(Long id) throws DataAccessException;
	
	public void getTopicesByGroupId(Pagination<Topic> pagination)
	throws DataAccessException ;
	
	public void getTopicComments (Pagination<TopicComment> pagination) throws DataAccessException ;
	
	public void createTopicComment(TopicComment topicComment) throws DataAccessException ;
	public void getVideoesByGroupId(Pagination<Video> pagination)
	throws DataAccessException;
	
	public void getPlayBillsByGroupId(Pagination<Playbill> pagination)
	throws DataAccessException;
	
	public Group getGroupById(Long id) throws DataAccessException ;
	
	public void getMyGroupMembers(Pagination<GroupAndUser> pagination)
	throws DataAccessException ;
	
	public void getGroupHistories(Pagination<GroupHistory> pagination) throws DataAccessException ;
	
	
	public void createORupdateGroupRequest(GroupRequest groupRequest) throws DataAccessException ;
	
	public void deleteGroupRequestById(long id) throws DataAccessException;
	
	public List<GroupRequest> getGroupRequestsByGroupId(Long id)  throws DataAccessException;
	
	public void createGroupAndUser(GroupAndUser groupAndUser)
	throws DataAccessException;
	public void deleteGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException ;
	public void createTopic(Topic topic) throws DataAccessException;
	public void createOrUpdateGroupHistory(GroupHistory groupHistory) throws DataAccessException;
	public void deleteTopicById(Long id) throws DataAccessException ;
	public List<Group> getMyGroups(Long userId) throws DataAccessException;
	
	public void agreeGroupInvite(SystemNotice systemNotice)throws DataAccessException;
	public Group createGroup(Group group) throws DataAccessException;
	
	public void deleteGroup(Long id,Long userId) throws DataAccessException;
	public void updateTopic(Topic topic) throws DataAccessException;
	
	public void deleteTopic(Long id) throws DataAccessException;
	
	public void getGroups(Pagination<Group> pagination) throws DataAccessException;
	
	public void updateGroup(Group group) throws DataAccessException;
	
	public void getGroupAdmins(Pagination<GroupAndUser> pagination)  throws DataAccessException;
	public void deleteTopicComment(Long id) throws DataAccessException;
	
	public List<Group> getMyGroupList(Long id) throws DataAccessException;
	
	public List<Topic> getTopicesByDaily(Long id) throws DataAccessException;
}
