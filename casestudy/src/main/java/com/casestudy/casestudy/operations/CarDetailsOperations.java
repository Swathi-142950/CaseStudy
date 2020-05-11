package com.casestudy.casestudy.operations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.CarsDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.Cars;
import com.casestudy.casestudy.repository.CarDetailsRepo;

@Service
public class CarDetailsOperations {

	@Autowired
	CarDetailsRepo carDetailsRepo;
	
	public List<CarsDto> fetchCarDetails() throws CaseStudyException {
		List<Cars> cars = carDetailsRepo.findAll();
		List<CarsDto> carsDtoList = new ArrayList<>();
		cars.stream().forEach(carsFetch -> {
			CarsDto carsDto = new CarsDto();
			carsDto.setId(carsFetch.getId());;
			carsDto.setCategory(carsFetch.getCategory());;
			carsDto.setBrand(carsFetch.getBrand());
			carsDto.setName(carsFetch.getName());
			carsDtoList.add(carsDto);
		});
		return carsDtoList;
	}
}
