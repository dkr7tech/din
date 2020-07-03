package com.db;

import java.util.List;

import com.model.user.User;
import com.model.user.UserPreference;

public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	public User getUser(String login,String password);
	
	public User saveOrUpdate(User user);
	
	public User getUser(String userName);
	

	public UserPreference saveUserPref(UserPreference preference);
	//public void saveOrUpdateRole(TtRole role);
	
	public void delete(User user);
}