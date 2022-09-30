package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.masai.Repo.AminSessionDao;
import com.masai.exceptions.IdCardException;
import com.masai.exceptions.IdCardNotFoundException;
import com.masai.exceptions.MemberNotFoundException;
import com.masai.model.AdharCard;
import com.masai.model.CurrentAdminSession;
import com.masai.model.IDCard;
import com.masai.model.IDCard;
import com.masai.model.Pancard;
import com.masai.model.Pancard;
import com.masai.Repo.AminSessionDao;
import com.masai.Repo.IdCardDao;

@Service
public class IdCardServiceImpl implements IdCardService {

	@Autowired
	private IdCardDao idDao;

	@Autowired
	private AminSessionDao adminSessionDAO;
	

	@Override
	public IDCard getIdCardByAdharNo(Long adharno,String key) throws MemberNotFoundException {

		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
		
		IDCard idcard = idDao.findByAdharcard(new AdharCard(adharno));
		if (idcard == null)
			throw new IdCardNotFoundException("IdCard not found with the adharNo :" + adharno);
		else
			return idcard;
	}

	@Override
	public IDCard addIdCard(IDCard idCard) {
		IDCard id = idDao.findByPancard(idCard.getPancard());
		if (id != null)
			throw new IdCardException("Id card already exist with the id : " + idCard.getPancard());
		IDCard id2 = idDao.findByAdharcard(idCard.getAdharcard());
		if (id2 != null)
			throw new IdCardException("Id card already exist with the id : " + idCard.getAdharcard());

		return idDao.save(idCard);
	}

	@Override
	public IDCard getIdcardByPanNo(String panNo, String key) throws IdCardNotFoundException {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
				
			}
		
		
		IDCard idcard = idDao.findByPancard(new Pancard(panNo));
		if (idcard == null)
			throw new IdCardNotFoundException("Idcard not found with the  panNo:" + panNo);
		else
			return idcard;
		
	}

	

}