package com.casestudy.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.dto.AddOnsDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.operations.AddOnOperations;

@RestController
@RequestMapping("/api/addons")
@CrossOrigin(origins = "http://localhost:4200")
public class AddOnController {

	@Autowired
	AddOnOperations addOnOp;

	@GetMapping("/fetchAddOns")
	public ResponseEntity<List<AddOnsDto>> fetchAddOnDetails() throws CaseStudyException {
		List<AddOnsDto> addOnList = addOnOp.fetchAddOns();
		return new ResponseEntity<>(addOnList, HttpStatus.OK);
	}

	@PostMapping("/saveAddOns")
	public ResponseEntity<List<AddOnsDto>> saveAddOnDetails(@RequestBody List<AddOnsDto> addOnsListDto)
			throws CaseStudyException {
		List<AddOnsDto> addOnsList = addOnOp.saveAddOns(addOnsListDto);
		return new ResponseEntity<>(addOnsList, HttpStatus.OK);
	}
}
