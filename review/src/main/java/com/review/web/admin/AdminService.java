package com.review.web.admin;

import java.util.List;

public interface AdminService {

	void join(Admin member);

	int count();

	public Admin login(Admin member);
	
	public Admin detail(String userid);

	public boolean check(String userid);

	boolean update(Admin member);

	boolean delete(Admin member);
	
	public void saveFile(Admin member);
	
	public List<Admin> readFile();

	List<String> list();

}
