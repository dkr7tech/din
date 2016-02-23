package com.service.auth;

import java.util.Map;

import com.model.common.RoleEnum;

public class RolePermManager {
	
	public Map<Integer,String> getAllRoles(){
		return RoleEnum.getRolesIdWithNameMap();
		
	}

	public Map<Integer,String> getUserRoles(){
		return RoleEnum.getRolesIdWithNameMap();
		
	}
	
}
