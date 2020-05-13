package com.casestudy.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.casestudy.dto.CustomerDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.operations.CustomerDetailsOperations;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsOperations customerDetailsOp; 
	
	@PostMapping("/saveCustomerDetails/{id}")
	public ResponseEntity<CustomerDto> saveCustomerDetails(@RequestBody CustomerDto customer, @PathVariable int id) throws CaseStudyException {
		customer.setId(id);
		CustomerDto customerResponse = customerDetailsOp.saveCustomerData(customer);
		return new ResponseEntity<>(customerResponse, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerDetails/{id}")
	public ResponseEntity<CustomerDto> getCustomerDetails(@PathVariable int id) {
		CustomerDto customer = customerDetailsOp.getCustomerData(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
