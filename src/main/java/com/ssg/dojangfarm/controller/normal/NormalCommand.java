package com.ssg.dojangfarm.controller.normal;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.ssg.dojangfarm.domain.Product;

public class NormalCommand {
	private Product product;
	@Min(1000)
	private int price;
	@NotBlank
	private String title;
	private String state;
	private String info;
	@NotNull
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regidDate;
	private String saleType;
	private String saleState;
	@Min(1)
	private int count;
	private MultipartFile image;
	
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
	public Date getRegidDate() {
		return regidDate;
	}
	public void setRegidDate(Date regiDate) {
		regidDate = regiDate;
	}
	public String getSaleState() {
		return saleState;
	}
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
}
