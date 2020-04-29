package com.review.web.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired AdminDao adminDao;
	@Override
	public boolean register(Admin admin) {
		adminDao.insert(admin);
		return false;
	}

	@Override
	public List<Admin> findAll() {
		adminDao.selectAll();
		return null;
	}

	@Override
	public Admin findOne(String employNumber) {
		adminDao.selectOne(employNumber);
		return null;
	}

	@Override
	public boolean modify(Admin admin) {
		adminDao.update(admin);
		return false;
	}

	@Override
	public boolean remove(Admin admin) {
		adminDao.delete(admin);
		return false;
	}

}
