package com.streamz.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Album {

	private Long albumPk;
	private int artist_id;
	private int album_numId;
	private Artists album_id;
	private String album_name;
	private int released_year;
	private long artist_fk;
}
