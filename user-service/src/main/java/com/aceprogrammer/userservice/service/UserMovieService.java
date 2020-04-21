package com.aceprogrammer.userservice.service;

import reactor.core.publisher.Flux;

public interface UserMovieService {
	
	Flux<Integer> getUserMovies(int userId);

}
