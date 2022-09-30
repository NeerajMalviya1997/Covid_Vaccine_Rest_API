package com.masai.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Vaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineId;
	private String vaccinename;
	private String description;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "vaccine")
	private VaccineCount vaccinecount;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccine")
	private List<Member> member;

}
