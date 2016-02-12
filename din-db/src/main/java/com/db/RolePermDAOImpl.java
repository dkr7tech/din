package com.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.model.user.Permission;
import com.model.user.Role;
import com.model.user.RolePerm;

@Repository
public class RolePermDAOImpl implements RolePermDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	@Transactional
	public int createRole(Role role) {
		getEntityManager().merge(role);
		Permission permission = new Permission();
		// permission.
		return 0;
	}

	
	public int updateRole(Role role) {
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

	
	@Transactional
	public int createPermission(Permission perm) {

		getEntityManager().merge(perm);
		
		return 0;
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
