package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	private String vaccinename;
	private String description;
	public Integer getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}
	public String getVaccinename() {
		return vaccinename;
	}
	public void setVaccinename(String vaccinename) {
		this.vaccinename = vaccinename;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Vaccine() {
		
	}
	public Vaccine(Integer vaccineId, String vaccinename, String description) {
		super();
		this.vaccineId = vaccineId;
		this.vaccinename = vaccinename;
		this.description = description;
	}
	

}
