package com.casestudy.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.Washer;

@Repository
public interface WasherRepo extends MongoRepository<Washer, Integer>{
	Washer findById(int id);
	List<Washer> findByStatus(String status);
}
