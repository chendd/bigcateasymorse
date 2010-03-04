package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.CollectionVideo;
import com.video.util.Pagination;

public interface CollectionVideoDao {

	public void createCollectionVideo(CollectionVideo collectionVideo)
			throws DataAccessException;

	public void deleteCollectionVideo(Long id) throws DataAccessException;

	public void getCollectionVideoes(Pagination<CollectionVideo> pagination)
			throws DataAccessException;

	public CollectionVideo getCollection(CollectionVideo collectionVideo)
			throws DataAccessException;

}
