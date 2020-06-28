package com.ssg.dojangfarm.controller.auction;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class BidCommand {
	private int bidPrice;
	private int addrNo;
	private int cardNo;
	@NotEmpty @Pattern(regexp = "01[01679]-\\d{3,4}-\\d{4}")
	private String phone;
	
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public int getAddrNo() {
		return addrNo;
	}
	public void setAddrNo(int addrNo) {
		this.addrNo = addrNo;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
