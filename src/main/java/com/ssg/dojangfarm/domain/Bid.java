package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Bid implements Serializable{
	private int bidNo;
	private Auction auction;
	private User user;
	private int bidPrice;
	private Date bidTime;
	private String state;		//실패, 현재최고가, 성공
	
	
	public int getBidNo() {
		return bidNo;
	}
	public void setBidNo(int bidNo) {
		this.bidNo = bidNo;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Date getBidTime() {
		return bidTime;
	}
	public void setBidTime(Date bidTime) {
		this.bidTime = bidTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
