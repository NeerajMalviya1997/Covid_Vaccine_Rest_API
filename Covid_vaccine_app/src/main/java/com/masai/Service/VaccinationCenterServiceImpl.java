package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repo.AminSessionDao;
import com.masai.Repo.VaccinCenterDao;
import com.masai.exceptions.VaccineCenterException;
import com.masai.exceptions.VaccineCenterNotFoundException;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.VaccinationCenter;
import com.masai.Repo.AminSessionDao;
import com.masai.Repo.UserSessionDAO;
import com.masai.Repo.VaccinCenterDao;

@Service
public class VaccinationCenterServiceImpl implements VaccinationCenterService {

	@Autowired
	private VaccinCenterDao dao;
	
	@Autowired
	private AminSessionDao adminSessionDAO;
	
	@Autowired
	private UserSessionDAO userSessionDAO;

	@Override
	public List<VaccinationCenter> allVaccineCenters(String key) {
		
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		
		List<VaccinationCenter> list = dao.findAll();
		if (list.size() == 0)
			throw new VaccineCenterException("No Vaccination Center Found...");
		return list;
	}

	@Override
	public VaccinationCenter getVaccineCenter(Integer centerid,String key) {
		Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
	
		return dao.findById(centerid).orElseThrow(
				() -> new VaccineCenterNotFoundException("No vaccination center is found by the id : " + centerid));
	}

	@Override
	public VaccinationCenter addVaccineCenter(VaccinationCenter center,String key) {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		
		Optional<VaccinationCenter> vc = dao.findById(center.getCode());

		if (vc.isPresent()) {
			throw new VaccineCenterException("Vaccination center is present with the same Id");
		}
		return dao.save(center);
	}

	@Override
	public VaccinationCenter updateVaccineCenter(VaccinationCenter center,String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<VaccinationCenter> vc = dao.findById(center.getCode());

		if (vc.isPresent()) {
			return dao.save(center);
		} else
			throw new VaccineCenterNotFoundException("Vaccination center is not present with the same Id");

	}

	@Override
	public boolean deleteVaccineCenter(VaccinationCenter center,String key) {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		Optional<VaccinationCenter> vc = dao.findById(center.getCode());

		if (vc.isPresent()) {
			dao.delete(center);
			return true;
		} else
			throw new VaccineCenterNotFoundException("Vaccination center is not present with the same Id");
	}

}
