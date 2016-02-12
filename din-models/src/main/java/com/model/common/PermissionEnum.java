package com.model.common;

import java.util.HashMap;
import java.util.Map;

public enum PermissionEnum {

	PermissionEnum_1(1, 1, "BASIC_USER Perission", "Basic Functionality", " "), 
	PermissionEnum_2(2, 1, "USER_ADMIN Permission", " User CRUD OPRATIONS"," "), 
	PermissionEnum_3(3, 1, "", " ab permission", "dd ");
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
