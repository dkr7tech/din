package com.service.user;

import java.util.List;

import com.model.user.User;

/**
 * @author dsharma
 *
 */

public interface UserService {
	
	public User createUser(User user);
	public User deleteUser(User user);
	public boolean validateUser(User user,User loggedInUser);

	public User getUser(int id);

	public User getUser(User user);
	public List<User> getUserList();
}
