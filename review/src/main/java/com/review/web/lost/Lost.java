package com.review.web.lost;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
public class Lost {
	String lostId, lostName, lostDate, lostClass, lostLocation;
	
	public String toString() {
		return String.format("%s,%s,%s,%s,%s",
				lostId,lostName,lostDate,lostClass,lostLocation);
	}
}
