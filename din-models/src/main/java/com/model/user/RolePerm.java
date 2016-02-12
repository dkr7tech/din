package com.model.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tl_role_perm database table.
 * 
 */
@Entity
@Table(name="tl_role_perm")
@NamedQuery(name="RolePerm.findAll", query="SELECT r FROM RolePerm r")
public class RolePerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_perm_id")
	private int rolePermId;

	//bi-directional many-to-one association to Permission
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="perm_id")
	private Permission permission;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public RolePerm() {
	}

	public int getRolePermId() {
		return this.rolePermId;
	}

	public void setRolePermId(int rolePermId) {
		this.rolePermId = rolePermId;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}