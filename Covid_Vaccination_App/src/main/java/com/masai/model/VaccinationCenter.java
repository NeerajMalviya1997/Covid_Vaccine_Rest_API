package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class VaccinationCenter {

	@Id
	private Integer code;
	private String centreName;
	private String Address;
	private String city;
	private String state;
	private String pincode;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getCentreName() {
		return centreName;
	}
	public void setCentreName(String centreName) {
		this.centreName = centreName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public VaccinationCenter(Integer code, String centreName, String address, String city, String state,
			String pincode) {
		super();
		this.code = code;
		this.centreName = centreName;
		Address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	public VaccinationCenter() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
}
