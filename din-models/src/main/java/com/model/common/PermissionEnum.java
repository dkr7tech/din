package com.model.common;

import java.util.HashMap;
import java.util.Map;

public enum PermissionEnum {

	PermissionEnum_1(1, 1, "BASIC USER ", "User can Login in system", " "), 
	PermissionEnum_2(2, 1, "Create User", " User Create"," "), 
	PermissionEnum_3(3, 1, "Delete User", " User Delet"," "), 
	PermissionEnum_5(4, 1, "Modify User", " User Modify/Activate/Deactivate"," "), 
	PermissionEnum_6(5, 1, "RolePerm Admistrator", " Create/Delete/Modify  Roles And Permission", " "),
	PermissionEnum_7(5, 1, "RolePerm Assigner", " Assign Roles And Permission", " ");
	private int id;
	private int isActive;
	private String name;
	private String desc;
	private String externalName;
	private PermissionEnum(int id, int isActive, String name, String desc, String externalName) {
		this.id = id;
		this.isActive = isActive;
		this.name = name;
		this.desc = desc;
		this.externalName = externalName;
	}
	
	public static Map<Integer,String> getPermIdWithNameMap(){
		Map<Integer,String> permMap=new HashMap<Integer,String>();
		for (PermissionEnum permEnum : PermissionEnum.values()) {
			permMap.put(permEnum.id,permEnum.name);
		}
		return permMap;
	}
	
}
