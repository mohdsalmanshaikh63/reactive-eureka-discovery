package com.aceprogrammer.consumer.movies.service;

import java.util.List;

import com.aceprogrammer.consumer.movies.model.Movie;

import reactor.core.publisher.Flux;

public interface MovieService {
	
	Flux<Movie> getUserMovies(List<Integer> movieIds);

}
