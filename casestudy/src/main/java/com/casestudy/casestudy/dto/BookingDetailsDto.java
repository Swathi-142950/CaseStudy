package com.casestudy.casestudy.dto;

import org.springframework.stereotype.Component;

import com.casestudy.casestudy.model.Cars;
import com.casestudy.casestudy.model.Customer;
import com.casestudy.casestudy.model.Washer;

@Component
public class BookingDetailsDto {

	private int id;
	private CustomerDto customerDetails;
	private CarsDto carDetails;
	private String payment;
	private String packageDetails;
	private WasherDto washerDetails;
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
	public String getPackageDetails() {
		return packageDetails;
	}
	public void setPackageDetails(String packageDetails) {
		this.packageDetails = packageDetails;
	}
	public WasherDto getWasherDetails() {
		return washerDetails;
	}
	public void setWasherDetails(WasherDto washerDto) {
		this.washerDetails = washerDto;
	}
	
	
}
