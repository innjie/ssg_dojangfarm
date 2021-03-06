package com.ssg.dojangfarm.controller.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserCommand {
	@NotBlank @Size(min=2)
	private String id;
	@NotEmpty	
	private String name;
	@NotBlank @Size(min=4)
	private String password;
	@NotBlank
	private String confirmPassword;
	@NotEmpty @Pattern(regexp = "01[01679]-\\d{3,4}-\\d{4}")
	private String phone;
	private boolean newAccount;
	
	
	
	public UserCommand() {
		super();
		this.newAccount = true;
	}
	
	public UserCommand(String id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.newAccount = false;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isNewAccount() {
		return newAccount;
	}
	
}
