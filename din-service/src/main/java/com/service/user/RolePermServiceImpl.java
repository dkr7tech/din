package com.service.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.RolePermDAO;
import com.model.common.PermissionEnum;
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
		return getRolePermDAO().updateRole(role);
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
		
		return getRolePermDAO().getRoles();
	}

	
	public Permission createPermission(Permission perm) {
		Date date = new Date();
		perm.setCreatetime(date);		
		perm.setModtime(date);
		return  getRolePermDAO().createPermission(perm);
		
	
		
	}

	
	public int addPermission(Permission perm) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public List<Permission> getAllSysPermissions() {
		// TODO Auto-generated method stub
		return getRolePermDAO().getPermissions();
	}


	public Role getRole(Role role) {
		// TODO Auto-generated method stub
		return getRolePermDAO().getRole(role);
	}

	
	// RolePermissions and remaining permissions available in the system
	public List<List<Permission>> getRolePermAndAvailPerm(Role role) {
		List<List<Permission>> list = new ArrayList<List<Permission>>();
		List<Permission> permissionList = getRolePermDAO().getPermissions();
		if (permissionList != null) {
			if (role != null && role.getPermissionList() != null && !role.getPermissionList().isEmpty()) {
				permissionList.removeAll(role.getPermissionList());
				list.add(permissionList);
				list.add(role.getPermissionList());
			} else {
				list.add(permissionList);
				}
		}
		return list;
	}
	
	
	// RolePermissions and remaining permissions available in the system
	public List<Map<Integer, String>> getRolePermAndAvailPerm(List<Permission> listPerm) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Map<Integer, String>> mapList = new ArrayList<Map<Integer, String>>();
		Map<Integer, String> allPermMap = PermissionEnum.getPermIdWithNameMap();
		if (listPerm != null) {
			for (Permission perm : listPerm) {
				map.put(perm.getPermId(), PermissionEnum.getPermEnumById(perm.getPermId()).getName());
				allPermMap.remove(perm.getPermId());
			}
		}
		mapList.add(allPermMap);
		mapList.add(map);
		return mapList;
	}

}
