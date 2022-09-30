package com.masai.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.masai.model.VaccineRegistration;

@Repository
public interface VaccinRegistrationDao extends JpaRepository<VaccineRegistration, String> {

}
