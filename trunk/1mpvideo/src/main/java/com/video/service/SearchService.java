package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.KeywordChannel;
import com.video.domain.SystemKeyword;
import com.video.domain.SystemKeywordChange;
import com.video.domain.SystemKeywordTerm;
import com.video.domain.UserKeyword;

public interface SearchService {
	public List<KeywordChannel> getKeywordChannelOrder()throws DataAccessException;

	public List<SystemKeyword> getSystemKeywordByChannelId(Long id)throws DataAccessException;

	public List<SystemKeywordChange> getSystemKeywordWithForeFront(
			SystemKeywordTerm term)throws DataAccessException;

	public List<UserKeyword> getUserSearchWithForeFront(int size)throws DataAccessException;

	public void createUserKeyword(UserKeyword userKeyword)
			throws DataAccessException;
}
