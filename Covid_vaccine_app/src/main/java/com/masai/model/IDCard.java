package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class IDCard { 
	
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private LocalDate Dob;
	private String address;
	private String gender;
	private String city;
	private String state;
	private String pincode;
	
	@JsonIgnore
	@OneToOne
	private Member member;

	@Embedded
	AdharCard adharcard;

	@Embedded
	Pancard pancard;

	public IDCard save(IDCard idCard) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
