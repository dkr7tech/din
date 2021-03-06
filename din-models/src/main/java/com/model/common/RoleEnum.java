package com.model.common;

import java.util.HashMap;
import java.util.Map;

public enum RoleEnum {
	// Remove spaces from name ,description and external name
	RoleEnum_1(1, 1, "Basic User", "Basic Login Functionality", " "),
	RoleEnum_2(2, 1, "User Administrator","User CRUD OPRATIONS", " "), 
	RoleEnum_3(3, 1, "Role Perm Administraor", "Create/Modify/Assign Roles"," "), 
	RoleEnum_4(4, 1, "User Sub Administrator", "User Activate/Deactivate User,Assign roles", " ");

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

	public int getIsActive() {
		return isActive;
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
			if (renum.name.equalsIgnoreCase(name) && renum.isActive == 1) {
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
		for (RoleEnum rEnum : RoleEnum.values()) {
			if (rEnum.id == id && rEnum.isActive == 1) {
				roleEnum = rEnum;
			}
		}
		if (roleEnum == null) {
			roleEnum = roleEnum;
		}
		return roleEnum;
	}

	public static Map<Integer, RoleEnum> getRolesEnumMap() {
		Map<Integer, RoleEnum> rolesMap = new HashMap<Integer, RoleEnum>();
		for (RoleEnum rolesEnum : RoleEnum.values()) {
			if (rolesEnum.isActive == 1) {
				rolesMap.put(rolesEnum.id, rolesEnum);
			}
		}
		return rolesMap;
	}

	public static Map<Integer, String> getRolesIdWithNameMap() {
		Map<Integer, String> rolesMap = new HashMap<Integer, String>();
		for (RoleEnum rolesEnum : RoleEnum.values()) {
			if (rolesEnum.isActive == 1) {
				rolesMap.put(rolesEnum.id, rolesEnum.name);
			}
		}
		return rolesMap;
	}

}
