package com.service.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.RolePermDAO;
import com.model.user.Permission;
import com.model.user.Role;
import com.model.user.RolePerm;

@Service
public class RolePermServiceImpl implements RolePermService {
	@Autowired
	private RolePermDAO rolePermDAO;
	

	public RolePermDAO getRolePermDAO() {
		return rolePermDAO;
	}

	
	public int createRole(Role role) {
		Date date = new Date();
		role.setCreatetime(date);
		role.setModtime(date);
		int i = getRolePermDAO().createRole(role);
		return 0;
	}

	
	public int editRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int addPermToRole(RolePerm roleperm) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int removePermFromRole(RolePerm roleperm) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int deleteRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int createPermission(Permission perm) {
		Date date = new Date();
		perm.setCreatetime(date);		
		perm.setModtime(date);
		int i = getRolePermDAO().createPermission(perm);
		return i;
	
		
	}

	
	public int addPermission(Permission perm) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<Permission> getPermissions() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
