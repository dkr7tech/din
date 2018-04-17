package com.common.persistance.springjpaaudit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl<T>  implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return  Optional.of("dinkar");
	}

	/* @Override
	    public String getCurrentAuditor() {
	        return "Naresh";
	        // Can use Spring Security to return currently logged in user
	        // return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()
	    }*/
}