package com.review.web.lose;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface LoseService {

	List<Lose> findAll();

	Lose findOne(String lostId);

}
