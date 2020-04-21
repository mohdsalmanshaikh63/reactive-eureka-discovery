package com.aceprogrammer.movies.repository;

import java.util.List;

import com.aceprogrammer.movies.entity.Movie;

import reactor.core.publisher.Flux;

public interface MovieRepository {

	Flux<Movie> getMoviesWhereIdIn(List<Integer> movieIds);
}
