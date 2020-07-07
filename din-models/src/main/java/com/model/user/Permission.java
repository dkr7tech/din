package com.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.common.audit.Audit;
import com.common.audit.Auditor;

/**
 * The persistent class for the tt_permission database table.
 * 
 */
@Entity
@Audit(Auditor.class)
@Table(name = "tt_permission")
@NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "perm_id")
	private int permId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modtime;

	private String name;
	
	private int status;

	@ManyToMany(mappedBy="permissionList",fetch=FetchType.EAGER)
	private List<Role> roleList;

	public Permission() {
	}

	public Permission(int permId, String name) {
		super();
		this.permId = permId;
		this.name = name;
	}

	public int getPermId() {
		return this.permId;
	}

	public void setPermId(int permId) {
		this.permId = permId;
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

	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

}