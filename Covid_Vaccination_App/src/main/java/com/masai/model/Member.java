package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer memberid;
	private Boolean dose1status;
	private Boolean dose2status;
	private LocalDateTime datefor1dose;	
	private LocalDateTime datefor2dose;
	
	
	@OneToOne
	private IDCard idcard;
	
	@ManyToOne
	private Vaccine vaccine;

	public Integer getMemberid() {
		return memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	public Boolean getDose1status() {
		return dose1status;
	}

	public void setDose1status(Boolean dose1status) {
		this.dose1status = dose1status;
	}

	public Boolean getDose2status() {
		return dose2status;
	}

	public void setDose2status(Boolean dose2status) {
		this.dose2status = dose2status;
	}

	public LocalDateTime getDatefor1dose() {
		return datefor1dose;
	}

	public void setDatefor1dose(LocalDateTime datefor1dose) {
		this.datefor1dose = datefor1dose;
	}

	public LocalDateTime getDatefor2dose() {
		return datefor2dose;
	}

	public void setDatefor2dose(LocalDateTime datefor2dose) {
		this.datefor2dose = datefor2dose;
	}

	public IDCard getIdcard() {
		return idcard;
	}

	public void setIdcard(IDCard idcard) {
		this.idcard = idcard;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Member() {
		
		// TODO Auto-generated constructor stub
	}

	public Member(Integer memberid, Boolean dose1status, Boolean dose2status, LocalDateTime datefor1dose,
			LocalDateTime datefor2dose, IDCard idcard, Vaccine vaccine) {
		super();
		this.memberid = memberid;
		this.dose1status = dose1status;
		this.dose2status = dose2status;
		this.datefor1dose = datefor1dose;
		this.datefor2dose = datefor2dose;
		this.idcard = idcard;
		this.vaccine = vaccine;
	}
	
	
	

}
