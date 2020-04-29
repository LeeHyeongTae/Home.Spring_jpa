package com.review.web.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserDao userDao;
	
	@Override
	public boolean add(User user) {
		userDao.insert(user);
		return false;
	}

	@Override
	public List<User> findAll() {
		userDao.selectAll();
		return null;
	}

	@Override
	public User findOne(String userid) {
		userDao.selectOne(userid);
		return null;
	}

	@Override
	public boolean modify(User user) {
		userDao.update(user);
		return false;
	}

	@Override
	public boolean remove(User user) {
		userDao.delete(user);
		return false;
	}

	
}