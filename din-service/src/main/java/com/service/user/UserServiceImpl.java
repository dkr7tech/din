/**
 * 
 */
package com.service.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.utils.EncryptionUtil;
import com.db.UserDAO;
import com.model.user.Role;
import com.model.user.User;

/**
 * @author dsharma
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private static String salt="$2a$10$J9x1IVEdhzDZHumEeSVlJO6UXg/h.1ruZAGBMMloJC1n9OnLDo1um";
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

	
	public boolean validateUser(User user,User loggedInUser) {
		boolean isValid=false;
		/*System.out.println("password :> "+user.getPassword());
		System.out.println("Generated salt > "+EncryptionUtil.generateSalt(user.getPassword()));
		System.out.println("salt validate > "+EncryptionUtil.isValidPassword(user.getPassword(),"$2a$10$UrgZ3wKuC71jjKRc.r0PyOlItAvwhYN1nrBE02PZ7wiyKV.wHRfQ."));*/
		System.out.println("Generated salt from salt > "+EncryptionUtil.generateWithGivenSalt(user.getPassword(),salt));
		if(loggedInUser!=null && EncryptionUtil.isValidPassword(user.getPassword(), loggedInUser.getPassword())){
			isValid=true;
		}
		
		return isValid;
	}

	
	public User getUser(User user) {
		User loggedInUser=getUserDao().getUser(user.getLogin(),EncryptionUtil.generateWithGivenSalt(user.getPassword(),salt));
		if(!validateUser(user,loggedInUser)){
			loggedInUser=null;
		}
		return loggedInUser;
	}

}
