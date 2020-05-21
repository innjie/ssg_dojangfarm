package com.ssg.dojangfarm.controller.user;

import javax.validation.constraints.NotBlank;

public class LoginCommand {
	@NotBlank
	private String userId;
	@NotBlank
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
