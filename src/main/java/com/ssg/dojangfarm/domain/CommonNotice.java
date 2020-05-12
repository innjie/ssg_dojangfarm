package com.ssg.dojangfarm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CommonNotice implements Serializable{
	private int CNNO;
	private String title;
	private String info;
	private User user;
	
	public int getCNNO() {
		return CNNO;
	}
	public void setCNNO(int cNNO) {
		CNNO = cNNO;
	}
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
