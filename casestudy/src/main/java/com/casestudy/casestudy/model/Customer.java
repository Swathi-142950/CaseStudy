package com.casestudy.casestudy.model;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Customer_Details")
public class Customer {

	@Id
	private int id;
	private String customer_name;
	private String customer_phone;
	private String customer_address;
	private String customer_vehicle_number;
	private Date customer_service_date;
	private String customer_service_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_address() {
		return customer_address;
	}
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}
	public String getCustomer_vehicle_number() {
		return customer_vehicle_number;
	}
	public void setCustomer_vehicle_number(String customer_vehicle_number) {
		this.customer_vehicle_number = customer_vehicle_number;
	}
	public Date getCustomer_service_date() {
		return customer_service_date;
	}
	public void setCustomer_service_date(Date customer_service_date) {
		this.customer_service_date = customer_service_date;
	}
	public String getCustomer_service_time() {
		return customer_service_time;
	}
	public void setCustomer_service_time(String customer_service_time) {
		this.customer_service_time = customer_service_time;
	}
	
}
