package com.aceprogrammer.userservice.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Table("users")
public class User {
	
	@Id
	@Column("id")
	private int id;
	
	@Column("name")
	private String name;
	
	@Column("country")
	private String country;
	
	private List<Integer> movieIds;

}
