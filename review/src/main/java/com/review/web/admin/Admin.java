package com.review.web.admin;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Admin {
	String userid, name, password, ssn, address;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", userid,name,password,ssn,address);
	}
}