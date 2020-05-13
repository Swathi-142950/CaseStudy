package com.casestudy.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.AddOns;

@Repository
public interface AddOnRepo extends MongoRepository<AddOns, Integer>{
		AddOns findById(int id);
}
