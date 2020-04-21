package com.aceprogrammer.userservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.aceprogrammer.userservice.entity.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

}
