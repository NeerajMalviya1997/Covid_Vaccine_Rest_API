package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class VaccineInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private LocalDate date;
	
	@OneToMany
    private List<VaccinationCenter> vaccinationCanter;
	
	@OneToMany
	private List<VaccineCount> vaccinecount=new ArrayList<>();

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<VaccinationCenter> getVaccinationCanter() {
		return vaccinationCanter;
	}

	public void setVaccinationCanter(List<VaccinationCenter> vaccinationCanter) {
		this.vaccinationCanter = vaccinationCanter;
	}

	public List<VaccineCount> getVaccinecount() {
		return vaccinecount;
	}

	public void setVaccinecount(List<VaccineCount> vaccinecount) {
		this.vaccinecount = vaccinecount;
	}

	public VaccineInventory(LocalDate date, List<VaccinationCenter> vaccinationCanter,
			List<VaccineCount> vaccinecount) {
		super();
		this.date = date;
		this.vaccinationCanter = vaccinationCanter;
		this.vaccinecount = vaccinecount;
	}

	public VaccineInventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
