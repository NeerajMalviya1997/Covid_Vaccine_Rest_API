package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.VaccineNotFoundException;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.Vaccine;
import com.masai.Repo.AminSessionDao;
import com.masai.Repo.UserSessionDAO;
import com.masai.Repo.VaccinDao;

@Service

public class VaccineServiceImpl implements VaccineService {


	@Autowired
	private VaccinDao dao;
	
	@Autowired
	private AminSessionDao adminSessionDAO;
	
	@Autowired
	private UserSessionDAO userSessionDAO;

	@Override
	public List<Vaccine> allVaccine(String key) {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
			
		List<Vaccine> list = dao.findAll();

		if (list.size() > 0)
			return list;
		else
			throw new VaccineNotFoundException("No Vaccines Available");
	}

	@Override
	public Vaccine getVaccineByName(String VaccineName,String key) {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		
		Optional<Vaccine> vaccine = dao.findByvaccinename(VaccineName);
		
		if(vaccine != null) return vaccine.get();
		else throw new VaccineNotFoundException("Vaccine with name " + VaccineName + " in not available");

	}

	@Override
	public Vaccine getVaccineById(Integer vaccineId,String key) {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> opt = dao.findById(vaccineId);

		if (opt.isPresent())
			return opt.get();

		else
			throw new VaccineNotFoundException("Vaccine with Id " + vaccineId + " is not available");
	}

	@Override
	public Vaccine addVaccine(Vaccine vaccine,String key) {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> vacc = dao.findByvaccinename(vaccine.getVaccinename());
		
		if(vacc.get() == null) {


            return dao.save(vaccine);
		}
		throw new RuntimeException("Vaccine already exists!");
	}

	@Override
	public Vaccine updateVaccine(Vaccine vaccine,String key) {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> opt = dao.findById(vaccine.getVaccineId());

		if (opt.isPresent()) {
			return dao.save(vaccine);
		} else
			throw new VaccineNotFoundException("The vaccine you want to update does not exist!");
	}

	@Override
	public boolean deleteVaccine(Vaccine vaccine,String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<Vaccine> opt = dao.findById(vaccine.getVaccineId());

		if (opt.isPresent()) {
			dao.delete(vaccine);
			return true;
		} else
			throw new VaccineNotFoundException("The vaccine you want to delete does not exist!");
	}

}
