package com.video.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.AdministratorDao;
import com.video.domain.Administrator;
import com.video.util.Pagination;

public class AdministratorDaoImpl extends SqlMapClientDaoSupport implements
		AdministratorDao {

	public Administrator createAdministrator(Administrator administrator)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createAdministrator", administrator);
		return administrator;
	}

	public void deleteAdministrator(Long Id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteAdministrator", Id);

	}

	public Administrator getAdministratorById(Long Id)
			throws DataAccessException {
		return (Administrator) getSqlMapClientTemplate().queryForObject(
				"getAdministratorById", Id);
	}

	public Administrator getAdministratorByName(String AdminName)
			throws DataAccessException {
		return (Administrator) getSqlMapClientTemplate().queryForObject(
				"getAdministratorByName", AdminName);
	}

	public void getAdministrators(Pagination<Administrator> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countAdministrator");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Administrator> list;

		
				list = this.getSqlMapClientTemplate().queryForList("getAdministrators",
						pagination);
	


				pagination.setResults(list);
		
		}
	}

	public void updateAdministrator(Administrator administrator)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateAdministrator", administrator);

	}

	public List<Administrator> getAdministratorList()
			throws DataAccessException {
		List<Administrator> administratorList;
		administratorList = getSqlMapClientTemplate().queryForList(
				"getAdministratorList");
		return administratorList;
	}
}
