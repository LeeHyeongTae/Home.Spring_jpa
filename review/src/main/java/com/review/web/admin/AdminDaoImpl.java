package com.review.web.admin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao{

	private static final String ADMIN_PATH = "/Users/ihyeongtae/git/repository2/review/src/main/resources/static/admin/";

	@Override
	public void insert(Admin admin) {
		try {
			@SuppressWarnings("resource")
			BufferedWriter writer =  new BufferedWriter(
									 new FileWriter(
									 new File(ADMIN_PATH+"list.csv")));
			writer.write(admin.toString());
			writer.newLine();
			writer.flush();
		} catch(Exception e) {
			System.out.println("파일쓰기에서 에러발생");
		}
	}

	@Override
	public List<Admin> selectAll() {
		try {
			
		} catch(Exception e) {
			
		} 
		return null;
	}

	@Override
	public Admin selectOne(String employNumber) {
		try {
			
		} catch(Exception e) {
			
		}
		
		return null;
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin admin) {
		// TODO Auto-generated method stub
		
	}
	
}
