package com.ssg.dojangfarm.domain;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Normal implements Serializable{
	private int saleNo;
	private Product product;
	private int price;
	private String title;
	private User user;
	private String state;
	private String info;
	private Date RegiDate;
	
	public int getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(int saleNo) {
		this.saleNo = saleNo;
	}
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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