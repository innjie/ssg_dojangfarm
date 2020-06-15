package com.ssg.dojangfarm.controller.common;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import com.ssg.dojangfarm.domain.Product;

public class CommonCommand  {
	@Min(1000)
	private int price;
	@NotBlank
	private String title;
	private String info;
	private Date regidDate;
	private String saleType;
	private String saleState;
	
	@Min(5)
	private int min;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public Date getRegidDate() {
		return regidDate;
	}
	public void setRegidDate(Date regidDate) {
		this.regidDate = regidDate;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public String getSaleState() {
		return saleState;
	}
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
	
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
		this.deadline = deadline;
	}
	
}
