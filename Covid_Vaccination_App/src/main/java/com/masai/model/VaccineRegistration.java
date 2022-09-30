package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
public class VaccineRegistration {
    
	@Id
	private Long mobileNo;
	private LocalDateTime dateofregistration;
	
	@ManyToMany
	private List<Member> member=new ArrayList<>();

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public LocalDateTime getDateofregistration() {
		return dateofregistration;
	}

	public void setDateofregistration(LocalDateTime dateofregistration) {
		this.dateofregistration = dateofregistration;
	}

	public List<Member> getMember() {
		return member;
	}

	public void setMember(List<Member> member) {
		this.member = member;
	}

	public VaccineRegistration(Long mobileNo, LocalDateTime dateofregistration, List<Member> member) {
		super();
		this.mobileNo = mobileNo;
		this.dateofregistration = dateofregistration;
		this.member = member;
	}

	public VaccineRegistration() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
