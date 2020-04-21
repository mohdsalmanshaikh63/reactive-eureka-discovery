package com.aceprogrammer.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;
import reactor.core.publisher.Flux;

@Service
@Log
public class UserMovieServiceImpl implements UserMovieService {
	
	@Autowired
	private DatabaseClient client;

	/*public static void main(String[] args) {
		UserDTO user = new UserDTO(1, "Salman Shaikh", "India", null);
		Flux<Integer> flux = Flux.just(1, 2, 3, 4);
		Mono<UserDTO> mono = Mono.just(user);
		mono.subscribe(u -> {
			System.out.println(u);
			u.setMovieIds(flux.collectList().block());
		});
		mono.subscribe(u -> System.out.println(u));
	}*/

	@Override
	public Flux<Integer> getUserMovies(int userId) {
		Flux<Integer> movieIds = client.execute("SELECT movie_id from user_movies where user_id = :user_id")
					 .bind("user_id", userId)
					 .as(Integer.class)
					 .fetch()
					 .all();
		movieIds.subscribe(id -> log.info("Id is: " + id));
		return movieIds;
	}

}
