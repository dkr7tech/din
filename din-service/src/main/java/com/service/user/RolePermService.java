package com.service.user;

import java.util.List;
import java.util.Map;

import com.model.user.Permission;
import com.model.user.Role;
import com.model.user.RolePerm;

public interface RolePermService {
	public int createRole(Role role);

	public int editRole(Role role);
	
	public int deleteRole(Role role);

	public List<Role> getRoles();
	
	public Role getRole(Role role);

	public int addPermToRole(RolePerm roleperm);

	public int removePermFromRole(RolePerm roleperm);

	public Permission createPermission(Permission perm);

	public int addPermission(Permission perm);

	public List<Permission> getAllSysPermissions();
	
	//RolePermissions and remaining permissions available in the system
    public List<List<Permission>> getRolePermAndAvailPerm(Role role);

	//RolePermissions and remaining permissions available in the system
	public List<Map<Integer, String>> getRolePermAndAvailPerm(List<Permission> listPerm);
}
