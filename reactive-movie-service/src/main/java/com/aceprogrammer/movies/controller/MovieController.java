package com.aceprogrammer.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceprogrammer.movies.entity.Movie;
import com.aceprogrammer.movies.repository.MovieRepository;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieRepository repository;
	
	@PostMapping("")
	public Flux<Movie> getAllMovies(@RequestBody List<Integer> movieIds) {
		return repository.getMoviesWhereIdIn(movieIds);
	}

}
