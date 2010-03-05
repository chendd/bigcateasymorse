package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Administrator;
import com.video.util.Pagination;

public interface AdministratorDao {

	public Administrator getAdministratorByName(String AdminName)
			throws DataAccessException;

	public Administrator getAdministratorById(Long Id)
			throws DataAccessException;

	public Administrator createAdministrator(Administrator administrator)
			throws DataAccessException;

	public void deleteAdministrator(Long Id) throws DataAccessException;

	public void updateAdministrator(Administrator administrator)
			throws DataAccessException;

	public List<Administrator> getAdministratorList()
			throws DataAccessException;

	public void getAdministrators(Pagination<Administrator> pagination)
			throws DataAccessException;

}
