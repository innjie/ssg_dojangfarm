package com.ssg.dojangfarm.service;

import java.util.List;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssg.dojangfarm.dao.AuctionDAO;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;

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

	public Bid getBid(int bidNo) {
		return auctionDAO.getBid(bidNo);
	}

	public List<Auction> getMyAuctionList(int userNo) {
		return auctionDAO.getMyAuctionList(userNo);
	}

	public SBid getSBidByAuction(int aNo) {
		return auctionDAO.getSBidByAuction(aNo);
	}

	public ImPur getImPurByAuction(int aNo) {
		return auctionDAO.getImPurByAuction(aNo);
	}

	public List<Bid> getMyBidList(int userNo) {
		return auctionDAO.getMyBidList(userNo);
	}

	public List<SBid> getMySBidList(int userNo) {
		return auctionDAO.getMySBidList(userNo);
	}

	public SBid getMySBid(int sBidNo) {
		return auctionDAO.getMySBid(sBidNo);
	}

	public List<ImPur> getMyImPurList(int userNo) {
		return auctionDAO.getMyImPurList(userNo);
	}

	public ImPur getMyImPur(int imPurNo) {
		return auctionDAO.getMyImPur(imPurNo);
	}

	public User getUserByAuction(int aNo) {
		return auctionDAO.getUserNoByAuction(aNo);
	}

	public int getPNoByPName(String pName) {
		return auctionDAO.getPNoByPName(pName);
	}

	@Override
	public List<SBid> getMySBidList(String id) {
		return auctionDAO.getMySBidList(id);
	}

	@Override
	public List<ImPur> getMyImPurList(String id) {
		return auctionDAO.getMyImPurList(id);
	}
	
	
	public int getLastANo() {
		return auctionDAO.getLastANo();
	}
	
	public void addImage(int aNo, String image) {
		auctionDAO.addImage(aNo, image);
		
	}
}
