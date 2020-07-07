package com.common.persistance.springjpaaudit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AuditorAwareImpl<T>  implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		String name=((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		return  Optional.of(name);
	}

	/* @Override
	    public String getCurrentAuditor() {
	        return "Naresh";
	        // Can use Spring Security to return currently logged in user
	        // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
	    }*/
}