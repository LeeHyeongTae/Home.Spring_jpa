package com.review.web.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void signup(User user) {

	}
	

	@Override
	public int count() {
		return 0;
	}

	@Override
	public User login(User user) {
		User signedUser = null;
		
		return signedUser;
	}

	@Override
	public User detail(String userid) {
		User returnUser = null;
		
		return returnUser;
	}

	@Override
	public boolean update(User user) {

		return true;
	}

	@Override
	public boolean remove(String userid) {

		return true;
	}
	
}