package com.casestudy.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.User;

@Repository
public interface UserDetailsRepo extends MongoRepository<User, Integer> {
	List<User> findByRole(String role);
	User findById(int id);
}
