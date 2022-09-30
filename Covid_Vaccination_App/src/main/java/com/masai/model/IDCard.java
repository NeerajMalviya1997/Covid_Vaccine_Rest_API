package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;


@Entity
public class IDCard { 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private String name;
	private LocalDateTime Dob;
	private String address;
	private String city;
	private String state;
	private String pincode;
	
	
	@OneToOne
	private Pancard pancard;
	
	
	@OneToOne
	private AdharCard addharcard;
	
	@OneToOne
	private Member member;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDob() {
		return Dob;
	}

	public void setDob(LocalDateTime dob) {
		Dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Pancard getPancard() {
		return pancard;
	}

	public void setPancard(Pancard pancard) {
		this.pancard = pancard;
	}

	public AdharCard getAddharcard() {
		return addharcard;
	}

	public void setAddharcard(AdharCard addharcard) {
		this.addharcard = addharcard;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public IDCard() {
	
	}

	public IDCard(Integer id, String name, LocalDateTime dob, String address, String city, String state, String pincode,
			Pancard pancard, AdharCard addharcard, Member member) {
		super();
		this.id = id;
		this.name = name;
		Dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.pancard = pancard;
		this.addharcard = addharcard;
		this.member = member;
	}

	
}
