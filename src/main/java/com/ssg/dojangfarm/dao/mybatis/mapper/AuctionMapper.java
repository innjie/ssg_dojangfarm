package com.ssg.dojangfarm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;

@CacheNamespaceRef(value=AuctionMapper.class)
public interface AuctionMapper {
	List<Auction> getAuctionList();	
	Auction getAuction(int aNo);
	void registerAuction(Auction auction);		//insert
	List<Auction> findAuctionByTitle(String title);
	List<Auction> findAuctionByProduct(String pName);
	void immePurchase(ImPur imPur); 
	void bidAuction(Bid bid);  
	void successBid(SBid sBid);
	//Auction getMyAuction(int userNo);
	Bid getBid(int bidNo);
	
	List<Auction> getMyAuctionList(int userNo);
	SBid getSBidByAuction(int aNo);
	ImPur getImPurByAuction(int aNo);
	
	List<Bid> getMyBidList(int userNo);
	
	List<SBid> getMySBidList(int userNo);
	SBid getMySBid(int sBidNo);
	
	List<SBid> getMySBidList(String id);
	
	List<ImPur> getMyImPurList(int userNo);
	ImPur getMyImPur(int imPurNo);
	
	List<ImPur> getMyImPurList(String id);
	
	User getUserNoByAuction(int aNo);
	void updateBidPrice(@Param("aNo") int aNo, @Param("bidPrice") int bidPrice);

	int getPNoByPName(String pName);
}
