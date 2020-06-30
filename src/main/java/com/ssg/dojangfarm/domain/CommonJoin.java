package com.ssg.dojangfarm.domain;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class CommonJoin implements Serializable{
	private int cjNo;
	private User user;
	private Common common;
	private String cjState;
	private Delivery delivery;
	private Payment payment;
	@Min(1)
	private int count;
	private int cardNo;
	
	public int getCjNo() {
		return cjNo;
	}
	public void setCjNo(int cjNo) {
		this.cjNo = cjNo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Common getCommon() {
		return common;
	}
	public void setCommon(Common common) {
		this.common = common;
	}
	public String getCjState() {
		return cjState;
	}
	public void setCjState(String cjState) {
		this.cjState = cjState;
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	
	
}
