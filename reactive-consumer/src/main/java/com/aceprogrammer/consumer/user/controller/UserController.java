package com.aceprogrammer.consumer.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aceprogrammer.consumer.user.model.User;
import com.aceprogrammer.consumer.user.service.UserService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/{userId}")
	public Mono<User> getUser(@PathVariable int userId) {
		return service.getUser(userId);
	}
	

}
