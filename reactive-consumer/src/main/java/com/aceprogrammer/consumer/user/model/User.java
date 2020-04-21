package com.aceprogrammer.consumer.user.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
	
	private int id;
	
	private String name;
	
	private String country;
	
	private List<Integer> movieIds;

}
