package com.casestudy.casestudy.operations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.WashPackageDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.WashPackage;
import com.casestudy.casestudy.repository.WashDetailsRepo;

@Service
public class WashDetailsOperations {

	@Autowired
	WashDetailsRepo washDetailsRepo;
	
	public List<WashPackageDto> fetchWashDetails() throws CaseStudyException {
		List<WashPackage> users = washDetailsRepo.findAll();
		List<WashPackageDto> washDtoList = new ArrayList<>();
		users.stream().forEach(washFetch -> {
			WashPackageDto washDto = new WashPackageDto();
			washDto.setId(washFetch.getId());
			washDto.setPackageValue(washFetch.getPackageValue());
			washDto.setPrice(washFetch.getPrice());
			washDtoList.add(washDto);
		});
		return washDtoList;
	}
}
