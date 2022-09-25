package com.person.sample.dto;

public class UserDto {

	private String userId;
	private String userPwd;
	
	public UserDto() {}

	public UserDto(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDto [userId=").append(userId).append(", userPwd=").append(userPwd).append("]");
		return builder.toString();
	}
}
