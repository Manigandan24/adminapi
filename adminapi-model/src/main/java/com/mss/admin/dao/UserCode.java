package com.mss.admin.dao;

import java.util.ArrayList;
import java.util.List;

public class UserCode {
	
	private int id;
	private String username;
	private String password;
	private List<UserRoleCode> userRoles=new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<UserRoleCode> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRoleCode> userRoles) {
		this.userRoles = userRoles;
	}
	
}
