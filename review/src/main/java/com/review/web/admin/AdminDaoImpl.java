package com.review.web.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{

	private static final String ADMIN_PATH = "C:\\Users\\bit3\\git\\Home.Spring_jpa\\review\\src\\main\\resources\\static\\resources\\file\\";

	@Override
	public void insert(Admin admin) {
		try {
			@SuppressWarnings("resource")
			BufferedWriter writer =  new BufferedWriter(
									 new FileWriter(
									 new File(ADMIN_PATH+"adminList.csv")));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
		} catch(Exception e) {
			System.out.println("save error");
		}
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin> adminlist = new ArrayList<>();
		List<String> list = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(
									new FileReader(
									new File(ADMIN_PATH+"adminList.csv")));
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
		Admin admin = new Admin();
		try {
			//selectAll().contains(o);
		} catch(Exception e) {
			
		}
		
		return admin;
	}

	@Override
	public void update(Admin admin) {
		
	}

	@Override
	public void delete(Admin admin) {
		
	}
	
}
