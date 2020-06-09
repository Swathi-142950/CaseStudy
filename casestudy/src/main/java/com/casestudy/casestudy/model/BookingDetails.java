package com.casestudy.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Booking_Details")
public class BookingDetails {
	@Id
	private int id;
	private Customer customerDetails;
	private Cars carDetails;
	private String payment;
	private String packageDetails;
	private Washer washerDetails;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}
	public Cars getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(Cars carDetails) {
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
	public Washer getWasherDetails() {
		return washerDetails;
	}
	public void setWasherDetails(Washer washerDetails) {
		this.washerDetails = washerDetails;
	}
	
}
