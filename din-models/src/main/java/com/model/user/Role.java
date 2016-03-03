package com.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the tt_role database table.
 * 
 */
@Entity
@Table(name="tt_role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String description;

	@Column(name="external_name")
	private String externalName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modtime;

	private String name;

	private String type;

	 @ManyToMany(fetch=FetchType.EAGER)
     @JoinTable(name="tl_role_perm",
             joinColumns=
             @JoinColumn(name="role_id", referencedColumnName="role_id"),
       inverseJoinColumns=
             @JoinColumn(name="perm_id", referencedColumnName="perm_id")
     )
	private List<Permission> permissionList;
	
	


	/*//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;
	*/
	  @OneToOne(cascade=CascadeType.ALL)  
	    @JoinTable(name="tl_user_role",  
	    joinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")},  
	    inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")}) 
	private User user;

	public Role() {
	}

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExternalName() {
		return this.externalName;
	}

	public void setExternalName(String externalName) {
		this.externalName = externalName;
	}

	public Date getModtime() {
		return this.modtime;
	}

	public void setModtime(Date modtime) {
		this.modtime = modtime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
/*
	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}*/

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public String getIdAsString(){
		return String.valueOf(roleId);
		}
	
}