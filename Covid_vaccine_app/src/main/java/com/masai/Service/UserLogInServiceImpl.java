package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.model.UserDto;
import com.masai.Repo.UserDao;
import com.masai.Repo.UserSessionDAO;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLogInServiceImpl implements UserLoginService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserSessionDAO userSessionDAO;
	
	@Override
	public String logIntoAccount(UserDto userDTO) throws Exception {

		Optional<User> opt= userDao.findByMobileNo(userDTO.getMobileNo());
		
		if(!opt.isPresent()) {
			return "Please enter valid Mobile number!";
		}
		
		User user1= opt.get();
		Integer userId = user1.getId();
		Optional<CurrentUserSession>  currUseropt1= userSessionDAO.findByUserId(userId);
		
		if(currUseropt1.isPresent()) {
			return "User already logged in with this number.";
		}
		
		if(user1.getPassword().equals(userDTO.getPassword())) {
			
			String key = RandomString.make(6);
			CurrentUserSession currentUserSession = new CurrentUserSession(userId, key, LocalDateTime.now());
			
			userSessionDAO.save(currentUserSession);

			return currentUserSession.toString();
		}
		else {
			return "Please Enter valid password.";
		}

		
	}
	

	@Override
	public String logOutAccount(String key) {
		Optional<CurrentUserSession> currUserOpt=userSessionDAO.findByUuid(key);
		
		if(currUserOpt.isPresent()) {
			CurrentUserSession currUser1=currUserOpt.get();
			
			userSessionDAO.delete(currUser1);
			return "User logged out successfully.";
		}
		return "User does not exist, Enter correct uuid";

	}

}
