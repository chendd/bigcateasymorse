package com.video.dao;

import java.util.List;

import com.video.domain.connection.DailyAndTag;

public interface DailyAndTagDao {
	public List<DailyAndTag> getDailyAndTagByDailyId(Long id);

	public List<DailyAndTag> getDailyAndTagByTagId(Long id);

	public void deleteDailyAndTagByDailyIdAndTagId(DailyAndTag dailyAndTag);

	public void deleteDailyAndTagByDailyId(Long id);

	public void deleteDailyAndTagByTagId(Long id);

	public void createDailyAndTag(DailyAndTag dailyAndTag);
}
