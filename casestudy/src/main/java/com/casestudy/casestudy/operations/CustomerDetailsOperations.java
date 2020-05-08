package com.casestudy.casestudy.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.Customer;
import com.casestudy.casestudy.repository.CustomerDetailsRepo;

@Service
public class CustomerDetailsOperations {
	
	@Autowired
	private CustomerDetailsRepo customerDetailsRepo;
	
	public Customer saveCustomerData(Customer customer) throws CaseStudyException {
		return customerDetailsRepo.save(customer);
	}

	public Customer getCustomerData(int id) {
		return customerDetailsRepo.findById(id);
	}
}
