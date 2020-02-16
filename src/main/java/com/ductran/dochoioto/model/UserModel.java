package com.ductran.dochoioto.model;

import com.ductran.dochoioto.entity.Users;

public class UserModel {
	
	private String userId;
	private String fullName;
	private String username;
	private String password;
	private boolean userStatus;
	public UserModel() {}
	public UserModel(Users user) {
		this.userId = user.getUserId();
		this.fullName = user.getFullName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.userStatus = user.isUserStatus();
		this.userRole = user.isUserRole();
	}
	public UserModel(String userId, String fullName, String username, String password, boolean userStatus,
			boolean userRole) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.userStatus = userStatus;
		this.userRole = userRole;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isUserStatus() {
		return userStatus;
	}
	public void setUserStatus(boolean userStatus) {
		this.userStatus = userStatus;
	}
	public boolean isUserRole() {
		return userRole;
	}
	public void setUserRole(boolean userRole) {
		this.userRole = userRole;
	}
	private boolean userRole;
}
