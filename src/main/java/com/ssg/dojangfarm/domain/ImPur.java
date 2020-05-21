package com.ssg.dojangfarm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ImPur implements Serializable{
	private int imPurNo;
	private Auction auction;
	private User user;
	private Delivery delivery;
	private Payment payment;
	
	
	public int getImPurNo() {
		return imPurNo;
	}
	public void setImPurNo(int imPurNo) {
		this.imPurNo = imPurNo;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
}
