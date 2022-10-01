package com.masai.Repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.User;
import com.masai.model.Vaccine;

@Repository
public interface VaccinDao extends JpaRepository<Vaccine, Integer>{


	
	
	public Optional<Vaccine> findByvaccinename(String name);

}
