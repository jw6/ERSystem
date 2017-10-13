package com.revature.beans;

public class ERSUserRole {
	private int roleID;
	private String role;
	
	public ERSUserRole() {
		super();
	}
	
	public ERSUserRole(int roleID, String role) {
		super();
		this.roleID = roleID;
		this.role = role;
	}
	
	public int getRoleID() {
		return roleID;
	}
	
	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "UserRole [roleID=" + roleID + ", role=" + role + "]";
	}
}
