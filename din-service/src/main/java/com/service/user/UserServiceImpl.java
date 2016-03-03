/**
 * 
 */
package com.service.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.UserDAO;
import com.model.user.Role;
import com.model.user.User;

/**
 * @author dsharma
 *
 */
@Service
public class UserServiceImpl implements UserService {
	 @Autowired
	private UserDAO userDao;
     
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	
	public User createUser(User user) {
		Date currDate=new Date();
		user.setCreatetime(currDate);
		user.setModtime(currDate);
		return getUserDao().saveOrUpdate(user);
	}

	
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean validateUser(User user) {
		boolean isValid=false;
		if(user!=null){
			isValid=true;
		}
		
		return isValid;
	}

	
	public User getUser(User user) {
		User loggedInUser=getUserDao().getUser(user.getLogin(), user.getPassword());
		return loggedInUser;
	}

}
