package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;

@Component
@WebService(serviceName="AuctionService") 
public class AuctionServiceEndpoint {
	@Autowired
	AuctionService auctionService;		// inject AuctionServiceImpl
	
	@WebMethod
	public List<Auction> getAuctionList() {
		return auctionService.getAuctionList();
	}

	@WebMethod
	public List<Auction>findAuctionByTitle(String title){
		return auctionService.findAuctionByTitle(title);
	}

	@WebMethod
	public List<Auction>findAuctionByProduct(String pName) {
		return auctionService.findAuctionByProduct(pName);
	}

	@WebMethod
	public Auction getAuction(int aNo) {
		return auctionService.getAuction(aNo);
	}

	@WebMethod
	public void registerAuction(Auction auction) {
		auctionService.registerAuction(auction);
	}

	@WebMethod
	public void bidAuction(Bid bid) {
		auctionService.bidAuction(bid);
	}

	@WebMethod
	public void successBid(SBid sBid) {
		auctionService.successBid(sBid);
	}

	@WebMethod
	public void immePurchase(ImPur imPur) {
		auctionService.immePurchase(imPur);
	}

}
