package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GeneratorType;


@Entity
public class VaccineCount {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer vaccineCountId;	
private Integer quantity;
private Integer price;

public VaccineCount(Integer vaccineCountId, Integer quantity, Integer price, List<Vaccine> vaccine) {
	super();
	this.vaccineCountId = vaccineCountId;
	this.quantity = quantity;
	this.price = price;
	this.vaccine = vaccine;
}

public VaccineCount() {
	
	// TODO Auto-generated constructor stub
}

public Integer getVaccineCountId() {
	return vaccineCountId;
}

public void setVaccineCountId(Integer vaccineCountId) {
	this.vaccineCountId = vaccineCountId;
}

public Integer getQuantity() {
	return quantity;
}

public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}

public Integer getPrice() {
	return price;
}

public void setPrice(Integer price) {
	this.price = price;
}

public List<Vaccine> getVaccine() {
	return vaccine;
}

public void setVaccine(List<Vaccine> vaccine) {
	this.vaccine = vaccine;
}

@ManyToMany
private List<Vaccine> vaccine=new ArrayList<>();
}
