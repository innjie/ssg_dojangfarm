package com.ssg.dojangfarm.controller.normal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.ssg.dojangfarm.domain.User;

public class PaymentCommand {
	private int payNo;
	private boolean payCheck;
	private int cardNo;
	private int addrNo;
	@Min(1)
	private int quantity;
	private int saleNo;
	@NotEmpty @Pattern(regexp = "01[01679]-\\d{3,4}-\\d{4}")
	private String phone;
	private String saleType;
	
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}

	public boolean isPayCheck() {
		return payCheck;
	}
	public void setPayCheck(boolean payCheck) {
		this.payCheck = payCheck;
	}

	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public int getAddrNo() {
		return addrNo;
	}
	public void setAddrNo(int addrNo) {
		this.addrNo = addrNo;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
