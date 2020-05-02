package com.casestudy.casestudy.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.model.Cars;
import com.casestudy.casestudy.repository.CarDetailsRepo;

@Service
public class CarDetailsOperations {

	@Autowired
	CarDetailsRepo carDetailsRepo;
	
	public List<Cars> fetchCarDetails() {
		System.out.println("Entered operation");
		return carDetailsRepo.findAll();
	}
}