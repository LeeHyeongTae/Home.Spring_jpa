package com.review.web.admin;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class Admin {
	private String employNumber, userid, name, password, 
	position, address, profile, email, phoneNumber, registerDate;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", 
				employNumber,userid,name,password,position,
				address,profile,email,phoneNumber,registerDate);
	}
}