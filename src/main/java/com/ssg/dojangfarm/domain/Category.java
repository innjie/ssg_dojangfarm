package com.ssg.dojangfarm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable  {
	private String cateNo;
	private String kind;
	  
	  
	public String getCateNo() {
		return cateNo;
	}
	public void setCateNo(String cateNo) {
		this.cateNo = cateNo;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	  
	  
}
