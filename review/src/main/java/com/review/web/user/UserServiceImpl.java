package com.review.web.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void signup(User user) {
		map.put(user.getUserid(), user);
	}
	

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public User login(User user) {
		User signedUser = null;
		if(map.containsKey(user.getUserid())) {
			User u = detail(user.getUserid());
			if(user.getPassword().equals(u.getPassword())) {
				signedUser = u;
			}
		}
		
		return signedUser;
	}

	@Override
	public User detail(String userid) {
		return (User) map.get(userid);
	}

	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(), user);
		return true;
	}

	@Override
	public boolean remove(String userid) {
		map.remove(userid);
		return true;
	}

	@Override
	public List<User> list() {
		List<User> returnList = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator it = set.iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> e = (Entry<String, User>) it.next();
			returnList.add(e.getValue());
		}
		return returnList;
	}
	
}