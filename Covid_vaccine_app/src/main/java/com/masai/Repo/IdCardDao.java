package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.masai.model.AdharCard;
import com.masai.model.Appointment;
import com.masai.model.IDCard;
import com.masai.model.Pancard;

@Repository
public interface IdCardDao extends JpaRepository<IDCard, Integer> {
	
	
	public IDCard findByPancard(Pancard pancard);

	public IDCard findByAdharcard(AdharCard adharcard);
}
