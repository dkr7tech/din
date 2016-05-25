package com.model.common;

import java.util.HashMap;
import java.util.Map;

public enum PermissionEnum {

	PermissionEnum_1(1, 1, "Basic User",  "User can Login in system", " "), 
	PermissionEnum_2(2, 1, "Create User", "User Create", " "), 
	PermissionEnum_3(3, 1, "Delete User", "User Delet", " "), 
	PermissionEnum_4(4, 1, "Modify User", "User Modify/Activate/Deactivate", " "),
	PermissionEnum_5(5, 1, "RolePerm Admistrator", "Create/Delete/Modify  Roles And Permission"," "), 
	PermissionEnum_6(6, 1, "RolePerm Assigner", "Assign Roles And Permission", " ");
	private int id;
	private int isActive;
	private String name;
	private String desc;
	private String externalName;

	public int getId() {
		return id;
	}

	public int getIsActive() {
		return isActive;
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

	private PermissionEnum(int id, int isActive, String name, String desc, String externalName) {
		this.id = id;
		this.isActive = isActive;
		this.name = name;
		this.desc = desc;
		this.externalName = externalName;
	}

	public static PermissionEnum getPermeEnumByName(String name) {
		PermissionEnum permissionEnum = null;
		for (PermissionEnum permEnum : PermissionEnum.values()) {
			if (permEnum.name.equalsIgnoreCase(name) && permEnum.isActive == 1) {
				permissionEnum = permEnum;
			}
		}
		return permissionEnum;
	}

	public static PermissionEnum getPermEnumById(int id) {
		PermissionEnum permissionEnum = null;
		for (PermissionEnum permEnum : PermissionEnum.values()) {
			if (permEnum.id == id && permEnum.isActive == 1) {
				permissionEnum = permEnum;
			}
		}
		return permissionEnum;
	}

	public static Map<Integer, String> getPermIdWithNameMap() {
		Map<Integer, String> permMap = new HashMap<Integer, String>();
		for (PermissionEnum permEnum : PermissionEnum.values()) {
			if (permEnum.isActive == 1) {
				permMap.put(permEnum.id, permEnum.name);
			}
		}
		return permMap;
	}

}
