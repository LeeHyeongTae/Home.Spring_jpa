package com.review.web.admin;

public interface AdminService {
	public void add(Admin member);
	public Admin[] list(Admin member);
	public Admin detail(String userid);
	public int count();
	public boolean login(Admin member);
	public void update(Admin member);
	public void delete(Admin member);
	
}
