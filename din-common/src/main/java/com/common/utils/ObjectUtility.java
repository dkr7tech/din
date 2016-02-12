package com.common.utils;

public class ObjectUtility {
	private ObjectUtility() {
		throw new AssertionError("cannot instantiate ObjectUtility");
	}

	/**
	 * Check Object reference
	 *
	 * @param object
	 * @return boolean
	 */
	public static boolean isNull(Object object) {
		return object == null ? true : false;
	}

	/**
	 * Check Object reference
	 *
	 * @param object
	 * @return boolean
	 */
	public static boolean isNotNull(Object object) {
		return object != null ? true : false;
	}
}
