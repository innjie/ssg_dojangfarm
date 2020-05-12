package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Common extends Normal implements Serializable{
	private int min;
	private Date deadline;
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		deadline = deadline;
	}
	
}
