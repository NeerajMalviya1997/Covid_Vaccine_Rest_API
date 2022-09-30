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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class VaccineInventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineInventoryId;
	
	private LocalDate date;
	
	@OneToMany
    private List<VaccinationCenter> vaccinationCanter;
	
	@OneToMany
	private List<VaccineCount> vaccinecount=new ArrayList<>();

	
	
	
}
