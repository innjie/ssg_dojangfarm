package com.ssg.dojangfarm.controller.user;

import javax.validation.constraints.NotBlank;

public class LoginCommand {
	@NotBlank
	private String id;
	@NotBlank
	private String password;
	private String forwardAction;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getForwardAction() {
		return forwardAction;
	}

	public void setForwardAction(String forwardAction) {
		this.forwardAction = forwardAction;
	}
}
