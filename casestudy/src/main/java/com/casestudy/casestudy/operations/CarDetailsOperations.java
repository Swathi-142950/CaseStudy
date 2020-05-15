package com.casestudy.casestudy.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
			carsDto.setId(carsFetch.getId());
			carsDto.setCategory(carsFetch.getCategory());
			carsDto.setBrand(carsFetch.getBrand());
			carsDto.setName(carsFetch.getName());
			carsDtoList.add(carsDto);
		});
		return carsDtoList;
	}

	public List<CarsDto> saveCars(List<CarsDto> carsListDto) throws CaseStudyException {
		List<Cars> carList = new ArrayList<>();
		for(CarsDto carPackage : carsListDto) {
			if (!carPackage.isDeleteFlag()) {
				Cars carsFetch = carDetailsRepo.findById((carPackage.getId()));
				if(null == carsFetch) {
					carsFetch = new Cars();
					Random random = new Random();
					carsFetch.setId(random.nextInt(1000));
				} else {
					carsFetch.setId(carPackage.getId());
				}
				carsFetch.setBrand(carPackage.getBrand());
				carsFetch.setCategory(carPackage.getCategory());
				carsFetch.setName(carPackage.getName());
				carList.add(carsFetch);
				carDetailsRepo.save(carList);
			} else {
				carDetailsRepo.delete(carPackage.getId());
			}
		}
		return fetchCarDetails();
	}
}
