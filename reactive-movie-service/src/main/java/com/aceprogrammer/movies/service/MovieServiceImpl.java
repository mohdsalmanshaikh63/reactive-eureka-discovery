package com.aceprogrammer.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aceprogrammer.movies.entity.Movie;
import com.aceprogrammer.movies.repository.MovieRepository;

import reactor.core.publisher.Flux;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository repository;

	@Override
	public Flux<Movie> getMoviesWhereIdIn(List<Integer> movieIds) {
		return repository.getMoviesWhereIdIn(movieIds);
	}

}
