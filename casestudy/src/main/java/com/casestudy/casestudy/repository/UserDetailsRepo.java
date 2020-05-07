package com.casestudy.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.User;

@Repository
public interface UserDetailsRepo extends MongoRepository<User, Integer> {
}
