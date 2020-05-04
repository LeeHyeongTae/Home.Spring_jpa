package com.review.web.user;

import java.util.List;

public interface UserDao {

	boolean insert(User user);

	List<User> selectAll();

	User selectOne(String name);

	boolean update(User user);

	boolean delete(User user);

}
