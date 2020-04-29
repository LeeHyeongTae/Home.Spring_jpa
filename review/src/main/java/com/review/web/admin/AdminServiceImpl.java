package com.review.web.admin;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired AdminDao adminDao;
	
	@Override
	public void register(Admin admin) {
		System.out.println("2"+admin);
		//employNumber(4자리수 랜덤), userid, name, password, 
		//position, address, profile, email, phoneNumber, registerDate(현재날짜)
		admin.setEmployNumber(createEmployNumber());
		admin.setPassword("1");
		admin.setRegisterDate(createCurrentDate());
		adminDao.insert(admin);
	}

	private String createCurrentDate() {
		return new SimpleDateFormat("yyyy-mm-dd").format(new Date());
	}

	private String createEmployNumber() {
		String startNum ="";
		for(int i=0; i<4; i++) {
			startNum += String.valueOf((int)(Math.random()*10));
		}
		//String.format("%04d", Math.random()*10000+1000);
		return startNum;
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
