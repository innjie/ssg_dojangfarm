package com.ssg.dojangfarm.controller.normal;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.ssg.dojangfarm.domain.Product;

public class NormalCommand {
	private Product product;
	@Min(1000)
	private int price;
	@NotBlank
	private String title;
	private String state;
	private String info;
	private Date RegiDate;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getRegiDate() {
		return RegiDate;
	}
	public void setRegiDate(Date regiDate) {
		RegiDate = regiDate;
	}
	
}
