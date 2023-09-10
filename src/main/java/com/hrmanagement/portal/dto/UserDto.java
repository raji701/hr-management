package com.hrmanagement.portal.dto;

public class UserDto {
	
	private String userId;
	
	private String passWord;
	
	private int status;

	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDto(String userId, String passWord, int status) {
		super();
		this.userId = userId;
		this.passWord = passWord;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
