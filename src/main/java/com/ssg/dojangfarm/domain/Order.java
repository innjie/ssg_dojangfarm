package com.ssg.dojangfarm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Order implements Serializable{
	private int orderNo;
	private int saleNo;
	private String saleType;
	private Delivery delivery;
	private Payment payment;
	private int quantity;
	private User user;
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getSaleNo() {
		return saleNo;
	}
	public void setSaleNo(int saleNo) {
		this.saleNo = saleNo;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	
}
