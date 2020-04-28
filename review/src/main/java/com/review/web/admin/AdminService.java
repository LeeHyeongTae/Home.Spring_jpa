package com.review.web.admin;

import java.util.List;


public interface AdminService {

	public void saveFile(Admin admin);
	
	public List<Admin> readFile();

	public boolean idCheck(String userid);

}
