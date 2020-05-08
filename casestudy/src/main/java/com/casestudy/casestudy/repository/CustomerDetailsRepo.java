package com.casestudy.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.Customer;

@Repository
public interface CustomerDetailsRepo extends MongoRepository<Customer, Integer>{
	Customer findById(int id);
}
