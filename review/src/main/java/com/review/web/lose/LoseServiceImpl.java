package com.review.web.lose;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoseServiceImpl implements LoseService{
	@Autowired LoseDao lostDao;
	
	@Override
	public List<Lose> findAll() {
		return lostDao.selectAll();
	}

	@Override
	public Lose findOne(String lostId) {
		return lostDao.selectOne(lostId);
	}

}
