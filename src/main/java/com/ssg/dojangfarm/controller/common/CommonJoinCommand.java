package com.ssg.dojangfarm.controller.common;

import javax.validation.constraints.Min;

import com.ssg.dojangfarm.domain.Common;

import com.ssg.dojangfarm.domain.User;

public class CommonJoinCommand {
	private User user;
	private Common common;
	@Min(1)
	private String count;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Common getCommon() {
		return common;
	}
	public void setCommon(Common common) {
		this.common = common;
	}

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
}
