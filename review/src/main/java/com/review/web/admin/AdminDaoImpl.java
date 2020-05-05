package com.review.web.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{

	private static final String ADMIN_PATH = "/Users/ihyeongtae/git/repository2/review/src/main/resources/static/resources/file/";

	@Override
	public boolean insert(Admin admin) {
		boolean returnValue = false;
		try {
			@SuppressWarnings("resource")
			BufferedWriter writer =  new BufferedWriter(
									 new FileWriter(
									 new File(ADMIN_PATH+"admin_list.csv")));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
		} catch(Exception e) {
			System.out.println("save error");
		}
		if(admin.toString() != null) {
			returnValue = true;
		}
		return returnValue;
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin> adminlist = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(
									new FileReader(
									new File(ADMIN_PATH+"admin_list.csv")));
			String admin = "";
			while((admin = reader.readLine()) != null) {
				list.add(admin);
			}
			reader.close();
			Admin a = null;
			for(int i=0; i<list.size(); i++) {
				a = new Admin();
				String[] arr = list.get(i).split(",");
				//employNumber, userid, name, password, 
				//position, address, profile, email, phoneNumber, registerDate
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
				adminlist.add(a);
			}
		} catch(Exception e) {
			System.out.println("read error");
		} 
		return adminlist;
	}

	@Override
	public Admin selectOne(String employNumber) {
		Admin returnAdmin = new Admin();
		List<Admin> list = selectAll();
		for(int i=0; i<list.size(); i++) {
			if(employNumber.equals(list.get(i).getEmployNumber())) {
				returnAdmin = list.get(i);
				break;
			}
		}
		return returnAdmin;
	}

	@Override
	public void update(Admin admin) {
		
	}

	@Override
	public void delete(Admin admin) {
		
	}
	
}
