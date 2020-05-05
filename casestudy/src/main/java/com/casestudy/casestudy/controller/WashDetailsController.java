package com.casestudy.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.WashPackage;
import com.casestudy.casestudy.operations.WashDetailsOperations;

@RestController
@RequestMapping("/wash")
@CrossOrigin(origins = "http://localhost:4200")
public class WashDetailsController {

	@Autowired
	WashDetailsOperations washDetailsOp;

	@RequestMapping(value="/fetchWashPackages", method=RequestMethod.GET)
	public ResponseEntity<List<WashPackage>> fetchCarDetails() throws CaseStudyException {
		List<WashPackage> carList = washDetailsOp.fetchWashDetails();
		return new ResponseEntity<>(carList, HttpStatus.OK);
	}
}
