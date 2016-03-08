package com.db;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
		Role role1=getEntityManager().find(Role.class, role.getRoleId());
		/*if(role1!=null){
		getEntityManager().merge(role);
		}*/
		getEntityManager().merge(role);
	
		
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
		 Query query = getEntityManager().createQuery("SELECT e FROM Role e");
		return (List<Role>) query.getResultList();
	}

	@Transactional
	public Permission createPermission(Permission perm) {
		return getEntityManager().merge(perm);
	}

	public List<Permission> getPermissions() {
		 Query query = getEntityManager().createQuery("SELECT e FROM Permission e");
		    return (List<Permission>) query.getResultList();
		
	}

	public Role addPermToRole(Role role) {
		return getEntityManager().merge(role);
	}

	public List<Permission> getRolePermissions(Role role) {
		Role roleObject = getEntityManager().find(Role.class, role.getRoleId());
		return roleObject.getPermissionList();
	}

	public Role getRole(Role role) {
		Role roleObject = getEntityManager().find(Role.class, role.getRoleId());
		return roleObject;
	}
	
}
