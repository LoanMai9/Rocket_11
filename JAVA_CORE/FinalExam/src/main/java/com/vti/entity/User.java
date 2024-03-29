package com.vti.entity;

public class User {
	
	private int id;
	private String fullName;
	private String email;
	private String password;
	private String role;

	
	public User()
	{
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String string) {
		this.role = string;
	}

	public void getInfor() {
		System.out.println("User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", role="
				+ role + "]");
	}

}