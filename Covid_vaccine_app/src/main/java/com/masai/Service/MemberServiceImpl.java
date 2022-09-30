package com.masai.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.MemberNotFoundException;
import com.masai.model.AdharCard;
import com.masai.model.Appointment;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.IDCard;
import com.masai.model.Member;
import com.masai.model.Pancard;
import com.masai.model.Vaccine;
import com.masai.model.VaccineCount;
import com.masai.model.VaccineRegistration;
import com.masai.Repo.AminSessionDao;
import com.masai.Repo.AppointmentDao;
import com.masai.Repo.IdCardDao;
import com.masai.Repo.MemberDao;
import com.masai.Repo.UserSessionDAO;
import com.masai.Repo.VaccineCountDao;
import com.masai.Repo.VaccinDao;
import com.masai.Repo.VaccinRegistrationDao;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao dao;

	@Autowired
	IdCardDao idDao;

	@Autowired
	VaccinRegistrationDao vrDao;

	@Autowired
	AppointmentDao apDao;

	@Autowired
	VaccinDao vDao;

	@Autowired
	VaccineCountDao countDao;
	
	@Autowired
	private AminSessionDao adminSessionDAO;
	
	@Autowired
	private UserSessionDAO userSessionDAO;

	@Override
	public Member addMemberbyMobileNo(Member member, String mobileNo,String key) throws MemberNotFoundException {
		
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		
		
		Optional<VaccineRegistration> vacc = vrDao.findById(mobileNo);
		if (vacc.isPresent()) {
			IDCard idcard = idDao.findByAdharcard(member.getIdCard().getAdharcard());
			if (idcard == null)

			{
				member.setVaccineRegistration(vacc.get());
				member.setDatefor1dose(null);
				member.setDatefor2dose(null);
				member.setDose1status(false);
				member.setDose2status(false);
				return dao.save(member);
			} else
				throw new MemberNotFoundException("Member is already present");
		} else
			throw new MemberNotFoundException("This MOBILE NUMBER is NOT REGISTERED:" + mobileNo);
	}

	@Override
	public Member updateMember(Member member, Integer mid,String key) throws MemberNotFoundException {
	
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		
		Optional<Member> mId = dao.findById(mid);
		if (mId.isPresent()) {
			Member exist = mId.get();
			if (member.getIdCard() != null) {
				IDCard id = exist.getIdCard();
				if (member.getIdCard().getDob() != null)
					id.setDob(member.getIdCard().getDob());
				if (member.getIdCard().getCity() != null)
					id.setCity(member.getIdCard().getCity());
				
				if (member.getIdCard().getAddress() != null)
					id.setAddress(member.getIdCard().getAddress());
				if (member.getIdCard().getPincode() != null)
					id.setPincode(member.getIdCard().getPincode());
				if (member.getIdCard().getState() != null)
					id.setState(member.getIdCard().getState());

				if (member.getIdCard().getAdharcard() != null) {
					AdharCard adar = exist.getIdCard().getAdharcard();
					adar.setAdharNo(member.getIdCard().getAdharcard().getAdharNo());
				}

				if (member.getIdCard().getPancard() != null) {
					Pancard pan = exist.getIdCard().getPancard();
					pan.setPanNo(member.getIdCard().getPancard().getPanNo());
				}
			}
			return dao.save(exist);
		} else
			throw new MemberNotFoundException("Member not found with the MEMBER ID :" + member.getMemberid());
	}

	@Override
	public Member getMemberById(Integer idcardid,String key) throws MemberNotFoundException {
		
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()&&!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		
		Optional<IDCard> idcard = idDao.findById(idcardid);
		if (idcard != null) {
			Member mbyId = dao.findByIdCard(idcard);
			if (mbyId != null) {
				List<Appointment> appointment = apDao.findByMember(mbyId);
				mbyId.setAppointments(appointment);
				return mbyId;
			} else
				throw new MemberNotFoundException("Member not found  with the IDCARD ID:" + idcardid);
		} else
			throw new MemberNotFoundException("Member not found  with the IDCARD ID:" + idcardid);
	}

	@Override
	public boolean deleteMember(Integer mid,String key) throws MemberNotFoundException {
		
		 Optional<CurrentUserSession> optCurrUser= userSessionDAO.findByUuid(key);
			
			if(!optCurrUser.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
	
		
		Optional<Member> mId = dao.findById(mid);
		if (mId.isPresent()) {
			Member exist = mId.get();
			if (exist.getVaccineRegistration() != null)
				vrDao.delete(exist.getVaccineRegistration());
			if (exist.getIdCard() != null)
				idDao.delete(exist.getIdCard());
			if (exist.getAppointments() != null)
				apDao.deleteAll(exist.getAppointments());
			dao.delete(exist);
			return true;
		} else
			throw new MemberNotFoundException("Member not found with the MEMBER ID :" + mid);
	}

	@Override
	public Member getMemberByPanNo(String panNo,String key) throws MemberNotFoundException {
	
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
		
		IDCard idcard = idDao.findByPancard(new Pancard(panNo));
		if (idcard != null) {
			Optional<IDCard> id = idDao.findById(idcard.getId());
			Member mbyId = dao.findByIdCard(id);
			if (mbyId != null)
				return mbyId;
			else
				throw new MemberNotFoundException("Member doesnot exist with the PAN NUMBER : " + panNo);
		} else
			throw new MemberNotFoundException("Member doesnot exist with the PAN NUMBER : " + panNo);
	}

	@Override
	public boolean deleteMemberRecord(Member member,String key) throws MemberNotFoundException {
		
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
		
		
		Optional<Member> mId = dao.findById(member.getMemberid());
		if (mId.isPresent()) {
			Member exist = mId.get();
			
			dao.delete(member);
			return true;
		} else
			throw new MemberNotFoundException("Member not found with the MEMBER ID :" + member.getMemberid());
	}

	@Override
	public Member getMemberByAdharNo(Long adharno,String key) throws MemberNotFoundException {
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
		
		IDCard idcard = idDao.findByAdharcard(new AdharCard(adharno));
		Optional<IDCard> idcard1 = idDao.findById(idcard.getId());
		if (idcard1 != null) {
			Member mbyId = dao.findByIdCard(idcard1);
			if (mbyId != null)
				return mbyId;
			else
				throw new MemberNotFoundException("Member doesnot exist with the ADHAR NUMBER : " + adharno);
		} else
			throw new MemberNotFoundException("Member doesnot exist with the ADHAR NUMBER : " + adharno);

	}

	@Override
	public Member updatedoseStatus(Member member, Integer mid,String key) throws MemberNotFoundException {
		
		 Optional<CurrentAdminSession> optCurrAdmin= adminSessionDAO.findByUuid(key);
			
			if(!optCurrAdmin.isPresent()) {
				
				throw new RuntimeException("Unauthorised access");
			}
			
		Optional<Member> mId = dao.findById(mid);
		if (mId.isPresent()) {
			Member exist = mId.get();
			LocalDate present = LocalDate.now();
			LocalDate pastDate = present.minusDays(3);

			if (member.getDatefor1dose() != null) {
				LocalDate given1 = member.getDatefor1dose();
				if (member.getDatefor1dose() != null && (given1.isBefore(present) || present.isEqual(given1))
						&& given1.isAfter(pastDate)) {
					exist.setDatefor1dose(member.getDatefor1dose());
					if (exist.getDatefor1dose() != null) {
						exist.setDose1status(null);
						Optional<Vaccine> vaccine = vDao.findByvaccinename(exist.getVaccine().getVaccinename());
						exist.setVaccine(vaccine.get());
						VaccineCount vc = countDao.findByvaccine(vaccine.get());
						vc.setQuantity(vc.getQuantity() - 1);
					}
				}

				else if (member.getDatefor1dose() != null && present.isBefore(given1))
					throw new MemberNotFoundException("Future date is given in DOSE 1 DATE area");

				else if (member.getDatefor1dose() != null && pastDate.isAfter(given1))
					throw new MemberNotFoundException(" date is 3 days before the present date(DOSE 1)");
			}
			if (exist.getDatefor1dose() == null && member.getDatefor2dose() != null)
				throw new MemberNotFoundException(" Dose 1 not taken");

			if (member.getDatefor2dose() != null) {
				LocalDate given2 = member.getDatefor2dose();
				if (given2.isBefore(present)
						|| present.isEqual(given2) && given2.isAfter(pastDate) && exist.getDatefor1dose() != null) {
					System.out.println("call");
					exist.setDatefor2dose(member.getDatefor2dose());
					if (exist.getDatefor2dose() != null) {
						exist.setDose2status(true);
						Vaccine vaccine = exist.getVaccine();
						VaccineCount vc = countDao.findByvaccine(vaccine);
						vc.setQuantity(vc.getQuantity() - 1);
					}

				}

				else if (member.getDatefor2dose() != null && present.isBefore(given2))
					throw new MemberNotFoundException("Future date is given in DOSE 2 DATE area");
				else if (member.getDatefor1dose() != null && pastDate.isAfter(given2))
					throw new MemberNotFoundException("date is 3 days before the present date(DOSE 2)");

			}

			if (exist.getDatefor2dose() != null)
				exist.setDose2status(true);
			return dao.save(exist);
		} else
			throw new MemberNotFoundException("Member not found with the MEMBER ID :" + member.getMemberid());

	}

}