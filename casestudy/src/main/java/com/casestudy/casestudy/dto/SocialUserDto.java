package com.casestudy.casestudy.dto;

public class SocialUserDto {

	public String name;
    public String email;
    public String provider;
    public String provideid;
    public String image;
    public String token;
    public String idToken;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getProvideid() {
		return provideid;
	}
	public void setProvideid(String provideid) {
		this.provideid = provideid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getIdToken() {
		return idToken;
	}
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}
    
}
