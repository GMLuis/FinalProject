package com.streamz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.streamz.entity.Album;
import com.streamz.entity.Artists;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DefaultStreamsSelectionDao implements StreamsSelectionDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	public List<Album> returnAlbumByArtist(Artists album_id, String album_name) {
		log.debug("DAO: artist and album" , album_id, album_name);

		String sql = ""
				+ "SELECT * "
				+ "FROM albums "
				+ "WHERE album_id = :album_id AND album_name = :album_name) ";

			Map<String,String> params = new HashMap<>();
			params.put("aLbum_id", album_id.toString());
			params.put("album_name", album_name.toString());


		   return jdbcTemplate.query(sql, params, new RowMapper<>() {


			public  Album mapRow(ResultSet rs, int rowNum) throws SQLException {
					return Album.builder()
 					.album_id(Artists.valueOf(rs.getString("album_id")))
 					.album_numId(rs.getInt("album_numId"))
 					.album_name(rs.getString("album_name"))
 					.released_year(rs.getInt("released_year"))
					.build();
				}});
	}


}
