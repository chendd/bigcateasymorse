package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.Challenge;
import com.video.util.Pagination;

public interface ChallengeDao {
	
	public Challenge createChallenge(Challenge challenge) throws DataAccessException;
	
	public void updateChallenge(Challenge challenge) throws DataAccessException;
	
	public void deleteChallenge(Long id) throws DataAccessException;
	
	public void getChallenges(Pagination<Challenge> pagination) throws DataAccessException;
	
	


}
