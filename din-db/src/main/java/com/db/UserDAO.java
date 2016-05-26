package com.db;

import java.util.List;

import com.model.user.User;

public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	public User getUser(String login,String password);
	
	public User saveOrUpdate(User user);
	
	public User getUser(String userName);
	//public void saveOrUpdateRole(TtRole role);
	
	public void delete(User user);
}