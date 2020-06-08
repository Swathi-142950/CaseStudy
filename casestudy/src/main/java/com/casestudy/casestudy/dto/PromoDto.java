package com.casestudy.casestudy.dto;

import org.springframework.stereotype.Component;

@Component
public class PromoDto {
	private int id;
	private String promoCode;
	private String description;
	private boolean isDeleteFlag;
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDeleteFlag() {
		return isDeleteFlag;
	}
	public void setDeleteFlag(boolean isDeleteFlag) {
		this.isDeleteFlag = isDeleteFlag;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
