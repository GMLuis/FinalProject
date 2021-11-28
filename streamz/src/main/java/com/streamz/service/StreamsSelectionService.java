package com.streamz.service;

import java.util.List;

import com.streamz.entity.Album;
import com.streamz.entity.Artists;



public interface StreamsSelectionService {
	List<Album> returnAlbumByArtist(Artists album_id, String album_name);
}
