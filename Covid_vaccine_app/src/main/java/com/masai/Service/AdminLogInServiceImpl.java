package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Admin;
import com.masai.model.AdminDto;
import com.masai.model.CurrentAdminSession;



import net.bytebuddy.utility.RandomString;
import com.masai.Repo.AdminDao;
@Service
public class AdminLogInServiceImpl implements AdminLoginService{

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AminSessionDao adminSessionDAO;

	@Override
	public String logIntoAccount(AdminDto admin){
		
//		Optional<Admin> adminObj= adminDao.findByMobileNo(adminDTO.getMobileNo());
//		
//		if(!adminObj.isPresent()) {
//			return "Please enter valid Mobile number!";
//		}
//		
//		Admin admin1= adminObj.get();
//		Integer adminId = admin1.getId();
//		
//		Optional<CurrentAdminSession>  currAdminopt1= adminSessionDAO.findByAdminId(adminId);
//		
//		if(currAdminopt1.isPresent()) {
//			return "Admin already logged in with this number.";
//		}
//		
//		if(admin1.getPassword().equals(adminDTO.getPassword())) {
//			
//			String key = RandomString.make(6);
//			CurrentAdminSession currentAdminSession = new CurrentAdminSession(adminId, key, LocalDateTime.now());
//			
//			adminSessionDAO.save(currentAdminSession);
//			
//			return currentAdminSession.toString();
//		}
//		else {
//			return "Please Enter valid password.";
//		}

		return null;
	}

	@Override
	public String logOutAccount(String key) {
		Optional<CurrentAdminSession> currAdminOpt=adminSessionDAO.findByUuid(key);
		
		if(currAdminOpt.isPresent()) {
			CurrentAdminSession currAdmin1=currAdminOpt.get();
			
			adminSessionDAO.delete(currAdmin1);
			return "Admin logged out successfully.";
		}
		return "Admin does not exist, Enter correct uuid";
	}

	@Override
	public String logIntoAccount(Admin adminDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String logIntoAccount(AdminDto adminDTO) {
		// TODO Auto-generated method stub
		return null;
	}
}
