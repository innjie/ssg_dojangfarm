package com.ssg.dojangfarm.controller.common;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ssg.dojangfarm.domain.Common;
import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.Payment;
import com.ssg.dojangfarm.domain.User;

public class CommonJoinCommand {
	private User user;
	private Common common;
	@Min(1)
	private int count;
	private String cjState;
	private Delivery delivery;
	private Payment payment;
	private int cardNo;
	private int addrNo;
	private int cjNo;
	@NotEmpty @Pattern(regexp = "01[01679]-\\d{3,4}-\\d{4}")
	private String phone;
	
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

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
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
	public int getCjNo() {
		return cjNo;
	}
	public void setCjNo(int cjNo) {
		this.cjNo = cjNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
