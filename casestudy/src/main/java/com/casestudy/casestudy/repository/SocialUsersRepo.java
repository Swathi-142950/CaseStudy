package com.casestudy.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.SocialUser;

@Repository
public interface SocialUsersRepo extends MongoRepository<SocialUser, String>{

}
