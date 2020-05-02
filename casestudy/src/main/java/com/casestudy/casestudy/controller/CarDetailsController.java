package com.casestudy.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.model.Cars;
import com.casestudy.casestudy.operations.CarDetailsOperations;

@RestController
@RequestMapping("/cars")
public class CarDetailsController {

	@Autowired
	CarDetailsOperations carDetailsOp;

	@RequestMapping(value="/fetchCars", method=RequestMethod.GET)
	public ResponseEntity<List<Cars>> fetchCarDetails() {
		List<Cars> carList = carDetailsOp.fetchCarDetails();
		return new ResponseEntity<>(carList, HttpStatus.OK);
	}
}
