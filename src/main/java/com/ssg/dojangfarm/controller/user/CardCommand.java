package com.ssg.dojangfarm.controller.user;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.ssg.dojangfarm.domain.User;

public class CardCommand {
	@NotEmpty
	private String bank;
	@NotEmpty @Pattern(regexp="\\d{4}")
	private String cardPW;
	@Future @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date period;
	@NotEmpty @Pattern(regexp="\\d{3,4}")
	private String cvc;
	private String type;
	@NotEmpty @Pattern(regexp = "(\\d{4}-\\d{4}-\\d{4}-\\d{4})|(\\d{4}-\\d{6}-\\d{5})") 
	private String cardPayNo;
	
	
	public CardCommand() {
		super();
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


	public String getCvc() {
		return cvc;
	}


	public void setCvc(String cvc) {
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
		this.cardPayNo = cardPayNo;
	}
	
	
}
