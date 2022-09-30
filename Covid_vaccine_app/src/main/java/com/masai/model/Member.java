package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberid;
	private Boolean dose1status;
	private Boolean dose2status;
	private LocalDate datefor1dose;	
	private LocalDate datefor2dose;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Vaccine vaccine;

	@ManyToOne(cascade = CascadeType.ALL)
	private VaccineRegistration vaccineRegistration;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member", fetch = FetchType.EAGER)
	private List<Appointment> appointments = new ArrayList<Appointment>();
	
	
	

}
