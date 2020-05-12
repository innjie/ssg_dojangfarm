package com.ssg.dojangfarm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.AuctionDAO;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;

@Service("AuctionServiceImpl")
public class AuctionServiceImpl implements AuctionService{

	@Autowired
	private AuctionDAO auctionDAO;

	public List<Auction> getAuctionList() {
		return auctionDAO.getAuctionList();
	}

	public List<Auction>findAuctionByTitle(String title) {
		return auctionDAO.findAuctionByTitle(title);
	}

	public List<Auction>findAuctionByProduct(String pName) {
		return auctionDAO.findAuctionByProduct(pName);
	}

	public Auction getAuction(int aNo) {
		return auctionDAO.getAuction(aNo);
	}

	public void registerAuction(Auction auction) {
		auctionDAO.registerAuction(auction);
	}

	public void bidAuction(Bid bid) {
		auctionDAO.bidAuction(bid);
	}

	public void successBid(SBid sBid)  {
		auctionDAO.successBid(sBid);
	}

	public void immePurchase(ImPur imPur) {
		auctionDAO.immePurchase(imPur);
	}

}
