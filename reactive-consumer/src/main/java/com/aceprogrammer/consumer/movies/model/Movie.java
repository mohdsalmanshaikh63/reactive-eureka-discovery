package com.aceprogrammer.consumer.movies.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Movie {
	
	private int id;
	
	private String title;
	
	private String year;
	
	private String rating;

}
