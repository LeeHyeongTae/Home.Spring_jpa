package com.review.web.admin;

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
public class AdminServiceImpl implements AdminService{
	private Map<String, Object> map;
	public final static String FILE_PATH= "/Volumes/Macintosh HD/Spring-workspace/review/src/main/resources/static/admin/";
	
	public AdminServiceImpl() {
		map = new HashMap<>();
	}

	@Override
	public void join(Admin admin) {
		map.put(admin.getUserid(), admin);
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public Admin login(Admin admin) {
		Admin returnadmin = null;
		if(map.containsKey(admin.getUserid())) {
			Admin m = detail(admin.getUserid());
			if(admin.getPassword().equals(m.getPassword())) {
				returnadmin = m;
			}
		}
		return returnadmin;
	}

	@Override
	public Admin detail(String userid) {
		return (Admin) map.get(userid);
	}

	@Override
	public boolean check(String userid) {
		return map.containsKey(userid);
	}

	@Override
	public boolean update(Admin admin) {
		map.replace(admin.getUserid(), admin);
		return true;
	}

	@Override
	public boolean delete(Admin admin) {
		map.remove(admin.userid);
		return true;
	}

	@Override
	public List<String> list() {
		
		return null;
	}

	@Override
	public void saveFile(Admin admin) {
		try {
			File file = new File(FILE_PATH+"list.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
			
		} catch (Exception e) {
			System.out.println("저장 오류");
		}
	}

	@Override
	public List<Admin> readFile() {
		List<Admin> adminList = new ArrayList<>();
		List<String> list = new ArrayList<>(); 
		try {
			File file = new File(FILE_PATH+"list.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message = "";
			while((message =reader.readLine()) != null) {
				message += reader.lines();
				list.add(message);
			}
			reader.close();
		} catch(Exception e) {
			System.out.println("읽기 오류");
		}
		Admin m = new Admin();
		for(int i=0; i<list.size(); i++) {
			String[] arr = list.get(i).split(",");
			m.setUserid(arr[0]);
			m.setName(arr[1]);
			m.setPassword(arr[2]);
			m.setSsn(arr[3]);
			m.setAddress(arr[4]);
			adminList.add(m);
		}
		return adminList;
	}
}
