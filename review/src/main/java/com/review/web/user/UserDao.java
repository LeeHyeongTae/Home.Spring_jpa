package com.review.web.user;

import java.util.List;

public interface UserDao {

	boolean insert(User user);

	List<User> selectAll();

	User selectOne(String userid);

	boolean update(User user);

	boolean delete(User user);

}
