package com.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.User;

import com.model.common.DateTimeSupport;
@Entity
@Table(name="tt_audit")
@NamedQuery(name="AuditData.findAll", query="SELECT a FROM AuditData a")
public class AuditData extends  DateTimeSupport<User> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long auditid;
	String action;
	String actionResult;
	String entityId;
	String entityType;
	String transactionId;
	@Column(length = 3000)
	String entityXML;

	

	

	public long getAuditid() {
		return auditid;
	}

	public void setAuditid(long auditid) {
		this.auditid = auditid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getEntityXML() {
		return entityXML;
	}

	public void setEntityXML(String entityXML) {
		this.entityXML = entityXML;
	}

}
