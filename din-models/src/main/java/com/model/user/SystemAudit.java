package com.model.user;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tt_system_audit database table.
 * 
 */
@Entity
@Table(name="tt_system_audit")
@NamedQuery(name="SystemAudit.findAll", query="SELECT s FROM SystemAudit s")
public class SystemAudit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="audit_id")
	private String auditId;

	@Column(name="audit_ref")
	private String auditRef;

	private int audittype;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String description;

	public SystemAudit() {
	}

	public String getAuditId() {
		return this.auditId;
	}

	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}

	public String getAuditRef() {
		return this.auditRef;
	}

	public void setAuditRef(String auditRef) {
		this.auditRef = auditRef;
	}

	public int getAudittype() {
		return this.audittype;
	}

	public void setAudittype(int audittype) {
		this.audittype = audittype;
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

}