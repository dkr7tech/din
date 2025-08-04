package com.model.user;


import com.common.audit.Type;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public interface ParentEntity {
	public static final Type TYPE = Type.of("ParentEntity");

}
