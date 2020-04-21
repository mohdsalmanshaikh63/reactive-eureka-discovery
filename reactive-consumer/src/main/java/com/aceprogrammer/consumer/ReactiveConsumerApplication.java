package com.aceprogrammer.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReactiveConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveConsumerApplication.class, args);
	}

}
