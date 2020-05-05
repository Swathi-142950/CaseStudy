package com.casestudy.casestudy.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.WashPackage;
import com.casestudy.casestudy.repository.WashDetailsRepo;

@Service
public class WashDetailsOperations {

	@Autowired
	WashDetailsRepo washDetailsRepo;
	
	public List<WashPackage> fetchWashDetails() throws CaseStudyException {
		return washDetailsRepo.findAll();
	}
}
