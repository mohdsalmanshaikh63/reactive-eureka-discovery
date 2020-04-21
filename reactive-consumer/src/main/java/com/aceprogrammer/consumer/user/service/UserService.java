package com.aceprogrammer.consumer.user.service;

import com.aceprogrammer.consumer.user.model.User;

import reactor.core.publisher.Mono;

public interface UserService {
	
	Mono<User> getUser(int userId);

}
