package com.masai.model;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class VaccineCount {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer vaccineCountId;	

private Integer vaccineId;
private Integer quantity;
private Double price;
@OneToOne(cascade = CascadeType.ALL)
private Vaccine vaccine;

@JsonIgnore
@ManyToOne(cascade = CascadeType.ALL)
private VaccineInventory vaccineInventory;

}
