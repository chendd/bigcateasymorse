package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.AuspiceAnnal;
import com.video.util.Pagination;

public interface AuspiceAnnalDao {
	
	public void createAuspiceAnnal(AuspiceAnnal auspiceAnnal ) throws DataAccessException;
	
	public void getAuspiceAnnals(Pagination<AuspiceAnnal> pagination) throws DataAccessException;

}
