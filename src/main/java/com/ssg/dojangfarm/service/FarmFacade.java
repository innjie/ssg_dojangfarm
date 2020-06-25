package com.ssg.dojangfarm.service;

import java.util.List;

import com.ssg.dojangfarm.domain.*;

//DojangFarm's central business interface. 

public interface FarmFacade {

	
	//Message
	public void sendMsg(Message msg);
	public void sendCMsg(Message msg);
	public void deleteMsg(int msgNo);
	public List<Message> sendMessageList(int userNo);
	public List<Message> receiveMessageList(int userNo);
	public List<Message> findMsg(String title);
	public Message checkMsg(int msgNo);
	public Message checkMsgWithCMsg(int msgNo);
	public Message checkSMsg(int msgNo);
	public int getRUserNo(int msgNo);
	public int getSUserNo(int msgNo);
	
	//QnA
	public List<QnA> getQnAList(int saleNo);
	public void questionQnA(QnA qna);
	public void answerQnA(int qNo, String answer);
	public QnA getQnA(int qNo);
	
	//Auction
	public List<Auction> getAuctionList();
	public List<Auction>findAuctionByTitle(String title);
	public List<Auction>findAuctionByProduct(String pName);
	public Auction getAuction(int aNo);
	public void registerAuction(Auction auction);
	public void bidAuction(Bid bid);
	public void successBid(SBid sBid);
	public void immePurchase(ImPur imPur);
	public Bid getBid(int bidNo);
	public List<Auction> getMyAuctionList(int userNo);
	public SBid getSBidByAuction(int aNo);
	public ImPur getImPurByAuction(int aNo);
	public List<Bid> getMyBidList(int userNo);
	public List<SBid> getMySBidList(int userNo);
	public SBid getMySBid(int sBidNo);
	public List<ImPur> getMyImPurList(int userNo);
	public ImPur getMyImPur(int imPurNo);
	public User getUserByAuction(int aNo);
	public int getPNoByPName(String pName);
	public int getLastANo();
	public void addImage(int aNo, String image);
	public void addImage(Auction auction, int aNo, String image);
	
	
	//User
	public void createUser(User user);
	public void modifyUser(User user);
	public void deleteUser(int userNo);
	public User getUser(int userNo);
	public User existingId(String id);
	public User existingPhone(String phone);
	public User checkIdPw(String id, String password);
	public boolean confirmPassword(String password, String cPassword);

	
	//Address
	public Address getAddress(int addrNo);
	public void createAddress(Address address);
	public void modifyAddress(Address address);
	public void deletAddress(int addrNo);
	public List<Address> getAddressList(int userNo);
	
	//Delivery
	public Delivery getDelivery(int dNo);
	public void changeDeliveryStatus(int dNo, String status);
	public void addDelivery(Delivery delivery);
	
	//Order
	public Order getOrder(int orderNo);
	public List<Order> getOrderList(int userNo);
	public int cancelOrder(int orderNo);
	public int insertOrder(int userNo, Order order);
	public List<Order> getOrderUserList(int orderNo);
	
	//Card
	public Card getCard(int cardNo);
	public List<Card> getCardList(int userNo);
	public void insertCard(Card card);
	public void deleteCard(int cardNo);
	
	//Common
	public int insertCommon(Common common);
	public int updateCommon(Common common);
	public Common getCommonSale(int saleNo);
	public List<Common> getAllCommonList();
	public List<Common> getCommonListByUserNo(int userNo);
	public List<Common> searchCommon(String title);
	
	public int insertCommonjoin(CommonJoin commonJoin);  
	public int cancelCommonjoin( int CJNo);
	public int updateCommonjoin(CommonJoin commonJoin);
	public CommonJoin getCommonJoin(int CJNo);
	public List<CommonJoin> getCommonJoinListByUserNo(int userNo);
	public List<CommonJoin> getCommonJoinListBySaleNo(int saleNo);
	public CommonJoin ExistCommonJoin(int userNo, int saleNo);
	
	//CommonNotice
	public int insertCommonNotice(CommonNotice cn);
	public int updateCommonNotice(CommonNotice cn);
	public int deleteCommonNotice(CommonNotice cn);
	public CommonNotice viewCommonNotice(int CNNo);
	public List<CommonNotice> getAllNoticeList();
	public List<CommonNotice> getCNoticeListByUserNo(int userNo);
	public List<CommonNotice> searchCommonNotice(String word);
	
	//Discount
	public void newDiscount(Normal normal);
	public void deleteDiscount(int saleNo);
	
	//Normal
	public int insertSale( Normal normal);
	public int updateSale(Normal normal);
	public Normal getNormalSale(int saleNo) ;
	public List<Normal> getAllNormalList();
	public List<Normal> getNormalListByUserNo(int userNo);
	public List<Normal> searchNormal(String title);
	int turnSaleState(int saleNo, String saleState);
	public int getUserByNormal(int saleNo);
	public String getSaleState(int saleNo);
	public List<Product> getProductList();
	public List<Category> getCategoryList();
	public int getLastSaleNo();
	public void addNormalImage(int saleNo, String string);
	
	//Payment
	public Payment getPayment(int payNo);
	public void insertPayment(Payment payment);
	
	//Refund
	public int refundSale(int saleNo);
	public Refund getRefund(int refundNo);
	public List<Refund> getRefundList(int userNo);
	public Card checkCardPayNo(String cardPayNo);
	public Product getProduct(int pNo);
	public List<Normal> getNormalListByCateNo(int cateNo);
	
	
	
	

	


	
	
	
	
	

}
