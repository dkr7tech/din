package com.model.user;

import javax.persistence.MappedSuperclass;

import com.common.audit.Type;

@MappedSuperclass
public interface ParentEntity {
	public static final Type TYPE = Type.of("ParentEntity");

}
