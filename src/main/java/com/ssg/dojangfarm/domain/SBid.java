package com.ssg.dojangfarm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SBid implements Serializable{
	private int sBidNo;
	private Bid bid;
	private String payState;
	private Delivery delivery;
	private Payment payment;
	
	
	public int getsBidNo() {
		return sBidNo;
	}
	public void setsBidNo(int sBidNo) {
		this.sBidNo = sBidNo;
	}
	public Bid getBid() {
		return bid;
	}
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
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
	
	
	
}
