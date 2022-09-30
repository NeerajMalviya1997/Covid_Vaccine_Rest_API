package com.masai.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.Enum.Slots;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	private Long mobileNo;
	private LocalDate dateofbooking;
	private Slots slot;
	private boolean bookingStatus;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	Member member;

	@ManyToOne(cascade = CascadeType.ALL)
	VaccinationCenter vaccinationCenter;
	
	
	
}
