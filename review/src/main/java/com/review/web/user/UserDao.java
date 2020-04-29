package com.review.web.user;

public interface UserDao {

	public void insert(User user);

	public void selectAll();

	public void selectOne(String userid);

	public void update(User user);

	public void delete(User user);

}
