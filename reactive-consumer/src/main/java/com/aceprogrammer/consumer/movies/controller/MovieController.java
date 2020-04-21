package com.aceprogrammer.consumer.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceprogrammer.consumer.movies.model.Movie;
import com.aceprogrammer.consumer.movies.service.MovieService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@PostMapping("")
	public Flux<Movie> getUserMovies(@RequestBody List<Integer> movieIds) {
		return service.getUserMovies(movieIds);
	}
	

}
