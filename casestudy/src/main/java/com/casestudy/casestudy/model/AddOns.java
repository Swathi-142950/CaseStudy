package com.casestudy.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="AddOn_Details")
public class AddOns {

	@Id
	private int id;
	private String addOnName;
	private double addOnCost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddOnName() {
		return addOnName;
	}
	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}
	public double getAddOnCost() {
		return addOnCost;
	}
	public void setAddOnCost(double addOnCost) {
		this.addOnCost = addOnCost;
	}
	
	
}
