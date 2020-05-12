package com.ssg.dojangfarm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Bid implements Serializable{
	private int bidNo;
	private Auction auction;
	private User user;
	private int cBidPrice;		//current
	private int bidPrice;
	private Date bidTime;
	
	
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
	public int getcBidPrice() {
		return cBidPrice;
	}
	public void setcBidPrice(int cBidPrice) {
		this.cBidPrice = cBidPrice;
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

	
	
}
