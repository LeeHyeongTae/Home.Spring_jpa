package com.review.web.lose;

import java.util.List;

public interface LoseDao {

	List<Lose> selectAll();

	Lose selectOne(String lostId);

}
