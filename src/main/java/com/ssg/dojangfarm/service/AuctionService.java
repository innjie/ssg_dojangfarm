package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;

//@WebService(name = "AuctionService") 
public interface AuctionService{
	List<Auction> getAuctionList();
	List<Auction>findAuctionByTitle(String title);
	List<Auction>findAuctionByProduct(String pName);
	Auction getAuction(int aNo);
	void registerAuction(Auction auction);
	void bidAuction(Bid bid);
	void successBid(SBid sBid);
	void immePurchase(ImPur imPur);
}
