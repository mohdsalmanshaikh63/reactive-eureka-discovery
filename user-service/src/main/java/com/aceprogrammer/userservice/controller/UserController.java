package com.aceprogrammer.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceprogrammer.userservice.entity.User;
import com.aceprogrammer.userservice.repository.UserRepository;
import com.aceprogrammer.userservice.service.UserMovieServiceImpl;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserMovieServiceImpl userMovieService;

	@GetMapping("")
	public Flux<User> getAllUser() {
		return repository.findAll();
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Mono<User>> getUserById(@PathVariable int userId) {
		Flux<Integer> movieIds = userMovieService.getUserMovies(userId);
		Mono<User> user = repository.findById(userId).map(u -> {
			u.setMovieIds(movieIds.collectList().block());
			log.info("changed user object to {}", u);
			return u;
		});
		return ResponseEntity.ok(user);

	}

}
