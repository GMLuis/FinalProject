package com.streamz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.streamz.dao.StreamsSelectionDao;
import com.streamz.entity.Album;
import com.streamz.entity.Artists;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultStreamsSelectionService implements StreamsSelectionService {

	@Autowired
	private StreamsSelectionDao streamsSelectionsDao;

	public List<Album> returnAlbumByArtist(Artists album_id, String album_name) {
		log.info("The Stream method was called with artist={} and Album name={}");
		return streamsSelectionsDao.returnAlbumByArtist(album_id, album_name);
	}

}
