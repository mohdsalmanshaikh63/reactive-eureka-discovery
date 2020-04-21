package com.aceprogrammer.movies.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("movies")
public class Movie {
	
	@Id
	@Column("id")
	private int id;
	
	@Column("title")
	private String title;
	
	@Column("year")
	private String year;
	
	@Column("rating")
	private String rating;

}
