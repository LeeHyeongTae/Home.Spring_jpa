package com.review.web.user;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserDao userDao;
	
	@Override
	public boolean add(User user) {
		return userDao.insert(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.selectAll();
	}

	@Override
	public User findOne(String name) {
		return userDao.selectOne(name);
	}

	@Override
	public boolean modify(User user) {
		return userDao.update(user);
	}

	@Override
	public boolean remove(User user) {
		return userDao.delete(user);
	}

	
}