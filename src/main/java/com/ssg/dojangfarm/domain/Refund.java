package com.ssg.dojangfarm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Refund implements Serializable{
	private int refundNo;
	private Order order;
	private String bank;
	private String account;
	private String name;
	private String refundType;
	
	
	public int getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(int refundNo) {
		this.refundNo = refundNo;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRefundType() {
		return refundType;
	}
	public void setRefundType(String refundType) {
		this.refundType = refundType;
	}
	
	
}