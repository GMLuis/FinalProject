package com.streamz.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import com.streamz.entity.Album;
import com.streamz.entity.Artists;

import lombok.Getter;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {
    "classpath:flyway/migrations/Streams_Schema.sql",
    "classpath:flyway/migrations/Streams_Data.sql"},
    config = @SqlConfig(encoding = "utf-8"))
class SelectSongTest {

		@Test
		void testThatAlbumIsSelectedByArtistAndAlbum() {
			// Given
			Artists album_id = Artists.KANYE_WEST;
			String album_name = "Graduation";
			String uri =
					String.format("http://localhost:%d/?artist=%s&album_name=%s", serverPort, album_id, album_name) ;
			// When
			ResponseEntity<Album> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

			//Then
			assertThat(response.getStatusCode());
			List<Album> expected = buildExpected();
			assertThat(response.getBody()).isEqualTo(expected);
		}

		  @Autowired
		  @Getter
		  private TestRestTemplate restTemplate;

		  @LocalServerPort
		  private int serverPort;

		  protected List<Album> buildExpected(){
			  List<Album> list = new LinkedList<>();
			      list.add(Album.builder()
			      .artist_id(1)
				  .album_id(Artists.KANYE_WEST)
	 			  .album_numId(3)
	 			  .album_name("Graduation")
	 		      .released_year(2007)
				  .build());

			     list.add(Album.builder()
			      .artist_id(1)
				  .album_id(Artists.KANYE_WEST)
	 			  .album_numId(6)
	 			  .album_name("Yeezus")
	 		      .released_year(2013)
				  .build());


			  return list;
		  }

}
