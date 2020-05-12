package com.ssg.dojangfarm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable{
	private int pNo;
	private String pName;
	private Category category;
	
	
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
