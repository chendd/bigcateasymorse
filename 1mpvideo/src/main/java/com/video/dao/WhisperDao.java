package com.video.dao;

import java.util.Date;

import org.springframework.dao.DataAccessException;

import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.util.Pagination;

public interface WhisperDao {
	
	public void createWhisper(Whisper whisper) throws DataAccessException;
	
	public void deleteWhisper(Long id) throws DataAccessException;
	
	public void getWhispers(Pagination<Whisper> pagination) throws DataAccessException;
	
	public void deleteWhisperByGrade(User user)  throws DataAccessException;
	
	public void deleteWhisperByDate(int dayNum)  throws DataAccessException;
	
	public Whisper getWhisperById(Long id) throws DataAccessException;
	
	public int countNewWhisper(Long id) throws DataAccessException;
	
   public void updateWhisperById(Whisper whisper) throws DataAccessException;

}
