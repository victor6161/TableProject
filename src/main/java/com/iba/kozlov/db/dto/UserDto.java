package com.iba.kozlov.db.dto;

public class UserDto {
	private int id;
	private String username;
	public UserDto(String username) {
		super();
		this.username = username;
	}
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
}
