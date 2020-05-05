package com.casestudy.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.WashPackage;

@Repository
public interface WashDetailsRepo extends MongoRepository<WashPackage, Integer>{
}
