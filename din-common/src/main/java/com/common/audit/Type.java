package com.common.audit;

import java.util.HashMap;
import java.util.Map;



public class Type {
	private static Map<String, Type> commonTypes = new HashMap<String, Type>();
	 private  String name;
	Class obj;
	
	


	

	public Type(String name) {
		super();
		this.name=name;
	}
	
	
	public String getName() {
		return name;
	}


	public static final Type of(String name) {
		commonTypes.put("", new Type("ParentEntity"));
		return new Type(name);
	}
	static {
		//org.aspectj.apache.bcel.generic.Type
		commonTypes.put("ParentEntity", new Type("ParentEntity"));
		commonTypes.put("Role", new Type("Role"));
		
		
	}
	/*public static final Type getType(String signature) {
		Type t = commonTypes.get(signature);
		return t;
	}*/
	

}
