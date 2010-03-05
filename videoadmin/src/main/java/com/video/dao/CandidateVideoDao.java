package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.CandidateVideo;
import com.video.util.Pagination;

public interface CandidateVideoDao {
	public CandidateVideo createCandidateVideo(CandidateVideo candidateVideo) throws DataAccessException;
	
	public void updateCandidateVideo(CandidateVideo candidateVideo) throws DataAccessException;
	 
	public void getCandidateVideoes(Pagination<CandidateVideo> pagination) throws DataAccessException;
	
	public List<CandidateVideo> getCandidateVideoeList() throws DataAccessException;
	
	public CandidateVideo getCandidateVideoByVideoId(Long vid) throws DataAccessException;
	
	public void deleteCandidateVideo(Long id) throws DataAccessException;
 

}
