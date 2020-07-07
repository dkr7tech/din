package com.common.persistance;

import org.hibernate.event.service.spi.DuplicationStrategy;

public class CustomStrategy implements DuplicationStrategy {

	private static final long serialVersionUID = 1L;
	public static final CustomStrategy INSTANCE = new CustomStrategy();
	@Override
	public boolean areMatch(Object listener, Object original) {
      System.out.println("CustomStrategy1");
		return false;
	}
	@Override
	public Action getAction() {
		System.out.println("CustomStrategy2");
		return Action.REPLACE_ORIGINAL;
	}

	
}