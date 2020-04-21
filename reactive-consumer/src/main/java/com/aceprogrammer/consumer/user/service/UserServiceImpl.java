package com.aceprogrammer.consumer.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.aceprogrammer.consumer.user.model.User;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public Mono<User> getUser(int userId) {
		List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
		ServiceInstance instance = instances
								   .stream().findAny().get();
		
		UriComponentsBuilder uriBuilder =  UriComponentsBuilder.fromUri(instance.getUri()).path("/user/" + userId);
		log.info("Final url is {}", uriBuilder.build().toUriString());
		
		return webClientBuilder.build().get().uri(uriBuilder.toUriString()).retrieve().bodyToMono(User.class);
										
	}

}
