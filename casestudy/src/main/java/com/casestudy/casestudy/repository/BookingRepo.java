package com.casestudy.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.casestudy.model.BookingDetails;

@Repository
public interface BookingRepo extends MongoRepository<BookingDetails, Integer>{
}
