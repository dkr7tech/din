package com.model.common;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {
	RoleEnum_1(1, 1, "BASIC USER", "Basic Login Functionality", " "),
	RoleEnum_2(2, 1, "USER ADMIN", " User CRUD OPRATIONS"," "),
	RoleEnum_3(3, 1, "Role Perm Administraor", " Create/Modify/Assign Roles", " "),
	RoleEnum_4(4, 1, "USER Sub ADMIN", "User Activate/Deactivate User,Assign roles"," ");
	

	private int id;
	private int isActive;
	private String name;
	private String desc;
	private String externalName;

	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getExternalName() {
		return externalName;
	}

	private RoleEnum(int id, int isActive, String name, String desc, String externalName) {
		this.id = id;
		this.isActive = isActive;
		this.name = name;
		this.desc = desc;
		this.externalName = externalName;
	}

	public static RoleEnum getRoleEnumByName(String name) {
		RoleEnum roleEnum = null;
		for (RoleEnum renum : RoleEnum.values()) {
			if (renum.name.equalsIgnoreCase(name)) {
				roleEnum = renum;
			}
		}
		if (roleEnum == null) {
			roleEnum = roleEnum;
		}
		return roleEnum;
	}
	public static RoleEnum getRoleEnumById(int id) {
		RoleEnum roleEnum = null;
		for (RoleEnum renum : RoleEnum.values()) {
			if (renum.id==id) {
				roleEnum = renum;
			}
		}
		if (roleEnum == null) {
			roleEnum = roleEnum;
		}
		return roleEnum;
	}
	public static Map<Integer,RoleEnum> getRolesEnumMap(){
		Map<Integer,RoleEnum> rolesMap=new HashMap<Integer,RoleEnum>();
		for (RoleEnum rolesEnum : RoleEnum.values()) {
			rolesMap.put(rolesEnum.id,rolesEnum);
		}
		return rolesMap;
	}
	
	public static Map<Integer,String> getRolesIdWithNameMap(){
		Map<Integer,String> rolesMap=new HashMap<Integer,String>();
		for (RoleEnum rolesEnum : RoleEnum.values()) {
			rolesMap.put(rolesEnum.id,rolesEnum.name);
		}
		return rolesMap;
	}

}
