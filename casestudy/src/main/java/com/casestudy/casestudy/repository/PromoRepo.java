package com.casestudy.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.casestudy.model.Promo;

public interface PromoRepo extends MongoRepository<Promo, Integer>{

	Promo findById(int code);
}
