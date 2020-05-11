package com.casestudy.casestudy.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.casestudy.dto.CustomerDto;
import com.casestudy.casestudy.exception.CaseStudyException;
import com.casestudy.casestudy.model.Customer;
import com.casestudy.casestudy.repository.CustomerDetailsRepo;

@Service
public class CustomerDetailsOperations {
	
	@Autowired
	private CustomerDetailsRepo customerDetailsRepo;
	
	public CustomerDto saveCustomerData(CustomerDto customerDto) throws CaseStudyException {
		Customer customer = new Customer();
		customer.setId(customerDto.getId());
		customer.setCustomer_address(customerDto.getCustomer_address());
		customer.setCustomer_name(customerDto.getCustomer_name());
		customer.setCustomer_phone(customerDto.getCustomer_phone());
		customer.setCustomer_service_date(customerDto.getCustomer_service_date());
		customer.setCustomer_service_time(customerDto.getCustomer_service_time());
		customer.setCustomer_vehicle_number(customerDto.getCustomer_vehicle_number());
		customerDetailsRepo.save(customer);
		return customerDto;
	}

	public CustomerDto getCustomerData(int id) {
		Customer customer = customerDetailsRepo.findById(id);
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomer_address(customer.getCustomer_address());
		customerDto.setCustomer_name(customer.getCustomer_name());
		customerDto.setCustomer_phone(customer.getCustomer_phone());
		customerDto.setCustomer_service_date(customer.getCustomer_service_date());
		customerDto.setCustomer_service_time(customer.getCustomer_service_time());
		customerDto.setCustomer_vehicle_number(customer.getCustomer_vehicle_number());
		customerDto.setId(customer.getId());
		return customerDto;
	}
}
