package com.casestudy.casestudy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.casestudy.casestudy.dto.CarsDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.operations.CarDetailsOperations;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin(origins = "http://localhost:4200")
public class CarDetailsController {

	@Autowired
	CarDetailsOperations carDetailsOp;

	@RequestMapping(value="/fetchCars", method=RequestMethod.GET)
	public ResponseEntity<List<CarsDto>> fetchCarDetails() throws CaseStudyException {
		List<CarsDto> carList = carDetailsOp.fetchCarDetails();
		return new ResponseEntity<>(carList, HttpStatus.OK);
	}
	
	@PostMapping("/saveCars")
	public ResponseEntity<List<CarsDto>> saveCarDetails(@RequestBody List<CarsDto> carsListDto) throws CaseStudyException, IOException {
		List<CarsDto> carList = carDetailsOp.saveCars(carsListDto);
		return new ResponseEntity<>(carList, HttpStatus.OK);
	}
}
