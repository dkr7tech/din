package com.model.common;

import com.model.user.Permission;
import com.model.user.User;
import com.model.user.UserPreference;

public class LoginSessionBean {
	private User user;
	private UserPreference userPreference;
	private Permission permission;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserPreference getUserPreference() {
		return userPreference;
	}

	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

}
