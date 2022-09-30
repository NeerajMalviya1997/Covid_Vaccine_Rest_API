package com.masai.Service;

import com.masai.model.Admin;
import com.masai.model.AdminDto;


public interface AdminLoginService {

	public String logIntoAccount(Admin adminDTO);
	
	public String logOutAccount(String key);

	String logIntoAccount(AdminDto adminDTO);
}
