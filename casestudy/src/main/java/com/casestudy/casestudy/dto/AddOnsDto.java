package com.casestudy.casestudy.dto;

import org.springframework.stereotype.Component;

@Component
public class AddOnsDto {


	private int id;
	private String addOnName;
	private double addOnCost;
	private boolean deleteFlag;
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
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}
