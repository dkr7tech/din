package com.db;

import java.util.List;

import com.model.user.Permission;
import com.model.user.Role;
import com.model.user.RolePerm;

public interface RolePermDAO {

	public int createRole(Role role);

	public int updateRole(Role role);

	public int addPermToRole(RolePerm roleperm);

	public int removePermFromRole(RolePerm roleperm);

	public int deleteRole(Role role);

	public List<Role> getRoles();

	public int createPermission(Permission perm);

	public int addPermission(Permission perm);

	public List<Permission> getPermissions();

}
