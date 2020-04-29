package com.review.web.admin;

import java.util.List;

public interface AdminService {

	public boolean register(Admin admin);

	public List<Admin> findAll();

	public Admin findOne(String employNumber);

	public boolean modify(Admin admin);

	public boolean remove(Admin admin);

}
