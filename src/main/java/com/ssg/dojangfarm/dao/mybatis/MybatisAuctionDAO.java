package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.dojangfarm.dao.AuctionDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.AuctionMapper;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;

@Repository
public class MybatisAuctionDAO implements AuctionDAO{
	@Autowired
	private AuctionMapper auctionMapper;
	
	public List<Auction> getAuctionList() {
		return auctionMapper.getAuctionList();
	}	
	public Auction getAuction(int aNo) {
		return auctionMapper.getAuction(aNo);
	}
	public void registerAuction(Auction auction) {
		auctionMapper.registerAuction(auction);
	}		
	public List<Auction> findAuctionByTitle(String title) {
		return auctionMapper.findAuctionByTitle("%" + title + "%");
	}
	public List<Auction> findAuctionByProduct(String pName) {
		return auctionMapper.findAuctionByProduct("%" + pName + "%");
	}
	public List<Auction> getMyAuctionList(int userNo) {
		return auctionMapper.getMyAuctionList(userNo);
	}
	public User getUserNoByAuction(int aNo) {
		return auctionMapper.getUserNoByAuction(aNo);
	}
	
	
	public void immePurchase(ImPur imPur) {
		auctionMapper.immePurchase(imPur);
	} 
	public ImPur getImPurByAuction(int aNo) {
		return auctionMapper.getImPurByAuction(aNo);
	}
	public List<ImPur> getMyImPurList(int userNo) {
		return auctionMapper.getMyImPurList(userNo);
	}
	public ImPur getMyImPur(int imPurNo) {
		return auctionMapper.getMyImPur(imPurNo);
	}
	
	@Transactional	
	public void bidAuction(Bid bid) {
		auctionMapper.updateBidPrice(bid.getAuction().getaNo(), bid.getBidPrice());
		auctionMapper.bidAuction(bid);
	}  
	public Bid getBid(int bidNo) {
		return auctionMapper.getBid(bidNo);
	}
	public List<Bid> getMyBidList(int userNo) {
		return auctionMapper.getMyBidList(userNo);
	}
	
	
	public void successBid(SBid sBid) {
		auctionMapper.successBid(sBid);
	}
	public SBid getSBidByAuction(int aNo) {
		return auctionMapper.getSBidByAuction(aNo);
	}
	public List<SBid> getMySBidList(int userNo) {
		return auctionMapper.getMySBidList(userNo);
	}
	public SBid getMySBid(int sBidNo) {
		return auctionMapper.getMySBid(sBidNo);
	}
	
	
	public int getPNoByPName(String pName) {
		return auctionMapper.getPNoByPName(pName);
	}

}
