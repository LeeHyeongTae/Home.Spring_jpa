package com.review.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

	private static final String FILE_PATH = "C:\\Users\\bit3\\git\\Home.Spring_jpa\\review\\src\\main\\resources\\static\\resources\\file\\";

	@Override
	public boolean insert(User user) {
		saveFile(user);
		return true;
	}

	private void saveFile(User user) {
		try {
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(
									new FileWriter(
									new File(FILE_PATH+"userList.csv")));
			writer.write(user.toString());
			writer.newLine();
			writer.flush();
		}catch (Exception e) {
			System.out.println("file save error");
		}
	}

	@Override
	public List<User> selectAll() {
		List<User> userList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(
									new FileReader(
									new File(FILE_PATH+"userList.csv")));
			String message = "";
			while((message = reader.readLine()) != null) {
				list.add(message);
			}
			reader.close();		
		} catch (Exception e) {
			System.out.println("file read error");
		}
		User u = null;
		for (int i =0; i<list.size(); i++) {
			u = new User();
			String[] arr = list.get(i).split(",");
			u.setUserid(arr[0]);
			u.setPassword(arr[1]);
			u.setName(arr[2]);
			u.setSsn(arr[3]);
			u.setAddress(arr[4]);
			u.setProfile(arr[5]);
			u.setEmail(arr[6]);
			u.setPhoneNumber(arr[7]);
			u.setRegisterDate(arr[8]);
			userList.add(u);
		}
		return userList;
	}

	@Override
	public User selectOne(String userid) {
		User returnUser = null;
		return returnUser;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
