package com.model.common;
import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@MappedSuperclass
public abstract class  DateTimeSupport<T> {

	T createdBy;
	Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	Date lastModifiedBy;
	@Temporal(TemporalType.TIMESTAMP)
	Date lastModifiedDate;
	public T getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(T createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(Date lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	
}
