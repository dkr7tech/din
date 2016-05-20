package com.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.db.UserDAO;
import com.model.user.User;



@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			User user= userDAO.getUser(username);
			GrantedAuthority authority = new SimpleGrantedAuthority("Admin");
			UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(user.getLogin(), 
					user.getPassword(), Arrays.asList(authority));
			return userDetails;
	}
	
/*	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user= userDAO.getUser(username);
		GrantedAuthority authority = new SimpleGrantedAuthority("Admin");
		UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(user.getLogin(), 
				user.getPassword(), Arrays.asList(authority));
		return userDetails;
	}*/
} 