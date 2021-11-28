package com.streamz.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Artist {
	private long artistPk;
	private String artist_numId;
	private String artist_name;
}
