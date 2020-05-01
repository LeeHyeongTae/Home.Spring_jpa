package com.review.web.admin;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AdminService {
	
	public void register(Admin admin);
	
	public List<Admin> findAll();
	
	public Admin findOne(String employNumber);
	
	public boolean modify(Admin admin);
	
	public boolean remove(Admin admin);

	public void login(Admin admin);
}
