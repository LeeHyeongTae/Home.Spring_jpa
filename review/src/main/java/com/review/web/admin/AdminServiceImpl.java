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
	private Map<String, Object> map = new HashMap<>();
	private static final String ADMINFILE_PATH = "/Users/ihyeongtae/git/repository2/review/src/main/resources/static/admin/";

	@Override
	public void saveFile(Admin admin) {
		File file = new File(ADMINFILE_PATH+"adminList.txt");
		try {
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
		} catch (Exception e) {
			System.out.println("save error");
		}
	}

	@Override
	public List<Admin> readFile() {
		List<Admin> AdminList = new ArrayList<>();
		List<String> list = new ArrayList<>();
		File file = new File(ADMINFILE_PATH+"adminList.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String message ="";
			while((message = reader.readLine())!= null) {
				list.add(message);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("read error");
		}
		Admin a = null;
		for(int i=0; i<list.size(); i++) {
			a = new Admin();
			String[] arr = list.get(i).split(",");
			a.setEmployNumber(arr[0]);
			a.setUserid(arr[1]);
			a.setName(arr[2]);
			a.setPassword(arr[3]);
			a.setPosition(arr[4]);
			a.setAddress(arr[5]);
			a.setProfile(arr[6]);
			a.setEmail(arr[7]);
			a.setPhoneNumber(arr[8]);
			a.setRegisterDate(arr[9]);
			AdminList.add(a);
		}
		return AdminList;
	}

	@Override
	public boolean idCheck(String userid) {
		List<Admin> adminList = readFile();
		for(int i=0; i<adminList.size(); i++) {
			adminMap(adminList.get(i));
		}
		return map.containsKey(userid);
	}

	private void adminMap(Admin admin) {
		map.put(admin.getUserid(), admin);
	}

	
}
