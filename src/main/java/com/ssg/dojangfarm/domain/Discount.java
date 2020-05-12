package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Discount implements Serializable{
	private Normal normal;
	private int dRate;
	private Date dDate; 
	
	
	public Normal getNormal() {
		return normal;
	}
	public void setNormal(Normal normal) {
		this.normal = normal;
	}
	public int getdRate() {
		return dRate;
	}
	public void setdRate(int dRate) {
		this.dRate = dRate;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}
	
}
