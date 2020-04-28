package com.review.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	private Map<String, Object> map;
	public final static String FILE_PATH = "/Volumes/Macintosh HD/Spring-workspace/review/src/main/resources/static/user/";
	
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
	public void saveFile(User user) {
		try {
			File file = new File(FILE_PATH+"list.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String message = user.toString();
			writer.write(message);
			writer.newLine();
			writer.flush();
		}catch(Exception e){
			System.out.println("저장시 오류 발생");
		}
	}

	@Override
	public List<User> readFile() {
		List<User> userList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			File file = new File(FILE_PATH+"list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message ="";
			while((message = reader.readLine()) != null) {
				list.add(message);
			}
			reader.close();
		}catch(Exception e) {
			System.out.println("읽기에서 오류 발생");
		}
		User u = new User();
		for(int i=0; i<list.size(); i++) {
			String[] arr = list.get(i).split(",");
			u.setUserid(arr[0]);
			u.setName(arr[1]);
			u.setPassword(arr[2]);
			u.setSsn(arr[3]);
			u.setAddress(arr[4]);
			userList.add(u);
		}
		return userList;
	}
	
}