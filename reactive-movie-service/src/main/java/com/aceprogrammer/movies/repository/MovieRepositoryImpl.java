package com.aceprogrammer.movies.repository;

import static org.springframework.data.relational.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

import com.aceprogrammer.movies.entity.Movie;

import reactor.core.publisher.Flux;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@Autowired
	private DatabaseClient client;

	@Override
	public Flux<Movie> getMoviesWhereIdIn(List<Integer> movieIds) {
		return client
			   .select()
			   .from(Movie.class)
			   .matching(
					   where("id")
					   .in(movieIds)
					   )
			   .as(Movie.class)
			   .all();
	}

}
