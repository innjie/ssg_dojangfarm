package com.ssg.dojangfarm.controller.commonnotice;

import javax.validation.constraints.NotBlank;

import com.ssg.dojangfarm.domain.User;

public class CommonNoticeCommand {
	@NotBlank
	private String title;
	@NotBlank
	private String info;
	private User user;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
