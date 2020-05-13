package com.casestudy.casestudy.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.AddOnsDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.AddOns;
import com.casestudy.casestudy.repository.AddOnRepo;

@Service
public class AddOnOperations {

	@Autowired
	AddOnRepo addOnsRepo;

	public List<AddOnsDto> fetchAddOns() throws CaseStudyException {
		List<AddOns> addOns = addOnsRepo.findAll();
		List<AddOnsDto> addOnsDtoList = new ArrayList<>();
		addOns.stream().forEach(addOnsFetch -> {
			AddOnsDto addOnsDto = new AddOnsDto();
			addOnsDto.setId(addOnsFetch.getId());
			addOnsDto.setAddOnCost(addOnsFetch.getAddOnCost());
			addOnsDto.setAddOnName(addOnsFetch.getAddOnName());
			addOnsDtoList.add(addOnsDto);
		});
		return addOnsDtoList;
	}

	public List<AddOnsDto> saveAddOns(List<AddOnsDto> addOnsListDto) throws CaseStudyException {
		List<AddOns> addOnsList = new ArrayList<>();
		for (AddOnsDto addOnsPackage : addOnsListDto) {
			AddOns addOnsFetch = addOnsRepo.findById((addOnsPackage.getId()));
			if (null == addOnsFetch) {
				addOnsFetch = new AddOns();
				Random random = new Random();
				addOnsFetch.setId(random.nextInt(1000));
			} else {
				addOnsFetch.setId(addOnsPackage.getId());
			}
			addOnsFetch.setAddOnCost(addOnsPackage.getAddOnCost());
			addOnsFetch.setAddOnName(addOnsPackage.getAddOnName());
			addOnsList.add(addOnsFetch);
			addOnsRepo.save(addOnsList);
		}
		return fetchAddOns();
	}
}
