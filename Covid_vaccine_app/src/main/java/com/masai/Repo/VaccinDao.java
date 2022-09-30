package com.masai.Repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.User;
import com.masai.model.Vaccine;
import com.masai.model.VaccineInventory;

@Repository
public interface VaccinDao extends JpaRepository<Vaccine, Integer>{

	
	public Optional<User> findByMobileNo(String mobileNo);
	
	public Optional<Vaccine> findByvaccinename(String name);

}
