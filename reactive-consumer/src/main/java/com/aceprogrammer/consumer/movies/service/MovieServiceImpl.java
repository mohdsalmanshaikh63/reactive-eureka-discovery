package com.aceprogrammer.consumer.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.aceprogrammer.consumer.movies.model.Movie;

import reactor.core.publisher.Flux;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private WebClient.Builder webClientBuilder;

	@Override
	public Flux<Movie> getUserMovies(List<Integer> movieIds) {
		ServiceInstance instance = discoveryClient.getInstances("movie-service")
								   .stream().findAny().get();
		
		UriComponentsBuilder UriBuilder =  UriComponentsBuilder.fromUri(instance.getUri()).path("/movies/");
		
		return webClientBuilder.build().post().uri(UriBuilder.toUriString()).bodyValue(movieIds).retrieve().bodyToFlux(Movie.class);
										
	}

}
