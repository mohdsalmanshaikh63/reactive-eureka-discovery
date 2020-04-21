package com.aceprogrammer.movies.service;

import java.util.List;

import com.aceprogrammer.movies.entity.Movie;

import reactor.core.publisher.Flux;

public interface MovieService {
	
	
	Flux<Movie> getMoviesWhereIdIn(List<Integer> movieIds);

}
