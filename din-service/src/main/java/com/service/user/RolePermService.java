package com.service.user;

import java.util.List;

import com.model.user.Permission;
import com.model.user.Role;
import com.model.user.RolePerm;

public interface RolePermService {
	public int createRole(Role role);

	public int editRole(Role role);

	public int addPermToRole(RolePerm roleperm);

	public int removePermFromRole(RolePerm roleperm);

	public int deleteRole(Role role);

	public List<Role> getRoles();

	public int createPermission(Permission perm);

	public int addPermission(Permission perm);

	public List<Permission> getPermissions();

}
