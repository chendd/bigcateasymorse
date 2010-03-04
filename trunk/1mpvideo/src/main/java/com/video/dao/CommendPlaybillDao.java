package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.CommendPlaybill;
import com.video.domain.PlaybillCommet;
import com.video.util.Pagination;

public interface CommendPlaybillDao {
	public void createCommendPlaybill(CommendPlaybill commendPlaybill)
			throws DataAccessException;

	public void updateCommendPlaybill(CommendPlaybill commendPlaybill)
			throws DataAccessException;

	public void deleteCommendPlaybill(Long id) throws DataAccessException;

	public List<CommendPlaybill> getCommendPlaybill()
			throws DataAccessException;

	public void createCommentPlaybill(PlaybillCommet commet)
			throws DataAccessException;

	public void getCommentPlaybillByPlaybillId(
			Pagination<PlaybillCommet> pagination) throws DataAccessException;

	public void updateCommendPlaybillWithBrowseCount(
			CommendPlaybill commendPlaybill) throws DataAccessException;

}
