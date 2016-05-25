package com.model.user;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tl_user_role database table.
 * 
 */

@Table(name="tl_user_role")
@NamedQuery(name="UserRole.findAll", query="SELECT u FROM UserRole u")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tl_user_role_id")
	private int tlUserRoleId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public UserRole() {
	}

	public int getTlUserRoleId() {
		return this.tlUserRoleId;
	}

	public void setTlUserRoleId(int tlUserRoleId) {
		this.tlUserRoleId = tlUserRoleId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}