package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Auction implements Serializable{
	private int aNo;
	private User user;
	private Product product;
	private String title;
	private String detail;
	private int minPrice;
	private Date rDate;		//register
	private Date deadline;
	private Boolean imPurAva;		//imme Purchase Available
	private int imPurPrice;		//imme Purchase
	private Boolean finish;
	private int bidPrice;
	private String image;
	
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Boolean getImPurAva() {
		return imPurAva;
	}
	public void setImPurAva(Boolean imPurAva) {
		this.imPurAva = imPurAva;
	}
	public int getImPurPrice() {
		return imPurPrice;
	}
	public void setImPurPrice(int imPurPrice) {
		this.imPurPrice = imPurPrice;
	}
	public void setFinish(Boolean finish) {
		this.finish = finish;
	}
	public Boolean getFinish() {
		return finish;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
