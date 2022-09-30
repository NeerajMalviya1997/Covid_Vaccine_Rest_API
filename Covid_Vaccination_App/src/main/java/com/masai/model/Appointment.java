package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;


@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	private Long mobileNo;
	private LocalDateTime localdate;
	private Integer slot;
	private boolean bookingStatus;
	
	@OneToOne
	private Member member;
	
	
	@ManyToOne
	private VaccinationCenter vaccinationcanter;


	
	public Long getBookingId() {
		return bookingId;
	}



	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}



	public Long getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}



	public LocalDateTime getLocaldate() {
		return localdate;
	}



	public void setLocaldate(LocalDateTime localdate) {
		this.localdate = localdate;
	}



	public Integer getSlot() {
		return slot;
	}



	public void setSlot(Integer slot) {
		this.slot = slot;
	}



	public boolean isBookingStatus() {
		return bookingStatus;
	}



	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}



	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	public VaccinationCenter getVaccinationcanter() {
		return vaccinationcanter;
	}



	public void setVaccinationcanter(VaccinationCenter vaccinationcanter) {
		this.vaccinationcanter = vaccinationcanter;
	}



	public Appointment() {
		
		// TODO Auto-generated constructor stub
	}
	
	
}
