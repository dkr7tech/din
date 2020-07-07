package com.model.common;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

import javax.persistence.Temporal;
public interface  DateTimeSupport<T> {

	
	public  T createdBy();

	@Temporal(TIMESTAMP)
	public Date createdDate();


	public T lastModifiedBy();


	@Temporal(TIMESTAMP)
	public Date lastModifiedDate();

	
	
}
