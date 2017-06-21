package com.niit.activity.dao;

import com.niit.activity.model.User;

public interface UsersDAO {
	public User login(User user);
	boolean saveUser(User users);
	public User get(int id);
	public boolean update(User user1);
	public User authenticate(int id, String password);
}
