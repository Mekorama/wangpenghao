package com.connext.pojo;

import java.io.Serializable;


public class User implements Serializable {

	private static final long serialVersionUID = -1581691088397097000L;
	
	private String phone;
	private String password;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
