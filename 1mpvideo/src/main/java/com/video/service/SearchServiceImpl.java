package com.video.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.KeywordChannelDao;
import com.video.dao.SystemKeywordDao;
import com.video.dao.UserKeywordDao;
import com.video.domain.KeywordChannel;
import com.video.domain.SystemKeyword;
import com.video.domain.SystemKeywordChange;
import com.video.domain.SystemKeywordTerm;
import com.video.domain.UserKeyword;

public class SearchServiceImpl implements SearchService {

	private KeywordChannelDao keywordChannelDao;
	private SystemKeywordDao systemKeywordDao;
	private UserKeywordDao userKeywordDao;

	public UserKeywordDao getUserKeywordDao() {
		return userKeywordDao;
	}

	public void setUserKeywordDao(UserKeywordDao userKeywordDao) {
		this.userKeywordDao = userKeywordDao;
	}

	public KeywordChannelDao getKeywordChannelDao() {
		return keywordChannelDao;
	}

	public void setKeywordChannelDao(KeywordChannelDao keywordChannelDao) {
		this.keywordChannelDao = keywordChannelDao;
	}

	public SystemKeywordDao getSystemKeywordDao() {
		return systemKeywordDao;
	}

	public void setSystemKeywordDao(SystemKeywordDao systemKeywordDao) {
		this.systemKeywordDao = systemKeywordDao;
	}

	public List<KeywordChannel> getKeywordChannelOrder() {
		return this.keywordChannelDao.getKeywordChannels();
	}

	public List<SystemKeyword> getSystemKeywordByChannelId(Long id) {
		return this.systemKeywordDao.getSystemKeywordByChannelId(id);
	}

	public List<SystemKeywordChange> getSystemKeywordWithForeFront(
			SystemKeywordTerm term) {
		List<SystemKeyword> list = this.systemKeywordDao
				.getSystemKeywordWithForeFront(term);
		List<SystemKeywordChange> changeList = null;
		if (list != null) {
			changeList = new ArrayList<SystemKeywordChange>();
			for (SystemKeyword systemKeyword : list) {
				SystemKeywordChange change = new SystemKeywordChange();
				change.setId(systemKeyword.getId());
				change.setName(systemKeyword.getName());
				change.setViewTimes(systemKeyword.getViewTimes());
				double changeNum = (double) (systemKeyword.getYesterday() - systemKeyword
						.getBeforeYesterday())
						/ systemKeyword.getBeforeYesterday();
				change.setChange(changeNum);
				changeList.add(change);
			}
		}
		return changeList;
	}

	public List<UserKeyword> getUserSearchWithForeFront(int size) {
		return this.userKeywordDao.getUserSearchWithForeFront(size);
	}

	public void createUserKeyword(UserKeyword userKeyword)
			throws DataAccessException {
		UserKeyword key = this.userKeywordDao.getUserKeywordByName(userKeyword);
		userKeyword.setAddDate(new Date());
		if (key == null) {
			this.userKeywordDao.createUserKeyword(userKeyword);
		} else {
			this.userKeywordDao.updateUserSearch(userKeyword);
		}
	}
}
