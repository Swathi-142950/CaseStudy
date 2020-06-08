package com.casestudy.casestudy.dto;

import org.springframework.stereotype.Component;

import com.casestudy.casestudy.model.Cars;
import com.casestudy.casestudy.model.Customer;

@Component
public class BookingDetailsDto {

	private int id;
	private CustomerDto customerDetails;
	private CarsDto carDetails;
	private String payment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CustomerDto getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDto customerDetails) {
		this.customerDetails = customerDetails;
	}
	public CarsDto getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(CarsDto carDetails) {
		this.carDetails = carDetails;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
}
