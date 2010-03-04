package com.video.service;

import org.springframework.dao.DataAccessException;

import com.video.dao.GroupDao;
import com.video.dao.SystemNoticeDao;
import com.video.dao.UserDao;
import com.video.dao.WhisperDao;
import com.video.domain.Group;
import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.util.Pagination;

public class WhisperServiceImpl implements WhisperService {
	private WhisperDao whisperDao;
	private SystemNoticeDao systemNoticeDao;
	private UserDao userDao;
	private GroupDao groupDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public GroupDao getGroupDao() {
		return groupDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public SystemNoticeDao getSystemNoticeDao() {
		return systemNoticeDao;
	}

	public void setSystemNoticeDao(SystemNoticeDao systemNoticeDao) {
		this.systemNoticeDao = systemNoticeDao;
	}

	public WhisperDao getWhisperDao() {
		return whisperDao;
	}

	public void setWhisperDao(WhisperDao whisperDao) {
		this.whisperDao = whisperDao;
	}

	public void createWhisper(Whisper whisper) throws DataAccessException {
		this.whisperDao.createWhisper(whisper);
	}

	public void getWhispers(Pagination<Whisper> pagination)
			throws DataAccessException {
		this.whisperDao.getWhispers(pagination);
	}

	public Whisper getWhisperById(Long id) throws DataAccessException {
		Whisper whisper = this.whisperDao.getWhisperById(id);
		
		if(whisper!=null&&whisper.getStatus()==0){
			whisper.setStatus(1);
			this.whisperDao.updateWhisperById(whisper);
		}
		return whisper;
	}

	public SystemNotice getSystemNoticeById(Long id) throws DataAccessException {
		SystemNotice systemNotice = this.systemNoticeDao
				.getSystemNoticeById(id);
		if(systemNotice!=null && systemNotice.getStatus()==0){
			systemNotice.setStatus(1);
			this.systemNoticeDao.updateSystemNoticeById(systemNotice);
		}
		if (systemNotice != null && systemNotice.getModule() != null) {
			if (systemNotice.getType() == 2 || systemNotice.getType() == 3) {
					Group group = this.groupDao.getGroupById(systemNotice.getModule().getId());
					systemNotice.getModule().setName(group.getName());
					systemNotice.getModule().setImage(group.getImage());
			}
			if (systemNotice.getType() == 4 || systemNotice.getType() == 5) {
				User user = this.userDao.getUserById(systemNotice.getModule().getId());
				systemNotice.getModule().setName(user.getRealName());
				systemNotice.getModule().setImage(user.getFace());
				
			}
		}
		return systemNotice;
	}

	public void getSystemNoticesByUserId(Pagination<SystemNotice> pagination)
			throws DataAccessException {
		this.systemNoticeDao.getSystemNoticesByUserId(pagination);

	}

	public void createSystemNotice(SystemNotice systemNotice)
			throws DataAccessException {
		this.systemNoticeDao.createSystemNotice(systemNotice);
		
	}

	public int getNewMessageCount(Long id) throws DataAccessException {
		int count1 = this.whisperDao.countNewWhisper(id);
		int count2 = this.systemNoticeDao.countNewNotice(id);
		int count = count1+count2;
		return count;
		
	}



}
