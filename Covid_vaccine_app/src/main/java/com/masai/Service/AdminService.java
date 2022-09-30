package com.masai.Service;

import com.masai.model.Admin;

public interface AdminService {

	public Admin createAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin, String key);
}
