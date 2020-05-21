package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Card implements Serializable{
	private int cardNo;
	private User user;
	private String bank;
	private String cardPW;
	private Date period;
	private int cvc;
	private String type;
	private String cardPayNo;		//real card number
	
	
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
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getCardPW() {
		return cardPW;
	}
	public void setCardPW(String cardPW) {
		this.cardPW = cardPW;
	}
	public Date getPeriod() {
		return period;
	}
	public void setPeriod(Date period) {
		this.period = period;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCardPayNo() {
		return cardPayNo;
	}
	public void setCardPayNo(String cardPayNo) {
		this.type = cardPayNo;
	}
}
