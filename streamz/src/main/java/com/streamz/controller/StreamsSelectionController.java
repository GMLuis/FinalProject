package com.streamz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.streamz.entity.Artists;
import com.streamz.entity.Album;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

public interface StreamsSelectionController {

	@RequestMapping("/streams")
	@OpenAPIDefinition (info = @Info (title = "Streaming service"), servers = {
		@Server(url = "https://localhost:8080", description = "Local server.")})
	public interface StreamsSelectionsController {


		 @Operation(
					summary = "Returns List of songs",
					description = "Returns a list of songs given by optional artist and/or album",
					responses = {
					@ApiResponse (
						responseCode = "200",
					    description = "A list of songs is returned",
						content = @Content (
						  mediaType = "application/json",
						  schema = @Schema (implementation = Album.class))),
		     		@ApiResponse (
						responseCode = "400",
						description = "The request parameter are invalid",
					    content = @Content (
						  mediaType = "application/json")),
				    @ApiResponse (
					    responseCode = "404",
				        description = "No songs were found with the input criteria",
					    content = @Content (
						  mediaType = "application/json")),
				    @ApiResponse (
				    	responseCode = "500",
					    description = "An uplanned error occurred.",
					    content = @Content (
					      mediaType = "application/json")),
				    },
				     parameters = {
						@Parameter(
							name = "album_id",
							description = "The artist's name (i.e., 'Kanye West') "),
						@Parameter(
							name = "album_name",
							description = "The album's name (i.e., 'Graduation') ")
					}
			)
		 @GetMapping
		 	@ResponseStatus(code = HttpStatus.OK)
			  List<Album> returnAlbumByArtist(@RequestParam (value = "album_id" , defaultValue = "KANYE_WEST") Artists album_id,
					  @RequestParam(value = "album_name", defaultValue = "Graduation")
					   String album_name);

	 }

}
