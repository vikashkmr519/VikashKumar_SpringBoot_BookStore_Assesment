package com.vikash.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Admin {

	@Id
	private String email;
	
	private String username;
	
	private String password;
	
	public Admin(){
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
		
}
