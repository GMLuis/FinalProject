package com.streamz.dao;

import java.util.List;

import com.streamz.entity.Album;
import com.streamz.entity.Artists;

public interface StreamsSelectionDao {
	List<Album> returnAlbumByArtist(Artists Album_id, String album_name);
}
