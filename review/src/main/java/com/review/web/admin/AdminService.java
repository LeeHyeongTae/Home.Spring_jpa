package com.review.web.admin;

import java.util.List;

public interface AdminService {

	void join(Admin admin);

	int count();

	public Admin login(Admin admin);
	
	public Admin detail(String userid);

	public boolean check(String userid);

	boolean update(Admin admin);

	boolean delete(Admin admin);
	
	public void saveFile(Admin admin);
	
	public List<Admin> readFile();

	List<String> list();

}
