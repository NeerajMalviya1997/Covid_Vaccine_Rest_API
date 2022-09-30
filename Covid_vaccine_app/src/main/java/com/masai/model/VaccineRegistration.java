package com.masai.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VaccineRegistration {
    
	@Id
	private String mobileNo;
	private LocalDateTime dateofregistration;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vaccineRegistration")
	private List<Member> members;
	
	
	
	
}
