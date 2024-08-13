package com.ankit.user;

public class UserBean {
	private String id;
	private String full_Name;
	private String email;
	private String password;
	
	public UserBean() {}

	public String getFull_Name() {
		return full_Name;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFull_Name(String full_Name) {
		this.full_Name = full_Name;
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
}
