package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.ChallengeDao;
import com.video.domain.Challenge;
import com.video.util.Pagination;

public class ChallengeDaoImpl extends SqlMapClientDaoSupport implements ChallengeDao{

	public Challenge createChallenge(Challenge challenge)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteChallenge(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void getChallenges(Pagination<Challenge> pagination)
			throws DataAccessException {
		// TODO Auto-generated method stub
	}

	public void updateChallenge(Challenge challenge) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
