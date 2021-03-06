package com.ductran.dochoioto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ductran.dochoioto.model.UserModel;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@Column(name = "user_Id",length = 10)
	private String userId;
	@Column(name = "user_FullName",length = 50)
	private String fullName;
	@Column(name = "user_Name", length = 50)
	private String username;
	@Column(name = "pass_Word", length = 50)
	private String password;
	@Column(name = "user_Status")
	private boolean userStatus;
	@Column(name = "user_Role")
	private boolean userRole;
	
	public Users() {}
	public Users(UserModel user) {
		this.userId = user.getUserId();
		this.fullName = user.getFullName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.userStatus = user.isUserStatus();
		this.userRole = user.isUserRole();
	}
	public Users(String userId, String fullName, String username, String password, boolean userStatus,
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
	
}
