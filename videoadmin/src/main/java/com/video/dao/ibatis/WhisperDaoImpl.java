package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.WhisperDao;
import com.video.domain.Tag;
import com.video.domain.User;
import com.video.domain.Whisper;
import com.video.util.Pagination;

public class WhisperDaoImpl extends SqlMapClientDaoSupport implements
		WhisperDao {

	public void createWhisper(Whisper whisper) throws DataAccessException {
		getSqlMapClientTemplate().insert("createWhisper", whisper);

	}

	public void deleteWhisper(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteWhisperById",id);

	}

	public void getWhispers(Pagination<Whisper> pagination)
			throws DataAccessException {
		if(pagination.getCondition()!=null){
			Whisper whisper = (Whisper) pagination.getCondition();
			
			if (whisper.getMessage() != null && !whisper.getMessage().isEmpty()) {
				whisper.setMessage(MessageFormat.format("%{0}%",whisper.getMessage()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
			
			
		}
		
		
		
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countWhisper",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Whisper> list;

			list = getSqlMapClientTemplate()
					.queryForList("getWhispers", pagination);

			pagination.setResults(list);
		}
	}

	public void deleteWhisperByGrade(User user) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteWhisperByGrade", user);

	}

	public void deleteWhisperByDate(int dayNum) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteWhisperByDate", dayNum);

	}

	public Whisper getWhisperById(Long id) throws DataAccessException {
		return (Whisper)getSqlMapClientTemplate().queryForObject("getWhisperById",id);
	}


	

}
