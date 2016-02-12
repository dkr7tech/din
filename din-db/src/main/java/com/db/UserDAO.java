package com.db;

import java.util.List;

import com.model.user.User;

public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	public User getUser(String login,String password);
	
	public void saveOrUpdate(User user);
	//public void saveOrUpdateRole(TtRole role);
	
	public void delete(int id);
}