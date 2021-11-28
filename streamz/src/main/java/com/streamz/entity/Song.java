package com.streamz.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Song {
	private Long songPk;
	private int album_id;
	private int song_id;
	private String Song_name;
	private Float song_duration;
}

