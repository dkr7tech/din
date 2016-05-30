package com.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.db.UserDAO;
import com.model.common.RoleEnum;




@Service
public class AuthenticationService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 System.out.println("loadUserByUsername2");

	        com.model.user.User user= userDAO.getUser(username);
	        
	        List<GrantedAuthority> authorities = 
	                buildUserAuthority(RoleEnum.getRolesIdWithNameMap());
				UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(user.getLogin(), 
						user.getPassword(), authorities);
				return userDetails;
	}
	
	/*
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername2");

        com.model.user.User user= userDAO.getUser(username);
        
        List<GrantedAuthority> authorities = 
                buildUserAuthority(RoleEnum.getRolesIdWithNameMap());
			UserDetails userDetails = (UserDetails)new org.springframework.security.core.userdetails.User(user.getLogin(), 
					user.getPassword(), authorities);
			return userDetails;
	}*/

	
	// Converts User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.model.user.User user, 
		List<GrantedAuthority> authorities) {
		return new User(user.getLogin(), user.getPassword(), 
			true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Map<Integer,String> roleMap) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		Set<Map.Entry<Integer, String>> entrySet = roleMap.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
		// Build user's authorities
			setAuths.add(new SimpleGrantedAuthority(entry.getValue()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
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