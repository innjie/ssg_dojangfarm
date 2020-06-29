package com.ssg.dojangfarm.controller.common;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.Payment;
import com.ssg.dojangfarm.domain.User;

public class CommonJoinCommand {
	private User user;
	private Common common;
	@Min(1)
	private String count;
	private String cjState;
	private Delivery delivery;
	private Payment payment;
	private int cardNo;
	private int addrNo;
	
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
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

	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
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
	public int getAddrNo() {
		return addrNo;
	}
	public void setAddrNo(int addrNo) {
		this.addrNo = addrNo;
	}
}
