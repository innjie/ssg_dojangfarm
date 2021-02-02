package com.ssg.dojangfarm.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssg.dojangfarm.dao.AuctionDAO;
import com.ssg.dojangfarm.dao.mybatis.mapper.AuctionMapper;
import com.ssg.dojangfarm.dao.mybatis.mapper.DeliveryMapper;
import com.ssg.dojangfarm.dao.mybatis.mapper.PaymentMapper;
import com.ssg.dojangfarm.domain.Auction;
import com.ssg.dojangfarm.domain.Bid;
import com.ssg.dojangfarm.domain.Delivery;
import com.ssg.dojangfarm.domain.ImPur;
import com.ssg.dojangfarm.domain.Payment;
import com.ssg.dojangfarm.domain.SBid;
import com.ssg.dojangfarm.domain.User;

@Repository
public class MybatisAuctionDAO implements AuctionDAO{
	@Autowired
	private AuctionMapper auctionMapper;
	@Autowired
	private DeliveryMapper deliveryMapper;
	@Autowired
	private PaymentMapper paymentMapper;
	
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
	
	@Transactional	
	public void immePurchase(ImPur imPur) {
		
		deliveryMapper.addDelivery(imPur.getDelivery());
		paymentMapper.insertPayment(imPur.getPayment());
		
		int dNo = deliveryMapper.getLastDNo();
		int payNo = paymentMapper.getLastPayNo();
		
		auctionMapper.changeBidState(imPur.getAuction().getaNo());
		
		imPur.getDelivery().setdNo(dNo);
		imPur.getPayment().setPayNo(payNo);
		
		auctionMapper.immePurchase(imPur);
		
		auctionMapper.finishAuction(imPur.getAuction().getaNo());
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
		auctionMapper.changeBidState(bid.getAuction().getaNo());
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
	
	
	
	
	@Override
	public List<SBid> getMySBidList(String id) {
		return auctionMapper.getMySBidList(id);
	}
	@Override
	public List<ImPur> getMyImPurList(String id) {
		return auctionMapper.getMyImPurList(id);
	}
	
	
	@Override
	public int getLastANo() {
		return auctionMapper.getLastANo();
	}
	@Override
	public void addImage(int aNo, String image) {
		auctionMapper.addImage(aNo, image);
		
	}
	
	@Transactional
	public void addImage(Auction auction, int aNo, String image) {
		auctionMapper.registerAuction(auction);
		auctionMapper.addImage(aNo, image);
		
	}
	
	public void finishAuction(int aNo) {
		auctionMapper.finishAuction(aNo);
	}
	
	@Transactional
	public void successBidAuction(Auction auction) {
		auctionMapper.finishAuction(auction.getaNo()); //finish='1'		
		auctionMapper.changeBidStateSuccess(auction.getaNo()); //bid.state=='낙찰'
		
		Bid bid = auctionMapper.findSBid(auction.getaNo());
		
		if(bid != null) {
			System.out.println("bid is not null " + bid.getBidNo());
			bid = auctionMapper.getBid(bid.getBidNo());
			Delivery delivery = new Delivery();
			Payment payment = new Payment();
			
			delivery.setAddress(bid.getAddress());
			delivery.setPhone(bid.getPhone());
			payment.setCard(bid.getCard());
			payment.setTotalPrice(bid.getBidPrice());
			
			deliveryMapper.addDelivery(delivery);
			paymentMapper.insertPayment(payment);
			
			SBid sBid = new SBid();
			sBid.setBid(bid);
			sBid.setDelivery(delivery);
			sBid.setPayment(payment);
			
			auctionMapper.successBid(sBid);
		}

	}
	
	
	@Transactional
	public void immePurchaseKakao(ImPur imPur) {
		deliveryMapper.addDelivery(imPur.getDelivery());
		paymentMapper.insertPaymentKakao(imPur.getPayment());
		
		int dNo = deliveryMapper.getLastDNo();
		int payNo = paymentMapper.getLastPayNo();
		
		auctionMapper.changeBidState(imPur.getAuction().getaNo());
		
		imPur.getDelivery().setdNo(dNo);
		imPur.getPayment().setPayNo(payNo);
		
		auctionMapper.immePurchase(imPur);
		
		auctionMapper.finishAuction(imPur.getAuction().getaNo());
		
	}
	
	@Override
	public ImPur getMyImPurKakao(int imPurNo) {
		return auctionMapper.getMyImPurKakao(imPurNo);
	}

}
