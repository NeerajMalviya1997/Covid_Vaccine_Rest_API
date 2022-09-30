package com.masai.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class VaccinationCenter {

	@Id
	private Integer code;
	private String centreName;
	private String Address;
	private String city;
	private String state;
	private String pincode;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccinationCenter")
	private List<Appointment> appointments;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private VaccineInventory vaccineInventory;
	
	
}
