package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.*;

//DojangFarm's central business interface. 

public interface FarmFacade {
	//Category
	public Category getCategory(int cateNo);
	public List<Category> getCategoryList();
	
	//Message
	public void sendMsg(Message msg);
	public void deleteMsg(int msgNo);
	public List<Message> sendMessageList(int userNo);
	public List<Message> receiveMessageList(int userNo);
	public List<Message> findMsg(String title);
	public Message checkMsg(int msgNo);
	
	//QnA
	public List<QnA> getQnAList(int saleNo);
	public void questionQnA(QnA qna);
	public void answerQnA(int qNo, String answer);
	
	//Auction
	public List<Auction> getAuctionList();
	public List<Auction>findAuctionByTitle(String title);
	public List<Auction>findAuctionByProduct(String pName);
	public Auction getAuction(int aNo);
	public void registerAuction(Auction auction);
	public void bidAuction(Bid bid);
	public void successBid(SBid sBid);
	public void immePurchase(ImPur imPur);
	
	//User
	public void createUser(User user);
	public void modifyUser(int userNo, String id, String password, String name, String phone);
	public void deleteUser(int userNo);
	public User getUser(int userNo);
	public boolean existingId(String id);
	public boolean existingPhone(String phone);
	public boolean checkIdPw(String id, String password);
	public void login();
	public void logout();
	
	//Address
	public Address getAddress(int addrNo);
	public void createAddress(Address address);
	public void modifyAddress(int addrNo, String addr, int zip, String detail);
	public void deletAddress(int addrNo);
	public List<Address> getAddressList(int userNo);
	
	//Delivery
	public Delivery getDelivery(int dNo);
	public void changeDeliveryStatus(int dNo, String status);
	public void addDelivery(Delivery delivery);
	
	//Order
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public void CancelOrder(int orderNo);
	
	//Card
	public Card getCard(int cardNo);
	public List<Card> getCardList(int userNo);
	public void insertCard(Card card);
	public void deleteCard(int cardNo);
	
	//Common
	public int insertSale(int userNo, Common common);
	public int updateSale(Common common);
	public Common getCommonSale(int saleNo);
	public List<Common> getAllCommonList();
	public List<Common> getCommonListByUserNo(int userNo);
	public List<Common> searchCommon(String title);
	public int insertCommonjoin(int userNo, int saleNo);  //CommonJoin commonJoin
	public int cancelCommonjoin(int userNo, int CJNo);
	public int updateCommonjoin(int userNo, int CJNo);
	
	//CommonNotice
	public int insertCommonNotice(CommonNotice cn);// throws dataAcception;
	public void updateCommonNotice(CommonNotice cn);// throws dataAcception;
	public void deleteCommonNotice(CommonNotice cn);// throws dataAcception;
	public CommonNotice viewCommonNotice(CommonNotice cn);
	public List<CommonNotice> getAllNoticeList();
	public List<CommonNotice> getCNoticeListByUserNo(int userNo);
	
	//Discount
	public void newDiscount(Normal normal);
	public void deleteDiscount(int saleNo);
	
	//Normal
	public int insertSale(int userNo, Normal normal);
	public int updateSale(Normal normal);
	public Normal getNormalSale(int saleNo) ;
	public List<Normal> getAllNormalList();
	public List<Normal> getNormalListByUserNo(int userNo);
	public List<Normal> searchNormal(String title);
	int turnSaleState(int saleNo);
	
	//Payment
	public Payment getPayment(int payNo);
	public void insertPayment(Payment payment);
	
	//Refund
	public int refundSale(int saleNo);
	public Refund getRefund(int refundNo);
	public List<Refund> getRefundList(int userNo);
	

}
