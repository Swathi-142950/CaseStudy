package com.casestudy.casestudy.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.Cars;

@Repository
public interface CarDetailsRepo extends MongoRepository<Cars, Integer>{
}
